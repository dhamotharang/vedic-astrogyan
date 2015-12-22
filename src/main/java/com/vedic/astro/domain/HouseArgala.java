package com.vedic.astro.domain;

import java.util.HashSet;
import java.util.Set;

import com.vedic.astro.enums.ArgalaType;
import com.vedic.astro.enums.HouseArgalaStatus;
import com.vedic.astro.enums.Planet;

public class HouseArgala {
	
	private HouseArgalaStatus status;
	private Set<Planet> positivePlanets = new HashSet<Planet>();
	private Set<Planet> negativePlanets = new HashSet<Planet>();
	private ArgalaType argalaType;

	public HouseArgala(Set<Planet> positivePlanets, Set<Planet> negativePlanets) {
		super();
		this.positivePlanets = positivePlanets;
		this.negativePlanets = negativePlanets;
	}
	public HouseArgalaStatus getStatus() {
		return status;
	}
	public void setStatus(HouseArgalaStatus status) {
		this.status = status;
	}
	public Set<Planet> getPositivePlanets() {
		return positivePlanets;
	}
	public void setPositivePlanets(Set<Planet> positivePlanets) {
		this.positivePlanets = positivePlanets;
	}
	public Set<Planet> getNegativePlanets() {
		return negativePlanets;
	}
	public void setNegativePlanets(Set<Planet> negativePlanets) {
		this.negativePlanets = negativePlanets;
	}
	public ArgalaType getArgalaType() {
		return argalaType;
	}
	public void setArgalaType(ArgalaType argalaType) {
		this.argalaType = argalaType;
	}
	@Override
	public String toString() {
		return "HouseArgala [status=" + status + ", positivePlanets="
				+ positivePlanets + ", negativePlanets=" + negativePlanets
				+ ", argalaType=" + argalaType + "]";
	}
}
