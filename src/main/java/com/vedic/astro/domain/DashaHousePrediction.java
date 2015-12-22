package com.vedic.astro.domain;

import java.util.Set;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Signification;

public class DashaHousePrediction {
	
	private Double impactPercent;
	private Integer normalizedImpactScore;
	private Set<Signification> likelyEvents;
	private House house;
	
	public Double getImpactPercent() {
		return impactPercent;
	}
	public void setImpactPercent(Double impactPercent) {
		this.impactPercent = impactPercent;
	}
	public Integer getNormalizedImpactScore() {
		return normalizedImpactScore;
	}
	public void setNormalizedImpactScore(Integer normalizedImpactScore) {
		this.normalizedImpactScore = normalizedImpactScore;
	}
	public Set<Signification> getLikelyEvents() {
		return likelyEvents;
	}
	public void setLikelyEvents(Set<Signification> likelyEvents) {
		this.likelyEvents = likelyEvents;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "DashaHousePrediction [impactPercent=" + impactPercent
				+ ", normalizedImpactScore=" + normalizedImpactScore
				+ ", likelyEvents=" + likelyEvents + ", house=" + house + "]";
	}
}
