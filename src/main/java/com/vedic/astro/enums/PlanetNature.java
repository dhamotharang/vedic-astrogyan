package com.vedic.astro.enums;

public enum PlanetNature {
	Malefic(0), Benefic(1), Neutral(-1);
	
	private int value;

	private PlanetNature(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
