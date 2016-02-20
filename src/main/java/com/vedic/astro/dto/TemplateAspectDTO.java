package com.vedic.astro.dto;

public class TemplateAspectDTO extends PathProfileAspectDTO {
	
	private Boolean selected = false;

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "TemplateAspectDTO [selected=" + selected + "]";
	}
}
