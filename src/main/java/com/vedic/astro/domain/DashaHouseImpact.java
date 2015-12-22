package com.vedic.astro.domain;

import java.util.HashSet;
import java.util.Set;

import com.vedic.astro.enums.Planet;

public class DashaHouseImpact {
	
	private Set<Planet> planets = new HashSet<Planet>();
	private Integer impactCount = 0;
	
	
	public Set<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(Set<Planet> planets) {
		this.planets = planets;
	}
	public Integer getImpactCount() {
		return impactCount;
	}
	public void setImpactCount(Integer impactCount) {
		this.impactCount = impactCount;
	}
	
	public void addPlanet(Planet planet){
		this.planets.add(planet);
	}
	
	public void incrementCount(){
		impactCount++;
	}

	@Override
	public String toString() {
		return "DashaHouseImpact [planets=" + planets + ", impactCount="
				+ impactCount + "]";
	}
}