package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.ZodiacUtil;

@Service
@Transactional
public class AstroPredictiveService {

	@Autowired
	PlanetUtil planetUtil;

	@Autowired
	ZodiacUtil zodiacUtil;

	@Autowired
	HouseUtil houseUtil;

	@Autowired
	RelationshipUtil relationshipUtil;

	@Autowired
	BirthChartUtil birthChartUtil;

	/*
	 * public BirthChartAnalysis predictChart(BirthChartData birthChartData) {
	 * 
	 * List<HouseInputRequest> houseInputRequestList = birthChartData
	 * .getHouseInputs(); BirthChartCalcPrep prepData = relationshipUtil
	 * .preparePlanetsForCalc(houseInputRequestList);
	 * 
	 * BirthChartAnalysis birthChartAnalysis = new BirthChartAnalysis();
	 * 
	 * Map<House, HouseAnalysis> houseAnalysisMap = new HashMap<House,
	 * HouseAnalysis>();
	 * 
	 * for (HouseInputRequest houseInputRequest : houseInputRequestList) {
	 * 
	 * HouseAnalysis analysis = new HouseAnalysis(); House house =
	 * houseInputRequest.getHouse();
	 * analysis.setHouseDetails(houseUtil.getHouseDetails(house));
	 * analysis.setZodiacDetails(zodiacUtil.getZodiacDetails(prepData
	 * .getHouseZodiacMapping().get(house)));
	 * 
	 * Map<PlanetDetails, List<PlanetStrengthOutput>> ownerStrengthMap = new
	 * HashMap<PlanetDetails, List<PlanetStrengthOutput>>();
	 * 
	 * Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);
	 * 
	 * List<PlanetStrengthOutput> ownerStrengthList = new
	 * ArrayList<PlanetStrengthOutput>();
	 * 
	 * PlanetStrengthOutput ownerStrength = this.prepareStrengthForPlanet(
	 * prepData, house, null, HousePlanetRelationshipType.Owner);
	 * 
	 * PlanetStrengthOutput ownerHouseStrength = this
	 * .prepareHouseStrengthForPlanet(prepData, house, null,
	 * HousePlanetRelationshipType.Owner);
	 * 
	 * ownerStrengthList.add(ownerStrength);
	 * ownerStrengthList.add(ownerHouseStrength);
	 * 
	 * ownerStrengthMap.put(planetUtil.getPlanetDetails(ownerPlanet),
	 * ownerStrengthList); analysis.setOwnerPlanetStrength(ownerStrengthMap);
	 * 
	 * List<Planet> inhabitantsPlanets = prepData
	 * .getHouseInhabitantsMapping().get(house); Map<PlanetDetails,
	 * PlanetStrengthOutput> inhabitantsStrengthMap = new HashMap<PlanetDetails,
	 * PlanetStrengthOutput>();
	 * 
	 * if (inhabitantsPlanets != null) { for (Planet inhabitantPlanet :
	 * inhabitantsPlanets) { inhabitantsStrengthMap.put(planetUtil
	 * .getPlanetDetails(inhabitantPlanet), this
	 * .prepareStrengthForPlanet(prepData, house, inhabitantPlanet,
	 * HousePlanetRelationshipType.Inhabitant)); } }
	 * 
	 * analysis.setInhabitantsPlanetsStrength(inhabitantsStrengthMap);
	 * 
	 * List<Planet> aspectPlanets = prepData.getHouseAspectsMapping().get(
	 * house); Map<PlanetDetails, List<PlanetStrengthOutput>> aspectsStrengthMap
	 * = new HashMap<PlanetDetails, List<PlanetStrengthOutput>>();
	 * List<PlanetStrengthOutput> aspectsStrengthList = new
	 * ArrayList<PlanetStrengthOutput>();
	 * 
	 * if (aspectPlanets != null) { for (Planet aspectPlanet : aspectPlanets) {
	 * 
	 * aspectsStrengthList.add(this.prepareStrengthForPlanet( prepData, null,
	 * aspectPlanet, HousePlanetRelationshipType.Neighbour));
	 * aspectsStrengthList.add(this.prepareHouseStrengthForPlanet( prepData,
	 * house, aspectPlanet, HousePlanetRelationshipType.Neighbour));
	 * aspectsStrengthMap.put( planetUtil.getPlanetDetails(aspectPlanet),
	 * aspectsStrengthList); } }
	 * 
	 * analysis.setAspectingPlanetsStrength(aspectsStrengthMap);
	 * houseAnalysisMap.put(houseInputRequest.getHouse(), analysis); }
	 * birthChartAnalysis.setHouseAnalysisMap(houseAnalysisMap);
	 * 
	 * return birthChartAnalysis; }
	 */

/*
	public Map<Planet, PlanetStrengthOutput> predictPlanetStrengthsInBrief(
			BirthPlanetaryPositions birthPlanetaryPositions) {

		Map<Planet, PlanetStrengthOutput> map = new HashMap<Planet, PlanetStrengthOutput>();
		BirthChartCalcPrep prepData = relationshipUtil
				.preparePlanetsForCalc(birthChartUtil.generateD1Chart(
						birthPlanetaryPositions).getChartHouses());

		for (Planet planet : Planet.values()) {

			PlanetStrengthOutput inhabitantOwnStrength = this
					.prepareStrengthForPlanet(prepData, prepData
							.getPlanetHouseMapping().get(planet), planet,
							HousePlanetRelationshipType.Inhabitant);

			map.put(planet, inhabitantOwnStrength);

		}

		return map;

	}


	public HouseSummary getHouseSummary(
			BirthPlanetaryPositions birthPlanetaryPositions, House house) {

		BirthChartCalcPrep prepData = relationshipUtil
				.preparePlanetsForCalc(birthChartUtil.generateD1Chart(
						birthPlanetaryPositions).getChartHouses());

		HouseSummary houseSummary = new HouseSummary(prepData
				.getHousePlanetKarakasMap().get(house), prepData
				.getHouseOwnerMapping().get(house), prepData
				.getHouseInhabitantsMapping().get(house), prepData
				.getHouseAspectsMapping().get(house));

		return houseSummary;
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
