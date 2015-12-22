package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.enums.YogaCategory;
import com.vedic.astro.enums.Zodiac;

public class YogaDetails {
	
	private List<String> positives = new ArrayList<String>();
	private List<String> negatives = new ArrayList<String>();
	
	private List<House> housesInvolved = new ArrayList<House>();
	private List<Planet> planetsInvolved  = new ArrayList<Planet>();
	private List<Zodiac> zodiacsInvolved  = new ArrayList<Zodiac>();
	
	private String conditionChecked;
	private boolean dashaDependent;
	private YogaCategory category;
	private Yoga yoga;
	
	public YogaDetails(String conditionChecked, boolean dashaDependent,
			YogaCategory category, Yoga yoga) {
		super();
		this.conditionChecked = conditionChecked;
		this.dashaDependent = dashaDependent;
		this.category = category;
		this.yoga = yoga;
	}
	
	public List<String> getPositives() {
		return positives;
	}
	public void setPositives(List<String> positives) {
		this.positives = positives;
	}
	public List<String> getNegatives() {
		return negatives;
	}
	public void setNegatives(List<String> negatives) {
		this.negatives = negatives;
	}
	public void addNegative(String negative){
		this.negatives.add(negative);
	}
	public void addPlanetsInvolved(Planet planet){
		this.planetsInvolved.add(planet);
	}
	public void addZodiacsInvolved(Zodiac zodiac){
		this.zodiacsInvolved.add(zodiac);
	}
	public void addHousesInvolved(House house){
		this.housesInvolved.add(house);
	}
	public void addPositive(String positive){
		this.positives.add(positive);
	}
	public List<House> getHousesInvolved() {
		return housesInvolved;
	}
	public void setHousesInvolved(List<House> housesInvolved) {
		this.housesInvolved = housesInvolved;
	}
	public List<Planet> getPlanetsInvolved() {
		return planetsInvolved;
	}
	public void setPlanetsInvolved(List<Planet> planetsInvolved) {
		this.planetsInvolved = planetsInvolved;
	}
	public List<Zodiac> getZodiacsInvolved() {
		return zodiacsInvolved;
	}
	public void setZodiacsInvolved(List<Zodiac> zodiacsInvolved) {
		this.zodiacsInvolved = zodiacsInvolved;
	}
	public String getConditionChecked() {
		return conditionChecked;
	}
	public void setConditionChecked(String conditionChecked) {
		this.conditionChecked = conditionChecked;
	}
	public boolean isDashaDependent() {
		return dashaDependent;
	}
	public void setDashaDependent(boolean dashaDependent) {
		this.dashaDependent = dashaDependent;
	}
	public YogaCategory getCategory() {
		return category;
	}
	public void setCategory(YogaCategory category) {
		this.category = category;
	}
	public Yoga getYoga() {
		return yoga;
	}
	public void setYoga(Yoga yoga) {
		this.yoga = yoga;
	}
	@Override
	public String toString() {
		return "YogaDetails [positives=" + positives + ", negatives="
				+ negatives + ", housesInvolved=" + housesInvolved
				+ ", planetsInvolved=" + planetsInvolved + ", zodiacsInvolved="
				+ zodiacsInvolved + ", conditionChecked=" + conditionChecked
				+ ", dashaDependent=" + dashaDependent + ", category="
				+ category + ", yoga=" + yoga + "]";
	}
}