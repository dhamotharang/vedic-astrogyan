package com.vedic.astro.vo;

import com.vedic.astro.enums.NakDashaSystem;
import com.vedic.astro.enums.LifeEvent;

public class LifeEventPrediction {
	
	private String pid;
	private String startDate; 
	private String endDate; 
	private NakDashaSystem dashaSystem;
	private LifeEvent lifeEvent;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public NakDashaSystem getDashaSystem() {
		return dashaSystem;
	}
	public void setDashaSystem(NakDashaSystem dashaSystem) {
		this.dashaSystem = dashaSystem;
	}
	public LifeEvent getLifeEvent() {
		return lifeEvent;
	}
	public void setLifeEvent(LifeEvent lifeEvent) {
		this.lifeEvent = lifeEvent;
	}
	@Override
	public String toString() {
		return "LifeEventPrediction [pid=" + pid + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", dashaSystem=" + dashaSystem
				+ ", lifeEvent=" + lifeEvent + "]";
	}
}
