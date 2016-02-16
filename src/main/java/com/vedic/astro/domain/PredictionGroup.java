package com.vedic.astro.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="prediction_groups")
@TypeAlias("prediction_group")
public class PredictionGroup {

	@Id
	private String id = null;
	private String predictionTemplateCode = null;
	private String name = null;
	private Map<String, PredictionObservation> predictionObservations = 
			new HashMap<String, PredictionObservation>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPredictionTemplateCode() {
		return predictionTemplateCode;
	}
	public void setPredictionTemplateCode(String predictionTemplateCode) {
		this.predictionTemplateCode = predictionTemplateCode;
	}
	public Map<String, PredictionObservation> getPredictionObservations() {
		return predictionObservations;
	}
	public void setPredictionObservations(Map<String, PredictionObservation> predictionObservations) {
		this.predictionObservations = predictionObservations;
	}
	@Override
	public String toString() {
		return "PredictionGroup [id=" + id + ", predictionTemplateCode=" + predictionTemplateCode + ", name=" + name
				+ ", predictionObservations=" + predictionObservations + "]";
	}
}
