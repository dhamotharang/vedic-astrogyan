package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePlanetaryPositions {

	private Double lagna = null;

	private List<PlanetAbsoluteLocation> absolutePlanetPositions = new ArrayList<PlanetAbsoluteLocation>(
			9);

	public Double getLagna() {
		return lagna;
	}

	public void setLagna(Double lagna) {
		this.lagna = lagna;
	}

	public List<PlanetAbsoluteLocation> getAbsolutePlanetPositions() {
		return absolutePlanetPositions;
	}

	public void setAbsolutePlanetPositions(
			List<PlanetAbsoluteLocation> absolutePlanetPositions) {
		this.absolutePlanetPositions = absolutePlanetPositions;
	}

	public void addAbsolutePlanetPosition(
			PlanetAbsoluteLocation planetAbsoluteLocation) {
		this.absolutePlanetPositions.add(planetAbsoluteLocation);
	}

	@Override
	public String toString() {
		return "AbsolutePlanetaryPositions [lagna=" + lagna
				+ ", absolutePlanetPositions=" + absolutePlanetPositions + "]";
	}

}
