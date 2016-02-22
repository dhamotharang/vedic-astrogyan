package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileAspectDTO extends LevelProfileAspectDTO{
	
	private List<ProfileAspectDTO> children = new ArrayList<ProfileAspectDTO>();
	private String mappedTemplates = null;
	private List<ProfilePredictionDTO> predictions = null;
	private String[] headings = {"Source","Component","Condition","Outcome","Time dependence","Impact", "Nature"};
	
	public List<ProfileAspectDTO> getChildren() {
		return children;
	}
	public void setChildren(List<ProfileAspectDTO> children) {
		this.children = children;
	}
	public String getMappedTemplates() {
		return mappedTemplates;
	}
	public void setMappedTemplates(String mappedTemplates) {
		this.mappedTemplates = mappedTemplates;
	}
	public List<ProfilePredictionDTO> getPredictions() {
		return predictions;
	}
	public void setPredictions(List<ProfilePredictionDTO> predictions) {
		this.predictions = predictions;
	}
	public void addChild(ProfileAspectDTO profileAspectDTO){
		this.children.add(profileAspectDTO);
	}
	public String[] getHeadings() {
		return headings;
	}
	public void setHeadings(String[] headings) {
		this.headings = headings;
	}
	@Override
	public String toString() {
		return "ProfileAspectDTO [children=" + children + ", mappedTemplates=" + mappedTemplates + ", predictions="
				+ predictions + ", headings=" + Arrays.toString(headings) + "]";
	}
}
