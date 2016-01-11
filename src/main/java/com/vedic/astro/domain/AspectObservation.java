package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.enums.ProfileAspectType;

public class AspectObservation {

	private String pid;
	private String description;
	private boolean timeDependent;
	private PlanetNature nature;
	private ObservationCondition source;
	private ProfileAspectType aspectType;
	private List<ObservationCondition> dashaConditions = new ArrayList<ObservationCondition>();
	private PredictionSystem predictionSystem;
	

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTimeDependent() {
		return timeDependent;
	}
	public void setTimeDependent(boolean timeDependent) {
		this.timeDependent = timeDependent;
	}
	public PlanetNature getNature() {
		return nature;
	}
	public void setNature(PlanetNature nature) {
		this.nature = nature;
	}
	public ObservationCondition getSource() {
		return source;
	}
	public void setSource(ObservationCondition source) {
		this.source = source;
	}
	public List<ObservationCondition> getDashaConditions() {
		return dashaConditions;
	}
	public void setDashaConditions(List<ObservationCondition> dashaConditions) {
		this.dashaConditions = dashaConditions;
	}
	
	public ProfileAspectType getAspectType() {
		return aspectType;
	}
	public void setAspectType(ProfileAspectType aspectType) {
		this.aspectType = aspectType;
	}
	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}
	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
	}
	@Override
	public String toString() {
		return "AspectObservation [pid=" + pid + ", description=" + description
				+ ", timeDependent=" + timeDependent + ", nature=" + nature
				+ ", source=" + source + ", aspectType=" + aspectType
				+ ", dashaConditions=" + dashaConditions
				+ ", predictionSystem=" + predictionSystem + "]";
	}
}
