package com.vedic.astro.dto;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetAge;

public class PlanetStrengthDTO {
	
	private String id = null;
	private Planet planet = null;
	private PlanetAge age = null;
	private Double score = null;
	
	public PlanetStrengthDTO(String id, Planet planet, PlanetAge age, Double score) {
		this.id = id;
		this.planet = planet;
		this.age = age;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public PlanetAge getAge() {
		return age;
	}
	public void setAge(PlanetAge age) {
		this.age = age;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "PlanetStrengthDTO [id=" + id + ", planet=" + planet + ", age=" + age + ", score=" + score + "]";
	}
}
