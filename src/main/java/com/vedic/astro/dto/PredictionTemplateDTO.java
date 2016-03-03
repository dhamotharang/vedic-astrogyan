package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.MemberType;

public class PredictionTemplateDTO {
	
	private String name = null;
	private String code = null;
	private List<String> aspectCodes = new ArrayList<String>();
	private MemberType memberType = null;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getAspectCodes() {
		return aspectCodes;
	}
	public void setAspectCodes(List<String> aspectCodes) {
		this.aspectCodes = aspectCodes;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	@Override
	public String toString() {
		return "PredictionTemplateDTO [name=" + name + ", code=" + code + ", aspectCodes=" + aspectCodes
				+ ", memberType=" + memberType + "]";
	}
}
