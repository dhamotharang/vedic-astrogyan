package com.vedic.astro.dto;

import com.vedic.astro.enums.Planet;

public class BaseDashaDTO {

	protected String startDate = null;
	protected String endDate = null;
	protected boolean current = false;
	
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
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	@Override
	public String toString() {
		return "BaseDashaDTO [startDate=" + startDate + ", endDate=" + endDate + ", current=" + current + "]";
	}
}
