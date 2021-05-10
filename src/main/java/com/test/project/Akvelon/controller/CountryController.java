package com.test.project.Akvelon.controller;

import com.test.project.Akvelon.entity.Country;
import com.test.project.Akvelon.service.ICountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private ICountry iCountry;

    @GetMapping("/countries")
    public List<Country> getAll(){
        return iCountry.findAll();
    }

    @PostMapping("/countries")
    public void addNew(@RequestBody Country country){
        iCountry.saveCountry(country);
    }

    @PutMapping("/countries/{countryId}")
    public void updateCountry(@RequestBody Country country,
                              @PathVariable int countryId){
        iCountry.findById(countryId)
                .map(c -> {
                    c.setName(country.getName());
                    c.setSmallName(country.getSmallName());

                    return iCountry.saveCountry(c);
                })
                .orElseGet(() -> {
                    country.setId(countryId);
                    return iCountry.saveCountry(country);
                });
    }
    @DeleteMapping("/countries/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        iCountry.deleteById(id);
    }

}
