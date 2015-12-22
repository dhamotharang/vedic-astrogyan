package com.vedic.astro.enums;

public enum CharaKaraka {

	AtmaKarka(Relationship.Self,60.0), AmatyaKaraka(Relationship.Self,45.0), BhratruKaraka(Relationship.Sibling, 30.0), MatruKaraka(Relationship.Mother, 22.5), PutraKaraka(Relationship.Children, 15.0), GnatiKaraka(Relationship.Relatives, 7.5), StreeDaraKaraka(Relationship.Spouse, 3.75);
	
	private Relationship relationship;
	private Double score;
	
	private CharaKaraka(Relationship relationship, Double score) {
		this.relationship = relationship;
		this.score = score;
	}

	public Double getScore() {
		return score;
	}
	
	public Relationship getRelationship() {
		return relationship;
	}
}
