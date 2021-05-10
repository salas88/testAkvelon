package com.test.project.Akvelon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "weather")
public class WeatherDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double windSpeed;
    private String weatherDescription;
    private Double temperature;
    private Double temperatureMin;
    private Double temperatureMax;
    private String country;

}
