package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.AnalysisGroup;

@Document(collection = "analysis_components")
@TypeAlias("analysis_component")
public class AnalysisComponent {

	@Id
	private String id = null;
	private AnalysisGroup analysisGroup = null; 
	private String code = null;
	private String name = null;
	private String conditionChecked = null;
	private String predictionTemplateCode = null;
	private List<String> predictionOutcomes = new ArrayList<String>();
	private Boolean enabled = Boolean.TRUE;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<String> getPredictionOutcomes() {
		return predictionOutcomes;
	}
	public void setPredictionOutcomes(List<String> predictionOutcomes) {
		this.predictionOutcomes = predictionOutcomes;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "AnalysisComponent [id=" + id + ", analysisGroup=" + analysisGroup + ", code=" + code + ", name=" + name
				+ ", conditionChecked=" + conditionChecked + ", predictionTemplateCode=" + predictionTemplateCode
				+ ", predictionOutcomes=" + predictionOutcomes + ", enabled=" + enabled + "]";
	}
}
