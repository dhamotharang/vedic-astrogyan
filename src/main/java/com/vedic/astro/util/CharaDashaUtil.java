package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.DashaTimePeriod;
import com.vedic.astro.domain.ZodiacDashaPeriod;
import com.vedic.astro.enums.CharaType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("charaDashaUtil")
public class CharaDashaUtil {

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	
	public Map<DashaTimePeriod, Zodiac> generateMahaDashaInfo(String dob, BirthChartCalcPrep birthChartCalcPrep){
		Map<DashaTimePeriod, Zodiac> mahadashaData = new LinkedHashMap<DashaTimePeriod, Zodiac>();
		
		Map<Zodiac, Integer> mahadashaPeriods = calcMahaDashaPeriods(birthChartCalcPrep);
		Date dateOfBirth = DateUtil.toDate(dob, "dd/MM/yyyy");
		Date startDate = dateOfBirth;
		
		for(Map.Entry<Zodiac, Integer> mahadashaPeriodEntry : mahadashaPeriods.entrySet()){
			Zodiac zodiac = mahadashaPeriodEntry.getKey();
			Integer years = mahadashaPeriodEntry.getValue();
			
			Date endDate = DateUtil.addMonths(startDate, 12*years);
			
		//	dashaPeriod.addMahadashaData(startDate, endDate, zodiac);
			mahadashaData.put(new DashaTimePeriod(startDate, endDate), zodiac);
			
			startDate = endDate;
		}
		
		return mahadashaData;
	}
	
	public Map<Zodiac, Integer> calcMahaDashaPeriods(
			BirthChartCalcPrep birthChartCalcPrep) {
		Map<Zodiac, Integer> dashaPeriods = new LinkedHashMap<Zodiac, Integer>();
		Zodiac ascZodiac = birthChartCalcPrep.getHouseZodiacMapping().get(
				House.H1);
		List<Zodiac> zodiacList = generateMahadashaOrder(ascZodiac);

		for (Zodiac zodiac : zodiacList) {
			Planet rulingPlanet = zodiacUtil.getOwnerPlanet(zodiac);
			Zodiac rulingPlanetZodiac = birthChartCalcPrep
					.getHouseZodiacMapping().get(
							birthChartCalcPrep.getPlanetHouseMapping().get(
									rulingPlanet));

			dashaPeriods.put(
					zodiac,
					calcDashaPeriod(rulingPlanetZodiac, zodiac,
							birthChartCalcPrep));
		}

		return dashaPeriods;
	}

	public List<Zodiac> generateMahadashaOrder(Zodiac ascZodiac) {

		List<Zodiac> dashaOrder = new ArrayList<Zodiac>();
		Zodiac ninthZodiac = zodiacUtil.getZodiacAtDistance(9, ascZodiac);
		for (int i = 1; i <= 12; i++) {
			int j = i;
			if (ninthZodiac.getCharaType().equals(CharaType.Indirect)) {
				j = -i;
			}
			dashaOrder.add(zodiacUtil.getZodiacAtDistance(j, ascZodiac));
		}

		return dashaOrder;
	}
	
	public Map<Zodiac, Integer > generateAntardashaData(int years, Zodiac startZodiac) {

		Map<Zodiac, Integer> antardashaOrder = new LinkedHashMap<Zodiac, Integer>();
		
		Zodiac ninthZodiac = zodiacUtil.getZodiacAtDistance(9, startZodiac);
		for (int i = 1; i <= 12; i++) {
			int j = i+1;
			if (ninthZodiac.getCharaType().equals(CharaType.Indirect)) {
				j = -(i+1);
			}
			antardashaOrder.put(zodiacUtil.getZodiacAtDistance(j, startZodiac), years);
		}

		return antardashaOrder;
	}


