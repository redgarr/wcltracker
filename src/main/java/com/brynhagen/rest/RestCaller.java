package com.brynhagen.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Component
public class RestCaller {

    private static RestCaller instance = null;

    enum RequestType
    {
        GET,
        POST,
        DELETE,
        PUT;
    }
    public static RestCaller getInstance() {
        if (instance == null) {
            instance = new RestCaller();
        }
        return instance;
    }

    @Value("classpath:api.key")
    private Resource apiFile;

    private RestCaller() {
        templateBuilder = new RestTemplateBuilder();
    }

    private static RestTemplateBuilder templateBuilder;

    private static String apiKey;

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

    public static String getUser(String name)
    {
        String url = "https://www.warcraftlogs.com:443/v1/reports/user/" + name;


        call(url, RequestType.GET);
        return "oops";
    }

    private static void call(String url, RequestType type)
    {
        RestTemplate template = templateBuilder.build();
        url = addApiKey(url);
        switch(type)
        {
            case GET:
                    String body = template.getForEntity(url, String.class).getBody().replaceAll("\\[", "").replaceAll("\\]","");
                    JSONObject jsonObject = new JSONObject(body);
                    System.out.println(jsonObject);
                    break;
        }
    }

    private static String addApiKey(String url)
    {
        return url+=apiKey;
    }

}
