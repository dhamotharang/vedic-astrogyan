package com.vedic.astro.vo;

import com.vedic.astro.enums.Planet;

public class PlanetStrength {
	
	public PlanetStrength(Planet planet, Double score) {
		super();
		this.planet = planet;
		this.score = score;
	}

	private Planet planet;
	private Double score;

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "PlanetStrength [planet=" + planet + ", score=" + score + "]";
	}
}