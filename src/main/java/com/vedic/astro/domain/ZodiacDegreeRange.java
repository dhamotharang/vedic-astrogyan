package com.vedic.astro.domain;

public class ZodiacDegreeRange {
	
	private Double startDeg;
	private Double endDeg;
	
	public ZodiacDegreeRange(Double startDeg, Double endDeg) {
		super();
		this.startDeg = startDeg;
		this.endDeg = endDeg;
	}
	
	public Double getStartDeg() {
		return startDeg;
	}
	public void setStartDeg(Double startDeg) {
		this.startDeg = startDeg;
	}
	public Double getEndDeg() {
		return endDeg;
	}
	public void setEndDeg(Double endDeg) {
		this.endDeg = endDeg;
	}
	@Override
	public String toString() {
		return "ZodiacDegreeRange [startDeg=" + startDeg + ", endDeg=" + endDeg
				+ "]";
	}
	
	
	public boolean isBetween(Double deg){
		
		boolean result = false;
		
		result = ((deg.doubleValue() > this.startDeg) && (deg.doubleValue()<= this.endDeg));
		
		return result;
	}
}
