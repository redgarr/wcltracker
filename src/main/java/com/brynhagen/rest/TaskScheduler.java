package com.brynhagen.rest;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jonathan on 2017-05-21.
 */
@Component
public class TaskScheduler {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime()
    {
    }
}
