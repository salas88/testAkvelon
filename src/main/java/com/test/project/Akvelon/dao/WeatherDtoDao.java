package com.test.project.Akvelon.dao;

import com.test.project.Akvelon.entity.WeatherDto;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDtoDao extends CrudRepository<WeatherDto, Long> {
    WeatherDto findByName(String name);
}
