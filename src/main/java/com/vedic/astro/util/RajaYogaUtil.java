package com.vedic.astro.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.RajaYogaCombination;
import com.vedic.astro.domain.YogaDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.RajaYogaCombinationType;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("rajaYogaUtil")
public class RajaYogaUtil {

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	private RajaYogaUtil() {
	}

	public Set<RajaYogaCombination> findRajaYogaPresent(BirthChartCalcPrep birthChartCalcPrep) {

		Set<RajaYogaCombination> combinations = new HashSet<RajaYogaCombination>();

		Map<House, Planet> kendraLordPlanets = new HashMap<House, Planet>();
		Map<House, Planet> trikoneLordPlanets = new HashMap<House, Planet>();

		for (House kendraHouse : houseUtil.getHousesOfType(HouseType.Kendra)) {
			Planet kendraLordPlanet = birthChartCalcPrep.getHouseOwnerMapping()
					.get(kendraHouse);
			kendraLordPlanets.put(kendraHouse, kendraLordPlanet);
		}

				
		List<House> trikoneHouses = houseUtil
				.getHousesOfType(HouseType.Trikona);

		for (House trikoneHouse : trikoneHouses) {
			Planet trikoneLordPlanet = birthChartCalcPrep
					.getHouseOwnerMapping().get(trikoneHouse);
			trikoneLordPlanets.put(trikoneHouse, trikoneLordPlanet);
		}
		
		
		for (Map.Entry<House, Planet> kendraMapEntry : kendraLordPlanets
				.entrySet()) {
			for (Map.Entry<House, Planet> trikoneMapEntry : trikoneLordPlanets
					.entrySet()) {
				if (!kendraMapEntry.getKey().equals(
						trikoneMapEntry.getKey()) && !kendraMapEntry.getValue().equals(
								trikoneMapEntry.getValue())) {
					
					Set<RajaYogaCombination> aspectCombination = this.isConnectedViaAspect(kendraMapEntry.getValue(),
							trikoneMapEntry.getValue(), birthChartCalcPrep);
					if(!aspectCombination.isEmpty()){
						combinations.addAll(aspectCombination);
					}
					RajaYogaCombination conjunctionCombination = this.isConnectedViaConjunction(kendraMapEntry.getValue(),
							trikoneMapEntry.getValue(), birthChartCalcPrep);
					if(conjunctionCombination!=null){
						combinations.add(conjunctionCombination);
					}
					RajaYogaCombination exchangeCombination = this.isConnectedViaExchange(kendraMapEntry.getValue(),
							kendraMapEntry.getKey(),
							trikoneMapEntry.getValue(),
							trikoneMapEntry.getKey(), birthChartCalcPrep);
					if(exchangeCombination!=null){
						combinations.add(exchangeCombination);
					}
				
				}
			}
		}

		return combinations;
	}

	public Set<Yoga> findVipreetRajaYogaPresent(BirthChartCalcPrep birthChartCalcPrep) {
		
		Set<Yoga> yogas = new HashSet<Yoga>();
		
		Planet house6Lord = birthChartCalcPrep.getHouseOwnerMapping().get(House.H6);
		Planet house8Lord = birthChartCalcPrep.getHouseOwnerMapping().get(House.H8);
		Planet house12Lord = birthChartCalcPrep.getHouseOwnerMapping().get(House.H12);
		
		Set<Planet> house6Planets = birthChartCalcPrep.getHouseInhabitantsMapping().get(House.H6);
		Set<Planet> house8Planets = birthChartCalcPrep.getHouseInhabitantsMapping().get(House.H8);
		Set<Planet> house12Planets = birthChartCalcPrep.getHouseInhabitantsMapping().get(House.H12);
		
		if(house8Planets.contains(house6Lord) || house12Planets.contains(house6Lord)){
			yogas.add(Yoga.Harsha);
		}
		if(house6Planets.contains(house8Lord) || house12Planets.contains(house8Lord)){
			yogas.add(Yoga.Sarala);
		}

		if(house6Planets.contains(house12Lord) || house8Planets.contains(house12Lord)){
			yogas.add(Yoga.Vimal);
		}
		return yogas;
	}

