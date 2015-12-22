package com.vedic.astro.vo;

public class PlanetDegree {
	
	private Integer degrees;
	private Integer minutes;
	private Integer seconds;
	
	public PlanetDegree(Integer degrees, Integer minutes, Integer seconds) {
		super();
		this.degrees = degrees;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public Integer getDegrees() {
		return degrees;
	}
	public void setDegrees(Integer degrees) {
		this.degrees = degrees;
	}
	public Integer getMinutes() {
		return minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public Integer getSeconds() {
		return seconds;
	}
	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
	
	

}
