package com.vedic.astro.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.AshtakvargaChart;
import com.vedic.astro.domain.PlanetDetails;
import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.domain.ZodiacDegreeRange;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.TransitImpact;
import com.vedic.astro.enums.TransitReference;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.BirthChartCalcPrep;
import com.vedic.astro.vo.TransitOutcome;

@Component("transitUtil")
public class TransitUtil {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("ashtakvargaChartUtil")
	private AshtakvargaChartUtil ashtakvargaChartUtil;

	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;

	private TransitUtil() {
	}

	public List<PlanetTransitData> setDateRange(
			List<PlanetTransitData> transitList) {
		Collections.sort(transitList, new Comparator<PlanetTransitData>() {
			public int compare(PlanetTransitData t1, PlanetTransitData t2) {
				return t1.getStartDate().compareTo(t2.getStartDate());
			}
		});

		Map<Integer, Date> toDateMap = new HashMap<Integer, Date>();

		int counter = 0;

		for (PlanetTransitData planetTransitData : transitList) {
			counter++;
			planetTransitData.setSequence(counter);
			toDateMap.put(counter, planetTransitData.getStartDate());
		}

		for (PlanetTransitData planetTransitData : transitList) {
			planetTransitData.setEndDate(toDateMap.get(planetTransitData
					.getSequence() + 1));
		}

		return transitList;
	}

	public Map<Planet, TransitOutcome> findTransitOutcomesFromMoon(
			BirthChartCalcPrep birthChartCalcPrep,
			Map<Planet, Zodiac> transitData) {

		Map<Planet, TransitOutcome> planetTransitOutcomes = new HashMap<Planet, TransitOutcome>();

		System.out.println("transitData = " + transitData);

		House moonHouse = birthChartCalcPrep.getPlanetHouseMapping().get(
				Planet.MON);
		for (Map.Entry<Planet, Zodiac> transitMapEntry : transitData.entrySet()) {
			Planet transitingPlanet = transitMapEntry.getKey();
			House transitingPlanetHouse = birthChartCalcPrep
					.getZodiacToHouseMapping().get(transitMapEntry.getValue());
			Integer distanceFromMoon = houseUtil.distanceBetween(moonHouse,
					transitingPlanetHouse);

			System.out.println("transitingPlanet = " + transitingPlanet);
			System.out.println("transitingPlanetHouse = "
					+ transitingPlanetHouse);
			System.out.println("distanceFromMoon = " + distanceFromMoon);

			TransitOutcome planetTransitOutcome = BaseTransitRefData
					.getTransitOutcomesFromMoon(transitingPlanet).get(
							distanceFromMoon);
			planetTransitOutcomes.put(transitingPlanet, planetTransitOutcome);
		}
		return planetTransitOutcomes;
	}

	public Map<Planet, TransitOutcome> findTransitOutcomesFromAshtavarga(
			BirthChartCalcPrep birthChartCalcPrep,
			Map<Planet, Zodiac> transitData,
			Map<Planet, Double> transitPlanetDegrees) {

		Map<Planet, TransitOutcome> planetTransitOutcomes = new HashMap<Planet, TransitOutcome>();

		AshtakvargaChart ashtakvargaChart = ashtakvargaChartUtil
				.prepareCharts(birthChartCalcPrep);

		System.out.println("ashtakvargaChart full chart = "
				+ ashtakvargaChart.getFullChart());

		for (Map.Entry<Planet, Zodiac> transitMapEntry : transitData.entrySet()) {
			Planet transitingPlanet = transitMapEntry.getKey();
			Zodiac transitZodiac = transitMapEntry.getValue();

			Integer score = ashtakvargaChart.getZodiacScoreInChart(
					transitingPlanet, transitZodiac);

			System.out.println("score = " + score);

			PlanetDetails transitPlanetDetails = planetUtil
					.getPlanetDetails(transitingPlanet);
			TransitImpact transitImpact = null;

			if (score >= 4) {
				transitImpact = TransitImpact.Good;
			} else {
				transitImpact = TransitImpact.Bad;
			}

			Double transitPlanetDegree = transitPlanetDegrees
					.get(transitingPlanet);

			Planet kakshaPlanet = getKaksha(transitPlanetDegree);
			TransitImpact subPeriodImpact = null;

			PlanetNature subPeriodTransit = ashtakvargaChart.getIndividualChart(transitingPlanet).get(kakshaPlanet).get(transitZodiac.getNumber());
				if (subPeriodTransit.equals(PlanetNature.Benefic)) {
					subPeriodImpact = TransitImpact.Good;
				} else {
					subPeriodImpact = TransitImpact.Bad;
				}
			
			TransitOutcome transitOutcome = new TransitOutcome(transitImpact,
					transitPlanetDetails.getAshtavargaPointsSignificances()
							.get(score), score, TransitReference.AshtavargaSystem, subPeriodImpact);

			planetTransitOutcomes.put(transitingPlanet, transitOutcome);
		}
		return planetTransitOutcomes;
	}

	public Map<Planet, TransitOutcome> findTransitOutcomesFromNak(
			BirthChartCalcPrep birthChartCalcPrep,
			Map<Planet, Nakshatra> transitData) {

		Map<Planet, TransitOutcome> planetTransitOutcomes = new HashMap<Planet, TransitOutcome>();

		for (Map.Entry<Planet, Nakshatra> transitMapEntry : transitData
				.entrySet()) {
			Planet transitingPlanet = transitMapEntry.getKey();
			Nakshatra transitNakshatra = transitMapEntry.getValue();
			Nakshatra moonNakshatra = birthChartCalcPrep
					.getPlanetNakshatrasMapping().get(Planet.MON);

			Integer distanceFromMoonNak = nakshatraUtil.distanceBetween(
					moonNakshatra, transitNakshatra);

			TransitImpact transitImpact = null;
			if (planetUtil.getPlanetDetails(transitingPlanet)
					.getBeneficTransitPointsFromMoonNak()
					.contains(distanceFromMoonNak)) {
				transitImpact = TransitImpact.Good;
			} else {
				transitImpact = TransitImpact.Bad;
			}
			TransitOutcome transitOutcome = new TransitOutcome(transitImpact, TransitReference.NatalMoonNakshatra);
			planetTransitOutcomes.put(transitingPlanet, transitOutcome);
		}
		return planetTransitOutcomes;
	}

	public Planet getKaksha(Double degrees) {
		Planet kakshaPlanet = null;
		Map<ZodiacDegreeRange, Planet> kakshaMap = BaseEntityRelationshipRefData
				.getKakshaMapping();

		for (Map.Entry<ZodiacDegreeRange, Planet> kakshaMapEntry : kakshaMap
				.entrySet()) {
			ZodiacDegreeRange degreeRange = kakshaMapEntry.getKey();
			if ((degrees >= degreeRange.getStartDeg())
					&& (degrees < degreeRange.getEndDeg())) {
				kakshaPlanet = kakshaMapEntry.getValue();
			}
		}

		return kakshaPlanet;
	}
}