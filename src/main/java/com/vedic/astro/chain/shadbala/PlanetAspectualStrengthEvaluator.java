package com.vedic.astro.chain.shadbala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.util.MathUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("planetAspectualStrengthEvaluator")
public class PlanetAspectualStrengthEvaluator implements Command {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Override
	public boolean execute(Context context) throws Exception {

	    Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);
		BirthChartData birthChartData = (BirthChartData) context
				.get(Constants.BIRTH_CHART_DATA);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(birthChartData.getChartHouses());

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Map<Planet, Double> planetToDegMap = birthChartCalcPrep
				.getPlanetAgeMapping();
		Map<Planet, Map<Planet, Double>> planetAspectStrengthMap =
				new HashMap<Planet, Map<Planet, Double>>();
		
		for (Planet aspectedPlanet : planetUtil.getPlanetsForConsideration(false)) {
			
			System.out.println("aspected planet = " + aspectedPlanet);
			
			List<Planet> aspectingPlanets = planetUtil.getPlanetsForConsideration(false);
			aspectingPlanets.remove(aspectedPlanet);
			
			System.out.println("aspecting planets = " + aspectingPlanets);
			
			Double planetScore = 0.0;
			Map<Planet, Double> aspectingPlanetStrengths = new HashMap<Planet, Double>();

			for (Planet aspectingPlanet : aspectingPlanets) {
				
				System.out.println("aspectingPlanet = " + aspectingPlanet);
				
				Double aspectingPlanetDegrees = 
						birthChartCalcPrep.getAbsoluteDegrees(aspectingPlanet);
				Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap
						.get(aspectedPlanet));

				Double aspectedPlanetDegrees = zodiac.getMinDegrees()
						+ planetToDegMap.get(aspectedPlanet);

				if (aspectedPlanetDegrees < aspectingPlanetDegrees) {
					aspectedPlanetDegrees = aspectedPlanetDegrees + 360.0;
				}

				System.out.println("aspectedPlanetDegrees = " + aspectedPlanetDegrees);
				System.out.println("aspectingPlanetDegrees = " + aspectingPlanetDegrees);

				Double degDiff = MathUtil.round(
						(aspectedPlanetDegrees - aspectingPlanetDegrees), 2);
				Double score = planetUtil.getAspectStrength(degDiff,
						aspectingPlanet);
				
				if (planetUtil.getPlanetDetails(aspectingPlanet).getNature()
						.equals(PlanetNature.Malefic)) {
					score = score * (-1);
				}
				System.out.println("score = " + score);
				aspectingPlanetStrengths.put(aspectingPlanet, score);
				planetScore = planetScore + score;
			}
			planetStrengths.put(aspectedPlanet, MathUtil.round((planetScore/4),2));
			planetAspectStrengthMap.put(aspectedPlanet, aspectingPlanetStrengths);
		}
		System.out.println("aspectual strength = " + planetStrengths);
		System.out.println("planetAspectStrengthMap = " + planetAspectStrengthMap);
		
		return false;
	}
}