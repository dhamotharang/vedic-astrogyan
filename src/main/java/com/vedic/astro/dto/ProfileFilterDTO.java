package com.vedic.astro.dto;

import com.vedic.astro.enums.AnalysisGroup;

public class ProfileFilterDTO {
	
	private ProfileFilterTypeDTO filterType;
	private String filterValue;
	private AnalysisGroup analysisGroup;

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
	@Override
	public String toString() {
		return "ProfileFilterDTO [filterType=" + filterType + ", filterValue=" + filterValue + ", analysisGroup="
				+ analysisGroup + "]";
	}
}
