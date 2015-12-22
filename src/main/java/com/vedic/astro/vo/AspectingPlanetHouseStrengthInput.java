package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class AspectingPlanetHouseStrengthInput {
	
	private Planet planet;
	private List<Planet> otherInhabitants = new ArrayList<Planet>();
	private Planet ownerOfHouse;
	private Zodiac zodiac;
	private House house;
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public List<Planet> getOtherInhabitants() {
		return otherInhabitants;
	}
	public void setOtherInhabitants(List<Planet> otherInhabitants) {
		this.otherInhabitants = otherInhabitants;
	}
	public Planet getOwnerOfHouse() {
		return ownerOfHouse;
	}
	public void setOwnerOfHouse(Planet ownerOfHouse) {
		this.ownerOfHouse = ownerOfHouse;
	}
	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}

	@Override
	public String toString() {
		return "AspectingPlanetHouseStrengthInput [planet=" + planet
				+ ", otherInhabitants=" + otherInhabitants + ", ownerOfHouse="
				+ ownerOfHouse + ", zodiac=" + zodiac + ", house=" + house
				+ "]";
	}
}
