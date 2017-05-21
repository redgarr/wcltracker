package com.brynhagen.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jonathan on 2017-05-21.
 */

public class RestCaller {

    private static RestTemplateBuilder templateBuilder;

    public static String getPlayer(String name)
    {
        RestTemplate template = templateBuilder.build();

        
    }

}
