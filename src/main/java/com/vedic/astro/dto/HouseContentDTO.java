package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.Planet;

public class HouseContentDTO {
	
	private Integer zod = -1;
	private Integer arudha = -1;
	private List<Planet> planets = new ArrayList<Planet>();
	private List<Double> longitudes = new ArrayList<Double>();
	private List<Integer> naks = new ArrayList<Integer>();
	private Planet lord = null;
	
	public HouseContentDTO(int zod, List<Planet> planets, List<Integer> naks, List<Double> longitudes,int arudha, Planet lord ) {
		this.zod = zod;
		this.planets = planets;
		this.naks = naks;
		this.longitudes = longitudes;
		this.arudha = arudha;
		this.lord = lord;
	}
	
	public HouseContentDTO(int zod, int arudha, Planet lord) {
		this.zod = zod;
		this.lord = lord;
		this.arudha = arudha;
	}

	public void addPlanet(Planet planet){
		planets.add(planet);
	}
	public void addLongitude(Double longitude){
		longitudes.add(longitude);
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

	public int getArudha() {
		return arudha;
	}
	public void setArudha(int arudha) {
		this.arudha = arudha;
	}
	public List<Double> getLongitudes() {
		return longitudes;
	}
	public void setLongitudes(List<Double> longitudes) {
		this.longitudes = longitudes;
	}
	public List<Integer> getNaks() {
		return naks;
	}
	public void setNaks(List<Integer> naks) {
		this.naks = naks;
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
	public void setArudha(Integer arudha) {
		this.arudha = arudha;
	}

	@Override
	public String toString() {
		return "HouseContentDTO [zod=" + zod + ", arudha=" + arudha + ", planets=" + planets + ", longitudes="
				+ longitudes + ", naks=" + naks + ", lord=" + lord + "]";
	}
	
}
