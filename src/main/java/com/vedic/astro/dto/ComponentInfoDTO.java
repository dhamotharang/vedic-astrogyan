package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.AnalysisGroup;

public class ComponentInfoDTO {
	
	private AnalysisGroup analysisGroup = null; 
	private String name = null;
	private String code = null;
	private String conditionChecked = null;
	private PredictionTemplateDTO predictionTemplate = null;
	private List<PredictionOutcomeDTO> predictionOutcomes = new ArrayList<PredictionOutcomeDTO>();
	private Boolean enabled = true;

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
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public PredictionTemplateDTO getPredictionTemplate() {
		return predictionTemplate;
	}
	public void setPredictionTemplate(PredictionTemplateDTO predictionTemplate) {
		this.predictionTemplate = predictionTemplate;
	}
	public List<PredictionOutcomeDTO> getPredictionOutcomes() {
		return predictionOutcomes;
	}
	public void setPredictionOutcomes(List<PredictionOutcomeDTO> predictionOutcomes) {
		this.predictionOutcomes = predictionOutcomes;
	}
	@Override
	public String toString() {
		return "ComponentInfoDTO [analysisGroup=" + analysisGroup + ", name=" + name + ", code=" + code
				+ ", conditionChecked=" + conditionChecked + ", predictionTemplate=" + predictionTemplate
				+ ", predictionOutcomes=" + predictionOutcomes + ", enabled=" + enabled + "]";
	}
}
