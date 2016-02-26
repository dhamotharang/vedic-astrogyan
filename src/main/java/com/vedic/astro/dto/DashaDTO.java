package com.vedic.astro.dto;

import com.vedic.astro.enums.Planet;

public class DashaDTO {

	private Planet planet = null;
	private String startDate = null;
	private String endDate = null;
	private boolean current = false;
	
	public DashaDTO(Planet planet, String startDate, String endDate) {
		this.planet = planet;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public DashaDTO() {}
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	@Override
	public String toString() {
		return "DashaDTO [planet=" + planet + ", startDate=" + startDate + ", endDate=" + endDate + ", current="
				+ current + "]";
	}
}
