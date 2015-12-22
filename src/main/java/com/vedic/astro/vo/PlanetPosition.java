package com.vedic.astro.vo;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class PlanetPosition extends ZodiacPosition{
	
	private Planet planet;
	
	public PlanetPosition(){}
	
	public PlanetPosition(Double degrees, Zodiac zodiac, Planet planet) {
		super();
		super.setDegrees(degrees);
		super.setZodiac(zodiac);
		this.planet = planet;
	}
	
	public PlanetPosition(Double degrees, Planet planet) {
		super();
		super.setDegrees(degrees);
		this.planet = planet;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	@Override
	public String toString() {
		return "PlanetPosition [planet=" + planet + ", getDegrees()="
				+ getDegrees() + ", getZodiac()=" + getZodiac() + "]";
	}
}
