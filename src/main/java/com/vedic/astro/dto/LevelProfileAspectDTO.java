package com.vedic.astro.dto;

public class LevelProfileAspectDTO {
	
	private String code = null;
	private String name = null;
	private String id = null;
	private String parentCode = null;

	public LevelProfileAspectDTO() {
	}

	public LevelProfileAspectDTO(String code, String name) {
		this.code = code;
		this.name = name;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Override
	public String toString() {
		return "LevelProfileAspectDTO [code=" + code + ", name=" + name + ", id=" + id + ", parentCode=" + parentCode
				+ "]";
	}
}