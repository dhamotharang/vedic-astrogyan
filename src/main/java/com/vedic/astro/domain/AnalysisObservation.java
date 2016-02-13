package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.enums.ObservationSource;
import com.vedic.astro.enums.ObservationSourceComponent;
import com.vedic.astro.enums.PredictionSystem;

public class AnalysisObservation {

	private String observation;
	private boolean timeDependent;
	private ObservationNature nature;
	private ObservationSource source;
	private ObservationSourceComponent sourceCategory;
	private PredictionSystem predictionSystem = null;
	private List<ObservationCondition> conditions = 
			new ArrayList<ObservationCondition>();

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public boolean isTimeDependent() {
		return timeDependent;
	}

	public void setTimeDependent(boolean timeDependent) {
		this.timeDependent = timeDependent;
	}

	public ObservationNature getNature() {
		return nature;
	}

	public void setNature(ObservationNature nature) {
		this.nature = nature;
	}

	public ObservationSource getSource() {
		return source;
	}

	public void setSource(ObservationSource source) {
		this.source = source;
	}

	public ObservationSourceComponent getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(ObservationSourceComponent sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	public List<ObservationCondition> getConditions() {
		return conditions;
	}

	public void setConditions(List<ObservationCondition> conditions) {
		this.conditions = conditions;
	}

	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}

	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
	}

	@Override
	public String toString() {
		return "AnalysisObservation [observation=" + observation + ", timeDependent=" + timeDependent + ", nature="
				+ nature + ", source=" + source + ", sourceCategory=" + sourceCategory + ", predictionSystem="
				+ predictionSystem + ", conditions=" + conditions + "]";
	}
}