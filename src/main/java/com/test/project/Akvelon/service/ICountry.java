package com.test.project.Akvelon.service;

import com.test.project.Akvelon.entity.Country;

import java.util.List;
import java.util.Optional;

public interface ICountry {

    List<Country> findAll();
    Optional<Country> findById(int theId);
    void deleteById(int id);
    Country saveCountry(Country country);
}
