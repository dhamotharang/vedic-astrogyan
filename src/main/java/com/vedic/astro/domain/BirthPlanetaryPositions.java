package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.vo.PlanetPosition;

public class BirthPlanetaryPositions {

	private PlanetPosition lagna = null;
	
	private List<PlanetPosition> planetPositions = new ArrayList<PlanetPosition>(9);

	public List<PlanetPosition> getPlanetPositions() {
		return planetPositions;
	}

	public void setPlanetPositions(List<PlanetPosition> planetPositions) {
		this.planetPositions = planetPositions;
	}

	public PlanetPosition getLagna() {
		return lagna;
	}

	public void setLagna(PlanetPosition lagna) {
		this.lagna = lagna;
	}

	@Override
	public String toString() {
		return "BirthPlanetaryPositions [lagna=" + lagna + ", planetPositions="
				+ planetPositions + "]";
	}
}
