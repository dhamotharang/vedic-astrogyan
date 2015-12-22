package com.vedic.astro.eval;

import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class HouseEvaluationData {
	
	private Planet planet;
	private List<Planet> otherPlanets;
	private Planet ownerPlanet;
	private House house;
	private Zodiac zodiac;
	private Nakshatra nakshatra;

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public List<Planet> getOtherPlanets() {
		return otherPlanets;
	}
	public void setOtherPlanets(List<Planet> otherPlanets) {
		this.otherPlanets = otherPlanets;
	}
	public Planet getOwnerPlanet() {
		return ownerPlanet;
	}
	public void setOwnerPlanet(Planet ownerPlanet) {
		this.ownerPlanet = ownerPlanet;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}
	public Nakshatra getNakshatra() {
		return nakshatra;
	}
	public void setNakshatra(Nakshatra nakshatra) {
		this.nakshatra = nakshatra;
	}
	@Override
	public String toString() {
		return "ActivityInputData [planet=" + planet + ", otherPlanets="
				+ otherPlanets + ", ownerPlanet=" + ownerPlanet + ", house="
				+ house + ", zodiac=" + zodiac + ", nakshatra=" + nakshatra
				+ "]";
	}
}
