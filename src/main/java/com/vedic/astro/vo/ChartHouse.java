package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Zodiac;

public class ChartHouse extends BaseChartHouse{
	
	private List<HousePlanetInput> planets = new ArrayList<HousePlanetInput>();
	private HouseAscInput asc = null;

	public ChartHouse(Zodiac zodiac, List<HousePlanetInput> planets,
			House house) {
		super();
		this.zodiac = zodiac;
		this.planets = planets;
		this.house = house;
	}
	
	public ChartHouse(Zodiac zodiac, List<HousePlanetInput> planets,
			HouseAscInput asc, House house) {
		super();
		this.zodiac = zodiac;
		this.planets = planets;
		this.asc = asc;
		this.house = house;
	}

	public ChartHouse(){}
	
	public List<HousePlanetInput> getPlanets() {
		return planets;
	}
	public void setPlanets(List<HousePlanetInput> planets) {
		this.planets = planets;
	}
	
	public void addPlanet(HousePlanetInput housePlanetInput){
		this.planets.add(housePlanetInput);
	}
	
	public HouseAscInput getAsc() {
		return asc;
	}

	public void setAsc(HouseAscInput asc) {
		this.asc = asc;
	}
	@Override
	public String toString() {
		return "ChartHouse [zodiac=" + zodiac + ", planets=" + planets
				+ ", asc=" + asc + ", house=" + house + "]";
	}
}
