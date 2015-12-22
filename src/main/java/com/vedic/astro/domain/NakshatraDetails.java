package com.vedic.astro.domain;

import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;

public class NakshatraDetails {
	
	private Nakshatra nakshatra;
	private Planet lord;
	public Nakshatra getNakshatra() {
		return nakshatra;
	}
	public void setNakshatra(Nakshatra nakshatra) {
		this.nakshatra = nakshatra;
	}
	public Planet getLord() {
		return lord;
	}
	public void setLord(Planet lord) {
		this.lord = lord;
	}
	@Override
	public String toString() {
		return "NakshatraDetails [nakshatra=" + nakshatra + ", lord=" + lord
				+ "]";
	}
}
