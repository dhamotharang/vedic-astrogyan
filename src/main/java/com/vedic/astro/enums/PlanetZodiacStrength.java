package com.vedic.astro.enums;

public enum PlanetZodiacStrength {
	MooltrikonaSign(45.0), OwnSign(30.0), FastFriendSign(22.5), FriendSign(15.0), NeutralSign(7.5), EnemySign(3.75), BitterEnemySign(1.875);
	
	private Double score;

	private PlanetZodiacStrength(Double score) {
		this.score = score;
	}

	public Double getScore() {
		return score;
	}
}
