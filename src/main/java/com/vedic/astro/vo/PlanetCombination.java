package com.vedic.astro.vo;

import com.vedic.astro.enums.Planet;

public class PlanetCombination {

	private Planet fromPlanet;
	private Planet toPlanet;

	public PlanetCombination(Planet fromPlanet, Planet toPlanet) {
		super();
		this.fromPlanet = fromPlanet;
		this.toPlanet = toPlanet;
	}

	public Planet getFromPlanet() {
		return fromPlanet;
	}

	public void setFromPlanet(Planet fromPlanet) {
		this.fromPlanet = fromPlanet;
	}

	public Planet getToPlanet() {
		return toPlanet;
	}

	public void setToPlanet(Planet toPlanet) {
		this.toPlanet = toPlanet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fromPlanet == null) ? 0 : fromPlanet.hashCode());
		result = prime * result
				+ ((toPlanet == null) ? 0 : toPlanet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanetCombination other = (PlanetCombination) obj;
		if (fromPlanet != other.fromPlanet)
			return false;
		if (toPlanet != other.toPlanet)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanetCombination [fromPlanet=" + fromPlanet + ", toPlanet="
				+ toPlanet + "]";
	}
}
