package com.vedic.astro.domain;

import java.util.Date;

public class DashaTimePeriod {
	
	public DashaTimePeriod(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public DashaTimePeriod() {}
	
	private Date startDate;
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "DashaTimePeriod [startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
}
