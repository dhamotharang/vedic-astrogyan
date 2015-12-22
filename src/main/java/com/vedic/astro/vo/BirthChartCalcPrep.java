package com.vedic.astro.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

public class BirthChartCalcPrep {

	Map<House, Set<Planet>> houseInhabitantsMapping = new HashMap<House, Set<Planet>>();
	Map<House, Planet> houseOwnerMapping = new HashMap<House, Planet>();
	Map<Planet, List<House>> planetOwnedHouse = new HashMap<Planet, List<House>>();
	Map<House, List<Planet>> houseAspectsMapping = new HashMap<House, List<Planet>>();
	Map<Planet, Double> planetAgeMapping = new HashMap<Planet, Double>();
	Map<Planet, House> planetHouseMapping = new HashMap<Planet, House>();
	Map<House, Zodiac> houseZodiacMapping = new HashMap<House, Zodiac>();
	Map<Planet, List<House>> aspectPlanetHousesMapping = new HashMap<Planet, List<House>>();
	Map<Planet, List<House>> planetHouseKarakasMap = new HashMap<Planet, List<House>>();
	Map<House, List<Planet>> housePlanetKarakasMap = new HashMap<House, List<Planet>>();
	Map<Planet, Nakshatra> planetNakshatrasMap = new HashMap<Planet, Nakshatra>();
	Map<Planet, House> nakshatraLordHouseMap = new HashMap<Planet, House>();
	Map<CharaKaraka, Planet> charakarakaMap = new HashMap<CharaKaraka, Planet>();

	public Map<House, Set<Planet>> getHouseInhabitantsMapping() {
		return houseInhabitantsMapping;
	}

	public void setHouseInhabitantsMapping(
			Map<House, Set<Planet>> houseInhabitantsMapping) {
		this.houseInhabitantsMapping = houseInhabitantsMapping;
	}

	public Map<House, Planet> getHouseOwnerMapping() {
		return houseOwnerMapping;
	}

	public void setHouseOwnerMapping(Map<House, Planet> houseOwnerMapping) {
		this.houseOwnerMapping = houseOwnerMapping;
	}

	public Map<House, List<Planet>> getHouseAspectsMapping() {
		return houseAspectsMapping;
	}

	public void setHouseAspectsMapping(
			Map<House, List<Planet>> houseAspectsMapping) {
		this.houseAspectsMapping = houseAspectsMapping;
	}

	public Map<Planet, Double> getPlanetAgeMapping() {
		return planetAgeMapping;
	}

	public void setPlanetAgeMapping(Map<Planet, Double> planetAgeMapping) {
		this.planetAgeMapping = planetAgeMapping;
	}

	public Map<Planet, House> getPlanetHouseMapping() {
		return planetHouseMapping;
	}

	public void setPlanetHouseMapping(Map<Planet, House> planetHouseMapping) {
		this.planetHouseMapping = planetHouseMapping;
	}

	public Map<House, Zodiac> getHouseZodiacMapping() {
		return houseZodiacMapping;
	}

	public void setHouseZodiacMapping(Map<House, Zodiac> houseZodiacMapping) {
		this.houseZodiacMapping = houseZodiacMapping;
	}

	public Map<Planet, List<House>> getPlanetOwnedHouse() {
		return planetOwnedHouse;
	}

	public void setPlanetOwnedHouse(Map<Planet, List<House>> planetOwnedHouse) {
		this.planetOwnedHouse = planetOwnedHouse;
	}

	public Map<Planet, List<House>> getAspectPlanetHousesMapping() {
		return aspectPlanetHousesMapping;
	}

	public void setAspectPlanetHousesMapping(
			Map<Planet, List<House>> aspectPlanetHousesMapping) {
		this.aspectPlanetHousesMapping = aspectPlanetHousesMapping;
	}

	public Map<Planet, List<House>> getPlanetHouseKarakasMap() {
		return planetHouseKarakasMap;
	}

	public void setPlanetHouseKarakasMap(
			Map<Planet, List<House>> planetHouseKarakasMap) {
		this.planetHouseKarakasMap = planetHouseKarakasMap;
	}

	public Map<House, List<Planet>> getHousePlanetKarakasMap() {
		return housePlanetKarakasMap;
	}

	public void setHousePlanetKarakasMap(
			Map<House, List<Planet>> housePlanetKarakasMap) {
		this.housePlanetKarakasMap = housePlanetKarakasMap;
	}

	public List<Planet> getInhabitantsOtherThan(House house, Planet planet) {

		Set<Planet> inhabitants = this.houseInhabitantsMapping.get(house);
		List<Planet> otherInhabitants = new ArrayList<Planet>();

		if ((inhabitants != null) && (!inhabitants.isEmpty())) {
			otherInhabitants.addAll(inhabitants);
			otherInhabitants.remove(planet);
		}

		return otherInhabitants;
	}
	
	public Double getAbsoluteDegrees(Planet planet){
		Zodiac zodiac = houseZodiacMapping.get(planetHouseMapping.get(planet));

		Double absoluteDegrees = zodiac.getMinDegrees()
				+ planetAgeMapping.get(planet);

		return absoluteDegrees;
	}

	public Map<Planet, Nakshatra> getPlanetNakshatrasMapping() {
		return planetNakshatrasMap;
	}

	public void setPlanetNakshatrasMapping(Map<Planet, Nakshatra> planetNakshatrasMap) {
		this.planetNakshatrasMap = planetNakshatrasMap;
	}
	
	public Map<Planet, House> getNakshatraLordHouseMapping() {
		return nakshatraLordHouseMap;
	}

	public void setNakshatraLordHouseMapping(Map<Planet, House> nakshatraLordHouseMap) {
		this.nakshatraLordHouseMap = nakshatraLordHouseMap;
	}

	public Map<Zodiac, House> getZodiacToHouseMapping(){
		Map<Zodiac, House> zodiacToHouseMap = new HashMap<Zodiac, House>();
		
		for(Map.Entry<House, Zodiac> houseToZodiacEntry :getHouseZodiacMapping().entrySet()){
			zodiacToHouseMap.put(houseToZodiacEntry.getValue(), houseToZodiacEntry.getKey());
		}
		return zodiacToHouseMap;
	}

	
	public Map<CharaKaraka, Planet> getCharakarakaMap() {
		return charakarakaMap;
	}

	public void setCharakarakaMap(Map<CharaKaraka, Planet> charakarakaMap) {
		this.charakarakaMap = charakarakaMap;
	}

	@Override
	public String toString() {
		return "BirthChartCalcPrep [houseInhabitantsMapping="
				+ houseInhabitantsMapping + ", houseOwnerMapping="
				+ houseOwnerMapping + ", planetOwnedHouse=" + planetOwnedHouse
				+ ", houseAspectsMapping=" + houseAspectsMapping
				+ ", planetAgeMapping=" + planetAgeMapping
				+ ", planetHouseMapping=" + planetHouseMapping
				+ ", houseZodiacMapping=" + houseZodiacMapping
				+ ", aspectPlanetHousesMapping=" + aspectPlanetHousesMapping
				+ ", planetHouseKarakasMap=" + planetHouseKarakasMap
				+ ", housePlanetKarakasMap=" + housePlanetKarakasMap
				+ ", planetNakshatrasMap=" + planetNakshatrasMap
				+ ", nakshatraLordHouseMap=" + nakshatraLordHouseMap
				+ ", charakarakaMap=" + charakarakaMap + "]";
	}
}
