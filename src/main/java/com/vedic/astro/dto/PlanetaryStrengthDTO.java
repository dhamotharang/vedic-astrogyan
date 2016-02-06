package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class PlanetaryStrengthDTO {
	
	private List<PlanetStrengthDTO> strengths = new ArrayList<PlanetStrengthDTO>();
	private List<PlanetStrengthSignificanceDTO> significances = new ArrayList<PlanetStrengthSignificanceDTO>();
	
	public void addStrength(PlanetStrengthDTO planetStrengthDTO){
		strengths.add(planetStrengthDTO);
	}

	public void addSignificance(PlanetStrengthSignificanceDTO planetStrengthSignificanceDTO){
		significances.add(planetStrengthSignificanceDTO);
	}

	public List<PlanetStrengthDTO> getStrengths() {
		return strengths;
	}
	public void setStrengths(List<PlanetStrengthDTO> strengths) {
		this.strengths = strengths;
	}
	public List<PlanetStrengthSignificanceDTO> getSignificances() {
		return significances;
	}
	public void setSignificances(List<PlanetStrengthSignificanceDTO> significances) {
		this.significances = significances;
	}
	@Override
	public String toString() {
		return "PlanetaryStrengthDTO [strengths=" + strengths + ", significances=" + significances + "]";
	}
}
