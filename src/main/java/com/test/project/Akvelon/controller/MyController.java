package com.test.project.Akvelon.controller;

import com.test.project.Akvelon.service.WheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/theweather")
public class MyController {

    @Autowired
    private WheatherService wheatherService;

    @GetMapping("/a/{countryId}")
    public Object get(@PathVariable String countryId) {
        try {
            return ResponseEntity.ok()
                    .body(wheatherService.getPostsPlainJSON(countryId));
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your city name has the wrong name," +
                    " please check and send again");
        }

    }

}
