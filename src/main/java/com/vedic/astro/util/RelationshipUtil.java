package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.EntityRelationshipRefData;
import com.vedic.astro.domain.EntityRelationshipValue;
import com.vedic.astro.enums.Arudha;
import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetPlanetRelationship;
import com.vedic.astro.enums.PlanetPlanetRelationshipResult;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.BirthChartCalcPrep;
import com.vedic.astro.vo.ChartHouse;
import com.vedic.astro.vo.HousePlanetInput;
import com.vedic.astro.vo.PlanetPlanetRelationshipInput;
import com.vedic.astro.vo.VargaChartHouse;

@Component("relationshipUtil")
public class RelationshipUtil {

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	private static EntityRelationshipRefData planetHouseRelRefData = 
			BaseEntityRelationshipRefData.createPlanet_HouseRelRefData();
	
	private static EntityRelationshipRefData planetZodiacRelRefData = 
			BaseEntityRelationshipRefData.createPlanet_ZodiacRelRefData();
	
	private static EntityRelationshipRefData planetPlanetRelRefData = 
			BaseEntityRelationshipRefData.createPlanet_PlanetRelRefData();
	
	private static Map<Planet, Zodiac> exaltedPlanetZodiacMap = 
			BaseEntityRelationshipRefData.getExaltedPlanetZodiacMap();
	
	private static Map<Planet, Zodiac> debilatedPlanetZodiacMap = 
			BaseEntityRelationshipRefData.getDebilatedPlanetZodiacMap();
	
	private static Map<PlanetPlanetRelationshipInput, PlanetPlanetRelationshipResult> 
		planetPlanetRelationshipMatrix = BaseEntityRelationshipRefData.getPlanetPlanetRelationshipMatrix();
	
	private static List<Integer> temporaryEnemyPlanetHouses = 
			BaseEntityRelationshipRefData.getTemporaryEnemyPlanetHouses();
	
	private static List<Integer> temporaryFriendPlanetHouses = 
			BaseEntityRelationshipRefData.getTemporaryFriendPlanetHouses();
	
	private static Map<HouseType, Double> kendraBalaScoreMap = 
			BaseEntityRelationshipRefData.getKendraBalaScoreMap();
	
	private static Map<Planet, Map<Zodiac, Double>> planetOddEvenZodiacRelationshipMatrix = BaseEntityRelationshipRefData
			.getPlanetOddEvenZodiacRelationshipMatrix();
	
	private static Map<Planet, House> directionalStrengthMapping = 
			BaseEntityRelationshipRefData.getDirectionalStrengthMapping();
	
	private RelationshipUtil() {
	}

	public EntityRelationshipValue evaluate(House house, Planet planet) {

		return planetHouseRelRefData.getData().get(planet.name()).get(house.name());
	}

	public EntityRelationshipValue evaluate(Zodiac zodiac, Planet planet) {
		return planetZodiacRelRefData.getData().get(planet.name()).get(zodiac.name());
	}

	public EntityRelationshipValue evaluate(Planet planet1, Planet planet2) {
		return planetPlanetRelRefData.getData().get(planet1.name()).get(planet2.name());
	}

