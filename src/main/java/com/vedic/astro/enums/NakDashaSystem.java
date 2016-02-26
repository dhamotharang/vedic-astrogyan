package com.vedic.astro.enums;

public enum NakDashaSystem {

	VIM("Vimshottri"), YOG("Yogini");
	
    private String description;
	
	private NakDashaSystem(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}
}
