package com.vedic.astro.dto;

public class SubComponentOutcomeDTO {
	
	private String component = null;
	private String outcome = null;
	private String conditionChecked = null;

	public SubComponentOutcomeDTO(){}
	
	public SubComponentOutcomeDTO(String component, String outcome, String conditionChecked) {
		super();
		this.component = component;
		this.outcome = outcome;
		this.conditionChecked = conditionChecked;
	}
	
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	@Override
	public String toString() {
		return "ChartImpactDTO [component=" + component + ", outcome=" + outcome + ", conditionChecked="
				+ conditionChecked + "]";
	}
}
