package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.HouseDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;

@Component("houseUtil")
public class HouseUtil {

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Value("${score.zodiac.compatibility.weightage}")
	protected float zodiacWeight;

	@Value("${score.house.compatibility.weightage}")
	protected float houseWeight;

	@Value("${score.owner.compatibility.weightage}")
	protected float ownerWeight;

	@Value("${score.inhabitants.compatibility.weightage}")
	protected float inhabitantsWeight;

	private HouseUtil() {
	}

	public HouseDetails getHouseDetails(House house) {
		return BaseEntityRefData.createHouseRefData().getData()
				.get(house.name());

	}

	public Map<Planet, List<House>> getAspectedHouses(
			Map<House, Set<Planet>> currentHousesConfig) {

		Map<Planet, List<House>> returnMap = new HashMap<Planet, List<House>>();
		for (Map.Entry<House, Set<Planet>> entry : currentHousesConfig
				.entrySet()) {
			House house = entry.getKey();
			Set<Planet> planetList = entry.getValue();

			for (Planet planet : planetList) {

				List<House> planetHouseList = new ArrayList<House>();

				List<Integer> aspectCounts = planetUtil.getAspects(planet);

				for (Integer aspectCount : aspectCounts) {
					planetHouseList.add(getHouseAtDistance(aspectCount, house));
				}
				returnMap.put(planet, planetHouseList);
			}
		}

		return returnMap;

	}

	public House getHouseAtDistance(Integer count, House house) {

		if (count == 0) {
			return house;
		}

		int index = house.ordinal() + count - 1;

        int remainder = index%12;
		
		return House.values()[remainder];
	}

	public List<House> getHousesOfType(HouseType houseType) {
		Map<String, HouseDetails> map = BaseEntityRefData.createHouseRefData()
				.getData();
		List<House> resultHouses = new ArrayList<House>();

		for (Map.Entry<String, HouseDetails> houseDetailsEntry : map.entrySet()) {
			if (houseDetailsEntry.getValue().getHouseTypes()
					.contains(houseType)) {
				resultHouses.add(House.valueOf(houseDetailsEntry.getKey()));
			}
		}

		return resultHouses;
	}

	public Map<House, List<Planet>> getAspectedPlanets(
			Map<House, Set<Planet>> currentHousesConfig) {

		Map<House, List<Planet>> returnMap = new HashMap<House, List<Planet>>();
		for (Map.Entry<House, Set<Planet>> entry : currentHousesConfig
				.entrySet()) {
			House house = entry.getKey();
			Set<Planet> planetList = entry.getValue();

			for (Planet planet : planetList) {

				List<Integer> aspectCounts = planetUtil.getAspects(planet);

				if (aspectCounts != null) {
					House aspectedHouse = null;
					for (Integer aspectCount : aspectCounts) {
						aspectedHouse = getHouseAtDistance(aspectCount, house);

						List<Planet> houseAspectedPlanets = returnMap
								.get(aspectedHouse);

						if (houseAspectedPlanets != null) {
							houseAspectedPlanets.add(planet);
						} else {
							houseAspectedPlanets = new ArrayList<Planet>();
							houseAspectedPlanets.add(planet);
						}
						returnMap.put(aspectedHouse, houseAspectedPlanets);
					}
				}
			}
		}

		return returnMap;

	}
	
	public int distanceBetween(House fromHouse, House toHouse){
		int distance = 1;
		if(toHouse.getValue()>=fromHouse.getValue()){
			distance = toHouse.getValue() - fromHouse.getValue() + 1;
		}
		else {
			distance = (toHouse.getValue()+12) - fromHouse.getValue() + 1;
		}
		return distance;
	}

