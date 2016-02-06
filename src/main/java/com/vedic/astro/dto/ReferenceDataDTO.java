package com.vedic.astro.dto;

public class ReferenceDataDTO {
	
	private String code = null;
	private String name = null;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ReferenceDataDTO [code=" + code + ", name=" + name + "]";
	}
}
