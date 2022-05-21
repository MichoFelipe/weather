/**
 * 
 */
package com.micho.weather.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MICHAEL
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "weather")
public class Weather {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "city")
	private String 	city;
	
	@Column(name = "state")
	private String 	state;
	
	@Column(name = "lat")	
	private Long 	lat;
	
	@Column(name = "lon")
	private Long 	lon;
	
	
	
}
