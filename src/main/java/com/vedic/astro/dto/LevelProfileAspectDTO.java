package com.vedic.astro.dto;

import com.vedic.astro.enums.MemberType;

public class LevelProfileAspectDTO {
	
	private String code = null;
	private String name = null;
	private String id = null;
	private String parentCode = null;
	private MemberType memberType = null;

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
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "LevelProfileAspectDTO [code=" + code + ", name=" + name + ", id=" + id + ", parentCode=" + parentCode
				+ ", memberType=" + memberType + "]";
	}
}