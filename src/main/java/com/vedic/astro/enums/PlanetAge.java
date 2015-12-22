package com.vedic.astro.enums;

public enum PlanetAge {
	
	Infant(0.25), Teen(0.75), Young(1.0), Mature(0.75), Old(0.5);
	
	private double factor;
	
	private PlanetAge(double factor){
		this.setFactor(factor);
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

}
