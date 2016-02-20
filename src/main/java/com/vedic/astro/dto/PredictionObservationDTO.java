package com.vedic.astro.dto;

import com.vedic.astro.enums.ObservationNature;

public class PredictionObservationDTO {

	private String observation;
	private boolean timeDependent;
	private ObservationNature nature;
	private String aspectCode;
	private String aspectPath;
	
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
	public String getAspectCode() {
		return aspectCode;
	}
	public void setAspectCode(String aspectCode) {
		this.aspectCode = aspectCode;
	}
	public String getAspectPath() {
		return aspectPath;
	}
	public void setAspectPath(String aspectPath) {
		this.aspectPath = aspectPath;
	}
	@Override
	public String toString() {
		return "PredictionObservationDTO [observation=" + observation + ", timeDependent=" + timeDependent + ", nature="
				+ nature + ", aspectCode=" + aspectCode + ", aspectPath=" + aspectPath + "]";
	}
}
