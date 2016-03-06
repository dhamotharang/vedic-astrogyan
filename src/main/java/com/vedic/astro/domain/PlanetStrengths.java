package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.PredictionSystem;

@Document(collection = "planet_strengths")
@TypeAlias("planet_strength")
public class PlanetStrengths {
	@Id
	private String id = null;

    private String memberId = null;
	private PredictionSystem predictionSystem = null;
	private List<PlanetStrength> strengths = new ArrayList<PlanetStrength>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}
	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
	}
	public List<PlanetStrength> getStrengths() {
		return strengths;
	}
	public void setStrengths(List<PlanetStrength> strengths) {
		this.strengths = strengths;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "PlanetStrengths [id=" + id + ", memberId=" + memberId + ", predictionSystem=" + predictionSystem
				+ ", strengths=" + strengths + "]";
	}
}