	public BirthChartCalcPrep preparePlanetsForCalc(
			List<ChartHouse> houseInputList) {

		Map<House, Set<Planet>> inhabitantsMap = new HashMap<House, Set<Planet>>();
		Map<House, Planet> ownersMap = new HashMap<House, Planet>();
		Map<House, List<Planet>> aspectsMap = new HashMap<House, List<Planet>>();
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();
		Map<Planet, House> planetHouseMap = new HashMap<Planet, House>();
		Map<House, Zodiac> houseZodiac = new HashMap<House, Zodiac>();
		Map<Planet, List<House>> planetOwnedHouse = new HashMap<Planet, List<House>>();
		Map<Planet, List<House>> aspectPlanetHousesMapping = new HashMap<Planet, List<House>>();
		Map<Planet, List<House>> planetHouseKarakasMap = new HashMap<Planet, List<House>>();
		Map<House, List<Planet>> housePlanetKarakasMap = new HashMap<House, List<Planet>>();
		Map<Planet, Nakshatra> planetNakshatraMap = new HashMap<Planet, Nakshatra>();
		Map<Planet, House> nakshatraLordHouseMap = new HashMap<Planet, House>();

		for (ChartHouse chartHouse : houseInputList) {

			House houseKey = chartHouse.getHouse();
			Planet ownerPlanet = zodiacUtil.getOwnerPlanet(chartHouse
					.getZodiac());
			ownersMap.put(houseKey, ownerPlanet);

			houseZodiac.put(houseKey, chartHouse.getZodiac());

			Set<Planet> inhabitantPlanets = new HashSet<Planet>();
			for (HousePlanetInput housePlanetInput : chartHouse.getPlanets()) {
				inhabitantPlanets.add(housePlanetInput.getPlanet());
				planetHouseMap.put(housePlanetInput.getPlanet(), houseKey);

				planetStrengthMap.put(housePlanetInput.getPlanet(),
						housePlanetInput.getDegrees());
				planetNakshatraMap.put(housePlanetInput.getPlanet(),
						housePlanetInput.getNakshatra());
				nakshatraLordHouseMap.put(housePlanetInput.getNakshatraLord(),
						houseKey);
			}
			inhabitantsMap.put(houseKey, inhabitantPlanets);
		}
		aspectsMap = houseUtil.getAspectedPlanets(inhabitantsMap);
		aspectPlanetHousesMapping = houseUtil.getAspectedHouses(inhabitantsMap);

		for (Planet planet : Planet.values()) {

			planetHouseKarakasMap.put(planet,
					planetUtil.getHousesForKaraka(planet));
		}

		for (House house : House.values()) {
			housePlanetKarakasMap.put(house, houseUtil.getHouseDetails(house)
					.getKaraka());
		}

		List<House> housesOwned = null;
		for (Map.Entry<House, Planet> housePlanetEntry : ownersMap.entrySet()) {

			housesOwned = planetOwnedHouse.get(housePlanetEntry.getValue());

			if (housesOwned == null) {
				housesOwned = new ArrayList<House>();
			}
			housesOwned.add(housePlanetEntry.getKey());

			planetOwnedHouse.put(housePlanetEntry.getValue(), housesOwned);

		}

		BirthChartCalcPrep prepData = new BirthChartCalcPrep();

		prepData.setHouseAspectsMapping(aspectsMap);
		prepData.setHouseInhabitantsMapping(inhabitantsMap);
		prepData.setHouseOwnerMapping(ownersMap);
		prepData.setPlanetAgeMapping(planetStrengthMap);
		prepData.setHouseZodiacMapping(houseZodiac);
		prepData.setPlanetHouseMapping(planetHouseMap);
		prepData.setAspectPlanetHousesMapping(aspectPlanetHousesMapping);
		prepData.setPlanetOwnedHouse(planetOwnedHouse);
		prepData.setPlanetHouseKarakasMap(planetHouseKarakasMap);
		prepData.setHousePlanetKarakasMap(housePlanetKarakasMap);
		prepData.setNakshatraLordHouseMapping(nakshatraLordHouseMap);
		prepData.setPlanetNakshatrasMapping(planetNakshatraMap);

		prepData.setCharakarakaMap(this.setCharaKarakas(planetStrengthMap));

		return prepData;
	}

