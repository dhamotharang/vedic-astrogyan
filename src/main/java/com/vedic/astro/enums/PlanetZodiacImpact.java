package com.vedic.astro.enums;

public enum PlanetZodiacImpact {
	
	Debiliated(-1.5), Sad(-1.0), Happy(1.0), Exalted(1.5), Owner(2.0), Neutral(0.0);
	
	private double score;
	
	private PlanetZodiacImpact(double score){
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
