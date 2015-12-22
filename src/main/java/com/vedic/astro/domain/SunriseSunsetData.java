package com.vedic.astro.domain;

import java.util.Date;

public class SunriseSunsetData {
	
	private String sunsetTime;
	private String sunriseTime;

	public SunriseSunsetData(String sunsetTime, String sunriseTime) {
		super();
		this.sunsetTime = sunsetTime;
		this.sunriseTime = sunriseTime;
	}

	public String getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(String sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public String getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(String sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	@Override
	public String toString() {
		return "SunriseSunsetData [sunsetTime=" + sunsetTime + ", sunriseTime="
				+ sunriseTime + "]";
	}
}