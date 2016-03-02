package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class ComponentAnalysisResultDTO {

	private List<SubComponentOutcomeDTO> outcomes = new ArrayList<SubComponentOutcomeDTO>();
	private String name = null;
	private String code = null;

	public List<SubComponentOutcomeDTO> getOutcomes() {
		return outcomes;
	}
	public void setOutcomes(List<SubComponentOutcomeDTO> outcomes) {
		this.outcomes = outcomes;
	}
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
	@Override
	public String toString() {
		return "ComponentAnalysisResultDTO [outcomes=" + outcomes + ", name=" + name + ", code=" + code + "]";
	}
}
