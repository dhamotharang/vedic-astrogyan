package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResultDTO {

	private List<ComponentOutcomeDTO> nakAnalysis = new ArrayList<ComponentOutcomeDTO>();
	private List<ComponentOutcomeDTO> zodAnalysis = new ArrayList<ComponentOutcomeDTO>();
	private List<ComponentOutcomeDTO> houseStrengthAnalysis = new ArrayList<ComponentOutcomeDTO>();
	private List<ComponentOutcomeDTO> planetStrengthAnalysis = new ArrayList<ComponentOutcomeDTO>();

	public void addNakAnalysis(ComponentOutcomeDTO chartImpactDTO){
		nakAnalysis.add(chartImpactDTO);
	}
	
	public void addZodAnalysis(ComponentOutcomeDTO chartImpactDTO){
		zodAnalysis.add(chartImpactDTO);
	}

	public void addHouseStrengthAnalysis(ComponentOutcomeDTO chartImpactDTO){
		houseStrengthAnalysis.add(chartImpactDTO);
	}
	
	public void addPlanetStrengthAnalysis(ComponentOutcomeDTO chartImpactDTO){
		planetStrengthAnalysis.add(chartImpactDTO);
	}

	public List<ComponentOutcomeDTO> getNakAnalysis() {
		return nakAnalysis;
	}

	public void setNakAnalysis(List<ComponentOutcomeDTO> nakAnalysis) {
		this.nakAnalysis = nakAnalysis;
	}

	public List<ComponentOutcomeDTO> getZodAnalysis() {
		return zodAnalysis;
	}

	public void setZodAnalysis(List<ComponentOutcomeDTO> zodAnalysis) {
		this.zodAnalysis = zodAnalysis;
	}

	public List<ComponentOutcomeDTO> getHouseStrengthAnalysis() {
		return houseStrengthAnalysis;
	}

	public void setHouseStrengthAnalysis(List<ComponentOutcomeDTO> houseStrengthAnalysis) {
		this.houseStrengthAnalysis = houseStrengthAnalysis;
	}

	public List<ComponentOutcomeDTO> getPlanetStrengthAnalysis() {
		return planetStrengthAnalysis;
	}

	public void setPlanetStrengthAnalysis(List<ComponentOutcomeDTO> planetStrengthAnalysis) {
		this.planetStrengthAnalysis = planetStrengthAnalysis;
	}

	@Override
	public String toString() {
		return "AnalysisResultDTO [nakAnalysis=" + nakAnalysis + ", zodAnalysis=" + zodAnalysis
				+ ", houseStrengthAnalysis=" + houseStrengthAnalysis + ", planetStrengthAnalysis="
				+ planetStrengthAnalysis + "]";
	}
}
