package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class HousesStrengthDTO {
	
	private List<HouseStrengthDTO> strengths = new ArrayList<HouseStrengthDTO>();
	private List<HouseStrengthSignificanceDTO> significances = new ArrayList<HouseStrengthSignificanceDTO>();
	
	public void addStrength(HouseStrengthDTO planetStrengthDTO){
		strengths.add(planetStrengthDTO);
	}

	public void addSignificance(HouseStrengthSignificanceDTO planetStrengthSignificanceDTO){
		significances.add(planetStrengthSignificanceDTO);
	}

	public List<HouseStrengthDTO> getStrengths() {
		return strengths;
	}
	public void setStrengths(List<HouseStrengthDTO> strengths) {
		this.strengths = strengths;
	}
	public List<HouseStrengthSignificanceDTO> getSignificances() {
		return significances;
	}
	public void setSignificances(List<HouseStrengthSignificanceDTO> significances) {
		this.significances = significances;
	}
	@Override
	public String toString() {
		return "HousesStrengthDTO [strengths=" + strengths + ", significances=" + significances + "]";
	}
}
