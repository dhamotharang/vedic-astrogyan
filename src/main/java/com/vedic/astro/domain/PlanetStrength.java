package com.vedic.astro.domain;

import com.vedic.astro.enums.Planet;

public class PlanetStrength {

	private Planet planet = null;
	private Double strength = null;
	
	public PlanetStrength() {
	}
	public PlanetStrength(Planet planet, Double strength) {
		this.planet = planet;
		this.strength = strength;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Double getStrength() {
		return strength;
	}
	public void setStrength(Double strength) {
		this.strength = strength;
	}
	@Override
	public String toString() {
		return "PlanetStrength [planet=" + planet + ", strength=" + strength + "]";
	} 
}
