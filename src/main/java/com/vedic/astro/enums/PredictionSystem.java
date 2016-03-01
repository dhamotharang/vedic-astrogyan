package com.vedic.astro.enums;

public enum PredictionSystem {

	Prashara("Prashara"), Jaimini("Jaimini"), KP("Krishnamurti P"), Ashtavarga("Ashtavarga"), VarshaPhala("Tajika");

	private String desc;

	private PredictionSystem(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

}
