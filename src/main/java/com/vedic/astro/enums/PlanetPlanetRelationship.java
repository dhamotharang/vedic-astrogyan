package com.vedic.astro.enums;

public enum PlanetPlanetRelationship {
	
	Enemy(-1.0), Friend(1.0), Neutral(0.0);
	
	private double score;
	
	private PlanetPlanetRelationship(double score){
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
