package com.vedic.astro.enums;

public enum Planet {
	MER("Budha", "Mercury", 2), JUP("Guru", "Jupiter", 6), SAT("Shani", "Saturn", 7), MON(
			"Chandra", "Moon", 1), RAH("Rahu", "Rahu", -1), KET("Ketu", "Ketu", -1), SUN(
			"Surya", "Sun", 4), MAR("Mangal", "Mars", 5), VEN("Shukra", "Venus", 3), ASC("Lagna","Ascendant",-1);
 //URA("Arun","Uranus",-1), NEP("Varun","Neptune",-1);
	
	private String hindiName;
	private String englishName;
	private Integer horaWeight;
	
	private Planet(String hindiName, String englishName, Integer horaWeight) {
		this.hindiName = hindiName;
		this.englishName = englishName;
		this.horaWeight = horaWeight;
	}

	public String getHindiName() {
		return hindiName;
	}

	public void setHindiName(String hindiName) {
		this.hindiName = hindiName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public static Planet fromEnglishName(String englishName) {
		Planet returnPlanet = null;
		Planet[] planet = Planet.values();
		for (int i = 0; i < planet.length; i++) {
			if (planet[i].getEnglishName().equalsIgnoreCase(englishName)) {
				returnPlanet = planet[i];
				break;
			}
		}
		return returnPlanet;
	}

	public Integer getHoraWeight() {
		return horaWeight;
	}

	public void setHoraWeight(Integer horaWeight) {
		this.horaWeight = horaWeight;
	}
	
}
