package com.vedic.astro.dto;

import java.util.Date;

import com.vedic.astro.enums.Planet;

public class PlanetTransitInputDTO {

	private Planet planet = null;
	private Date asOfDate = null;

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Date getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	@Override
	public String toString() {
		return "PlanetTransitInputDTO [planet=" + planet + ", asOfDate=" + asOfDate + "]";
	}
}
