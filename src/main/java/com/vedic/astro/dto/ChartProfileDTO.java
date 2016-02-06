package com.vedic.astro.dto;

import java.util.ArrayList;
import java.util.List;

public class ChartProfileDTO {

	private List<ChartImpactDTO> body = new ArrayList<ChartImpactDTO>();
	private List<ChartImpactDTO> mind = new ArrayList<ChartImpactDTO>();
	private List<ChartImpactDTO> soul = new ArrayList<ChartImpactDTO>();

	public void addBodyImpact(ChartImpactDTO chartImpactDTO){
		body.add(chartImpactDTO);
	}
	
	public void addMindImpact(ChartImpactDTO chartImpactDTO){
		mind.add(chartImpactDTO);
	}

	public void addSoulImpact(ChartImpactDTO chartImpactDTO){
		soul.add(chartImpactDTO);
	}

	public List<ChartImpactDTO> getBody() {
		return body;
	}
	public void setBody(List<ChartImpactDTO> body) {
		this.body = body;
	}
	public List<ChartImpactDTO> getMind() {
		return mind;
	}
	public void setMind(List<ChartImpactDTO> mind) {
		this.mind = mind;
	}
	public List<ChartImpactDTO> getSoul() {
		return soul;
	}
	public void setSoul(List<ChartImpactDTO> soul) {
		this.soul = soul;
	}
	@Override
	public String toString() {
		return "ChartProfileDTO [body=" + body + ", mind=" + mind + ", soul=" + soul + "]";
	}
}
