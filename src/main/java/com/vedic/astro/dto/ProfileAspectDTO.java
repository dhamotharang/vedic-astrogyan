package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class ProfileAspectDTO extends LevelProfileAspectDTO{
	
	private List<ProfileAspectDTO> children = new ArrayList<ProfileAspectDTO>();
	private List<String> mappedTemplates = new ArrayList<String>();
	
	
	public List<ProfileAspectDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ProfileAspectDTO> children) {
		this.children = children;
	}
	
	public void addChild(ProfileAspectDTO profileAspectDTO){
		this.children.add(profileAspectDTO);
	}

	public List<String> getMappedTemplates() {
		return mappedTemplates;
	}

	public void setMappedTemplates(List<String> mappedTemplates) {
		this.mappedTemplates = mappedTemplates;
	}

	@Override
	public String toString() {
		return "ProfileAspectDTO [children=" + children + ", mappedTemplates=" + mappedTemplates + "]";
	}
}
