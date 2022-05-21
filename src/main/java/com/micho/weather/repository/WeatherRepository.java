package com.micho.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micho.weather.dao.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
