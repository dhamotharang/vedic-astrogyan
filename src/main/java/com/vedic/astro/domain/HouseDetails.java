package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Relationship;
import com.vedic.astro.enums.TravelType;

public class HouseDetails {
	
	private String bodyParts;
	private Relationship relationship;
	private TravelType travelImpact;
	private String characteristics;
	private List<HouseType> houseTypes = new ArrayList<HouseType>();
	private List<Planet> karaka = new ArrayList<Planet>();
	private Double kendraPowerlessPosition;
	
	
	public Relationship getRelationship() {
		return relationship;
	}
	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}
	public TravelType getTravelImpact() {
		return travelImpact;
	}
	public void setTravelImpact(TravelType travelImpact) {
		this.travelImpact = travelImpact;
	}
	public String getBodyParts() {
		return bodyParts;
	}
	public void setBodyParts(String bodyParts) {
		this.bodyParts = bodyParts;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	
	public List<HouseType> getHouseTypes() {
		return houseTypes;
	}
	public void setHouseTypes(List<HouseType> houseTypes) {
		this.houseTypes = houseTypes;
	}
	
	public void addHouseType(HouseType houseType){
		this.houseTypes.add(houseType);
	}
	
	public List<Planet> getKaraka() {
		return karaka;
	}
	public void setKaraka(List<Planet> karaka) {
		this.karaka = karaka;
	}
	
	public void addKaraka(Planet karaka) {
		this.karaka.add(karaka);
	}
	
	public Double getKendraPowerlessPosition() {
		return kendraPowerlessPosition;
	}
	public void setKendraPowerlessPosition(Double kendraPowerlessPosition) {
		this.kendraPowerlessPosition = kendraPowerlessPosition;
	}
	@Override
	public String toString() {
		return "HouseDetails [bodyParts=" + bodyParts + ", relationship="
				+ relationship + ", travelImpact=" + travelImpact
				+ ", characteristics=" + characteristics + ", houseTypes="
				+ houseTypes + ", karaka=" + karaka
				+ ", kendraPowerlessPosition=" + kendraPowerlessPosition + "]";
	}
}