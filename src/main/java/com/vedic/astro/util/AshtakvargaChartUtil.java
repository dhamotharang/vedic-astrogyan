package com.vedic.astro.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.AshtakvargaChart;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("ashtakvargaChartUtil")
public class AshtakvargaChartUtil {

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	private AshtakvargaChartUtil() {
	}

	public AshtakvargaChart prepareCharts(BirthChartCalcPrep birthChartCalcPrep) {
		AshtakvargaChart ashtakvargaChart = prepareBlankCharts();

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();

		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {
			Map<Planet, List<Integer>> beneficPoints = planetUtil
					.getPlanetDetails(planet).getBeneficPoints();
			Set<Map.Entry<Planet, List<Integer>>> beneficMapEntries = beneficPoints
					.entrySet();
			for (Map.Entry<Planet, List<Integer>> beneficMapEntry : beneficMapEntries) {
				Planet secondKey = beneficMapEntry.getKey();

				Zodiac currentZodiac = null;
				if (secondKey.equals(Planet.ASC)) {
					currentZodiac = houseToZodiacMap.get(House.H1);
				} else {
					currentZodiac = houseToZodiacMap.get(planetToHouseMap
							.get(secondKey));
				}
				List<Integer> planetBeneficPoints = beneficMapEntry.getValue();

				for (Integer movtBy : planetBeneficPoints) {
					Integer zodiacNumber = zodiacUtil.getZodiacAtDistance(
							movtBy, currentZodiac).getNumber();
					ashtakvargaChart.updateChart(planet, secondKey,
							zodiacNumber, PlanetNature.Benefic);
				}
			}
		}

		System.out.println("ashtakvargaChart =" + ashtakvargaChart);

		return ashtakvargaChart;
	}

	private AshtakvargaChart prepareBlankCharts() {

		AshtakvargaChart ashtakvargaChart = new AshtakvargaChart();

		for (Planet key : planetUtil.getPlanetsForConsideration(false)) {
			Map<Planet, Map<Integer, PlanetNature>> planetMap = new HashMap<Planet, Map<Integer, PlanetNature>>();

			for (Planet planet : planetUtil.getPlanetsForConsideration(true)) {
				Map<Integer, PlanetNature> planetNatureMap = new HashMap<Integer, PlanetNature>();

				for (int intKey = 1; intKey <= 12; intKey++) {
					planetNatureMap.put(intKey, PlanetNature.Malefic);
				}

				planetMap.put(planet, planetNatureMap);
			}
			ashtakvargaChart.addChart(key, planetMap);
		}
		return ashtakvargaChart;
	}

	public Map<House, Integer> getHouseStrengthChart(
			AshtakvargaChart ashtakvargaChart,
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<House, Integer> houseMap = new HashMap<House, Integer>();
		Map<Zodiac, Integer> zodiacMap = ashtakvargaChart.getFullZodiacChart();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();
		Set<Map.Entry<House, Zodiac>> mapEntrySet = houseToZodiacMap.entrySet();
		
		for(Map.Entry<House, Zodiac> mapEntry : mapEntrySet){
			houseMap.put(mapEntry.getKey(), zodiacMap.get(mapEntry.getValue()));
		}

		return houseMap;
	}
	
	public Map<House, Integer> getHouseChartForPlanet(
			Planet planet,
			AshtakvargaChart ashtakvargaChart,
			BirthChartCalcPrep birthChartCalcPrep) {
       
		Map<House, Integer> houseMap = new HashMap<House, Integer>();
		Map<Zodiac, House> zodiacToHouseMap = birthChartCalcPrep.getZodiacToHouseMapping();
		
		for(Map.Entry<Zodiac, Integer> zodiacMapEntry : ashtakvargaChart.getFullChart().get(planet).entrySet()){
			
			houseMap.put(zodiacToHouseMap.get(zodiacMapEntry.getKey()), zodiacMapEntry.getValue());
		}
		
		return houseMap;
	}
	
	public Map<Planet, Double> getPlanetStrengths(
			AshtakvargaChart ashtakvargaChart,
			BirthChartCalcPrep birthChartCalcPrep) {
       
		Map<Planet, Double> planetStrengthsMap = new HashMap<Planet, Double>();
		Map<Planet, Map<Zodiac, Integer>> fullChart = ashtakvargaChart.getFullChart();

		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep.getHouseZodiacMapping();
		Map<Planet, List<House>> planetToOwnedHousesMap = birthChartCalcPrep.getPlanetOwnedHouse();
		Map<Planet, House> planetToHouseMap = birthChartCalcPrep.getPlanetHouseMapping();
		
		for(Planet planet : planetUtil.getPlanetsForConsideration(false)){
			Integer planetStrengthTotal = 0;
			Double planetStrengthScore = 0.0;
			
			Map<Zodiac, Integer> zodiacPoints = fullChart.get(planet);
			House planetHouse = planetToHouseMap.get(planet);
			Zodiac planetZodiac = houseToZodiacMap.get(planetHouse);
			List<House> planetOwnedHouses = planetToOwnedHousesMap.get(planet);
			
			System.out.println("Planet = " + planet);
			System.out.println("zodiacPoints = " + zodiacPoints);
			System.out.println("planetHouse = " + planetHouse);
			System.out.println("planetZodiac = " + planetZodiac);
			System.out.println("planetOwnedHouses = " + planetOwnedHouses);
			
			for(House planetOwnedHouse : planetOwnedHouses){
				Zodiac ownedZodiac = houseToZodiacMap.get(planetOwnedHouse);
				System.out.println("ownedZodiac = " + ownedZodiac);
				planetStrengthTotal = planetStrengthTotal + zodiacPoints.get(ownedZodiac);
			}
			System.out.println("planetStrengthTotal = " + planetStrengthTotal);
			
			planetStrengthTotal = planetStrengthTotal + zodiacPoints.get(planetZodiac);
			
			System.out.println("planetStrengthTotal = " + planetStrengthTotal);
			
			if(planetOwnedHouses.size()>1){
				planetStrengthScore = (double)planetStrengthTotal/3;
			}
			else{
				planetStrengthScore = (double)planetStrengthTotal/2;
			}
			planetStrengthsMap.put(planet, MathUtil.round(planetStrengthScore, 2));
		}
		return planetStrengthsMap;
	}
}
