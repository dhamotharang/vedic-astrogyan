package com.vedic.astro.dto;

import java.util.Date;

public class FindMainDashaDTO {
	
	private String memberPid = null;
	private Date date = null;
	
	public String getMemberPid() {
		return memberPid;
	}
	public void setMemberPid(String memberPid) {
		this.memberPid = memberPid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "FindMainDashaDTO [memberPid=" + memberPid + ", date=" + date + "]";
	}
}
