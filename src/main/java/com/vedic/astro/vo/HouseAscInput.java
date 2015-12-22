package com.vedic.astro.vo;

import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;

public class HouseAscInput {
	
	public HouseAscInput(Double degrees, Nakshatra nakshatra,
			Planet nakshatraLord, Planet nakshatraSubLord) {
		super();
		this.degrees = degrees;
		this.nakshatra = nakshatra;
		this.nakshatraLord = nakshatraLord;
		this.nakshatraSubLord = nakshatraSubLord;
	}

	public HouseAscInput(){}
	
	private Double degrees;
	private Nakshatra nakshatra;
	private Planet nakshatraLord;
	private Planet nakshatraSubLord;

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
		return "HouseAscInput [degrees=" + degrees + ", nakshatra=" + nakshatra
				+ ", nakshatraLord=" + nakshatraLord + ", nakshatraSubLord="
				+ nakshatraSubLord + "]";
	}
}
