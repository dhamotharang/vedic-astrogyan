package com.vedic.astro.dto;

import java.util.Date;

import com.vedic.astro.enums.Planet;

public class FindAntarDashaDTO {
	
	private Planet planet = null;
	private String startDate = null;
	private String endDate = null;
	private Date date = null;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FindAntarDashaDTO [planet=" + planet + ", startDate=" + startDate + ", endDate=" + endDate + ", date="
				+ date + "]";
	}
}
