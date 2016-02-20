package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.AnalysisGroup;

public class ComponentInfoDTO {
	
	private AnalysisGroup analysisGroup = null; 
	private String name = null;
	private String conditionChecked = null;
	private String predictionTemplateName = null;
	private Boolean enabled = true;
	private List<String> predictionOutcomeNames = new ArrayList<String>();
	
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	public String getPredictionTemplateName() {
		return predictionTemplateName;
	}
	public void setPredictionTemplateName(String predictionTemplateName) {
		this.predictionTemplateName = predictionTemplateName;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public List<String> getPredictionOutcomeNames() {
		return predictionOutcomeNames;
	}
	public void setPredictionOutcomeNames(List<String> predictionOutcomeNames) {
		this.predictionOutcomeNames = predictionOutcomeNames;
	}
	public void addPredictionOutcomeName(String predictionOutcomeName) {
		this.predictionOutcomeNames.add(predictionOutcomeName);
	}
	@Override
	public String toString() {
		return "ComponentInfoDTO [analysisGroup=" + analysisGroup + ", name=" + name + ", conditionChecked="
				+ conditionChecked + ", predictionTemplateName=" + predictionTemplateName + ", enabled=" + enabled
				+ ", predictionOutcomeNames=" + predictionOutcomeNames + "]";
	}
}
