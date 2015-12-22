package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class VargaChartHouse extends BaseChartHouse{

	private List<Planet> planets = new ArrayList<Planet>();

	public VargaChartHouse(Zodiac zodiac, List<Planet> planets,
			House house) {
		this.house = house;
		this.planets = planets;
		this.zodiac = zodiac;
	}

	
	public VargaChartHouse() {
		super();
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}


	@Override
	public String toString() {
		return "VargaChartHouse [planets=" + planets + ", zodiac=" + zodiac
				+ ", house=" + house + "]";
	}
}