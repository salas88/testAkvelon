package com.test.project.Akvelon.controller;

import com.test.project.Akvelon.service.CountryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {
    @Autowired
    private CountryImpl country;

    @GetMapping("/1")
    public void a(){
        country.simpleJob();
    }
}
