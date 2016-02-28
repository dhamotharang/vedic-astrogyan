package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.Planet;

public class VargaHouseContentDTO {
	
	private Integer zod = -1;
	private List<Planet> planets = new ArrayList<Planet>();
	private Planet lord = null;
	
	public VargaHouseContentDTO(int zod, List<Planet> planets, Planet lord ) {
		this.zod = zod;
		this.planets = planets;
		this.lord = lord;
	}

	public void addPlanet(Planet planet){
		planets.add(planet);
	}
	public int getZod() {
		return zod;
	}
	public void setZod(int zod) {
		this.zod = zod;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	public Planet getLord() {
		return lord;
	}
	public void setLord(Planet lord) {
		this.lord = lord;
	}
	public void setZod(Integer zod) {
		this.zod = zod;
	}

	@Override
	public String toString() {
		return "VargaHouseContentDTO [zod=" + zod + ", planets=" + planets + ", lord=" + lord + "]";
	}
}
