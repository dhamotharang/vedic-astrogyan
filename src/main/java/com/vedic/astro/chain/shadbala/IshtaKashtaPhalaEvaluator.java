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
import com.vedic.astro.enums.Planet;
import com.vedic.astro.util.MathUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("ishtaKashtaPhalaEvaluator")
public class IshtaKashtaPhalaEvaluator implements Command {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Override
	public boolean execute(Context context) throws Exception {

		Map<Planet, Double> ishtaPhalaStrengths = new HashMap<Planet, Double>(7);
		Map<Planet, Double> kashtaPhalaStrengths = new HashMap<Planet, Double>(
				7);

		BirthChartData birthChartData = (BirthChartData) context
				.get(Constants.BIRTH_CHART_DATA);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(birthChartData.getChartHouses());

		Double sunDegrees = birthChartCalcPrep.getAbsoluteDegrees(Planet.SUN);
		Double moonDegrees = birthChartCalcPrep.getAbsoluteDegrees(Planet.MON);

		Double sunSayansaLongitude = sunDegrees + 23.60 + 90.0;

		if (sunSayansaLongitude > 180) {
			sunSayansaLongitude = 360 - sunSayansaLongitude;
		}

		Double moonSayansaLongitude = Math.abs(moonDegrees - sunDegrees);

		if (moonSayansaLongitude > 180) {
			moonSayansaLongitude = 360 - moonSayansaLongitude;
		}

		Double sunChestBala = MathUtil.round(sunSayansaLongitude / 3, 2);
		Double moonChestBala = MathUtil.round(moonSayansaLongitude / 3, 2);

		Map<Planet, Double> planetMotionalStrengths = (Map<Planet, Double>) context
				.get(Constants.PLANET_MOTIONAL_STRENGTH);

		Map<Planet, Double> planetUcchaBalaStrengths = (Map<Planet, Double>) context
				.get(Constants.UCCHA_PLANET_STRENGTHS);

		if (planetMotionalStrengths != null) {
			planetMotionalStrengths.put(Planet.SUN, sunChestBala);
			planetMotionalStrengths.put(Planet.MON, moonChestBala);
		}

		System.out.println("sunChestBala = " + sunChestBala);
		System.out.println("moonChestBala = " + moonChestBala);

		System.out.println("ishtaPhalaStrengths = " + ishtaPhalaStrengths);
		System.out.println("kashtaPhalaStrengths = " + kashtaPhalaStrengths);

		return false;
	}
	
	//private Map<Planet, Double> calculateIshtaPhalaStrengths
}