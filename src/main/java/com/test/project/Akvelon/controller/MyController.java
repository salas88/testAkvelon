package com.test.project.Akvelon.controller;

import com.test.project.Akvelon.entity.Weather;
import com.test.project.Akvelon.service.WheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theweather")
public class MyController {

    @Autowired
    private WheatherService wheatherService;

    @GetMapping("/a/{countryId}")
    public Weather get(@PathVariable String countryId){

        return  wheatherService.getPostsPlainJSON(countryId);
    }
}
