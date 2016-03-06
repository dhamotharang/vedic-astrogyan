package com.vedic.astro.domain;

import com.vedic.astro.enums.House;

public class HouseStrength {

	private House house = null;
	private Double strength = null;
	
	public HouseStrength() {
	}

	public HouseStrength(House house, Double strength) {
		super();
		this.house = house;
		this.strength = strength;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Double getStrength() {
		return strength;
	}

	public void setStrength(Double strength) {
		this.strength = strength;
	}

	@Override
	public String toString() {
		return "HouseStrength [house=" + house + ", strength=" + strength + "]";
	}
}
