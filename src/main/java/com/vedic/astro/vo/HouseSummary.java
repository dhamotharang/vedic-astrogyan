package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.Planet;

public class HouseSummary {
	
	public HouseSummary(List<Planet> karakas, Planet owner,
			List<Planet> inhabitants, List<Planet> aspects) {
		super();
		this.karakas = karakas;
		this.owner = owner;
		this.inhabitants = inhabitants;
		this.aspects = aspects;
	}
	private List<Planet> karakas = new ArrayList<Planet>();
	private Planet owner = null;
	private List<Planet> inhabitants = new ArrayList<Planet>();
	private List<Planet> aspects = new ArrayList<Planet>();
	
	public List<Planet> getKarakas() {
		return karakas;
	}
	public void setKarakas(List<Planet> karakas) {
		this.karakas = karakas;
	}
	public Planet getOwner() {
		return owner;
	}
	public void setOwner(Planet owner) {
		this.owner = owner;
	}
	public List<Planet> getInhabitants() {
		return inhabitants;
	}
	public void setInhabitants(List<Planet> inhabitants) {
		this.inhabitants = inhabitants;
	}
	public List<Planet> getAspects() {
		return aspects;
	}
	public void setAspects(List<Planet> aspects) {
		this.aspects = aspects;
	}
	@Override
	public String toString() {
		return "HouseSummary [karakas=" + karakas + ", owners=" + owner
				+ ", inhabitants=" + inhabitants + ", aspects=" + aspects + "]";
	}
}
