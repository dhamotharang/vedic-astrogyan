package com.vedic.astro.domain;

import java.io.Serializable;
import java.util.Map;

import com.vedic.astro.enums.EntityImpact;
import com.vedic.astro.enums.PlanetHouseImpact;
import com.vedic.astro.enums.PlanetPlanetRelationship;
import com.vedic.astro.enums.PlanetZodiacImpact;


public class EntityRelationshipValue implements Serializable {
	
	
	private PlanetPlanetRelationship planetImpact;
	private PlanetHouseImpact houseImpact;
	private PlanetZodiacImpact zodiacImpact;
	
	private Map<String, String> additionalInfo;

	
	

	
	
	public PlanetPlanetRelationship getPlanetImpact() {
		return planetImpact;
	}
	public void setPlanetImpact(PlanetPlanetRelationship planetImpact) {
		this.planetImpact = planetImpact;
	}
	public PlanetHouseImpact getHouseImpact() {
		return houseImpact;
	}
	public void setHouseImpact(PlanetHouseImpact houseImpact) {
		this.houseImpact = houseImpact;
	}
	public PlanetZodiacImpact getZodiacImpact() {
		return zodiacImpact;
	}
	public void setZodiacImpact(PlanetZodiacImpact zodiacImpact) {
		this.zodiacImpact = zodiacImpact;
	}
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "EntityRelationshipValue [planetImpact=" + planetImpact
				+ ", houseImpact=" + houseImpact + ", zodiacImpact="
				+ zodiacImpact + ", additionalInfo=" + additionalInfo + "]";
	}
}