	public int calcDashaPeriod(Zodiac rulingPlanetZodiac, Zodiac zodiac,
			BirthChartCalcPrep birthChartCalcPrep) {
		int period = 0;

		Planet secondaryLord = zodiacUtil.getSecondaryLord(zodiac);

		if (secondaryLord != null) {
			period = calcSpecialZodiac(zodiac, secondaryLord,
					birthChartCalcPrep);
		} else if (zodiac.getCharaType().equals(CharaType.Direct)) {
			period = zodiacUtil.distanceBetween(zodiac, rulingPlanetZodiac) - 1;
		} else {
			period = zodiacUtil.distanceBetween(rulingPlanetZodiac, zodiac) - 1;
		}

		if (period == 0) {
			period = 12;
		}
		return period;
	}

	public int calcSpecialZodiac(Zodiac zodiac, Planet secondaryLord,
			BirthChartCalcPrep birthChartCalcPrep) {

		int period = 0;

		Planet rulingPlanet = zodiacUtil.getOwnerPlanet(zodiac);
		//System.out.println("zodiac = " + zodiac);
		//System.out.println("secondaryLord = " + secondaryLord);
		//System.out.println("rulingPlanet = " + rulingPlanet);

		Map<Planet, House> planetToHouseMap = birthChartCalcPrep
				.getPlanetHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();

		Zodiac rulingPlanetZodiac = houseToZodiacMap.get(planetToHouseMap
				.get(rulingPlanet));
		Zodiac secondaryLordZodiac = houseToZodiacMap.get(planetToHouseMap
				.get(secondaryLord));

		//System.out.println("rulingPlanetZodiac = " + rulingPlanetZodiac);
		//System.out.println("secondaryLordZodiac = " + secondaryLordZodiac);
		
		Zodiac zodiacToConsider = null;
		boolean inSameZodiac = false;

		if (rulingPlanetZodiac.equals(zodiac)
				&& secondaryLordZodiac.equals(zodiac)) {
			inSameZodiac = true;
			//System.out.println("Both in same zodiac ");
		} else if (!rulingPlanetZodiac.equals(zodiac)
				&& secondaryLordZodiac.equals(zodiac)) {
			zodiacToConsider = rulingPlanetZodiac;
			//System.out.println("secondary in same, ruling in different");
		} else if (rulingPlanetZodiac.equals(zodiac)
				&& !secondaryLordZodiac.equals(zodiac)) {
			//System.out.println("ruling in same, secondary in different");
			zodiacToConsider = secondaryLordZodiac;
		} else if (!rulingPlanetZodiac.equals(zodiac)
				&& !secondaryLordZodiac.equals(zodiac)) {
			//System.out.println("Both in different");
			List<Planet> inhabitantsOfSecondaryLord = birthChartCalcPrep
					.getInhabitantsOtherThan(
							planetToHouseMap.get(secondaryLord), secondaryLord);
			List<Planet> inhabitantsOfRulingPlanet = birthChartCalcPrep
					.getInhabitantsOtherThan(
							planetToHouseMap.get(rulingPlanet), rulingPlanet);
			//System.out.println(" inhabitantsOfSecondaryLord= " + inhabitantsOfSecondaryLord);
			//System.out.println(" inhabitantsOfRulingPlanet = " + inhabitantsOfRulingPlanet);
			if (inhabitantsOfSecondaryLord.size() > inhabitantsOfRulingPlanet
					.size()) {
				
				zodiacToConsider = secondaryLordZodiac;
			} else if (inhabitantsOfSecondaryLord.size() < inhabitantsOfRulingPlanet
					.size()) {
				
				zodiacToConsider = rulingPlanetZodiac;
			} else {
				Map<Planet, Double> planetDegMap = birthChartCalcPrep
						.getPlanetAgeMapping();
			//	System.out.println("planetDegMap.get(secondaryLord) = " + planetDegMap.get(secondaryLord));
			//	System.out.println("planetDegMap.get(rulingPlanet) = " + planetDegMap.get(rulingPlanet));
				
				if (planetDegMap.get(secondaryLord) > planetDegMap
						.get(rulingPlanet)) {
					zodiacToConsider = secondaryLordZodiac;
				} else {
					zodiacToConsider = rulingPlanetZodiac;
				}
			}
		}

		if (!inSameZodiac) {
			if (zodiac.getCharaType().equals(CharaType.Direct)) {
		//		System.out.println(" Direct = ");
				period = zodiacUtil.distanceBetween(zodiac, zodiacToConsider) - 1;
			} else {
		//		System.out.println(" InDirect = ");
				period = zodiacUtil.distanceBetween(zodiacToConsider, zodiac) - 1;
			}
		}
		else{
			period = 12;
		}

		return period;
	}
	
