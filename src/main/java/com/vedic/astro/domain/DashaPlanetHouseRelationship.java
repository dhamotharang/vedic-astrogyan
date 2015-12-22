package com.vedic.astro.domain;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HousePlanetRelationshipType;
import com.vedic.astro.enums.Planet;

public class DashaPlanetHouseRelationship {
	
	private Planet planet;
	private House house;
	private HousePlanetRelationshipType housePlanetRelationship;

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public HousePlanetRelationshipType getHousePlanetRelationship() {
		return housePlanetRelationship;
	}
	public void setHousePlanetRelationship(
			HousePlanetRelationshipType housePlanetRelationship) {
		this.housePlanetRelationship = housePlanetRelationship;
	}
	@Override
	public String toString() {
		return "DashaPlanetHouseRelationship [planet=" + planet + ", house="
				+ house + ", housePlanetRelationship="
				+ housePlanetRelationship + "]";
	}
}
