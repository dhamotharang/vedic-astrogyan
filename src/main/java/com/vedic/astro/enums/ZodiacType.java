package com.vedic.astro.enums;

public enum ZodiacType {

	Fixed(30.0), Movable(15.0), Dual(60.0);
	
	private Double score;

	private ZodiacType(Double score) {
		this.score = score;
	}

	public Double getScore() {
		return score;
	}
}