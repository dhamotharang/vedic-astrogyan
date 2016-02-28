package com.vedic.astro.chain.shadbala;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetPlanetRelationshipResult;
import com.vedic.astro.enums.PlanetZodiacStrength;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.ZodiacUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;
import com.vedic.astro.vo.PlanetStrength;

@Component("planetPositionalStrengthEvaluator")
public class PlanetPositionalStrengthEvaluator implements Command {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Override
	public boolean execute(Context context) throws Exception {

		BirthChartData birthChartData = (BirthChartData) context.get(Constants.BIRTH_CHART_DATA);

		System.out.println("birthChartData = " + birthChartData);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil.preparePlanetsForCalc(birthChartData.getChartHouses());

		Map<Planet, Double> ucchaBalaPlanetStrengths = prepareUcchaBala(birthChartCalcPrep);
		System.out.println("ucchaBalaPlanetStrengths =" + ucchaBalaPlanetStrengths);
		context.put(Constants.UCCHA_PLANET_STRENGTHS, ucchaBalaPlanetStrengths);

		Map<Planet, Double> saptavargiyaPlanetStrengths = prepareSaptavargiyaBala(birthChartCalcPrep);
		System.out.println("saptavargiyaPlanetStrengths =" + saptavargiyaPlanetStrengths);

		Map<Planet, Double> prepareYugmayugmaBala = prepareYugmayugmaBala(birthChartCalcPrep);
		System.out.println("prepareYugmayugmaBala =" + prepareYugmayugmaBala);

		Map<Planet, Double> prepareKendraBala = prepareKendraBala(birthChartCalcPrep);
		System.out.println("prepareKendraBala =" + prepareKendraBala);

		Map<Planet, Double> prepareDreshkonBala = prepareDreshkonBala(birthChartCalcPrep);
		System.out.println("prepareDreshkonBala =" + prepareDreshkonBala);

		return false;
	}

	private Map<Planet, Double> prepareUcchaBala(BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep.getHouseZodiacMapping();
		Map<Planet, Double> planetToDegMap = birthChartCalcPrep.getPlanetAgeMapping();

		for (Planet planet : Planet.values()) {

			if (!planet.equals(Planet.ASC)) {
				Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));

				Double absoluteDegrees = zodiac.getMinDegrees() + planetToDegMap.get(planet);

				Double score = planetUtil.calcExaltationBasedStrength(absoluteDegrees, planet);
				planetStrengths.put(planet, score);
			}
		}

		return planetStrengths;
	}

	private Map<Planet, Double> prepareSaptavargiyaBala(BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);
		Map<Planet, Map<Planet, PlanetPlanetRelationshipResult>> planetRelationshipMap = relationshipUtil
				.preparePlanetPlanetRelationships(birthChartCalcPrep);

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep.getHouseZodiacMapping();

		Set<Map.Entry<Planet, House>> planetHouseEntrySet = planetToHouseMap.entrySet();

		for (Map.Entry<Planet, House> planetHouseEntry : planetHouseEntrySet) {

			PlanetStrength planetStrength = null;
			Planet planet = planetHouseEntry.getKey();
			House house = planetHouseEntry.getValue();
			Zodiac zodiac = houseToZodiacMap.get(house);

			Planet rulingPlanet = zodiacUtil.getOwnerPlanet(zodiac);
			PlanetZodiacStrength planetZodiacStrength = null;
			if (rulingPlanet.equals(planet)) {

				if (zodiac.equals(planetUtil.getPlanetDetails(rulingPlanet).getMooltrikonSign())) {
					planetZodiacStrength = PlanetZodiacStrength.MooltrikonaSign;
				} else {
					planetZodiacStrength = PlanetZodiacStrength.OwnSign;
				}
			} else {
				PlanetPlanetRelationshipResult planetPlanetResult = planetRelationshipMap.get(planet).get(rulingPlanet);
				if (planetPlanetResult.equals(PlanetPlanetRelationshipResult.FastFriend)) {
					planetZodiacStrength = PlanetZodiacStrength.FastFriendSign;
				} else if (planetPlanetResult.equals(PlanetPlanetRelationshipResult.Friend)) {
					planetZodiacStrength = PlanetZodiacStrength.FriendSign;
				} else if (planetPlanetResult.equals(PlanetPlanetRelationshipResult.Neutral)) {
					planetZodiacStrength = PlanetZodiacStrength.NeutralSign;
				} else if (planetPlanetResult.equals(PlanetPlanetRelationshipResult.Enemy)) {
					planetZodiacStrength = PlanetZodiacStrength.EnemySign;
				} else if (planetPlanetResult.equals(PlanetPlanetRelationshipResult.BitterEnemy)) {
					planetZodiacStrength = PlanetZodiacStrength.BitterEnemySign;
				}
			}

			planetStrength = new PlanetStrength(planet, planetZodiacStrength.getScore());
			planetStrengths.put(planet, planetZodiacStrength.getScore());
		}

		return planetStrengths;
	}

	private Map<Planet, Double> prepareYugmayugmaBala(BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep.getHouseZodiacMapping();

		Set<Map.Entry<Planet, House>> planetHouseEntrySet = planetToHouseMap.entrySet();

		for (Map.Entry<Planet, House> planetHouseEntry : planetHouseEntrySet) {

			Planet planet = planetHouseEntry.getKey();
			House house = planetHouseEntry.getValue();
			Zodiac zodiac = houseToZodiacMap.get(house);

			if (!planet.equals(Planet.RAH) && !planet.equals(Planet.KET)) {
				planetStrengths.put(planet, relationshipUtil.getOddEvenPlacementScore(planet, zodiac));
			}
		}

		return planetStrengths;
	}

	private Map<Planet, Double> prepareKendraBala(BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep.getPlanetHouseMapping();

		Set<Map.Entry<Planet, House>> planetHouseEntrySet = planetToHouseMap.entrySet();

		for (Map.Entry<Planet, House> planetHouseEntry : planetHouseEntrySet) {

			Planet planet = planetHouseEntry.getKey();
			House house = planetHouseEntry.getValue();

			Double score = null;

			List<HouseType> houseTypes = houseUtil.getHouseDetails(house).getHouseTypes();

			if (houseTypes.contains(HouseType.Kendra)) {
				score = relationshipUtil.getKendraBalaScore(HouseType.Kendra);
			} else if (houseTypes.contains(HouseType.Apoklim)) {
				score = relationshipUtil.getKendraBalaScore(HouseType.Apoklim);
			} else if (houseTypes.contains(HouseType.Panapara)) {
				score = relationshipUtil.getKendraBalaScore(HouseType.Panapara);
			}

			planetStrengths.put(planet, score);
		}

		return planetStrengths;
	}

	private Map<Planet, Double> prepareDreshkonBala(BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);

		Map<Planet, Double> planetToDegreesMap = birthChartCalcPrep.getPlanetAgeMapping();

		Set<Map.Entry<Planet, Double>> planetDegreeEntrySet = planetToDegreesMap.entrySet();

		for (Map.Entry<Planet, Double> planetDegreeEntry : planetDegreeEntrySet) {

			Planet planet = planetDegreeEntry.getKey();
			Double degrees = planetDegreeEntry.getValue();

			Double score = planetUtil.calcDreshkonBala(degrees, planet);

			planetStrengths.put(planet, score);
		}

		return planetStrengths;
	}

}
