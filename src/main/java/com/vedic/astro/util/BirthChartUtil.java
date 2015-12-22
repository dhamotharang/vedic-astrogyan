package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.BirthPlanetaryPositions;
import com.vedic.astro.domain.EntityRelationshipValue;
import com.vedic.astro.domain.HouseArgala;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.enums.ArgalaGroup;
import com.vedic.astro.enums.ArgalaType;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseArgalaStatus;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.PlanetPlanetRelationship;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.BirthChartCalcPrep;
import com.vedic.astro.vo.ChartHouse;
import com.vedic.astro.vo.HouseAscInput;
import com.vedic.astro.vo.HousePlanetInput;
import com.vedic.astro.vo.PlanetAbsoluteLocation;
import com.vedic.astro.vo.PlanetPosition;
import com.vedic.astro.vo.VargaChartHouse;
import com.vedic.astro.vo.ZodiacDegRange;
import com.vedic.astro.vo.ZodiacPosition;

@Component("birthChartUtil")
public class BirthChartUtil {

	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	public BirthChartData generateD1Chart(
			BirthPlanetaryPositions birthPlanetaryPositions) {

		Map<Zodiac, List<PlanetPosition>> zodiacMap = new HashMap<Zodiac, List<PlanetPosition>>();

		for (PlanetPosition planetPosition : birthPlanetaryPositions
				.getPlanetPositions()) {

			List<PlanetPosition> planetPositions = null;

			if (zodiacMap.containsKey(planetPosition.getZodiac())) {
				planetPositions = zodiacMap.get(planetPosition.getZodiac());
			} else {
				planetPositions = new ArrayList<PlanetPosition>();

			}
			planetPositions.add(planetPosition);
			zodiacMap.put(planetPosition.getZodiac(), planetPositions);
		}

		BirthChartData chartData = new BirthChartData();
		List<ChartHouse> chartHouses = new ArrayList<ChartHouse>();

		// System.out.println("ascendantZodiac =" + ascendantZodiac);

		for (int i = 1; i <= 12; i++) {
			chartHouses.add(createHouseData(i,
					birthPlanetaryPositions.getLagna(), zodiacMap));
		}

		chartData.setChartHouses(chartHouses);
		chartData.setBirthChartType(BirthChartType.D1);
		return chartData;
	}

	public BirthChartData generateD1Chart(
			AbsolutePlanetaryPositions absolutePlanetaryPositions) {
		return this.generateD1Chart(this
				.calcPlanetPosition(absolutePlanetaryPositions));
	}

	private ChartHouse createHouseData(int number, PlanetPosition lagna,
			Map<Zodiac, List<PlanetPosition>> zodiacMap) {

		Zodiac ascendantZodiac = lagna.getZodiac();

		ChartHouse house = new ChartHouse();
		House currentHouse = houseUtil.getHouseAtDistance(number, House.H1);
		if (currentHouse.equals(House.H1)) {
			this.populateAscData(house, lagna);
		}
		house.setHouse(currentHouse);

		Zodiac zodiac = zodiacUtil.getZodiacAtDistance(number, ascendantZodiac);
		house.setZodiac(zodiac);

		if ((zodiacMap.get(zodiac) != null) && !zodiacMap.get(zodiac).isEmpty()) {

			List<PlanetPosition> zodiacPlanets = zodiacMap.get(zodiac);

			for (PlanetPosition zodiacPlanet : zodiacPlanets) {

				Nakshatra nak = nakshatraUtil.getNakshatra(zodiac,
						zodiacPlanet.getDegrees());

				HousePlanetInput housePlanetInput = new HousePlanetInput(
						zodiacPlanet.getPlanet(), zodiacPlanet.getDegrees(),
						nak, nakshatraUtil.getNakshatraLord(nak),
						nakshatraUtil.getNakshatraSubLord(zodiac,
								zodiacPlanet.getDegrees()));

				house.addPlanet(housePlanetInput);
			}
		}

		return house;

	}

	public Planet getNakshatraLord(Planet planet, BirthChartData birthChartData) {

		Planet nakshatraLord = null;
		for (ChartHouse chartHouse : birthChartData.getChartHouses()) {

			for (HousePlanetInput housePlanetInput : chartHouse.getPlanets()) {
				if (housePlanetInput.getPlanet().equals(planet)) {
					nakshatraLord = nakshatraUtil
							.getNakshatraLord(housePlanetInput.getNakshatra());
					break;
				}
			}
		}
		return nakshatraLord;
	}

