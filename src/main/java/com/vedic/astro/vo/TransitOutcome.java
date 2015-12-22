package com.vedic.astro.vo;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.TransitImpact;
import com.vedic.astro.enums.TransitReference;

public class TransitOutcome {
	
	private TransitImpact impact = null;
	private String details = null;
	private Integer distanceFromReference;
	private TransitReference referencePoint;
	private TransitImpact subTransitPeriodOutcome;  

	public TransitOutcome(TransitImpact impact, String details,
			Integer distanceFromReference, TransitReference referencePoint) {
		super();
		this.impact = impact;
		this.details = details;
		this.distanceFromReference = distanceFromReference;
		this.referencePoint = referencePoint;
	}
	
	
	public TransitOutcome(TransitImpact impact, String details,
			Integer distanceFromReference, TransitReference referencePoint,
			TransitImpact subTransitPeriodOutcome) {
		super();
		this.impact = impact;
		this.details = details;
		this.distanceFromReference = distanceFromReference;
		this.referencePoint = referencePoint;
		this.subTransitPeriodOutcome = subTransitPeriodOutcome;
	}


	public TransitOutcome(TransitImpact impact, TransitReference referencePoint) {
		super();
		this.impact = impact;
		this.referencePoint = referencePoint;
	}

	public TransitImpact getImpact() {
		return impact;
	}
	public void setImpact(TransitImpact impact) {
		this.impact = impact;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getDistanceFromReference() {
		return distanceFromReference;
	}
	public void setDistanceFromReference(Integer distanceFromReference) {
		this.distanceFromReference = distanceFromReference;
	}
	public TransitReference getReferencePoint() {
		return referencePoint;
	}
	public void setReferencePoint(TransitReference referencePoint) {
		this.referencePoint = referencePoint;
	}
	public TransitImpact getSubTransitPeriodOutcome() {
		return subTransitPeriodOutcome;
	}
	public void setSubTransitPeriodOutcome(TransitImpact subTransitPeriodOutcome) {
		this.subTransitPeriodOutcome = subTransitPeriodOutcome;
	}
	@Override
	public String toString() {
		return "TransitOutcome [impact=" + impact + ", details=" + details
				+ ", distanceFromReference=" + distanceFromReference
				+ ", referencePoint=" + referencePoint
				+ ", subTransitPeriodOutcome=" + subTransitPeriodOutcome + "]";
	}
}
