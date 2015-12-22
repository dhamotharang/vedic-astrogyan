package com.vedic.astro.enums;

public enum PlanetHouseImpact {
	
	Sad(-1.0), Happy(1.0), Neutral(0), Fully_Awakened(2.0), Asleep(-0.5);
	
	private double score;
	
	private PlanetHouseImpact(double score){
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
