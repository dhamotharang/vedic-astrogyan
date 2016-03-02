package com.vedic.astro.dto;

import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;

public class ProfileFilterDTO {
	
	private ProfileFilterTypeDTO filterType;
	private String filterValue;
	private AnalysisGroup analysisGroup;
	private PredictionSystem model;

	public ProfileFilterTypeDTO getFilterType() {
		return filterType;
	}
	public void setFilterType(ProfileFilterTypeDTO filterType) {
		this.filterType = filterType;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	public PredictionSystem getModel() {
		return model;
	}
	public void setModel(PredictionSystem model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "ProfileFilterDTO [filterType=" + filterType + ", filterValue=" + filterValue + ", analysisGroup="
				+ analysisGroup + ", model=" + model + "]";
	}
}
