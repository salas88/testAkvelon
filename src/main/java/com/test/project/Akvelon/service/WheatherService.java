package com.test.project.Akvelon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.project.Akvelon.entity.Weather;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class WheatherService {

    public final RestTemplate restTemplate;

    public WheatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private final String APIKEY = "&appid=3db5cb23964dddbc4d9ec184ad260f25";
    private final String URI = "https://api.openweathermap.org/data/2.5/weather?q=";

//    @Scheduled(cron = "1 * * * * ?")
//    @EventListener(ApplicationReadyEvent.class)
    public Weather getPostsPlainJSON(String cityId){

        String url = URI+cityId+APIKEY;
        System.out.println(url);
        return this.restTemplate.getForObject(url, Weather.class);
    }
}
