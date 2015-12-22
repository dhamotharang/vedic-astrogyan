package com.vedic.astro.vo;

import com.vedic.astro.enums.Planet;

public class PlanetAbsoluteLocation {
	
	private Double degrees;
	private Planet planet;
	
	public PlanetAbsoluteLocation(Planet planet, Double degrees) {
		super();
		this.degrees = degrees;
		this.planet = planet;
	}

	public Double getDegrees() {
		return degrees;
	}
	public void setDegrees(Double degrees) {
		this.degrees = degrees;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	@Override
	public String toString() {
		return "PlanetAbsoluteLocation [degrees=" + degrees + ", planet="
				+ planet + "]";
	}
}
