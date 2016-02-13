package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class ProfileAspectDTO extends LevelProfileAspectDTO{
	
	private List<ProfileAspectDTO> children = new ArrayList<ProfileAspectDTO>();
	private List<String> mappedEntities = new ArrayList<String>();
	
	public List<ProfileAspectDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ProfileAspectDTO> children) {
		this.children = children;
	}
	
	public void addChild(ProfileAspectDTO profileAspectDTO){
		this.children.add(profileAspectDTO);
	}

	
	public List<String> getMappedEntities() {
		return mappedEntities;
	}

	public void setMappedEntities(List<String> mappedEntities) {
		this.mappedEntities = mappedEntities;
	}

	public void addMappedEntity(String entityName){
		this.mappedEntities.add(entityName);
	}

	@Override
	public String toString() {
		return "ProfileAspectDTO [children=" + children + ", mappedEntities=" + mappedEntities + "]";
	}
}
