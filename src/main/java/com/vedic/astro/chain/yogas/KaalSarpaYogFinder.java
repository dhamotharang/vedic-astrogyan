package com.vedic.astro.chain.yogas;

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
import com.vedic.astro.enums.Planet;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("kaalSarpaYogFinder")
public class KaalSarpaYogFinder implements Command {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	public boolean execute(Context context) throws Exception {

		boolean kalSarpaFound = true;

		BirthChartData birthChartData = (BirthChartData) context
				.get(Constants.BIRTH_CHART_DATA);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(birthChartData.getChartHouses());

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();

		Map<House, Set<Planet>> houseToPlanetMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		House ketHouse = planetToHouseMap.get(Planet.KET);
		for (int i = ketHouse.getValue(); i < ketHouse.getValue() + 7; i++) {
			House countedHouse = houseUtil.getHouseAtDistance(i, ketHouse);

			Set<Planet> planets = houseToPlanetMap.get(countedHouse);
			
			if (!planets.isEmpty()) {
				kalSarpaFound = false;
				break;
			}
		}

		System.out.println("kalSarpaFound = " + kalSarpaFound);

		return false;
	}
}