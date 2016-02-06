package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class HouseContentDTO {
	
	private int zod = -1;
	private List<String> planets = new ArrayList<>();
	private int nak = -1;
	
	public HouseContentDTO(int zod, List<String> planets, int nak) {
		this.zod = zod;
		this.planets = planets;
		this.nak = nak;
	}
	
	public HouseContentDTO(int zod, int nak) {
		this.zod = zod;
		this.nak = nak;
	}

	public void addPlanet(String planet){
		planets.add(planet);
	}
	public int getZod() {
		return zod;
	}
	public void setZod(int zod) {
		this.zod = zod;
	}
	public List<String> getPlanets() {
		return planets;
	}
	public void setPlanets(List<String> planets) {
		this.planets = planets;
	}
	public int getNak() {
		return nak;
	}
	public void setNak(int nak) {
		this.nak = nak;
	}
	@Override
	public String toString() {
		return "HouseContentDTO [zod=" + zod + ", planets=" + planets + ", nak=" + nak + "]";
	}
}
