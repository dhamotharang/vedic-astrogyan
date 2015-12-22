package com.vedic.astro.vo;

import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;

public class HousePlanetInput {
	
	public HousePlanetInput(Planet planet, Double degrees, Nakshatra nakshatra,
			Planet nakshatraLord, Planet nakshatraSubLord) {
		super();
		this.planet = planet;
		this.degrees = degrees;
		this.nakshatra = nakshatra;
		this.nakshatraLord = nakshatraLord;
		this.nakshatraSubLord = nakshatraSubLord;
	}

	public HousePlanetInput(Planet planet) {
		super();
		this.planet = planet;
	}

	public HousePlanetInput(){}
	
	private Planet planet;
	private Double degrees;
	private Nakshatra nakshatra;
	private Planet nakshatraLord;
	private Planet nakshatraSubLord;

	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Double getDegrees() {
		return degrees;
	}
	public void setDegrees(Double degrees) {
		this.degrees = degrees;
	}
	public Nakshatra getNakshatra() {
		return nakshatra;
	}
	public void setNakshatra(Nakshatra nakshatra) {
		this.nakshatra = nakshatra;
	}
	public Planet getNakshatraLord() {
		return nakshatraLord;
	}
	public void setNakshatraLord(Planet nakshatraLord) {
		this.nakshatraLord = nakshatraLord;
	}
	public Planet getNakshatraSubLord() {
		return nakshatraSubLord;
	}
	public void setNakshatraSubLord(Planet nakshatraSubLord) {
		this.nakshatraSubLord = nakshatraSubLord;
	}
	@Override
	public String toString() {
		
		if(nakshatra!=null){
		return "HousePlanetInput [planet=" + planet + ", degrees=" + degrees
				+ ", nakshatra=" + nakshatra + ", nakshatraLord="
				+ nakshatraLord + ", nakshatraSubLord=" + nakshatraSubLord
				+ "]";
		}
		else{
			return toStringForDiv();
		}
	}
	
	public String toStringForDiv() {
		return "HousePlanetInput [planet=" + planet +  "]";
	}

}
