package com.vedic.astro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vedic.astro.enums.Gender;
import com.vedic.astro.enums.Guna;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Role;
import com.vedic.astro.enums.Zodiac;

public class PlanetDetails implements Serializable {
	
	private Role role;
	private Guna guna;
	private Impact impact;
	private List<House> karakaOf = new ArrayList<House>();
	private List<Integer> aspectCount;
	private Planet planet;
	private PlanetNature nature;
	private Double debilitationPoint = -1.0;
	private Zodiac mooltrikonSign;
	private Gender gender;
	private Double epochDegree;
	private boolean innerPlanet;
	private boolean retrograde;
	private Double luminosity;
	private Map<Planet, List<Integer>> beneficPoints = null;
	private Double discDiameter;
	private List<Integer> beneficTransitPointsFromMoonNak;
	private Map<Integer, String> ashtavargaPointsSignificances = 
			new HashMap<Integer, String>();
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Guna getGuna() {
		return guna;
	}
	
	public void setGuna(Guna guna) {
		this.guna = guna;
	}
	
	public Impact getImpact() {
		return impact;
	}
	
	public void setImpact(Impact impact) {
		this.impact = impact;
	}
	
	public List<House> getKarakaOf() {
		return karakaOf;
	}
	
	public void setKarakaOf(List<House> karakaOf) {
		this.karakaOf = karakaOf;
	}
	
	public List<Integer> getAspectCount() {
		return aspectCount;
	}
	
	public void setAspectCount(List<Integer> aspectCount) {
		this.aspectCount = aspectCount;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	public PlanetNature getNature() {
		return nature;
	}
	
	public void setNature(PlanetNature nature) {
		this.nature = nature;
	}
	
	public Double getDebilitationPoint() {
		return debilitationPoint;
	}
	
	public void setDebilitationPoint(Double debilitationPoint) {
		this.debilitationPoint = debilitationPoint;
	}
	
	public Zodiac getMooltrikonSign() {
		return mooltrikonSign;
	}
	
	public void setMooltrikonSign(Zodiac mooltrikonSign) {
		this.mooltrikonSign = mooltrikonSign;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Double getEpochDegree() {
		return epochDegree;
	}
	
	public void setEpochDegree(Double epochDegree) {
		this.epochDegree = epochDegree;
	}
	
	public boolean isInnerPlanet() {
		return innerPlanet;
	}
	
	public void setInnerPlanet(boolean innerPlanet) {
		this.innerPlanet = innerPlanet;
	}
	
	public boolean isRetrograde() {
		return retrograde;
	}
	
	public void setRetrograde(boolean retrograde) {
		this.retrograde = retrograde;
	}
	
	public Double getLuminosity() {
		return luminosity;
	}

	public void setLuminosity(Double luminosity) {
		this.luminosity = luminosity;
	}

	public Map<Planet, List<Integer>> getBeneficPoints() {
		return beneficPoints;
	}

	public void setBeneficPoints(Map<Planet, List<Integer>> beneficPoints) {
		this.beneficPoints = beneficPoints;
	}
	
	public Double getDiscDiameter() {
		return discDiameter;
	}

	public void setDiscDiameter(Double discDiameter) {
		this.discDiameter = discDiameter;
	}
	
	public List<Integer> getBeneficTransitPointsFromMoonNak() {
		return beneficTransitPointsFromMoonNak;
	}

	public void setBeneficTransitPointsFromMoonNak(
			List<Integer> beneficTransitPointsFromMoonNak) {
		this.beneficTransitPointsFromMoonNak = beneficTransitPointsFromMoonNak;
	}

	public Map<Integer, String> getAshtavargaPointsSignificances() {
		return ashtavargaPointsSignificances;
	}

	public void setAshtavargaPointsSignificances(
			Map<Integer, String> ashtavargaPointsSignificances) {
		this.ashtavargaPointsSignificances = ashtavargaPointsSignificances;
	}

	public void addAshtavargaPointSignificance(Integer point, String significance) {
		this.ashtavargaPointsSignificances.put(point, significance);
	}
	
	@Override
	public String toString() {
		return "PlanetDetails [role=" + role + ", guna=" + guna + ", impact="
				+ impact + ", karakaOf=" + karakaOf + ", aspectCount="
				+ aspectCount + ", planet=" + planet + ", nature=" + nature
				+ ", debilitationPoint=" + debilitationPoint
				+ ", mooltrikonSign=" + mooltrikonSign + ", gender=" + gender
				+ ", epochDegree=" + epochDegree + ", innerPlanet="
				+ innerPlanet + ", retrograde=" + retrograde + ", luminosity="
				+ luminosity + ", beneficPoints=" + beneficPoints
				+ ", discDiameter=" + discDiameter
				+ ", beneficTransitPointsFromMoonNak="
				+ beneficTransitPointsFromMoonNak + "]";
	}
}