	public BirthChartCalcPrep prepareVargaChartForCalc(
			List<VargaChartHouse> houseInputList) {

		Map<House, Set<Planet>> inhabitantsMap = new HashMap<House, Set<Planet>>();
		Map<House, Planet> ownersMap = new HashMap<House, Planet>();
		Map<House, List<Planet>> aspectsMap = new HashMap<House, List<Planet>>();
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();
		Map<Planet, House> planetHouseMap = new HashMap<Planet, House>();
		Map<House, Zodiac> houseZodiac = new HashMap<House, Zodiac>();
		Map<Planet, List<House>> planetOwnedHouse = new HashMap<Planet, List<House>>();
		Map<Planet, List<House>> aspectPlanetHousesMapping = new HashMap<Planet, List<House>>();
		Map<Planet, List<House>> planetHouseKarakasMap = new HashMap<Planet, List<House>>();
		Map<House, List<Planet>> housePlanetKarakasMap = new HashMap<House, List<Planet>>();

		for (VargaChartHouse chartHouse : houseInputList) {

			House houseKey = chartHouse.getHouse();
			Planet ownerPlanet = zodiacUtil.getOwnerPlanet(chartHouse
					.getZodiac());
			ownersMap.put(houseKey, ownerPlanet);

			houseZodiac.put(houseKey, chartHouse.getZodiac());

			Set<Planet> inhabitantPlanets = new HashSet<Planet>();
			for (Planet housePlanet : chartHouse.getPlanets()) {
				inhabitantPlanets.add(housePlanet);
				planetHouseMap.put(housePlanet, houseKey);
			}
			inhabitantsMap.put(houseKey, inhabitantPlanets);
		}
		aspectsMap = houseUtil.getAspectedPlanets(inhabitantsMap);
		aspectPlanetHousesMapping = houseUtil.getAspectedHouses(inhabitantsMap);

		for (Planet planet : Planet.values()) {

			planetHouseKarakasMap.put(planet,
					planetUtil.getHousesForKaraka(planet));
		}

		for (House house : House.values()) {
			housePlanetKarakasMap.put(house, houseUtil.getHouseDetails(house)
					.getKaraka());
		}

		List<House> housesOwned = null;
		for (Map.Entry<House, Planet> housePlanetEntry : ownersMap.entrySet()) {

			housesOwned = planetOwnedHouse.get(housePlanetEntry.getValue());

			if (housesOwned == null) {
				housesOwned = new ArrayList<House>();
			}
			housesOwned.add(housePlanetEntry.getKey());

			planetOwnedHouse.put(housePlanetEntry.getValue(), housesOwned);

		}

		BirthChartCalcPrep prepData = new BirthChartCalcPrep();

		prepData.setHouseAspectsMapping(aspectsMap);
		prepData.setHouseInhabitantsMapping(inhabitantsMap);
		prepData.setHouseOwnerMapping(ownersMap);
		prepData.setHouseZodiacMapping(houseZodiac);
		prepData.setPlanetHouseMapping(planetHouseMap);
		prepData.setAspectPlanetHousesMapping(aspectPlanetHousesMapping);
		prepData.setPlanetOwnedHouse(planetOwnedHouse);
		prepData.setPlanetHouseKarakasMap(planetHouseKarakasMap);
		prepData.setHousePlanetKarakasMap(housePlanetKarakasMap);

		prepData.setCharakarakaMap(this.setCharaKarakas(planetStrengthMap));

		return prepData;
	}

	public static boolean isExalted(Planet planet, Zodiac zodiac) {
		return zodiac.equals(exaltedPlanetZodiacMap.get(planet));
	}

	public static boolean isDelibilated(Planet planet, Zodiac zodiac) {
		return zodiac.equals(debilatedPlanetZodiacMap.get(planet));
	}

	public static PlanetPlanetRelationshipResult evaluatePlanetRelationship(
			PlanetPlanetRelationshipInput input) {
		return planetPlanetRelationshipMatrix.get(input);
	}

	public static List<Integer> findTemporaryEnemyPlanetHouses() {
		return temporaryEnemyPlanetHouses;
	}

	public static List<Integer> findTemporaryFriendPlanetHouses() {
		return temporaryFriendPlanetHouses;
	}

	public Map<Planet, Map<Planet, PlanetPlanetRelationshipResult>> preparePlanetPlanetRelationships(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Map<Planet, PlanetPlanetRelationshipResult>> result = new HashMap<Planet, Map<Planet, PlanetPlanetRelationshipResult>>();

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Set<Planet>> houseToPlanetMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		for (Planet planet : Planet.values()) {

			Map<Planet, PlanetPlanetRelationshipResult> planetPlanetRelationshipResultMap = new HashMap<Planet, PlanetPlanetRelationshipResult>();

			Set<Planet> temporaryEnemyPlanets = new HashSet<Planet>();
			Set<Planet> temporaryFriendPlanets = new HashSet<Planet>();

			House planetHouse = planetToHouseMap.get(planet);
			List<Integer> enemyHouses = this.findTemporaryEnemyPlanetHouses();

			for (Integer houseAt : enemyHouses) {
				House enemyHouse = houseUtil.getHouseAtDistance(houseAt,
						planetHouse);
				temporaryEnemyPlanets.addAll(houseToPlanetMap.get(enemyHouse));
			}

			List<Integer> friendHouses = this.findTemporaryFriendPlanetHouses();

			for (Integer houseAt : friendHouses) {
				House friendHouse = houseUtil.getHouseAtDistance(houseAt,
						planetHouse);
				temporaryFriendPlanets
						.addAll(houseToPlanetMap.get(friendHouse));
			}

			temporaryEnemyPlanets.remove(planet);

			for (Planet temporaryEnemyPlanet : temporaryEnemyPlanets) {

				PlanetPlanetRelationship permanentRelationship = this.evaluate(
						planet, temporaryEnemyPlanet).getPlanetImpact();

				PlanetPlanetRelationshipResult planetPlanetResult = this
						.evaluatePlanetRelationship(new PlanetPlanetRelationshipInput(
								PlanetPlanetRelationship.Enemy,
								permanentRelationship));
				planetPlanetRelationshipResultMap.put(temporaryEnemyPlanet,
						planetPlanetResult);
			}
			temporaryFriendPlanets.remove(planet);

			for (Planet temporaryFriendPlanet : temporaryFriendPlanets) {

				PlanetPlanetRelationship permanentRelationship = this.evaluate(
						planet, temporaryFriendPlanet).getPlanetImpact();

				PlanetPlanetRelationshipResult planetPlanetResult = this
						.evaluatePlanetRelationship(new PlanetPlanetRelationshipInput(
								PlanetPlanetRelationship.Friend,
								permanentRelationship));
				planetPlanetRelationshipResultMap.put(temporaryFriendPlanet,
						planetPlanetResult);
			}

			result.put(planet, planetPlanetRelationshipResultMap);
		}
		return result;
	}