	public Map<DashaTimePeriod, Zodiac> generateAntardashaPeriod(Integer time, Zodiac parentZodiac, Date startDate){
		Map<DashaTimePeriod, Zodiac> antardashaData = new LinkedHashMap<DashaTimePeriod, Zodiac>();
		
		Map<Zodiac, Integer> antardashaMap = generateAntardashaData(time, parentZodiac);
		Date antardashaStartDate = startDate;
		for(Map.Entry<Zodiac, Integer> antardashaPeriodEntry : antardashaMap.entrySet()){
			
			Zodiac antarDashaZodiac = antardashaPeriodEntry.getKey();
			Integer months = antardashaPeriodEntry.getValue();
			
			Date antardashaEndDate = DateUtil.addMonths(antardashaStartDate, months);
			antardashaData.put(new DashaTimePeriod(antardashaStartDate, antardashaEndDate), antarDashaZodiac);
			antardashaStartDate = antardashaEndDate;
		}
		return antardashaData;
	}
	
	public ZodiacDashaPeriod getDashaAsOn(Date date, String dob, BirthChartCalcPrep birthChartCalcPrep){
		Map<DashaTimePeriod, Zodiac> mahadashas = this.generateMahaDashaInfo(dob, birthChartCalcPrep);
		
		System.out.println("mahadashas = " + mahadashas);
		
		Zodiac mahadashaZodiac = null;
		DashaTimePeriod mahadashaTimePeriod = null;
		
		for(Map.Entry<DashaTimePeriod, Zodiac> dashaMapEntry : mahadashas.entrySet()){
			
			DashaTimePeriod dashaTimePeriod = dashaMapEntry.getKey();
			Zodiac zodiac = dashaMapEntry.getValue();
			
			if((date.after(dashaTimePeriod.getStartDate())||date.equals(dashaTimePeriod.getStartDate()))&&date.before(dashaTimePeriod.getEndDate())){
				mahadashaZodiac = zodiac;
				mahadashaTimePeriod = dashaTimePeriod;
				break;
			}
		}
		
		Map<DashaTimePeriod, Zodiac> antardashas = 
				this.generateAntardashaPeriod(
						DateUtil.yearsBetween(mahadashaTimePeriod.getStartDate(), 
								mahadashaTimePeriod.getEndDate()), 
						mahadashaZodiac,
						mahadashaTimePeriod.getStartDate());
		
		System.out.println("antardashas = " + antardashas);
		
		Zodiac antardashaZodiac = null;
		DashaTimePeriod antardashaTimePeriod = null;
		
		for(Map.Entry<DashaTimePeriod, Zodiac> dashaMapEntry : antardashas.entrySet()){
			
			DashaTimePeriod dashaTimePeriod = dashaMapEntry.getKey();
			Zodiac zodiac = dashaMapEntry.getValue();
			
			if(date.after(dashaTimePeriod.getStartDate())&&date.before(dashaTimePeriod.getEndDate())){
				antardashaZodiac = zodiac;
				antardashaTimePeriod = dashaTimePeriod;
				break;
			}
		}
		
		return new ZodiacDashaPeriod(mahadashaZodiac, 
				antardashaZodiac, 
				antardashaTimePeriod, 
				mahadashaTimePeriod);
	}
}
