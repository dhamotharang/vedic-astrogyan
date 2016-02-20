package com.vedic.astro.dto;

import com.vedic.astro.enums.AnalysisGroup;

public class ComponentDTO {
	
	private AnalysisGroup analysisGroup = null; 
	private String code = null;
	private String name = null;
	private String conditionChecked = null;
	private String predictionTemplateCode = null;
	private Boolean enabled = true;
	
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
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
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	public String getPredictionTemplateCode() {
		return predictionTemplateCode;
	}
	public void setPredictionTemplateCode(String predictionTemplateCode) {
		this.predictionTemplateCode = predictionTemplateCode;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "ComponentDTO [analysisGroup=" + analysisGroup + ", code=" + code + ", name=" + name
				+ ", conditionChecked=" + conditionChecked + ", predictionTemplateCode=" + predictionTemplateCode
				+ ", enabled=" + enabled + "]";
	}
}
