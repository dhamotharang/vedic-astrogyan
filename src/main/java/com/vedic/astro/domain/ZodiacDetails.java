package com.vedic.astro.domain;

import com.vedic.astro.enums.Element;
import com.vedic.astro.enums.Gender;
import com.vedic.astro.enums.Goal;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;

public class ZodiacDetails {
	
	private Planet rulingPlanet;
	private String environment;
	private House closestHouse;
	private Element element;
	private Goal goal;
	private Gender gender;
	
	public Planet getRulingPlanet() {
		return rulingPlanet;
	}
	public void setRulingPlanet(Planet rulingPlanet) {
		this.rulingPlanet = rulingPlanet;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public House getClosestHouse() {
		return closestHouse;
	}
	public void setClosestHouse(House closestHouse) {
		this.closestHouse = closestHouse;
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public Goal getGoal() {
		return goal;
	}
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "ZodiacDetails [rulingPlanet=" + rulingPlanet + ", environment="
				+ environment + ", closestHouse=" + closestHouse + ", element="
				+ element + ", goal=" + goal + ", gender=" + gender + "]";
	}
}
