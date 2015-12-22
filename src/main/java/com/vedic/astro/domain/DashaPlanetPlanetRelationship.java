package com.vedic.astro.domain;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetPlanetRelationship;
import com.vedic.astro.enums.PlanetPlanetRelationshipType;

public class DashaPlanetPlanetRelationship {
	
	private Planet planet;
	private PlanetPlanetRelationshipType relationshipType;

	public DashaPlanetPlanetRelationship(Planet planet,
			PlanetPlanetRelationshipType relationshipType) {
		super();
		this.planet = planet;
		this.relationshipType = relationshipType;
	}

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public PlanetPlanetRelationshipType getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(PlanetPlanetRelationshipType relationshipType) {
		this.relationshipType = relationshipType;
	}

	@Override
	public String toString() {
		return "DashaPlanetPlanetRelationship [planet=" + planet
				+ ", relationshipType=" + relationshipType + "]";
	}
}
