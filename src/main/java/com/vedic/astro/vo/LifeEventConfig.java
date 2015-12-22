package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.Collection;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;

public class LifeEventConfig {
	
	private Collection<House> housesChanged = new ArrayList<House>();
	
	private Collection<Planet> planetsChanged = new ArrayList<Planet>();

	public Collection<House> getHousesChanged() {
		return housesChanged;
	}

	public void setHousesChanged(Collection<House> housesChanged) {
		this.housesChanged = housesChanged;
	}
	
	public void addHouseChanged(House houseChanged) {
		this.housesChanged.add(houseChanged);
	}

	public Collection<Planet> getPlanetsChanged() {
		return planetsChanged;
	}

	public void setPlanetsChanged(Collection<Planet> planetsChanged) {
		this.planetsChanged = planetsChanged;
	}

	public void addPlanetsChanged(Planet planetChanged) {
		this.planetsChanged.add(planetChanged);
	}

	@Override
	public String toString() {
		return "LifeEventConfig [housesChanged=" + housesChanged
				+ ", planetsChanged=" + planetsChanged + "]";
	}
}
