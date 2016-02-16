package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class MappedProfileAspectDTO extends LevelProfileAspectDTO{
	
	private boolean mapped = false;
	private List<MappedProfileAspectDTO> children = new ArrayList<MappedProfileAspectDTO>();
	
	public boolean isMapped() {
		return mapped;
	}

	public void setMapped(boolean mapped) {
		this.mapped = mapped;
	}
	
	public List<MappedProfileAspectDTO> getChildren() {
		return children;
	}

	public void setChildren(List<MappedProfileAspectDTO> children) {
		this.children = children;
	}

	public void addChild(MappedProfileAspectDTO mappedProfileAspectDTO){
		this.children.add(mappedProfileAspectDTO);
	}
	@Override
	public String toString() {
		return "MappedProfileAspectDTO [mapped=" + mapped + "]";
	}
}