	public Double getOddEvenPlacementScore(Planet planet, Zodiac zodiac) {
		return planetOddEvenZodiacRelationshipMatrix.get(planet).get(zodiac);
	}

	public Double getKendraBalaScore(HouseType houseType) {
		return kendraBalaScoreMap.get(houseType);
	}

	public Double getDirectionalWeakestPosition(Planet planet) {
		Double weakestDirectionalPosition = 0.0;
		House kendraHouse = directionalStrengthMapping.get(planet);
		if (kendraHouse != null) {
			weakestDirectionalPosition = houseUtil.getHouseDetails(kendraHouse)
					.getKendraPowerlessPosition();
		}

		return weakestDirectionalPosition;
	}

	public Double getDirectionalStrength(Planet planet, Double degrees) {

		Double score = 0.0;

		Double weakestDirectionalPosition = getDirectionalWeakestPosition(planet);
		System.out.println("weakestDirectionalPosition = "
				+ weakestDirectionalPosition);

		Double diff = Math.abs(weakestDirectionalPosition - degrees);
		if (diff > 180) {
			diff = 180 - diff;
		}
		System.out.println("diff = " + diff);
		score = MathUtil.round(diff / 3, 2);
		return score;
	}

	public Map<CharaKaraka, Planet> setCharaKarakas(
			Map<Planet, Double> unsortMap) {

		Map<Planet, Double> ownUnsortMap = new HashMap<Planet, Double>(); 

		for(Map.Entry<Planet, Double> mapEntry : unsortMap.entrySet()){
			if(!mapEntry.getKey().equals(Planet.RAH) && !mapEntry.getKey().equals(Planet.KET)){
				ownUnsortMap.put(mapEntry.getKey(), mapEntry.getValue());
			}
		}
		
		List<Entry<Planet, Double>> list = new LinkedList<Entry<Planet, Double>>(
				ownUnsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<Planet, Double>>() {
			public int compare(Entry<Planet, Double> o1,
					Entry<Planet, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// Maintaining insertion order with the help of LinkedList
		List<Planet> sortedPlanets = new ArrayList<Planet>();
		for (Entry<Planet, Double> entry : list) {
			sortedPlanets.add(entry.getKey());
		}

		Map<CharaKaraka, Planet> charakarakaMap = new HashMap<CharaKaraka, Planet>();

		charakarakaMap.put(CharaKaraka.AtmaKarka, sortedPlanets.get(0));
		charakarakaMap.put(CharaKaraka.AmatyaKaraka, sortedPlanets.get(1));
		charakarakaMap.put(CharaKaraka.BhratruKaraka, sortedPlanets.get(2));
		charakarakaMap.put(CharaKaraka.MatruKaraka, sortedPlanets.get(3));
		//charakarakaMap.put(CharaKaraka.PitruKaraka, sortedPlanets.get(4));
		charakarakaMap.put(CharaKaraka.PutraKaraka, sortedPlanets.get(4));
		charakarakaMap.put(CharaKaraka.GnatiKaraka, sortedPlanets.get(5));
		charakarakaMap.put(CharaKaraka.StreeDaraKaraka, sortedPlanets.get(6));

		return charakarakaMap;
	}

	public Map<House, Arudha> prepareArudhas(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<House, Arudha> arudhaMap = new HashMap<House, Arudha>();
		for (House house : House.values()) {
              Planet lordOfHouse = birthChartCalcPrep.getHouseOwnerMapping().get(house);
              House houseOfLordOfHouse = birthChartCalcPrep.getPlanetHouseMapping().get(lordOfHouse);
              
              arudhaMap.put(houseUtil.getHouseAtDistance(
    				  houseUtil.distanceBetween(house, houseOfLordOfHouse), 
    				  houseOfLordOfHouse), Arudha.getArudhaAt(house.getValue()));
		}
		return arudhaMap;
	}
	
	
}
