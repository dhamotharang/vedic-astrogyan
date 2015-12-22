package com.vedic.astro.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;

public class DashaPlanetRelationship {

	private Planet dashaPlanet;
	private List<DashaPlanetPlanetRelationship> relatedPlanets;
	private Map<Planet, List<DashaPlanetHouseRelationship>> relationships;

	public Planet getDashaPlanet() {
		return dashaPlanet;
	}

	public void setDashaPlanet(Planet dashaPlanet) {
		this.dashaPlanet = dashaPlanet;
	}

	public List<DashaPlanetPlanetRelationship> getRelatedPlanets() {
		return relatedPlanets;
	}

	public void setRelatedPlanets(
			List<DashaPlanetPlanetRelationship> relatedPlanets) {
		this.relatedPlanets = relatedPlanets;
	}

	public Map<Planet, List<DashaPlanetHouseRelationship>> getRelationships() {
		return relationships;
	}

	public void setRelationships(
			Map<Planet, List<DashaPlanetHouseRelationship>> relationships) {
		this.relationships = relationships;
	}
	
	public Map<House, DashaHouseImpact> getMostImpactedHouses(){
		Map<House, DashaHouseImpact> impactMap = new HashMap<House, DashaHouseImpact>();
		Collection<List<DashaPlanetHouseRelationship>> allRelationships = this.relationships.values();
		
		for(List<DashaPlanetHouseRelationship> relationshipList : allRelationships){
			for(DashaPlanetHouseRelationship dashaPlanetHouseRelationship : relationshipList){
				DashaHouseImpact dashaImpact = impactMap.get(dashaPlanetHouseRelationship.getHouse());
				if(dashaImpact == null){
					dashaImpact = new DashaHouseImpact();
				}
				dashaImpact.addPlanet(dashaPlanetHouseRelationship.getPlanet());
				dashaImpact.incrementCount();
				
				impactMap.put(dashaPlanetHouseRelationship.getHouse(), dashaImpact);
			}
		}
		
		return impactMap;
	}

	@Override
	public String toString() {
		return "DashaPlanetRelationship [dashaPlanet=" + dashaPlanet
				+ ", relatedPlanets=" + relatedPlanets + ", relationships="
				+ relationships + "]";
	}
}
