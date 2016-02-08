package com.vedic.astro.dto;

public class MemberSummaryDTO {
	
	private String name = null;
	private String dob = null;
	private String id = null;

	public MemberSummaryDTO() {
		
	}
	public MemberSummaryDTO(String name, String dob, String id) {
		this.name = name;
		this.dob = dob;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MemberSummaryDTO [name=" + name + ", dob=" + dob + ", id=" + id + "]";
	}
}
