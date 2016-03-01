package com.vedic.astro.dto;

import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.ObservationNature;

public class ProfilePredictionDTO {
	
	private String outcome = null;
	private String componentName = null;
	private AnalysisGroup analysisGroup = null;
	private String subComponentName = null;
	private String conditionChecked = null;
	private String observation = null;
	private ObservationNature nature = null;
	private Boolean timeDependent = null;
	
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public ObservationNature getNature() {
		return nature;
	}
	public void setNature(ObservationNature nature) {
		this.nature = nature;
	}
	public Boolean getTimeDependent() {
		return timeDependent;
	}
	public void setTimeDependent(Boolean timeDependent) {
		this.timeDependent = timeDependent;
	}
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	public String getSubComponentName() {
		return subComponentName;
	}
	public void setSubComponentName(String subComponentName) {
		this.subComponentName = subComponentName;
	}
	@Override
	public String toString() {
		return "ProfilePredictionDTO [outcome=" + outcome + ", componentName=" + componentName + ", analysisGroup="
				+ analysisGroup + ", subComponentName=" + subComponentName + ", conditionChecked=" + conditionChecked
				+ ", observation=" + observation + ", nature=" + nature + ", timeDependent=" + timeDependent + "]";
	}
}
