package com.vedic.astro.vo;

import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class OwnerPlanetHouseStrengthInput {
	
	private Planet planet;
	private List<Planet> otherInhabitants;
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
		return "OwnerPlanetHouseStrengthInput [planet=" + planet
				+ ", otherInhabitants=" + otherInhabitants + ", zodiac="
				+ zodiac + ", house=" + house + "]";
	}
}
