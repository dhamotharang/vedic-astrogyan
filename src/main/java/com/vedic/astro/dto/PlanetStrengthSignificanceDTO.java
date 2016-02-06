package com.vedic.astro.dto;

import com.vedic.astro.enums.Planet;

public class PlanetStrengthSignificanceDTO {
	
	private Planet planet = null;
	private String body = null;
	private String mind = null;
	private String karmic = null;
	private String age = null;
	
	public PlanetStrengthSignificanceDTO(Planet planet, String body, String mind, String karmic, String age) {
		super();
		this.planet = planet;
		this.body = body;
		this.mind = mind;
		this.karmic = karmic;
		this.age = age;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMind() {
		return mind;
	}
	public void setMind(String mind) {
		this.mind = mind;
	}
	public String getKarmic() {
		return karmic;
	}
	public void setKarmic(String karmic) {
		this.karmic = karmic;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PlanetStrengthSignificanceDTO [planet=" + planet + ", body=" + body + ", mind=" + mind + ", karmic="
				+ karmic + ", age=" + age + "]";
	}
}
