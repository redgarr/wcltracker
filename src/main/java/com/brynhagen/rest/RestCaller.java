package com.brynhagen.rest;

import com.brynhagen.entity.Encounter;
import com.brynhagen.entity.Player;
import com.brynhagen.entity.Ranking;
import com.brynhagen.entity.Zone;
import com.brynhagen.enums.PlayerClass;
import com.brynhagen.enums.Specialisation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Component
public class RestCaller {

    enum RequestType
    {
        GET,
        POST,
        DELETE,
        PUT;
    }

    @Value("classpath:api.key")
    private Resource apiFile;

    private RestCaller() {
        templateBuilder = new RestTemplateBuilder();
    }

    private RestTemplateBuilder templateBuilder;

    private final String urlAndPort = new String("https://www.warcraftlogs.com:443/");
    private final String apiVersion = new String("v1/");

    private String apiKey;

    @PostConstruct
    private void setApiKey()
    {
        try {
            final InputStream inputStream = apiFile.getInputStream();
            //use the stream
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
            apiKey = stringBuilder.toString();
            br.close();
        }catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Deprecated
    public Player getUser(String name)
    {
        String url = "https://www.warcraftlogs.com:443/v1/reports/user/" + name;
        JSONArray retVal = call(url, RequestType.GET);

        return null;
    }

    public List<Ranking> getRankings(String characterName, String serverName, String serverRegion,
        Zone zone, Encounter encounter)
    {
        Map<String, String> queryParams = new HashMap();
        List<Ranking> rankings = new ArrayList();
        queryParams.put("zone", Integer.toString(zone.getId()));
        queryParams.put("encounter", Integer.toString(encounter.getId()));
        queryParams.put("metric", "dps");
        queryParams.put("class", Integer.toString(PlayerClass.MAGE.getId()));
        queryParams.put("spec", Integer.toString(Specialisation.FROST_MAGE.getId()));

        JSONArray array = call(Arrays.asList("parses", "character", characterName, serverName, serverRegion), queryParams, HttpMethod.GET);

        ObjectMapper mapper = new ObjectMapper();
        for(int i = 0; i < array.length(); i++)
        {
            JSONObject rankingJson = array.getJSONObject(i);
            try
            {
                Ranking ranking = mapper.readValue(rankingJson.toString(), Ranking.class);
                //ranking.setSpec(ranking.getPlayerClass().getSpecForInt(rankingJson.getInt("spec")));
                ranking.setSpec(Specialisation.FROST_MAGE);
                ranking.setZone(zone);
                ranking.setEncounter(encounter);
                System.out.println("ranking = " + ranking);
                rankings.add(ranking);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

        }



        return rankings;
    }

    public List<Zone> getAllZones()
    {
        String path = "zones";
        JSONArray retVal = call(path, RequestType.GET);
        List<Zone> zones = new ArrayList();

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            for(int i = 0; i < retVal.length(); i++)
            {
                //Single out Zones
                JSONObject zoneObject = retVal.getJSONObject(i);
                //Break up into zones, encounters
                JSONArray encountersArray = new JSONArray(zoneObject.remove("encounters").toString());
                Zone zone = mapper.readValue(zoneObject.toString(), Zone.class);

                //Parse encounters
                List<Encounter> encounters = mapper.readValue(encountersArray.toString(), new TypeReference<List<Encounter>>(){});
                for(Encounter e : encounters)
                {
                    e.setZone(zone);
                }

                zone.setEncounters(encounters);
                zones.add(zone);
            }
        }
        catch(Exception e)
        {
            System.err.println(e + " " + e.getMessage());
        }

        return zones;
    }


    private JSONArray call(List<String> pathParams, Map<String, String> queryParams, HttpMethod method)
    {
        RestTemplate template = templateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlAndPort + apiVersion);

        for(String pathParam : pathParams)
        {
            builder.path(pathParam + "/");
        }

        for(String queryParam : queryParams.keySet())
        {
            builder.queryParam(queryParam, queryParams.get(queryParam));
        }

        builder.queryParam("api_key", apiKey);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        System.out.println("builder.build().encode().toUri() = " + builder.build().encode().toUri());

        HttpEntity<String> response = template.exchange(
            builder.build().encode().toUri(),
            method,
            entity,
            String.class);

        JSONArray jsonArray = new JSONArray(response.getBody());

        System.out.println(jsonArray.toString());

        return jsonArray;

    }



    private JSONArray call(String path, RequestType type)
    {
        RestTemplate template = templateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity(headers);


        String url = urlAndPort + apiVersion + path;
        url = addApiKey(url);
        url = cleanURL(url);

        System.out.println("Calling with URL: " + url);

        switch(type)
        {
            case GET:
                JSONArray body = template.getForEntity(url, JSONArray.class).getBody();
                return body;
        }

        return null;
    }


    private String addApiKey(String url)
    {
        if(url.contains("?"))
        {
            url+="&";
        }
        else
        {
            url+="?";
        }
        return url+=apiKey;
    }

    private String cleanURL(String url)
    {
     return url.replace("ö", "%C3%B6");
    }

}
