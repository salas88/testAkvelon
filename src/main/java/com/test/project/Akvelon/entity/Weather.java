package com.test.project.Akvelon.entity;

import java.util.List;
import java.util.Map;

public class Weather {

    private Map<String,Object> coord;
    private List<Object> weather;
    private String base;
    private Map<String,Object> main;
    private Long visibility;
    private Map<String,Object> wind;
    private Map<String,Object> clouds;
    private Long dt;
    private Map<String,Object> sys;
    private Integer timezone;
    private Long id;
    private String name;
    private Integer cod;

    public Map<String, Object> getCoord() {
        return coord;
    }

    public void setCoord(Map<String, Object> coord) {
        this.coord = coord;
    }

    public List<Object> getWeather() {
        return weather;
    }

    public void setWeather(List<Object> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Object> getMain() {
        return main;
    }

    public void setMain(Map<String, Object> main) {
        this.main = main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Map<String, Object> getWind() {
        return wind;
    }

    public void setWind(Map<String, Object> wind) {
        this.wind = wind;
    }

    public Map<String, Object> getClouds() {
        return clouds;
    }

    public void setClouds(Map<String, Object> clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Map<String, Object> getSys() {
        return sys;
    }

    public void setSys(Map<String, Object> sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather=" + weather +
                ", main=" + main +
                ", name='" + name + '\'' +
                '}';
    }
}
