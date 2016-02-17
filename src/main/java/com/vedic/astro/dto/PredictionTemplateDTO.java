package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class PredictionTemplateDTO {
	
	private String name = null;
	private String code = null;
	private List<String> aspectCodes = new ArrayList<String>();

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
	@Override
	public String toString() {
		return "PredictionTemplateDTO [name=" + name + ", code=" + code + ", aspectCodes=" + aspectCodes + "]";
	}
}
