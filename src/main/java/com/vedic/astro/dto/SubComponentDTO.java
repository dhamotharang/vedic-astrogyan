package com.vedic.astro.dto;

public class SubComponentDTO {
	
	private String componentCode = null; 
	private String code = null;
	private String name = null;
	private String conditionChecked = null;
	private String predictionTemplateCode = null;
	
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
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	public String getPredictionTemplateCode() {
		return predictionTemplateCode;
	}
	public void setPredictionTemplateCode(String predictionTemplateCode) {
		this.predictionTemplateCode = predictionTemplateCode;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	@Override
	public String toString() {
		return "SubComponentDTO [componentCode=" + componentCode + ", code=" + code + ", name=" + name
				+ ", conditionChecked=" + conditionChecked + ", predictionTemplateCode=" + predictionTemplateCode + "]";
	}
}
