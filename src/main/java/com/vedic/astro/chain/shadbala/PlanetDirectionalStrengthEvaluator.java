package com.vedic.astro.chain.shadbala;

import java.util.HashMap;
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
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.ZodiacUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("planetDirectionalStrengthEvaluator")
public class PlanetDirectionalStrengthEvaluator implements Command {

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

	    Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);
		
	    BirthChartData birthChartData = (BirthChartData) context
				.get(Constants.BIRTH_CHART_DATA);
		
	    System.out.println("birthChartData = " + birthChartData);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(birthChartData.getChartHouses());

		Map<Planet, Double> planetAgeMap = birthChartCalcPrep
				.getPlanetAgeMapping();
		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();

		Set<Map.Entry<Planet, Double>> planetDegreeEntrySet = planetAgeMap
				.entrySet();

		for (Map.Entry<Planet, Double> planetDegreeEntry : planetDegreeEntrySet) {
			Planet planet = planetDegreeEntry.getKey(); 
			Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));
			Double absoluteDegrees = zodiac.getMinDegrees()
					+ planetAgeMap.get(planet);
			System.out.println("planet =" + planet);
			System.out.println("absoluteDegrees =" + absoluteDegrees);
			Double score = relationshipUtil.getDirectionalStrength(
					planet, absoluteDegrees);
			if (score > 0.0) {
				planetStrengths.put(planetDegreeEntry
						.getKey(), score);
			}
		}

		System.out.println("directional strength = " + planetStrengths);

		return false;
	}
}
