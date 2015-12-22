package com.vedic.astro.vo;

import com.vedic.astro.enums.PlanetPlanetRelationship;

public class PlanetPlanetRelationshipInput {

	private PlanetPlanetRelationship temporaryRelationship;
	private PlanetPlanetRelationship permanentRelationship;
	
	public PlanetPlanetRelationshipInput(
			PlanetPlanetRelationship temporaryRelationship,
			PlanetPlanetRelationship permanentRelationship) {
	
		super();
		this.temporaryRelationship = temporaryRelationship;
		this.permanentRelationship = permanentRelationship;
	}

	public PlanetPlanetRelationship getTemporaryRelationship() {
		return temporaryRelationship;
	}
	public void setTemporaryRelationship(
			PlanetPlanetRelationship temporaryRelationship) {
		this.temporaryRelationship = temporaryRelationship;
	}
	public PlanetPlanetRelationship getPermanentRelationship() {
		return permanentRelationship;
	}
	public void setPermanentRelationship(
			PlanetPlanetRelationship permanentRelationship) {
		this.permanentRelationship = permanentRelationship;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((permanentRelationship == null) ? 0 : permanentRelationship
						.hashCode());
		result = prime
				* result
				+ ((temporaryRelationship == null) ? 0 : temporaryRelationship
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetPlanetRelationshipInput other = (PlanetPlanetRelationshipInput) obj;
		if (permanentRelationship != other.permanentRelationship)
			return false;
		if (temporaryRelationship != other.temporaryRelationship)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanetPlanetRelationshipInput [temporaryRelationship="
				+ temporaryRelationship + ", permanentRelationship="
				+ permanentRelationship + "]";
	}
}
