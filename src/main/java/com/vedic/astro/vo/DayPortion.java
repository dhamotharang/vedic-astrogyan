package com.vedic.astro.vo;

import java.util.Date;

public class DayPortion {
	
	private Date startPortion;
	private Date endPortion;
	
	public DayPortion(Date startPortion, Date endPortion) {
		super();
		this.startPortion = startPortion;
		this.endPortion = endPortion;
	}

	public Date getStartPortion() {
		return startPortion;
	}

	public void setStartPortion(Date startPortion) {
		this.startPortion = startPortion;
	}

	public Date getEndPortion() {
		return endPortion;
	}

	public void setEndPortion(Date endPortion) {
		this.endPortion = endPortion;
	}

	@Override
	public String toString() {
		return "DayPortion [startPortion=" + startPortion + ", endPortion="
				+ endPortion + "]";
	}
}
