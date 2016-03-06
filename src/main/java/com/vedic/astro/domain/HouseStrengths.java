package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.PredictionSystem;

@Document(collection = "house_strengths")
@TypeAlias("house_strength")
public class HouseStrengths {
	@Id
	private String id = null;

    private String memberId = null;
	private PredictionSystem predictionSystem = null;
	private List<HouseStrength> strengths = new ArrayList<HouseStrength>();
	
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public List<HouseStrength> getStrengths() {
		return strengths;
	}
	public void setStrengths(List<HouseStrength> strengths) {
		this.strengths = strengths;
	}
	@Override
	public String toString() {
		return "HouseStrengths [id=" + id + ", memberId=" + memberId + ", predictionSystem=" + predictionSystem
				+ ", strengths=" + strengths + "]";
	}
}
