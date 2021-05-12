package com.test.project.Akvelon.controller;

import com.test.project.Akvelon.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/city")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{countryId}/weather/current")
    public Object get(@PathVariable String countryId) {
        try {
            return ResponseEntity.ok()
                    .body(weatherService.getPostsPlainJSON(countryId));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Your city name has the wrong," +
                    " please check and send again");
        }

    }

}
