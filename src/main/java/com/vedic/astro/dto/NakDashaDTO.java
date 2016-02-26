package com.vedic.astro.dto;

import com.vedic.astro.enums.Planet;

public class NakDashaDTO extends BaseDashaDTO{

	private Planet planet = null;
	
	public NakDashaDTO(Planet planet, String startDate, String endDate) {
		this.planet = planet;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public NakDashaDTO() {}
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	@Override
	public String toString() {
		return "NakDashaDTO [planet=" + planet + "]";
	}
}
