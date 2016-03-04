package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.MemberType;

public class ProfileAspectDTO extends LevelProfileAspectDTO{
	
	private List<ProfileAspectDTO> children = new ArrayList<ProfileAspectDTO>();
	private String mappedTemplates = null;
	private List<ProfilePredictionDTO> predictions = null;
	private MemberType memberType = null;
	
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
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	@Override
	public String toString() {
		return "ProfileAspectDTO [children=" + children + ", mappedTemplates=" + mappedTemplates + ", predictions="
				+ predictions + ", memberType=" + memberType + "]";
	}
}
