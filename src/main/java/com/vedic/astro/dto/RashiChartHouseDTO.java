package com.vedic.astro.dto;

import com.vedic.astro.enums.House;

public class RashiChartHouseDTO {
	
	private House id = null;
	private RashiHouseContentDTO content = null;
	
	public RashiChartHouseDTO(House id, RashiHouseContentDTO content) {
		this.id = id;
		this.content = content;
	}
	
	public House getId() {
		return id;
	}
	public void setId(House id) {
		this.id = id;
	}
	public RashiHouseContentDTO getContent() {
		return content;
	}
	public void setContent(RashiHouseContentDTO content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ChartHouseDTO [id=" + id + ", content=" + content + "]";
	}
}
