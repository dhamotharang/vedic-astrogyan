package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResultDTO {

	private List<SubComponentOutcomeDTO> nakAnalysis = new ArrayList<SubComponentOutcomeDTO>();
	private List<SubComponentOutcomeDTO> zodAnalysis = new ArrayList<SubComponentOutcomeDTO>();
	private List<SubComponentOutcomeDTO> houseStrengthAnalysis = new ArrayList<SubComponentOutcomeDTO>();
	private List<SubComponentOutcomeDTO> planetStrengthAnalysis = new ArrayList<SubComponentOutcomeDTO>();

	public void addNakAnalysis(SubComponentOutcomeDTO chartImpactDTO){
		nakAnalysis.add(chartImpactDTO);
	}
	
	public void addZodAnalysis(SubComponentOutcomeDTO chartImpactDTO){
		zodAnalysis.add(chartImpactDTO);
	}

	public void addHouseStrengthAnalysis(SubComponentOutcomeDTO chartImpactDTO){
		houseStrengthAnalysis.add(chartImpactDTO);
	}
	
	public void addPlanetStrengthAnalysis(SubComponentOutcomeDTO chartImpactDTO){
		planetStrengthAnalysis.add(chartImpactDTO);
	}

	public List<SubComponentOutcomeDTO> getNakAnalysis() {
		return nakAnalysis;
	}

	public void setNakAnalysis(List<SubComponentOutcomeDTO> nakAnalysis) {
		this.nakAnalysis = nakAnalysis;
	}

	public List<SubComponentOutcomeDTO> getZodAnalysis() {
		return zodAnalysis;
	}

	public void setZodAnalysis(List<SubComponentOutcomeDTO> zodAnalysis) {
		this.zodAnalysis = zodAnalysis;
	}

	public List<SubComponentOutcomeDTO> getHouseStrengthAnalysis() {
		return houseStrengthAnalysis;
	}

	public void setHouseStrengthAnalysis(List<SubComponentOutcomeDTO> houseStrengthAnalysis) {
		this.houseStrengthAnalysis = houseStrengthAnalysis;
	}

	public List<SubComponentOutcomeDTO> getPlanetStrengthAnalysis() {
		return planetStrengthAnalysis;
	}

	public void setPlanetStrengthAnalysis(List<SubComponentOutcomeDTO> planetStrengthAnalysis) {
		this.planetStrengthAnalysis = planetStrengthAnalysis;
	}

	@Override
	public String toString() {
		return "AnalysisResultDTO [nakAnalysis=" + nakAnalysis + ", zodAnalysis=" + zodAnalysis
				+ ", houseStrengthAnalysis=" + houseStrengthAnalysis + ", planetStrengthAnalysis="
				+ planetStrengthAnalysis + "]";
	}
}
