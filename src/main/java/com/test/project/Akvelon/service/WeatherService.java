package com.test.project.Akvelon.service;

import com.test.project.Akvelon.dao.WeatherDtoDao;
import com.test.project.Akvelon.entity.Weather;
import com.test.project.Akvelon.entity.WeatherDto;
import com.test.project.Akvelon.utils.MappingUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
@Slf4j
public class WeatherService {

    @Autowired
    private WeatherDtoDao weatherDtoDao;

    public final RestTemplate restTemplate;
    private final String APIKEY = "&appid=3db5cb23964dddbc4d9ec184ad260f25";
    private final String URI = "https://api.openweathermap.org/data/2.5/weather?q=";

    @Value("${myschedule.name}")
    private String nameCity;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }
    //method which process request from client
    public WeatherDto getPostsPlainJSON(String cityId){
        String url = URI+cityId+APIKEY;
        log.info("******");
        log.info(url);
        log.info("******");
        return someLogicForWeather(url);
    }

    //method which creates and sends request to weather's service every 11 min
    @Scheduled(cron = "11 * * * * ?")
    @EventListener(ApplicationReadyEvent.class)
    public WeatherDto getPostsPlainJSON(){
        String url = URI+nameCity+APIKEY;
        log.info("******");
        log.info(url);
        log.info("******");
        return someLogicForWeather(url);
    }

    // this method creates an entity (weatherDto) if don't exist or replace the entity for new
    public WeatherDto someLogicForWeather(String url) throws HttpClientErrorException {
        Weather forObjectJson;
        WeatherDto weatherDto;

            forObjectJson = restTemplate.getForObject(url, Weather.class);
            weatherDto = MappingUtils.mapToWeatherDta(forObjectJson);

            if (weatherDtoDao.findByName(weatherDto.getName()) != null) {
                WeatherDto byName = weatherDtoDao.findByName(weatherDto.getName());
                weatherDtoDao.deleteById(byName.getId());
                log.info("******");
                log.debug(weatherDto.getName());
                log.info("******");
            }
            weatherDtoDao.save(weatherDto);

            return weatherDto;

    }
}
