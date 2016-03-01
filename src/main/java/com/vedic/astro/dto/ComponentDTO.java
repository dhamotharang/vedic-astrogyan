package com.vedic.astro.dto;

import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;

public class ComponentDTO {
	
	private AnalysisGroup analysisGroup = null; 
	private PredictionSystem predictionSystem = null;
	private String code = null;
	private String name = null;
	private boolean enabled = true;
	
	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}
	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
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
		return "ComponentDTO [analysisGroup=" + analysisGroup + ", predictionSystem=" + predictionSystem + ", code="
				+ code + ", name=" + name + ", enabled=" + enabled + "]";
	}
}