	public BirthPlanetaryPositions calcPlanetPosition(
			AbsolutePlanetaryPositions absolutePlanetaryPositions) {

		BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		List<PlanetPosition> planetPositions = new ArrayList<PlanetPosition>(9);
		List<PlanetAbsoluteLocation> planetAbsoluteLocs = absolutePlanetaryPositions
				.getAbsolutePlanetPositions();
		Map<ZodiacDegRange, Zodiac> zodiacMap = zodiacUtil
				.getZodiacDegreesMap();

		for (PlanetAbsoluteLocation planetAbsoluteLocation : planetAbsoluteLocs) {
			ZodiacPosition zodiacPosition = zodiacUtil.calcZodiacPosition(
					planetAbsoluteLocation.getDegrees(), zodiacMap);

			PlanetPosition planetPosition = new PlanetPosition(
					zodiacPosition.getDegrees(), zodiacPosition.getZodiac(),
					planetAbsoluteLocation.getPlanet());

			planetPositions.add(planetPosition);
		}

		ZodiacPosition lagnaZodiacPosition = zodiacUtil.calcZodiacPosition(
				absolutePlanetaryPositions.getLagna(), zodiacMap);

		PlanetPosition lagnaPlanetPosition = new PlanetPosition(
				lagnaZodiacPosition.getDegrees(),
				lagnaZodiacPosition.getZodiac(), null);
		birthPlanetaryPositions.setLagna(lagnaPlanetPosition);
		birthPlanetaryPositions.setPlanetPositions(planetPositions);

		return birthPlanetaryPositions;
	}

	private void populateAscData(ChartHouse chartHouse, PlanetPosition lagna) {

		Nakshatra nak = nakshatraUtil.getNakshatra(lagna.getZodiac(),
				lagna.getDegrees());

		Planet nakLord = nakshatraUtil.getNakshatraLord(nak);

		Planet nakSubLord = nakshatraUtil.getNakshatraSubLord(
				lagna.getZodiac(), lagna.getDegrees());

		chartHouse.setAsc(new HouseAscInput(lagna.getDegrees(), nak, nakLord,
				nakSubLord));
	}

	public VargaBirthChartData rotateChart(VargaBirthChartData birthChartData,
			int ascMovement) {

		VargaBirthChartData newBirthChart = new VargaBirthChartData();
		newBirthChart.setPid(birthChartData.getPid());
		newBirthChart.setBirthChartType(birthChartData.getBirthChartType());

		List<VargaChartHouse> newChartHouses = new ArrayList<VargaChartHouse>();

		List<VargaChartHouse> chartHouses = birthChartData.getChartHouses();

		VargaChartHouse h1Chart = chartHouses.get(0);
		Zodiac ascZod = h1Chart.getZodiac();
		Zodiac newAscZodiac = zodiacUtil.getZodiacAtDistance(ascMovement,
				ascZod);

		Map<Zodiac, VargaChartHouse> zodToChartHouseMap = new HashMap<Zodiac, VargaChartHouse>();

		for (VargaChartHouse chartHouse : chartHouses) {
			zodToChartHouseMap.put(chartHouse.getZodiac(), chartHouse);
		}

		for (int i = 1; i <= 12; i++) {
			Zodiac zodiac = zodiacUtil.getZodiacAtDistance(i, newAscZodiac);
			VargaChartHouse chartHouse = new VargaChartHouse(zodiac, zodToChartHouseMap
					.get(zodiac).getPlanets(), houseUtil.getHouseAtDistance(i,
					House.H1));
			newChartHouses.add(chartHouse);
		}
		newBirthChart.setChartHouses(newChartHouses);

		return newBirthChart;
	}

