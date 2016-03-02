package com.vedic.astro.domain;

public class SubComponentOutcome {

	private String subComponentCode = null;
	private String predictionOutcomeCode = null;

	public SubComponentOutcome() {
	}
	public SubComponentOutcome(String subComponentCode, String predictionOutcomeCode) {
		this.subComponentCode = subComponentCode;
		this.predictionOutcomeCode = predictionOutcomeCode;
	}
	public String getSubComponentCode() {
		return subComponentCode;
	}
	public void setSubComponentCode(String subComponentCode) {
		this.subComponentCode = subComponentCode;
	}
	public String getPredictionOutcomeCode() {
		return predictionOutcomeCode;
	}
	public void setPredictionOutcomeCode(String predictionOutcomeCode) {
		this.predictionOutcomeCode = predictionOutcomeCode;
	}
	@Override
	public String toString() {
		return "SubComponentOutcome [subComponentCode=" + subComponentCode + ", predictionOutcomeCode="
				+ predictionOutcomeCode + "]";
	}
}
