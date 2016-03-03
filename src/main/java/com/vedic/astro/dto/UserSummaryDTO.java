package com.vedic.astro.dto;

public class UserSummaryDTO {
	
	private String name = null;
	private String id = null;

	public UserSummaryDTO() {
	}
	public UserSummaryDTO(String name, String dob, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserSummaryDTO [name=" + name + ", id=" + id + "]";
	}
}
