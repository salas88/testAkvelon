package com.test.project.Akvelon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Weather {

    private Map<String,Object> coord;
    private List<Map<String, Object>> weather;
    private String base;
    private Map<String,Double> main;
    private Long visibility;
    private Map<String,Double> wind;
    private Map<String,Object> clouds;
    private Long dt;
    private Map<String,Object> sys;
    private Integer timezone;
    private Long id;
    private String name;
    private Integer cod;

    @Override
    public String toString() {
        return "Weather{" +
                "weather=" + weather +
                ", main=" + main +
                ", name='" + name + '\'' +
                '}';
    }
}
