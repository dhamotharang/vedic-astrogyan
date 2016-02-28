package com.vedic.astro.dto;

import com.vedic.astro.enums.House;

public class VargaChartHouseDTO {
	
	private House id = null;
	private VargaHouseContentDTO content = null;
	
	public VargaChartHouseDTO(House id, VargaHouseContentDTO content) {
		this.id = id;
		this.content = content;
	}
	
	public House getId() {
		return id;
	}
	public void setId(House id) {
		this.id = id;
	}
	public VargaHouseContentDTO getContent() {
		return content;
	}
	public void setContent(VargaHouseContentDTO content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ChartHouseDTO [id=" + id + ", content=" + content + "]";
	}
}
