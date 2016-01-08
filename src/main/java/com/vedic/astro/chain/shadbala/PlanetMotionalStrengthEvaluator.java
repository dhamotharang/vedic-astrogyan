package com.vedic.astro.chain.shadbala;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.PersonalBirthInfo;
import com.vedic.astro.domain.PlanetDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.MathUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.ZodiacUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("planetMotionalStrengthEvaluator")
public class PlanetMotionalStrengthEvaluator implements Command {

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
		PersonalBirthInfo personalBirthInfo = (PersonalBirthInfo) context
				.get(Constants.PERSONAL_BIRTH_INFO);
		
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

		System.out.println("personalBirthInfo DOB = "
				+ personalBirthInfo.getDob());

		Double sunMeanLongitude = planetUtil.getMeanLatitude(Planet.SUN,
				personalBirthInfo.getDob());

		for (Planet planet : Planet.values()) {

			PlanetDetails planetDetails = planetUtil.getPlanetDetails(planet);

			if (planetDetails.isRetrograde()) {
				Zodiac zodiac = houseToZodiacMap.get(planetToHouseMap.get(planet));

				
				Double meanLongitude = null;
				Double seeghrachcha = null;
				
				Double trueLongitude = zodiac.getMinDegrees()
						+ planetToDegMap.get(planet);

				if(!planetDetails.isInnerPlanet()){
				meanLongitude = planetUtil.getMeanLatitude(planet,
						personalBirthInfo.getDob());
				seeghrachcha = sunMeanLongitude;
				
				}
				else{
					meanLongitude = sunMeanLongitude; 
					seeghrachcha = planetUtil.getMeanLatitude(planet,
							personalBirthInfo.getDob()); 
				}
               Double chestaKendra = (seeghrachcha - (meanLongitude+trueLongitude)/2);
				
				if(chestaKendra > 180){
					chestaKendra = 360-chestaKendra;
				}
				planetStrengths.put(planet, MathUtil.round(Math.abs(chestaKendra/3), 2));
			}
		}

		System.out.println("motional strength = " + planetStrengths);

		return false;
	}
}
