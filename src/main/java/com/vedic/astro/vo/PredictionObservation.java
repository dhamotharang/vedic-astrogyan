package com.vedic.astro.vo;

import java.util.Date;

import com.vedic.astro.domain.ObservationCondition;
import com.vedic.astro.enums.PlanetNature;

public class PredictionObservation {
	
	private String description;
	private boolean timeDependent;
	private PlanetNature nature;
	private Date fromTimeline;
	private Date toTimeline;
	private ObservationCondition condition;

	public PredictionObservation(String description, boolean timeDependent,
			PlanetNature nature, Date fromTimeline, Date toTimeline,
			ObservationCondition condition) {
		super();
		this.description = description;
		this.timeDependent = timeDependent;
		this.nature = nature;
		this.fromTimeline = fromTimeline;
		this.toTimeline = toTimeline;
		this.condition = condition;
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
	public Date getFromTimeline() {
		return fromTimeline;
	}
	public void setFromTimeline(Date fromTimeline) {
		this.fromTimeline = fromTimeline;
	}
	public Date getToTimeline() {
		return toTimeline;
	}
	public void setToTimeline(Date toTimeline) {
		this.toTimeline = toTimeline;
	}
	public ObservationCondition getCondition() {
		return condition;
	}
	public void setCondition(ObservationCondition condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "PredictionObservation [description=" + description
				+ ", timeDependent=" + timeDependent + ", nature=" + nature
				+ ", fromTimeline=" + fromTimeline + ", toTimeline="
				+ toTimeline + ", condition=" + condition + "]";
	}
}
