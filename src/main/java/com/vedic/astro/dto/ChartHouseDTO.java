package com.vedic.astro.dto;

import com.vedic.astro.enums.House;

public class ChartHouseDTO {
	
	private House id = null;
	private HouseContentDTO content = null;
	
	public ChartHouseDTO(House id, HouseContentDTO content) {
		this.id = id;
		this.content = content;
	}
	
	public House getId() {
		return id;
	}
	public void setId(House id) {
		this.id = id;
	}
	public HouseContentDTO getContent() {
		return content;
	}
	public void setContent(HouseContentDTO content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ChartHouseDTO [id=" + id + ", content=" + content + "]";
	}
}
