package com.vedic.astro.enums;

public enum ZodDashaSystem {

	CHARA("Chara"), KALCHAKRA("Kal Chakra"), NARAYANI("Narayani"), SHOOL("Shool");
	
    private String description;
	
	private ZodDashaSystem(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}
}
