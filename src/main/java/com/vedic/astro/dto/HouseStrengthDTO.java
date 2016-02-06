package com.vedic.astro.dto;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetAge;

public class HouseStrengthDTO {
	
	private String id = null;
	private House house = null;
	private Double score = null;
	
	public HouseStrengthDTO(String id, House house, Double score) {
		this.id = id;
		this.house = house;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "HouseStrengthDTO [id=" + id + ", house=" + house + ", score=" + score + "]";
	}
}
