package com.vedic.astro.domain;

import java.util.HashSet;
import java.util.Set;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.RajaYogaCombinationType;

public class RajaYogaCombination {
	
	private Set<Planet> planets = new HashSet<Planet>();
	
	private Set<House> houses = new HashSet<House>();
	
	private RajaYogaCombinationType combinationType = null;
	
	public void addHouse(House house){
		this.houses.add(house);
	}

	public void addPlanet(Planet planet){
		this.planets.add(planet);
	}

	public Set<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(Set<Planet> planets) {
		this.planets = planets;
	}

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public RajaYogaCombinationType getCombinationType() {
		return combinationType;
	}

	public void setCombinationType(RajaYogaCombinationType combinationType) {
		this.combinationType = combinationType;
	}

	@Override
	public String toString() {
		return "RajaYogaCombination [planets=" + planets + ", houses=" + houses
				+ ", combinationType=" + combinationType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((combinationType == null) ? 0 : combinationType.hashCode());
		result = prime * result + ((houses == null) ? 0 : houses.hashCode());
		result = prime * result + ((planets == null) ? 0 : planets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RajaYogaCombination other = (RajaYogaCombination) obj;
		if (combinationType != other.combinationType)
			return false;
		if (houses == null) {
			if (other.houses != null)
				return false;
		} else if (!houses.equals(other.houses))
			return false;
		if (planets == null) {
			if (other.planets != null)
				return false;
		} else if (!planets.equals(other.planets))
			return false;
		return true;
	} 
}
