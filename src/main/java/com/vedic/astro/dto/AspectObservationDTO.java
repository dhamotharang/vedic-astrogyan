package com.vedic.astro.dto;

import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.enums.ObservationSource;
import com.vedic.astro.enums.ObservationSourceComponent;

public class AspectObservationDTO {
	
	private String observation;
	private boolean timeDependent;
	private ObservationNature nature;
	private ObservationSource source;
	private ObservationSourceComponent sourceCategory;
	private String conditions;
	

	public AspectObservationDTO(){}
	
	public AspectObservationDTO(String observation, boolean timeDependent, ObservationNature nature,
			ObservationSource source, ObservationSourceComponent sourceCategory) {
		this.observation = observation;
		this.timeDependent = timeDependent;
		this.nature = nature;
		this.source = source;
		this.sourceCategory = sourceCategory;
	}
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
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	@Override
	public String toString() {
		return "AspectObservationDTO [observation=" + observation + ", timeDependent=" + timeDependent + ", nature="
				+ nature + ", source=" + source + ", sourceCategory=" + sourceCategory + ", conditions=" + conditions
				+ "]";
	}
}
