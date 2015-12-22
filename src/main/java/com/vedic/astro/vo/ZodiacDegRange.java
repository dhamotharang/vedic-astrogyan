package com.vedic.astro.vo;

public class ZodiacDegRange {
	
	private Double minDegrees;
	private Double maxDegrees;
	
	public ZodiacDegRange(Double minDegrees, Double maxDegrees) {
		super();
		this.minDegrees = minDegrees;
		this.maxDegrees = maxDegrees;
	}

	public Double getMinDegrees() {
		return minDegrees;
	}
	public void setMinDegrees(Double minDegrees) {
		this.minDegrees = minDegrees;
	}
	public Double getMaxDegrees() {
		return maxDegrees;
	}
	public void setMaxDegrees(Double maxDegrees) {
		this.maxDegrees = maxDegrees;
	}
	@Override
	public String toString() {
		return "ZodiacDegRange [minDegrees=" + minDegrees + ", maxDegrees="
				+ maxDegrees + "]";
	}
}
