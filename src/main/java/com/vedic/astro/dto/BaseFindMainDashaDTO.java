package com.vedic.astro.dto;

import java.util.Date;

public class BaseFindMainDashaDTO {
	
	protected String memberPid = null;
	protected Date asOfDate = null;

	public String getMemberPid() {
		return memberPid;
	}
	public void setMemberPid(String memberPid) {
		this.memberPid = memberPid;
	}
	public Date getAsOfDate() {
		return asOfDate;
	}
	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}
	@Override
	public String toString() {
		return "FindMainDashaDTO [memberPid=" + memberPid + ", asOfDate=" + asOfDate + "]";
	}
}
