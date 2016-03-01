package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "analysis_sub_components")
@TypeAlias("analysis_sub_component")
public class AnalysisSubComponent {

	@Id
	private String id = null;
	private String componentCode = null; 
	private String code = null;
	private String name = null;
	private String conditionChecked = null;
	private String predictionTemplateCode = null;
	private List<String> predictionOutcomes = new ArrayList<String>();
	

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
	public List<String> getPredictionOutcomes() {
		return predictionOutcomes;
	}
	public void setPredictionOutcomes(List<String> predictionOutcomes) {
		this.predictionOutcomes = predictionOutcomes;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	@Override
	public String toString() {
		return "AnalysisSubComponent [id=" + id + ", componentCode=" + componentCode + ", code=" + code + ", name="
				+ name + ", conditionChecked=" + conditionChecked + ", predictionTemplateCode=" + predictionTemplateCode
				+ ", predictionOutcomes=" + predictionOutcomes + "]";
	}
}
