package com.vedic.astro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;

@Document(collection = "analysis_components")
@TypeAlias("analysis_component")
public class AnalysisComponent {

	@Id
	private String id = null;
	private AnalysisGroup analysisGroup = null; 
	private PredictionSystem predictionSystem = null;
	private String code = null;
	private String name = null;
	private Boolean enabled = Boolean.TRUE;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}
	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	@Override
	public String toString() {
		return "AnalysisComponent [id=" + id + ", analysisGroup=" + analysisGroup + ", predictionSystem="
				+ predictionSystem + ", code=" + code + ", name=" + name + ", enabled=" + enabled + "]";
	}
}
