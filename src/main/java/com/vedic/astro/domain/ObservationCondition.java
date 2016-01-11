package com.vedic.astro.domain;

import com.vedic.astro.enums.EntityType;

public class ObservationCondition {
	
	private EntityType sourceType;
	private String sourceValue;
	
	public EntityType getSourceType() {
		return sourceType;
	}
	public void setSourceType(EntityType sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceValue() {
		return sourceValue;
	}
	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	@Override
	public String toString() {
		return "ObservationCondition [sourceType=" + sourceType
				+ ", sourceValue=" + sourceValue + "]";
	}

}
