package com.test.project.Akvelon.service;

import com.test.project.Akvelon.dao.CountryDao;
import com.test.project.Akvelon.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryImpl implements ICountry{

    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryDao.findAll();
    }

    @Override
    public Optional<Country> findById(int theId) {
        return countryDao.findById(theId);
    }

    @Override
    public void deleteById(int id) {
        countryDao.deleteById(id);
    }

    @Override
    public Country saveCountry(Country country) {
        countryDao.save(country);
        return country;
    }

}
