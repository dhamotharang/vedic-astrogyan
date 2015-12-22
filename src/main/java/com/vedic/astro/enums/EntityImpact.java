package com.vedic.astro.enums;

public enum EntityImpact {

	Excellent(5), VeryGood(4), Positive(3), Negative(1), Neutral(2);
	
	private int score;
	
	private EntityImpact(int score){
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
