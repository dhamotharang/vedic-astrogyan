package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.enums.ZodiacType;
import com.vedic.astro.vo.ChartHouse;
import com.vedic.astro.vo.HousePlanetInput;
import com.vedic.astro.vo.VargaChartHouse;
import com.vedic.astro.vo.ZodiacDegRange;

@Component("divChartUtil")
public class DivChartUtil {

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	public VargaBirthChartData generateDivChart(BirthChartType birthChartType,
			BirthChartData d1Chart) {

		if (birthChartType.equals(BirthChartType.D2)) {
			return generateHoraChart(d1Chart);
		}

		Map<Zodiac, Map<ZodiacDegRange, Integer>> movtRule = BaseEntityRefData
				.getAllMovtRules(createMovtMap()).get(birthChartType);
		if (movtRule == null) {
			throw new IllegalArgumentException(
					"Birthchart type not configured " + birthChartType);
		}

		VargaBirthChartData divChart = new VargaBirthChartData();
		divChart.setBirthChartType(birthChartType);
		divChart.setPid(d1Chart.getPid());

		List<VargaChartHouse> divChartHouseList = new ArrayList<VargaChartHouse>();

		List<ChartHouse> d1ChartHouseList = d1Chart.getChartHouses();

		Map<House, List<Planet>> houseToPlanetMap = new HashMap<House, List<Planet>>();

		int moveAscBy = 0;

		for (ChartHouse chartHouse : d1ChartHouseList) {
			if (chartHouse.getAsc() != null) {
				
				moveAscBy = moveHouseBy(chartHouse.getAsc().getDegrees(),
						movtRule.get(chartHouse.getZodiac()));
				
				System.out.println("Asc degrees = "
						+ chartHouse.getAsc().getDegrees());
				System.out.println("Asc zodiac = " + chartHouse.getZodiac());
				System.out.println("Asc movt map = "
						+ movtRule.get(chartHouse.getZodiac()));
				System.out.println("moveAscBy = " + moveAscBy);
			}

			List<HousePlanetInput> housePlanets = chartHouse.getPlanets();

			for (HousePlanetInput housePlanet : housePlanets) {
				int houseMoveBy = moveHouseBy(housePlanet.getDegrees(),
						movtRule.get(chartHouse.getZodiac()));

				House newHouse = houseUtil.getHouseAtDistance(houseMoveBy,
						chartHouse.getHouse());
				List<Planet> planetList = null;
				if (houseToPlanetMap.containsKey(newHouse)) {
					planetList = houseToPlanetMap.get(newHouse);
					planetList
							.add(housePlanet.getPlanet());
				} else {
					planetList = new ArrayList<Planet>();
					planetList
							.add(housePlanet.getPlanet());
				}
				houseToPlanetMap.put(newHouse, planetList);
			}
		}
		for (ChartHouse chartHouse : d1ChartHouseList) {

			VargaChartHouse divChartHouse = new VargaChartHouse();
			divChartHouse.setHouse(chartHouse.getHouse());
			divChartHouse.setZodiac(chartHouse.getZodiac());

			divChartHouse
					.setPlanets(houseToPlanetMap.get(chartHouse.getHouse()));

			divChartHouseList.add(divChartHouse);
		}

		divChart.setChartHouses(divChartHouseList);

		if (moveAscBy > 0) {
			divChart = birthChartUtil.rotateChart(divChart, moveAscBy);
		}

		return divChart;
	}

	public VargaBirthChartData generateHoraChart(BirthChartData d1Chart) {

		VargaBirthChartData divChart = new VargaBirthChartData();
		divChart.setBirthChartType(BirthChartType.D2);
		divChart.setPid(d1Chart.getPid());

		List<VargaChartHouse> divChartHouseList = new ArrayList<VargaChartHouse>();

		List<ChartHouse> d1ChartHouseList = d1Chart.getChartHouses();

		Map<Zodiac, List<Planet>> zodiacToPlanetMap = new HashMap<Zodiac, List<Planet>>();
		for (ChartHouse chartHouse : d1ChartHouseList) {

			List<HousePlanetInput> housePlanets = chartHouse.getPlanets();

			for (HousePlanetInput housePlanet : housePlanets) {

				Double planetDeg = housePlanet.getDegrees();
				Zodiac movedZodiac = Zodiac.LEO;

				if ((planetDeg > 0) && (planetDeg <= 15)) {
					if (chartHouse.getZodiac().isEven()) {
						movedZodiac = Zodiac.CAN;
					}
				} else {
					if (!chartHouse.getZodiac().isEven()) {
						movedZodiac = Zodiac.CAN;
					}
				}

				List<Planet> planets = zodiacToPlanetMap.get(movedZodiac);
				if (planets == null) {
					planets = new ArrayList<Planet>();
				}
				planets.add(housePlanet.getPlanet());

				zodiacToPlanetMap.put(movedZodiac, planets);
			}
		}
		for (ChartHouse chartHouse : d1ChartHouseList) {

			VargaChartHouse divChartHouse = new VargaChartHouse();

			divChartHouse.setHouse(chartHouse.getHouse());
			divChartHouse.setZodiac(chartHouse.getZodiac());
			List<Planet> planets = zodiacToPlanetMap
					.get(chartHouse.getZodiac());

			List<Planet> planetInputs = new ArrayList<Planet>();

			if (planets != null) {
				for (Planet planet : planets) {
					planetInputs.add(planet);
				}
			}
			divChartHouse.setPlanets(planetInputs);
			divChartHouseList.add(divChartHouse);
		}

		divChart.setChartHouses(divChartHouseList);

		return divChart;
	}

	public Integer moveHouseBy(Double degrees,
			Map<ZodiacDegRange, Integer> divRuleMap) {

		Set<Map.Entry<ZodiacDegRange, Integer>> mapEntries = divRuleMap
				.entrySet();
		Integer movementBy = 0;

		for (Map.Entry<ZodiacDegRange, Integer> mapEntry : mapEntries) {
			if ((degrees > mapEntry.getKey().getMinDegrees())
					&& (degrees <= mapEntry.getKey().getMaxDegrees())) {
				movementBy = mapEntry.getValue();
				break;
			}
		}
		return movementBy;
	}
	
     private Map<Zodiac, Integer> createMovtForD16(){
		
		Map<Zodiac, Integer> d16MovtMap = new LinkedHashMap<Zodiac, Integer>();
		
		for(Zodiac zodiac : Zodiac.values()){
			Integer movtBy = 1;
			
			if(zodiac.getZodiacType().equals(ZodiacType.Movable)){
				movtBy = zodiacUtil.distanceBetween(zodiac, Zodiac.ARE);
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Fixed)){
				movtBy = zodiacUtil.distanceBetween(zodiac, Zodiac.LEO);
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Dual)){
				movtBy = zodiacUtil.distanceBetween(zodiac, Zodiac.SAG);
			}
			d16MovtMap.put(zodiac, movtBy);
		}
		
		System.out.println("d16MovtMap = " + d16MovtMap);
		
		return d16MovtMap;
	}
     
     private Map<BirthChartType, Map<Zodiac, Integer>> createMovtMap(){
    	 
    	 Map<BirthChartType, Map<Zodiac, Integer>> movtMap = new HashMap<BirthChartType, Map<Zodiac, Integer>>();
    	 movtMap.put(BirthChartType.D16, this.createMovtForD16());
    	 
    	 return movtMap;
     }

}
