/**
 * 
 */
package com.micho.weather.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micho.weather.dao.Weather;
import com.micho.weather.repository.WeatherRepository;



/**
 * @author MICHAEL
 *
 */

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@PostMapping("/weather")
	public ResponseEntity<Weather> createWeather(@Valid @RequestBody Weather weather) {
		Weather _weather = weatherRepository.save(weather);
		return new ResponseEntity<>(_weather, HttpStatus.CREATED);
	}
	
	@GetMapping("/weather")
	public List<Weather> getAllWeathers(){
		List<Weather> weathers = weatherRepository.findAll();
		weathers.sort(Comparator.comparing(Weather::getId));
		return weathers;
	}
	
	@GetMapping("/weather/{id}")
	public ResponseEntity<Weather> getWeatherById(@PathVariable("id") Integer id) {
		Optional<Weather> weather = weatherRepository.findById(id);
		if(weather.isPresent()) {
			return new ResponseEntity<>(weather.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/weather/{id}")
	public ResponseEntity<HttpStatus> deleteWeather(@PathVariable("id") Integer id){
		try {
			weatherRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
