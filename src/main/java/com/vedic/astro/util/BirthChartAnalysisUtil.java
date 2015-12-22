package com.vedic.astro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("birthChartAnalysisUtil")
public class BirthChartAnalysisUtil {
	

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
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;
	
	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

/*	public BirthBriefChartAnalysis predictChartInBrief(
			BirthChartData birthChartData, String pid) {

		List<ChartHouse> houseInputRequestList = birthChartData
				.getChartHouses();
		BirthChartCalcPrep prepData = relationshipUtil
				.preparePlanetsForCalc(houseInputRequestList);

		BirthBriefChartAnalysis birthChartAnalysis = new BirthBriefChartAnalysis();
		Collection<HouseBriefAnalysis> houseAnalysis = new ArrayList<HouseBriefAnalysis>();
		
		Map<Planet, List<PlanetStrengthOutput>> ownerStrengthMap = null;
		List<PlanetStrengthOutput> ownerStrengthList = null;
		Map<Planet, PlanetStrengthOutput> inhabitantsStrengthMap = null;
		Map<Planet, List<PlanetStrengthOutput>> aspectsStrengthMap = null;
		List<PlanetStrengthOutput> aspectsStrengthList = null;
		HouseBriefAnalysis analysis = null;

		for (ChartHouse chartHouse : houseInputRequestList) {

			analysis = new HouseBriefAnalysis();
			Map<Planet, Double> planetInterestScore = new HashMap<Planet, Double>();

			House house = chartHouse.getHouse();

			analysis.setHouse(house);
			analysis.setZodiac(prepData.getHouseZodiacMapping().get(
					house));

			ownerStrengthMap = new HashMap<Planet, List<PlanetStrengthOutput>>();

			Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);
			House ownerHouse = prepData.getPlanetHouseMapping()
					.get(ownerPlanet);

			analysis.setLinkedHouse(ownerHouse);

			ownerStrengthList = new ArrayList<PlanetStrengthOutput>();

			PlanetStrengthOutput ownerStrength = this.prepareStrengthForPlanet(
					prepData, house, null, HousePlanetRelationshipType.Owner);

			PlanetStrengthOutput ownerHouseStrength = this
					.prepareHouseStrengthForPlanet(prepData, house, null,
							HousePlanetRelationshipType.Owner);

			ownerStrengthList.add(ownerStrength);
			ownerStrengthList.add(ownerHouseStrength);

			Double interestScore = ownerStrength.getOverallScore()
					* ownerHouseStrength.getOverallScore();
			planetInterestScore.put(ownerPlanet, interestScore);

			ownerStrengthMap.put(ownerPlanet, ownerStrengthList);
			analysis.setOwnerPlanetStrength(ownerStrengthMap);

			List<Planet> inhabitantsPlanets = prepData
					.getHouseInhabitantsMapping().get(house);
			inhabitantsStrengthMap = new HashMap<Planet, PlanetStrengthOutput>();

			if (inhabitantsPlanets != null) {
				for (Planet inhabitantPlanet : inhabitantsPlanets) {
					PlanetStrengthOutput inhabitantOwnStrength = this
							.prepareStrengthForPlanet(prepData, house,
									inhabitantPlanet,
									HousePlanetRelationshipType.Inhabitant);
					inhabitantsStrengthMap.put(inhabitantPlanet,
							inhabitantOwnStrength);
					planetInterestScore.put(inhabitantPlanet,
							inhabitantOwnStrength.getOverallScore()
									* inhabitantOwnStrength.getOverallScore());
				}
			}

			analysis.setInhabitantsPlanetsStrength(inhabitantsStrengthMap);

			List<Planet> aspectPlanets = prepData.getHouseAspectsMapping().get(
					house);

			aspectsStrengthMap = new HashMap<Planet, List<PlanetStrengthOutput>>();

			if (aspectPlanets != null) {
				for (Planet aspectPlanet : aspectPlanets) {

					aspectsStrengthList = new ArrayList<PlanetStrengthOutput>();
					PlanetStrengthOutput aspectOwnStrength = this
							.prepareStrengthForPlanet(prepData, null,
									aspectPlanet,
									HousePlanetRelationshipType.Neighbour);

					PlanetStrengthOutput aspectHouseStrength = this
							.prepareHouseStrengthForPlanet(prepData, house,
									aspectPlanet,
									HousePlanetRelationshipType.Neighbour);

					Double aspectInterestScore = aspectOwnStrength
							.getOverallScore()
							* aspectHouseStrength.getOverallScore();
					planetInterestScore.put(aspectPlanet, aspectInterestScore);
					aspectsStrengthList.add(aspectOwnStrength);
					aspectsStrengthList.add(aspectHouseStrength);
					aspectsStrengthMap.put(aspectPlanet, aspectsStrengthList);
				}
			}

			analysis.setAspectingPlanetsStrength(aspectsStrengthMap);
			analysis.setInterestScore(planetInterestScore);
			analysis.setPid(pid);
			analysis.setBirthChartType(BirthChartType.D1);
			houseAnalysis.add(analysis);
		}
		birthChartAnalysis.setHouseAnalysis(houseAnalysis);

		return birthChartAnalysis;
	}

	private PlanetStrengthOutput prepareStrengthForPlanet(
			BirthChartCalcPrep prepData, House house, Planet planet,
			HousePlanetRelationshipType planetType) {

		PlanetOwnStrengthInput input = new PlanetOwnStrengthInput();

		if (planetType.equals(HousePlanetRelationshipType.Owner)) {
			Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);
			House ownerHouse = prepData.getPlanetHouseMapping()
					.get(ownerPlanet);
			Planet ownerHouseOwner = prepData.getHouseOwnerMapping().get(
					ownerHouse);
			Zodiac ownerZodiac = prepData.getHouseZodiacMapping().get(
					ownerHouse);
			List<Planet> ownerHouseInhabitants = prepData
					.getInhabitantsOtherThan(ownerHouse, ownerPlanet);
			PlanetAge ownerAge = prepData.getPlanetAgeMapping()
					.get(ownerPlanet);

			input.setHouse(house);
			input.setOtherInhabitants(ownerHouseInhabitants);
			input.setOwnerOfHouse(ownerHouseOwner);
			input.setPlanet(ownerPlanet);
			input.setPlanetAge(ownerAge);
			input.setZodiac(ownerZodiac);

		} else if (planetType.equals(HousePlanetRelationshipType.Inhabitant)) {

			input.setHouse(house);
			input.setOtherInhabitants(prepData.getInhabitantsOtherThan(house,
					planet));
			input.setOwnerOfHouse(prepData.getHouseOwnerMapping().get(house));
			input.setPlanet(planet);
			input.setPlanetAge(prepData.getPlanetAgeMapping().get(planet));
			input.setZodiac(prepData.getHouseZodiacMapping().get(house));

		} else if (planetType.equals(HousePlanetRelationshipType.Neighbour)) {

			House aspectHouse = prepData.getPlanetHouseMapping().get(planet);
			Planet aspectHouseOwner = prepData.getHouseOwnerMapping().get(
					aspectHouse);
			Zodiac aspectZodiac = prepData.getHouseZodiacMapping().get(
					aspectHouse);
			Planet aspectPlanet = planet;
			List<Planet> aspectOtherInhabitants = prepData
					.getInhabitantsOtherThan(aspectHouse, aspectPlanet);
			PlanetAge aspectPlanetAge = prepData.getPlanetAgeMapping().get(
					aspectPlanet);

			input.setHouse(aspectHouse);
			input.setOtherInhabitants(aspectOtherInhabitants);
			input.setOwnerOfHouse(aspectHouseOwner);
			input.setPlanet(planet);
			input.setPlanetAge(aspectPlanetAge);
			input.setZodiac(aspectZodiac);

		}

		return planetUtil.evaluateOwnStrength(input);

	}

	private PlanetStrengthOutput prepareHouseStrengthForPlanet(
			BirthChartCalcPrep prepData, House house, Planet aspectPlanet,
			HousePlanetRelationshipType planetType) {

		PlanetStrengthOutput output = null;
		if (planetType.equals(HousePlanetRelationshipType.Owner)) {

			OwnerPlanetHouseStrengthInput input = new OwnerPlanetHouseStrengthInput();
			Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);

			input.setHouse(house);
			input.setOtherInhabitants(prepData.getInhabitantsOtherThan(house,
					ownerPlanet));
			input.setPlanet(ownerPlanet);
			input.setZodiac(prepData.getHouseZodiacMapping().get(house));

			output = houseUtil.evaluateOwnerHouseStrength(input);
		} else if (planetType.equals(HousePlanetRelationshipType.Neighbour)) {

			AspectingPlanetHouseStrengthInput input = new AspectingPlanetHouseStrengthInput();
			Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);

			input.setHouse(house);
			input.setOtherInhabitants(prepData.getInhabitantsOtherThan(house,
					ownerPlanet));
			input.setPlanet(aspectPlanet);
			input.setOwnerOfHouse(ownerPlanet);
			input.setZodiac(prepData.getHouseZodiacMapping().get(house));

			output = houseUtil.evaluateAspectingPlanetHouseStrength(input);
		}

		return output;
	}


*/

}
