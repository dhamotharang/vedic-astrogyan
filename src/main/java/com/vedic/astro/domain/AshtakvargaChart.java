package com.vedic.astro.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Zodiac;

public class AshtakvargaChart {

	private Map<Planet, Map<Planet, Map<Integer, PlanetNature>>> chartsMap = new HashMap<Planet, Map<Planet, Map<Integer, PlanetNature>>>();

	public void addChart(Planet planet,
			Map<Planet, Map<Integer, PlanetNature>> planetChartMap) {
		chartsMap.put(planet, planetChartMap);
	}

	public Map<Planet, Map<Integer, PlanetNature>> getIndividualChart(Planet planet) {
		return chartsMap.get(planet);
	}

	public void updateChart(Planet firstKey, Planet secondKey,
			Integer zodiacNumber, PlanetNature nature) {
		Map<Integer, PlanetNature> housetoNatureMap = chartsMap.get(firstKey)
				.get(secondKey);
		// System.out.println("housetoNatureMap before = " + housetoNatureMap);

		housetoNatureMap.put(zodiacNumber, nature);

	}

	public Integer getPlanetScoreInChart(Planet chartType, Planet scoreForPlanet) {
		Map<Planet, Map<Integer, PlanetNature>> chartMap = chartsMap
				.get(chartType);
		Map<Integer, PlanetNature> houseScoresMap = chartMap
				.get(scoreForPlanet);

		Integer planetScore = 0;
		Set<Map.Entry<Integer, PlanetNature>> houseScoresEntries = houseScoresMap
				.entrySet();

		for (Map.Entry<Integer, PlanetNature> mapEntry : houseScoresEntries) {
			planetScore = planetScore + mapEntry.getValue().getValue();
		}

		return planetScore;
	}

	public Integer getZodiacScoreInChart(Planet chartType, Zodiac zodiac) {
		Map<Planet, Map<Integer, PlanetNature>> chartMap = chartsMap
				.get(chartType);
		Set<Map.Entry<Planet, Map<Integer, PlanetNature>>> allPlanetEntries = chartMap
				.entrySet();
		Integer houseScore = 0;
		for (Map.Entry<Planet, Map<Integer, PlanetNature>> planetEntry : allPlanetEntries) {
			Set<Map.Entry<Integer, PlanetNature>> houseScoresEntries = planetEntry
					.getValue().entrySet();
			for (Map.Entry<Integer, PlanetNature> houseScoreEntry : houseScoresEntries) {
				if (houseScoreEntry.getKey().equals(zodiac.getNumber())) {
					houseScore = houseScore
							+ houseScoreEntry.getValue().getValue();
				}
			}
		}
		return houseScore;
	}

   public Map<Planet, Map<Zodiac, Integer>> getFullChart() {
		
		Map<Planet, Map<Zodiac, Integer>> fullChart = new HashMap<Planet, Map<Zodiac, Integer>>();
		
		for(Planet planet : chartsMap.keySet()){
			Map<Zodiac, Integer> zodiacMap = new HashMap<Zodiac, Integer>(12);
			
			for(Zodiac zodiac : Zodiac.values()){
				zodiacMap.put(zodiac, this.getZodiacScoreInChart(planet, zodiac));
			}
			
			fullChart.put(planet, zodiacMap);
			
		}
		
		return fullChart;
	}
   
   public Map<Zodiac, Integer> getFullZodiacChart(){
	   
	   Map<Zodiac, Integer> zodiacMap = new HashMap<Zodiac, Integer>();
	   
	   Map<Planet, Map<Zodiac, Integer>> planetZodiacMap = getFullChart();
	   	for(Planet planet: chartsMap.keySet()){
				Integer zodiacScore = 0; 
				for(Zodiac zodiac : Zodiac.values()){
					if(zodiacMap.get(zodiac)!=null){
					zodiacScore = zodiacMap.get(zodiac) + planetZodiacMap.get(planet).get(zodiac);	
				}
					else{
						zodiacScore = planetZodiacMap.get(planet).get(zodiac);
					}
					zodiacMap.put(zodiac, zodiacScore);
			}
		}
	   return zodiacMap;
   }

	@Override
	public String toString() {
		return "AshtakvargaChart [chartsMap=" + chartsMap + "]";
	}
}
