package com.vedic.astro.dto;

import com.vedic.astro.enums.NakDashaSystem;
import com.vedic.astro.enums.Planet;

public class FindNakAntarDashaDTO extends BaseFindAntarDashaDTO{
	
	private Planet planet = null;
	private NakDashaSystem dashaSystem = null;
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public NakDashaSystem getDashaSystem() {
		return dashaSystem;
	}
	public void setDashaSystem(NakDashaSystem dashaSystem) {
		this.dashaSystem = dashaSystem;
	}
	@Override
	public String toString() {
		return "FindNakAntarDashaDTO [planet=" + planet + ", dashaSystem=" + dashaSystem + "]";
	}
}