	public Double getActualLongitude(Planet planet,
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Map<Planet, Double> planetToDegMap = birthChartCalcPrep
				.getPlanetAgeMapping();

		Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));

		Double absoluteDegrees = zodiac.getMinDegrees()
				+ planetToDegMap.get(planet);

		return absoluteDegrees;
	}

	public Map<Planet, Double> getActualLongitudeMap(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetToLongMap = new HashMap<Planet, Double>();

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Map<Planet, Double> planetToDegMap = birthChartCalcPrep
				.getPlanetAgeMapping();

		Set<Planet> planets = planetToHouseMap.keySet();

		for (Planet planet : planets) {
			Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));

			Double absoluteDegrees = zodiac.getMinDegrees()
					+ planetToDegMap.get(planet);
			planetToLongMap.put(planet, absoluteDegrees);
		}

		return planetToLongMap;
	}

	public Planet closestPlanetOtherThanRahuKetu(Planet planet,
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetToLongMap = getActualLongitudeMap(birthChartCalcPrep);

		System.out.println("planetToLongMap = " + planetToLongMap);

		Set<Planet> planetsUnderConsideration = planetToLongMap.keySet();

		Double planetLong = planetToLongMap.get(planet);
		planetsUnderConsideration.remove(Planet.RAH);
		planetsUnderConsideration.remove(Planet.KET);
		planetsUnderConsideration.remove(planet);

		Map<Double, Planet> diffPlanetMap = new HashMap<Double, Planet>();
		for (Planet planetUnderConsideration : planetsUnderConsideration) {

			diffPlanetMap.put(MathUtil.round(Math.abs((planetToLongMap
					.get(planetUnderConsideration) - planetLong)), 2),
					planetUnderConsideration);
		}

		Planet nearestPlanet = diffPlanetMap.get(Collections.min(diffPlanetMap
				.keySet()));

		System.out.println("nearestPlanet =" + nearestPlanet);

		return nearestPlanet;
	}

	public Map<Set<Planet>, Double> getPlanetDegreeDifferenceMap(
			List<Planet> planetList, BirthChartCalcPrep birthChartCalcPrep) {
		Map<Set<Planet>, Double> planetDegreeDifferenceMap = new HashMap<Set<Planet>, Double>();

		Map<Planet, Double> planetToLongMap = getActualLongitudeMap(birthChartCalcPrep);

		System.out.println("planetToLongMap = " + planetToLongMap);

		for (Planet planet : planetList) {

			List<Planet> planetListOtherThanCurrent = new ArrayList<Planet>();
			planetListOtherThanCurrent.addAll(planetList);
			planetListOtherThanCurrent.remove(planet);
			System.out.println("planet = " + planet);
			System.out.println("planetListOtherThanCurrent = "
					+ planetListOtherThanCurrent);

			for (Planet currentPlanet : planetListOtherThanCurrent) {
				Set<Planet> planetCombination = new HashSet<Planet>(2);
				planetCombination.add(planet);
				planetCombination.add(currentPlanet);

				Double diff = Math.abs(planetToLongMap.get(planet)
						- planetToLongMap.get(currentPlanet));
				planetDegreeDifferenceMap.put(planetCombination,
						MathUtil.round(diff, 2));
			}
		}

		System.out.println("planetDegreeDifferenceMap ="
				+ planetDegreeDifferenceMap);

		return planetDegreeDifferenceMap;
	}

	public Map<Planet, Double> calcPlanetStrengthViaZodiac(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {
			Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));
			Double score = 0.0;

			Planet lordOfSign = zodiacUtil.getZodiacDetails(zodiac)
					.getRulingPlanet();

			EntityRelationshipValue entityRelationshipValue = relationshipUtil
					.evaluate(planet, lordOfSign);

			if (entityRelationshipValue.getPlanetImpact().equals(
					PlanetPlanetRelationship.Friend)) {
				score = 22.5;
			} else if (entityRelationshipValue.getPlanetImpact().equals(
					PlanetPlanetRelationship.Enemy)) {
				score = 7.5;
			}

			if (RelationshipUtil.isExalted(planet, zodiac)) {
				score = 60.0;
			}
			if (RelationshipUtil.isDelibilated(planet, zodiac)) {
				score = 3.75;
			}

			if (zodiac.equals(planetUtil.getPlanetDetails(planet)
					.getMooltrikonSign())) {
				score = 45.0;
			}

			if (planet.equals(lordOfSign)
					&& !zodiac.equals(planetUtil.getPlanetDetails(planet)
							.getMooltrikonSign())) {
				score = 30.0;
			}

			planetStrengthMap.put(planet, score);
		}

		return planetStrengthMap;
	}

	public Map<Planet, Double> calcPlanetStrengthForKaraka(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.AtmaKarka),
				CharaKaraka.AtmaKarka.getScore());
		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.AmatyaKaraka),
				CharaKaraka.AmatyaKaraka.getScore());

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.BhratruKaraka),
				CharaKaraka.BhratruKaraka.getScore());

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.MatruKaraka),
				CharaKaraka.MatruKaraka.getScore());

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.PutraKaraka),
				CharaKaraka.PutraKaraka.getScore());

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.GnatiKaraka),
				CharaKaraka.GnatiKaraka.getScore());

		planetStrengthMap.put(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.StreeDaraKaraka),
				CharaKaraka.StreeDaraKaraka.getScore());
		return planetStrengthMap;
	}

	public Map<Planet, Double> calcPlanetStrengthsForKendra(
			BirthChartCalcPrep birthChartCalcPrep) {
		House atmakarakaHouse = birthChartCalcPrep.getPlanetHouseMapping().get(
				birthChartCalcPrep.getCharakarakaMap().get(
						CharaKaraka.AtmaKarka));
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();
		for (House kendraHouse : houseUtil.getHousesOfType(HouseType.Kendra)) {
			House fromKendraHouse = houseUtil.getHouseAtDistance(
					kendraHouse.getValue(), atmakarakaHouse);
			Set<Planet> fromKendraPlanets = birthChartCalcPrep
					.getHouseInhabitantsMapping().get(fromKendraHouse);
			for (Planet fromKendraPlanet : fromKendraPlanets) {
				planetStrengthMap.put(fromKendraPlanet, 60.0);
			}
		}
		for (House panaparaHouse : houseUtil
				.getHousesOfType(HouseType.Panapara)) {
			House fromPanaparaHouse = houseUtil.getHouseAtDistance(
					panaparaHouse.getValue(), atmakarakaHouse);
			Set<Planet> fromPanaparaPlanets = birthChartCalcPrep
					.getHouseInhabitantsMapping().get(fromPanaparaHouse);
			for (Planet fromPanaparaPlanet : fromPanaparaPlanets) {
				planetStrengthMap.put(fromPanaparaPlanet, 30.0);
			}
		}
		for (House apoklimHouse : houseUtil.getHousesOfType(HouseType.Apoklim)) {
			House fromApoklimHouse = houseUtil.getHouseAtDistance(
					apoklimHouse.getValue(), atmakarakaHouse);
			Set<Planet> fromApoklimPlanets = birthChartCalcPrep
					.getHouseInhabitantsMapping().get(fromApoklimHouse);
			for (Planet fromApoklimPlanet : fromApoklimPlanets) {
				planetStrengthMap.put(fromApoklimPlanet, 15.0);
			}
		}

		planetStrengthMap.remove(Planet.RAH);
		planetStrengthMap.remove(Planet.KET);

		return planetStrengthMap;

	}

	public boolean isInKartari(Planet planet,
			BirthChartCalcPrep birthChartCalcPrep) {

		boolean found = false;
		House house = birthChartCalcPrep.getPlanetHouseMapping().get(planet);
		House secondHouse = houseUtil.getHouseAtDistance(2, house);
		House twelthHouse = houseUtil.getHouseAtDistance(12, house);

		if (!birthChartCalcPrep.getHouseInhabitantsMapping().get(secondHouse)
				.isEmpty()
				&& !birthChartCalcPrep.getHouseInhabitantsMapping()
						.get(twelthHouse).isEmpty()) {
			found = true;
		}

		return found;
	}

	public Map<Planet, Double> calcPlanetStrengthForKartari(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();

		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {
			Double score = 0.0;
			Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));
			if (!zodiac.isEven() && isInKartari(planet, birthChartCalcPrep)) {
				score = 60.0;
			}
			planetStrengthMap.put(planet, score);
		}
		return planetStrengthMap;
	}

	public Map<Planet, Double> calcPlanetStrengthForAdhipati(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {

			Double score = 0.0;

			boolean hasOddSign = false;
			boolean hasMaleficPlanet = false;

			List<Zodiac> ownedZodiacs = zodiacUtil.getOwnedZodiacs(planet);

			for (Zodiac ownedZodiac : ownedZodiacs) {
				if (!ownedZodiac.isEven()) {
					hasOddSign = true;
				}
			}
			Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
					.getHouseZodiacMapping();
			Map<Planet, House> planetToHouseMap = birthChartCalcPrep
					.getPlanetHouseMapping();

			Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));

			for (Zodiac aspectingZodiac : zodiacUtil
					.getAspectingZodiacs(zodiac)) {
				House aspectingHouse = birthChartCalcPrep
						.getZodiacToHouseMapping().get(aspectingZodiac);
				for (Planet aspectingPlanet : birthChartCalcPrep
						.getInhabitantsOtherThan(aspectingHouse, planet)) {
					if (planetUtil.getPlanetDetails(aspectingPlanet)
							.getNature().equals(PlanetNature.Malefic)) {
						hasMaleficPlanet = true;
					}
				}
			}

			List<Planet> conjunctionPlanets = birthChartCalcPrep
					.getInhabitantsOtherThan(planetToHouseMap.get(planet),
							planet);
			for (Planet conjunctionPlanet : conjunctionPlanets) {
				if (planetUtil.getPlanetDetails(conjunctionPlanet).getNature()
						.equals(PlanetNature.Malefic)) {
					hasMaleficPlanet = true;
				}
			}
			if (hasMaleficPlanet && hasOddSign) {
				score = 60.0;
			}
			planetStrengthMap.put(planet, score);
		}
		return planetStrengthMap;
	}

	public Map<Planet, Double> calcPlanetStrengthsInJaimini(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();
		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {
			Double score = calcPlanetStrengthViaZodiac(birthChartCalcPrep).get(
					planet)
					+ calcPlanetStrengthForKaraka(birthChartCalcPrep).get(
							planet)
					+ calcPlanetStrengthsForKendra(birthChartCalcPrep).get(
							planet)
					+ calcPlanetStrengthForKartari(birthChartCalcPrep).get(
							planet)
					+ calcPlanetStrengthForAdhipati(birthChartCalcPrep).get(
							planet);

			planetStrengthMap.put(planet, score);
		}
		return planetStrengthMap;
	}

	public Map<Zodiac, Double> calcZodiacStrengthsOnKarakas(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();

		Map<Planet, Double> charakaScoreMap = calcPlanetStrengthForKaraka(birthChartCalcPrep);

		Map<Zodiac, House> zodiacToHouseMap = birthChartCalcPrep
				.getZodiacToHouseMapping();
		Map<House, Set<Planet>> houseToPlanetsMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		for (Zodiac zodiac : Zodiac.values()) {

			Set<Planet> planetsInZodiac = houseToPlanetsMap
					.get(zodiacToHouseMap.get(zodiac));
			Double score = 0.0;
			if (planetsInZodiac != null) {

				for (Planet inhabitantPlanet : planetsInZodiac) {
					if (!inhabitantPlanet.equals(Planet.RAH)
							&& !inhabitantPlanet.equals(Planet.KET)) {
						score = score + charakaScoreMap.get(inhabitantPlanet);
					}
				}
			}
			zodiacStrengthMap.put(zodiac, score);
		}

		return zodiacStrengthMap;
	}

	public Map<Zodiac, Double> calcZodiacStrengthsOnPlanetCount(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();
		Map<Zodiac, House> zodiacToHouseMap = birthChartCalcPrep
				.getZodiacToHouseMapping();

		Map<House, Set<Planet>> houseToPlanetsMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		for (Zodiac zodiac : Zodiac.values()) {

			Set<Planet> planetsInZodiac = houseToPlanetsMap
					.get(zodiacToHouseMap.get(zodiac));
			if (planetsInZodiac == null) {
				planetsInZodiac = new HashSet<Planet>();
			}
			zodiacStrengthMap.put(
					zodiac,
					BaseEntityRelationshipRefData
							.getScoreMappingBasedOnPlanetCount().get(
									planetsInZodiac.size()));
		}

		return zodiacStrengthMap;
	}

	public Map<Zodiac, Double> calcZodiacStrengthsOnAspect(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();
		Map<Zodiac, House> zodiacToHouseMap = birthChartCalcPrep
				.getZodiacToHouseMapping();

		Map<House, Set<Planet>> houseToPlanetsMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		for (Zodiac zodiac : Zodiac.values()) {

			Double score = 0.0;

			Set<Planet> planetsInZodiac = houseToPlanetsMap
					.get(zodiacToHouseMap.get(zodiac));

			Planet zodiacLord = zodiacUtil.getZodiacDetails(zodiac)
					.getRulingPlanet();

			for (Zodiac aspectingZodiac : zodiacUtil
					.getAspectingZodiacs(zodiac)) {
				House aspectingHouse = birthChartCalcPrep
						.getZodiacToHouseMapping().get(aspectingZodiac);

				for (Planet aspectingPlanet : birthChartCalcPrep
						.getHouseInhabitantsMapping().get(aspectingHouse)) {
					if (aspectingPlanet.equals(Planet.JUP)
							|| aspectingPlanet.equals(Planet.MER)) {
						score = score + 60.0;
					}
					if (aspectingPlanet.equals(zodiacLord)) {
						score = score + 60.0;
					}
				}
			}

			for (Planet conjunctionPlanet : planetsInZodiac) {
				if (conjunctionPlanet.equals(Planet.JUP)
						|| conjunctionPlanet.equals(Planet.MER)) {
					score = score + 60.0;
				}
				if (conjunctionPlanet.equals(zodiacLord)) {
					score = score + 60.0;
				}
			}

			zodiacStrengthMap.put(zodiac, score);
		}
		return zodiacStrengthMap;
	}

	public Map<Zodiac, Double> calcZodiacStrengthsOnLordOfHouse(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();

		for (Zodiac zodiac : Zodiac.values()) {

			Planet zodiacLord = zodiacUtil.getZodiacDetails(zodiac)
					.getRulingPlanet();
			Map<Planet, Double> planetScoreMap = this
					.calcPlanetStrengthsInJaimini(birthChartCalcPrep);
			zodiacStrengthMap.put(zodiac, planetScoreMap.get(zodiacLord));
		}

		return zodiacStrengthMap;
	}

	public Map<Zodiac, Double> calcZodiacStrengthsInJaimini(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();

		for (Zodiac zodiac : Zodiac.values()) {

			Double score = zodiacUtil.calcZodiacStrengthsBasedOnType().get(
					zodiac)
					+ calcZodiacStrengthsOnKarakas(birthChartCalcPrep).get(
							zodiac)
					+ calcZodiacStrengthsOnPlanetCount(birthChartCalcPrep).get(
							zodiac)
					+ calcZodiacStrengthsOnAspect(birthChartCalcPrep).get(
							zodiac)
					+ calcZodiacStrengthsOnLordOfHouse(birthChartCalcPrep).get(
							zodiac);

			zodiacStrengthMap.put(zodiac, score);
		}

		return zodiacStrengthMap;
	}

	public Map<Zodiac, Double> calcNormalizedZodiacStrengthsInJaimini(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();

		Double totalScore = 0.0;
		Map<Zodiac, Double> zodiacScores = calcZodiacStrengthsInJaimini(birthChartCalcPrep);
		for (Double score : zodiacScores.values()) {
			totalScore = totalScore + score;
		}

		Double averageScore = MathUtil.round(totalScore
				/ zodiacScores.values().size(), 2);

		for (Zodiac zodiac : Zodiac.values()) {
			zodiacStrengthMap.put(zodiac,
					MathUtil.round(zodiacScores.get(zodiac) / averageScore, 2));
		}

		return zodiacStrengthMap;
	}

	public Map<Planet, Double> calcNormalizedPlanetStrengthsInJaimini(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Double totalScore = 0.0;
		Map<Planet, Double> planetScores = calcPlanetStrengthsInJaimini(birthChartCalcPrep);

		for (Double score : planetScores.values()) {
			totalScore = totalScore + score;
		}

		Double averageScore = MathUtil.round(totalScore
				/ planetScores.values().size(), 2);

		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {
			planetStrengthMap.put(planet,
					MathUtil.round(planetScores.get(planet) / averageScore, 2));
		}

		return planetStrengthMap;
	}

	public Map<Integer, Set<Planet>> getPositiveArgalaPlanets(House house,
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Integer, Set<Planet>> positiveArgalaPlanets = new HashMap<Integer, Set<Planet>>();

		House secondHouseFromGiven = houseUtil.getHouseAtDistance(2, house);
		House fourthHouseFromGiven = houseUtil.getHouseAtDistance(4, house);
		House eleventhHouseFromGiven = houseUtil.getHouseAtDistance(11, house);
		House fifthFromGiven = houseUtil.getHouseAtDistance(5, house);
		House thirdFromGiven = houseUtil.getHouseAtDistance(3, house);

		positiveArgalaPlanets.put(2, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(secondHouseFromGiven));
		positiveArgalaPlanets.put(4, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(fourthHouseFromGiven));
		positiveArgalaPlanets.put(11, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(eleventhHouseFromGiven));
		positiveArgalaPlanets.put(5, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(fifthFromGiven));
		positiveArgalaPlanets.put(3, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(thirdFromGiven));

		return positiveArgalaPlanets;
	}

	public Map<Integer, Set<Planet>> getNegativeArgalaPlanets(House house,
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Integer, Set<Planet>> negativeArgalaPlanets = new HashMap<Integer, Set<Planet>>();

		House thirdHouseFromGiven = houseUtil.getHouseAtDistance(3, house);
		House tenthHouseFromGiven = houseUtil.getHouseAtDistance(10, house);
		House twelthHouseFromGiven = houseUtil.getHouseAtDistance(12, house);
		House ninthHouseFromGiven = houseUtil.getHouseAtDistance(9, house);

		negativeArgalaPlanets.put(3, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(thirdHouseFromGiven));
		negativeArgalaPlanets.put(10, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(tenthHouseFromGiven));
		negativeArgalaPlanets.put(12, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(twelthHouseFromGiven));
		negativeArgalaPlanets.put(9, birthChartCalcPrep
				.getHouseInhabitantsMapping().get(ninthHouseFromGiven));

		return negativeArgalaPlanets;

	}

	public Map<House, List<HouseArgala>> calcHouseArgalas(
			BirthChartCalcPrep birthChartPrep) {

		Map<House, List<HouseArgala>> houseArgalasMap = new HashMap<House, List<HouseArgala>>();

		for (House house : House.values()) {
			Map<Integer, Set<Planet>> positiveArgalaPlanets = getPositiveArgalaPlanets(
					house, birthChartPrep);

			// System.out.println("house = " + house);

			List<HouseArgala> houseArgalaList = new ArrayList<HouseArgala>();
			Map<Integer, Set<Planet>> negativeArgalaPlanets = getNegativeArgalaPlanets(
					house, birthChartPrep);

			HouseArgala status4 = evaluate(4, positiveArgalaPlanets.get(4),
					negativeArgalaPlanets.get(10), birthChartPrep);
			if (!status4.getStatus().equals(HouseArgalaStatus.Absent)) {
				status4.setArgalaType(ArgalaType.FourthHouse);
				houseArgalaList.add(status4);
			}
			HouseArgala status2 = evaluate(2, positiveArgalaPlanets.get(2),
					negativeArgalaPlanets.get(12), birthChartPrep);
			if (!status2.getStatus().equals(HouseArgalaStatus.Absent)) {
				status2.setArgalaType(ArgalaType.SecondHouse);
				houseArgalaList.add(status2);
			}
			HouseArgala status11 = evaluate(11, positiveArgalaPlanets.get(11),
					negativeArgalaPlanets.get(3), birthChartPrep);
			if (!status11.getStatus().equals(HouseArgalaStatus.Absent)) {
				status11.setArgalaType(ArgalaType.EleventhHouse);
				houseArgalaList.add(status11);
			}
			HouseArgala status3 = evaluate(3, positiveArgalaPlanets.get(3),
					new HashSet<Planet>(), birthChartPrep);
			if (!status3.getStatus().equals(HouseArgalaStatus.Absent)) {
				status3.setArgalaType(ArgalaType.ThirdHouse);
				houseArgalaList.add(status3);
			}
			HouseArgala status5 = evaluate(5, positiveArgalaPlanets.get(5),
					negativeArgalaPlanets.get(9), birthChartPrep);
			if (!status5.getStatus().equals(HouseArgalaStatus.Absent)) {
				status5.setArgalaType(ArgalaType.FifthHouse);
				houseArgalaList.add(status5);
			}

			houseArgalasMap.put(house, houseArgalaList);

		}

		return houseArgalasMap;
	}

	private HouseArgala evaluate(Integer houseCount, Set<Planet> pos,
			Set<Planet> neg, BirthChartCalcPrep birthChartCalcPrep) {

		HouseArgala argalaResult = new HouseArgala(pos, neg);

		// System.out.println("houseCount = " + houseCount);
		// System.out.println("pos = " + pos);
		// System.out.println("neg = " + neg);
		//
		HouseArgalaStatus status = HouseArgalaStatus.Absent;

		if (houseCount == 3) {
			if (pos.size() >= 3) {
				boolean allMalefic = true;
				for (Planet posPlanet : pos) {

					if (planetUtil.getPlanetDetails(posPlanet).getNature()
							.equals(PlanetNature.Benefic)) {
						allMalefic = false;
					}
				}
				if (allMalefic) {
					status = HouseArgalaStatus.VipreetArgala;
				}
			}

		} else if (neg.isEmpty() && !pos.isEmpty()) {
			status = HouseArgalaStatus.UnObstructed;
		} else if (!pos.isEmpty() & !neg.isEmpty()) {
			Set<Planet> allPlanets = new HashSet<Planet>();
			if (pos != null && !pos.isEmpty()) {
				allPlanets.addAll(pos);
			}
			if (neg != null && !neg.isEmpty()) {
				allPlanets.addAll(neg);
			}

			Map<Planet, ArgalaGroup> planetArgalaGroups = new HashMap<Planet, ArgalaGroup>();

			for (Planet planet : allPlanets) {
				Double degree = birthChartCalcPrep.getPlanetAgeMapping().get(
						planet);

				ArgalaGroup group = null;
				// System.out.println("degree = " + degree);

				if (degree > 0 && degree <= 7.5) {
					group = ArgalaGroup.first;
				} else if (degree > 7.5 && degree <= 15.0) {
					group = ArgalaGroup.second;
				} else if (degree > 15.0 && degree <= 22.5) {
					group = ArgalaGroup.third;
				} else {
					group = ArgalaGroup.fourth;
				}
				planetArgalaGroups.put(planet, group);
			}

			// System.out.println("planetArgalaGroups = " + planetArgalaGroups);

			List<ArgalaGroup> negArgalaGroups = new ArrayList<ArgalaGroup>();
			for (Planet planet : neg) {
				negArgalaGroups.add(planetArgalaGroups.get(planet));
			}

			for (Planet planet : pos) {
				if (planetArgalaGroups.get(planet).equals(ArgalaGroup.first)
						&& negArgalaGroups.contains(ArgalaGroup.fourth)) {
					status = HouseArgalaStatus.Obstructed;
				} else if (planetArgalaGroups.get(planet).equals(
						ArgalaGroup.second)
						&& negArgalaGroups.contains(ArgalaGroup.third)) {
					status = HouseArgalaStatus.Obstructed;
				} else if (planetArgalaGroups.get(planet).equals(
						ArgalaGroup.third)
						&& negArgalaGroups.contains(ArgalaGroup.second)) {
					status = HouseArgalaStatus.Obstructed;
				} else if (planetArgalaGroups.get(planet).equals(
						ArgalaGroup.fourth)
						&& negArgalaGroups.contains(ArgalaGroup.first)) {
					status = HouseArgalaStatus.Obstructed;
				} else {
					status = HouseArgalaStatus.UnObstructed;
				}
			}
		}
		argalaResult.setStatus(status);

		return argalaResult;
	}

	public List<Planet> findYogKarakaPlanets(
			BirthChartCalcPrep birthChartCalcPrep) {

		Set<Planet> kendraPlanets = new HashSet<Planet>();
		Set<Planet> trikonePlanets = new HashSet<Planet>();

		List<Planet> yogakarakaPlanets = new ArrayList<Planet>();

		Zodiac ascZodiac = birthChartCalcPrep.getHouseZodiacMapping().get(
				House.H1);

		System.out.println("ascZodiac = " + ascZodiac);
		System.out.println("houseOwners = "
				+ birthChartCalcPrep.getHouseOwnerMapping());

		for (House kendraHouse : houseUtil.getHousesOfType(HouseType.Kendra)) {
			Planet kendraPlanet = birthChartCalcPrep.getHouseOwnerMapping()
					.get(kendraHouse);
			kendraPlanets.add(kendraPlanet);
		}

		List<House> trikoneHouses = houseUtil
				.getHousesOfType(HouseType.Trikona);
		trikoneHouses.remove(House.H1);

		for (House trikoneHouse : trikoneHouses) {
			Planet trikonePlanet = birthChartCalcPrep.getHouseOwnerMapping()
					.get(trikoneHouse);

			trikonePlanets.add(trikonePlanet);
		}

		System.out.println("trikoneOwnerPlanets = " + trikonePlanets);
		System.out.println("kendraOwnerPlanets = " + kendraPlanets);

		for (Planet planet : Planet.values()) {
			if (kendraPlanets.contains(planet)
					&& trikonePlanets.contains(planet)) {
				yogakarakaPlanets.add(planet);
				break;
			}
		}

		if (yogakarakaPlanets.isEmpty()) {
			if (ascZodiac.equals(Zodiac.GEM)) {
				yogakarakaPlanets.add(Planet.MER);
				yogakarakaPlanets.add(Planet.VEN);
			} else if (ascZodiac.equals(Zodiac.ARE)) {
				yogakarakaPlanets.add(Planet.SUN);
				yogakarakaPlanets.add(Planet.JUP);
			} else if (ascZodiac.equals(Zodiac.SAG)) {
				yogakarakaPlanets.add(Planet.SUN);
				yogakarakaPlanets.add(Planet.MAR);
			} else if (ascZodiac.equals(Zodiac.PIS)) {
				yogakarakaPlanets.add(Planet.MAR);
				yogakarakaPlanets.add(Planet.JUP);
			} else if (ascZodiac.equals(Zodiac.VIR)) {
				yogakarakaPlanets.add(Planet.MER);
				yogakarakaPlanets.add(Planet.VEN);
			} else if (ascZodiac.equals(Zodiac.SCO)) {
				yogakarakaPlanets.add(Planet.MON);
				yogakarakaPlanets.add(Planet.SUN);
			}
		}

		return yogakarakaPlanets;

	}

	public PlanetNature findLordNature(Planet planet,
			BirthChartCalcPrep birthChartCalcPrep) {

		Set<PlanetNature> lordNature = new HashSet<PlanetNature>();

		PlanetNature result = null;

		Map<Planet, List<House>> houseToPlanetMap = birthChartCalcPrep
				.getPlanetOwnedHouse();
		List<House> ownedHouses = houseToPlanetMap.get(planet);

		if (ownedHouses.contains(House.H1) || ownedHouses.contains(House.H5)
				|| ownedHouses.contains(House.H9)) {
			lordNature.add(PlanetNature.Benefic);
		}
		if (ownedHouses.contains(House.H3) || ownedHouses.contains(House.H6)
				|| ownedHouses.contains(House.H11)) {
			lordNature.add(PlanetNature.Malefic);
		}
		if (ownedHouses.contains(House.H2) || ownedHouses.contains(House.H8)
				|| ownedHouses.contains(House.H12)) {
			lordNature.add(PlanetNature.Neutral);
		}

		if (ownedHouses.contains(House.H4) || ownedHouses.contains(House.H7)
				|| ownedHouses.contains(House.H10)) {

			if (planetUtil.getPlanetDetails(planet).getNature()
					.equals(PlanetNature.Benefic)) {
				lordNature.add(PlanetNature.Malefic);
			} else if (planetUtil.getPlanetDetails(planet).getNature()
					.equals(PlanetNature.Malefic)) {
				lordNature.add(PlanetNature.Benefic);
			}

		}
		if (!lordNature.isEmpty()) {
			if (lordNature.size() > 1) {
				if (lordNature.contains(PlanetNature.Benefic)
						&& lordNature.contains(PlanetNature.Malefic)) {

					result = PlanetNature.Neutral;

				} else if (lordNature.contains(PlanetNature.Benefic)
						&& lordNature.contains(PlanetNature.Neutral)) {

					result = PlanetNature.Benefic;

				} else if (lordNature.contains(PlanetNature.Malefic)
						&& lordNature.contains(PlanetNature.Neutral)) {

					result = PlanetNature.Malefic;
				}

			} else {
				if (lordNature.contains(PlanetNature.Benefic)) {
					result = PlanetNature.Benefic;
				} else if (lordNature.contains(PlanetNature.Malefic)){
					result = PlanetNature.Malefic;
				}
				else if (lordNature.contains(PlanetNature.Neutral)){
					result = PlanetNature.Neutral;
				}
			}
		}

		return result;
	}
}