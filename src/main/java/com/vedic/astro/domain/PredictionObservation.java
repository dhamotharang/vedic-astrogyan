package com.vedic.astro.domain;

import com.vedic.astro.enums.ObservationNature;

public class PredictionObservation {
	
	private String observation;
	private boolean timeDependent;
	private ObservationNature nature;
	
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
	@Override
	public String toString() {
		return "PredictionObservation [observation=" + observation + ", timeDependent=" + timeDependent + ", nature="
				+ nature + "]";
	}
}
