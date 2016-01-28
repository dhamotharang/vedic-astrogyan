package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.enums.ProfileAspectType;

public class AspectObservation {

	private String pid;
	private List<String> observations;
	private boolean timeDependent;
	private ObservationNature nature;
	private ObservationCondition source;
	private ProfileAspectType aspectType;
	private List<ObservationCondition> conditions = new ArrayList<ObservationCondition>();
	private PredictionSystem predictionSystem;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<String> getObservations() {
		return observations;
	}
	public void setObservations(List<String> observations) {
		this.observations = observations;
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
	public ObservationCondition getSource() {
		return source;
	}
	public void setSource(ObservationCondition source) {
		this.source = source;
	}
	public ProfileAspectType getAspectType() {
		return aspectType;
	}
	public void setAspectType(ProfileAspectType aspectType) {
		this.aspectType = aspectType;
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
		return "AspectObservation [pid=" + pid + ", observations=" + observations + ", timeDependent=" + timeDependent
				+ ", nature=" + nature + ", source=" + source + ", aspectType=" + aspectType + ", conditions="
				+ conditions + ", predictionSystem=" + predictionSystem + "]";
	}
}