	/*
	 * public PlanetStrengthOutput
	 * evaluateOwnerHouseStrength(OwnerPlanetHouseStrengthInput input) {
	 * 
	 * PlanetStrengthOutput output = new PlanetStrengthOutput(); Double
	 * consolidatedScore = 0.0;
	 * 
	 * House house = input.getHouse(); Planet planet = input.getPlanet(); Zodiac
	 * zodiac = input.getZodiac(); List<Planet> otherPlanets =
	 * input.getOtherInhabitants();
	 * 
	 * EntityRelationshipValue housePlanetValue =
	 * relationshipUtil.evaluate(house, planet); Map<PlanetStrengthCriteria,
	 * PlanetStrengthResult> strengthMap = new HashMap<PlanetStrengthCriteria,
	 * PlanetStrengthResult>();
	 * 
	 * PlanetStrengthResult planetHouseResult = new PlanetStrengthResult(
	 * housePlanetValue.getHouseImpact().getScore(),
	 * housePlanetValue.getHouseImpact().name());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.HOUSE_COMPATIBILITY,
	 * planetHouseResult);
	 * 
	 * EntityRelationshipValue zodiacPlanetRelationshipValue = relationshipUtil
	 * .evaluate(zodiac, planet);
	 * 
	 * PlanetStrengthResult planetZodiacResult = new PlanetStrengthResult(
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore(),
	 * zodiacPlanetRelationshipValue.getZodiacImpact().name());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.ZODIAC_COMPATIBILITY,
	 * planetZodiacResult);
	 * 
	 * Double inhabitantsScore = 0.0; int inhabitantCount = 0; Double
	 * inhabitantsAvgScore = 0.0;
	 * 
	 * if ((otherPlanets != null) && !otherPlanets.isEmpty()) {
	 * 
	 * StringBuilder descBuilder = new StringBuilder(); for (Planet otherPlanet
	 * : otherPlanets) { inhabitantCount++; EntityRelationshipValue
	 * planetImpactValue = relationshipUtil .evaluate(otherPlanet, planet);
	 * 
	 * 
	 * inhabitantsScore = inhabitantsScore +
	 * planetImpactValue.getPlanetImpact().getScore();
	 * descBuilder.append("planet=").append(otherPlanet)
	 * .append("relation=").append(planetImpactValue.getPlanetImpact().name());
	 * }
	 * 
	 * inhabitantsAvgScore = inhabitantsScore / inhabitantCount;
	 * 
	 * PlanetStrengthResult planetPlanetResult = new PlanetStrengthResult(
	 * inhabitantsAvgScore, descBuilder.toString());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.OTHERS_COMPATIBILITY,
	 * planetPlanetResult);
	 * 
	 * }
	 * 
	 * if ((otherPlanets != null) && !otherPlanets.isEmpty()) {
	 * consolidatedScore = (housePlanetValue.getHouseImpact().getScore() +
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore() +
	 * inhabitantsAvgScore) / 3; } else { consolidatedScore =
	 * (housePlanetValue.getHouseImpact().getScore() +
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore()) / 2; }
	 * 
	 * output.setOverallScore(consolidatedScore);
	 * output.setStrengthMap(strengthMap);
	 * output.setPlanetStrengthType(PlanetStrengthType.House);
	 * 
	 * return output; }
	 * 
	 * public PlanetStrengthOutput evaluateAspectingPlanetHouseStrength(
	 * AspectingPlanetHouseStrengthInput input) {
	 * 
	 * PlanetStrengthOutput output = new PlanetStrengthOutput(); Double
	 * consolidatedScore = 0.0;
	 * 
	 * House house = input.getHouse(); Planet planet = input.getPlanet(); Zodiac
	 * zodiac = input.getZodiac(); Planet ownerPlanet = input.getOwnerOfHouse();
	 * List<Planet> otherPlanets = input.getOtherInhabitants();
	 * 
	 * Map<PlanetStrengthCriteria, PlanetStrengthResult> strengthMap = new
	 * HashMap<PlanetStrengthCriteria, PlanetStrengthResult>();
	 * EntityRelationshipValue housePlanetValue =
	 * relationshipUtil.evaluate(house, planet);
	 * 
	 * PlanetStrengthResult planetHouseResult = new PlanetStrengthResult(
	 * housePlanetValue.getHouseImpact().getScore(),
	 * housePlanetValue.getHouseImpact().name());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.HOUSE_COMPATIBILITY,
	 * planetHouseResult);
	 * 
	 * EntityRelationshipValue zodiacPlanetRelationshipValue = relationshipUtil
	 * .evaluate(zodiac, planet);
	 * 
	 * PlanetStrengthResult planetZodiacResult = new PlanetStrengthResult(
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore(),
	 * zodiacPlanetRelationshipValue.getZodiacImpact().name());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.ZODIAC_COMPATIBILITY,
	 * planetZodiacResult);
	 * 
	 * EntityRelationshipValue ownerPlanetRelationshipValue = relationshipUtil
	 * .evaluate(ownerPlanet, planet);
	 * 
	 * PlanetStrengthResult planetOwnerResult = new PlanetStrengthResult(
	 * ownerPlanetRelationshipValue.getPlanetImpact().getScore(),
	 * ownerPlanetRelationshipValue.getPlanetImpact().name());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.OWNER_COMPATIBILITY,
	 * planetOwnerResult);
	 * 
	 * Double inhabitantsScore = 0.0; int inhabitantCount = 0; Double
	 * inhabitantsAvgScore = 0.0;
	 * 
	 * if ((otherPlanets != null) && !otherPlanets.isEmpty()) {
	 * 
	 * StringBuilder descBuilder = new StringBuilder(); for (Planet otherPlanet
	 * : otherPlanets) { inhabitantCount++; EntityRelationshipValue
	 * planetImpactValue = relationshipUtil .evaluate(otherPlanet, planet);
	 * 
	 * 
	 * inhabitantsScore = inhabitantsScore +
	 * planetImpactValue.getPlanetImpact().getScore();
	 * descBuilder.append(" planet = ").append(otherPlanet)
	 * .append(" relation = "
	 * ).append(planetImpactValue.getPlanetImpact().name()); }
	 * 
	 * inhabitantsAvgScore = inhabitantsScore / inhabitantCount;
	 * 
	 * PlanetStrengthResult planetPlanetResult = new PlanetStrengthResult(
	 * inhabitantsAvgScore, descBuilder.toString());
	 * 
	 * strengthMap.put(PlanetStrengthCriteria.OTHERS_COMPATIBILITY,
	 * planetPlanetResult);
	 * 
	 * }
	 * 
	 * if ((otherPlanets != null) && !otherPlanets.isEmpty()) {
	 * consolidatedScore = (housePlanetValue.getHouseImpact().getScore() +
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore() +
	 * ownerPlanetRelationshipValue.getPlanetImpact().getScore() +
	 * inhabitantsAvgScore) / 4; } else { consolidatedScore =
	 * (housePlanetValue.getHouseImpact().getScore() +
	 * zodiacPlanetRelationshipValue.getZodiacImpact().getScore() +
	 * ownerPlanetRelationshipValue.getPlanetImpact().getScore()) / 3; }
	 * 
	 * output.setOverallScore(consolidatedScore);
	 * output.setStrengthMap(strengthMap);
	 * output.setPlanetStrengthType(PlanetStrengthType.House);
	 * 
	 * return output; }
	 * 
	 * 
	 * 
	 * /* public static void main(String[] args) {
	 * 
	 * Map<House, List<Planet>> houseToPlanetMap = new HashMap<House,
	 * List<Planet>>();
	 * 
	 * List<Planet> planetList1 = new ArrayList<Planet>();
	 * planetList1.add(Planet.JUP); planetList1.add(Planet.SUN);
	 * 
	 * List<Planet> planetList2 = new ArrayList<Planet>();
	 * planetList2.add(Planet.SAT);
	 * 
	 * List<Planet> planetList3 = new ArrayList<Planet>();
	 * planetList3.add(Planet.MAR);
	 * 
	 * houseToPlanetMap.put(House.H7, planetList1);
	 * houseToPlanetMap.put(House.H12, planetList2);
	 * houseToPlanetMap.put(House.H5, planetList3);
	 * 
	 * System.out.println(getAspectedHouses(houseToPlanetMap));
	 * System.out.println(getHouseAtDistance(7, House.H7));
	 * System.out.println(getAspectedPlanets(houseToPlanetMap)); }
	 */
}
