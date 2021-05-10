package com.test.project.Akvelon.service;

import com.test.project.Akvelon.dao.WeatherDtoDao;
import com.test.project.Akvelon.entity.Weather;
import com.test.project.Akvelon.entity.WeatherDto;
import com.test.project.Akvelon.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class WheatherService {

    @Autowired
    private WeatherDtoDao weatherDtoDao;
    public final RestTemplate restTemplate;
    private final String APIKEY = "&appid=3db5cb23964dddbc4d9ec184ad260f25";
    private final String URI = "https://api.openweathermap.org/data/2.5/weather?q=";

    @Value("${myschedule.name}")
    private String nameCity;

    public WheatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    public WeatherDto getPostsPlainJSON(String cityId){
        String url = URI+cityId+APIKEY;
        System.out.println(url);

        return  someLogicForWeather(url);
    }

    @Scheduled(cron = "1 * * * * ?")
    @EventListener(ApplicationReadyEvent.class)
    public WeatherDto getPostsPlainJSON(){

        String url = URI+nameCity+APIKEY;
        System.out.println(url);

        return  someLogicForWeather(url);
    }

    public WeatherDto someLogicForWeather(String url) throws HttpClientErrorException {
        Weather forObjectJson;
        WeatherDto weatherDto = null;

            forObjectJson = restTemplate.getForObject(url, Weather.class);
            weatherDto = MappingUtils.mapToWeatherDta(forObjectJson);

            if (weatherDtoDao.findByName(weatherDto.getName()) != null) {
                WeatherDto byName = weatherDtoDao.findByName(weatherDto.getName());
                weatherDtoDao.deleteById(byName.getId());
            }
            weatherDtoDao.save(weatherDto);

            return weatherDto;

    }
}
