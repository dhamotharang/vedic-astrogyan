package com.vedic.astro.dto;

import java.util.Date;

public class BaseFindAntarDashaDTO {
	
	protected String startDate = null;
	protected String endDate = null;
	protected Date asOfDate = null;
	
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
	public Date getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	@Override
	public String toString() {
		return "BaseFindAntarDashaDTO [startDate=" + startDate + ", endDate=" + endDate + ", asOfDate=" + asOfDate
				+ "]";
	}
}