	private Set<RajaYogaCombination> isConnectedViaAspect(Planet kendraLord, Planet trikoneLord,
			BirthChartCalcPrep birthChartCalcPrep) {
		
		Set<RajaYogaCombination> combinations = new HashSet<RajaYogaCombination>();
		
		List<House> housesAspectedByKendraLord = birthChartCalcPrep
				.getAspectPlanetHousesMapping().get(kendraLord);
		for (House houseAspectedByKendraLord : housesAspectedByKendraLord) {
			if (houseUtil.getHousesOfType(HouseType.Trikona).contains(
					houseAspectedByKendraLord)) {
				
				RajaYogaCombination combination = new RajaYogaCombination();
				combination.addHouse(houseAspectedByKendraLord);
				combination.addPlanet(kendraLord);
				combination.setCombinationType(RajaYogaCombinationType.LordAspecting);
				
				combinations.add(combination);
			}
		}

		List<House> housesAspectedByTrikoneLord = birthChartCalcPrep
				.getAspectPlanetHousesMapping().get(trikoneLord);
		for (House houseAspectedByTrikoneLord : housesAspectedByTrikoneLord) {
			if (houseUtil.getHousesOfType(HouseType.Kendra).contains(
					houseAspectedByTrikoneLord)) {
				
				RajaYogaCombination combination = new RajaYogaCombination();
				combination.addHouse(houseAspectedByTrikoneLord);
				combination.addPlanet(trikoneLord);
				combination.setCombinationType(RajaYogaCombinationType.LordAspecting);
				
				combinations.add(combination);
			}
		}
		return combinations;
	}

	private RajaYogaCombination isConnectedViaExchange(Planet kendraLord,
			House kendraHouseOwned, Planet trikoneLord,
			House trikoneHouseOwned, BirthChartCalcPrep birthChartCalcPrep) {

		RajaYogaCombination combination = null;
		if (birthChartCalcPrep.getPlanetHouseMapping().get(kendraLord)
				.equals(trikoneHouseOwned)
				&& birthChartCalcPrep.getPlanetHouseMapping().get(trikoneLord)
						.equals(kendraHouseOwned)) {
			
			combination = new RajaYogaCombination();
			combination.addHouse(trikoneHouseOwned);
			combination.addHouse(kendraHouseOwned);
			combination.addPlanet(trikoneLord);
			combination.addPlanet(kendraLord);
			combination.setCombinationType(RajaYogaCombinationType.ExchangeOfHouse);
			
		}
		return combination;
	}

	private RajaYogaCombination isConnectedViaConjunction(Planet kendraLord,
			Planet trikoneLord, BirthChartCalcPrep birthChartCalcPrep) {

		RajaYogaCombination combination = null;
		House kendraLordHouse = birthChartCalcPrep.getPlanetHouseMapping()
				.get(kendraLord);

		House trikoneLordHouse = birthChartCalcPrep.getPlanetHouseMapping()
				.get(trikoneLord);
		
		if (birthChartCalcPrep.getHouseInhabitantsMapping()
				.get(kendraLordHouse).contains(trikoneLord) ||
				birthChartCalcPrep.getHouseInhabitantsMapping()
				.get(trikoneLordHouse).contains(kendraLord)) {

			combination = new RajaYogaCombination();
			combination.addHouse(kendraLordHouse);
			combination.addHouse(trikoneLordHouse);
			combination.addPlanet(trikoneLord);
			combination.addPlanet(kendraLord);
			combination.setCombinationType(RajaYogaCombinationType.LordCombination);

		}

		return combination;
	}

	public YogaDetails getYogaDetails(Yoga yoga) {
		return BaseYogasRefData.createNabhasYogasRefData().get(yoga);
	}
}
