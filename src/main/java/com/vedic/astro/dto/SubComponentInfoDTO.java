package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.AnalysisGroup;

public class SubComponentInfoDTO {
	
	private String componentName = null;
	private String componentCode = null;
	private String name = null;
	private String code = null;
	private String conditionChecked = null;
	
	private PredictionTemplateDTO predictionTemplate = null;
	private List<PredictionOutcomeDTO> predictionOutcomes = new ArrayList<PredictionOutcomeDTO>();

	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
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
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	@Override
	public String toString() {
		return "SubComponentInfoDTO [componentName=" + componentName + ", componentCode=" + componentCode + ", name="
				+ name + ", code=" + code + ", conditionChecked=" + conditionChecked + ", predictionTemplate="
				+ predictionTemplate + ", predictionOutcomes=" + predictionOutcomes + "]";
	}
}
