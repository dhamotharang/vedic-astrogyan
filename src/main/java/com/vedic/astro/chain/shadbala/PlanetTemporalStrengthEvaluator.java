package com.vedic.astro.chain.shadbala;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.PersonalBirthInfo;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Weekday;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.MathUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;
import com.vedic.astro.vo.DayPortion;

@Component("planetTemporalStrengthEvaluator")
public class PlanetTemporalStrengthEvaluator implements Command {

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Value("${ahargana.start.date}")
	public String AHARGANA_START_DATE;

	@Value("${ahargana.correction.days}")
	public Integer AHARGANA_CORRECTION_DAYS;

	@Override
	public boolean execute(Context context) throws Exception {

		PersonalBirthInfo personalBirthInfo = (PersonalBirthInfo) context
				.get(Constants.PERSONAL_BIRTH_INFO);

		BirthChartData birthChartData = (BirthChartData) context
				.get(Constants.BIRTH_CHART_DATA);
		
		Map<Planet, Double> planetPositionalStrengths = (Map<Planet, Double>)context
				.get(Constants.PLANET_POSITIONAL_STRENGTH);
		
		Map<Planet, Double> planetDirectionalStrengths = (Map<Planet, Double>)context
				.get(Constants.PLANET_DIRECTIONAL_STRENGTH);

		System.out.println("birthChartData = " + birthChartData);

		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(birthChartData.getChartHouses());

		Map<Planet, Double> nathonnathBalaMap = calcNathonnathBala(personalBirthInfo);
		System.out.println("nathonnathBalaMap = " + nathonnathBalaMap);

		Map<Planet, Double> calcPakshaBala = calcPakshaBala(birthChartCalcPrep);
		System.out.println("calcPakshaBala = " + calcPakshaBala);

		Map<Planet, Double> calcTribhagBala = calcTribhagBala(personalBirthInfo);
		System.out.println("calcTribhagBala = " + calcTribhagBala);

		Map<Planet, Double> calcMasaBala = calcMasaBala(personalBirthInfo);
		System.out.println("calcMasaBala = " + calcMasaBala);

		Map<Planet, Double> calcAbdaBala = calcAbdaBala(personalBirthInfo);
		System.out.println("calcAbdaBala = " + calcAbdaBala);

		Map<Planet, Double> calcVaraBala = calcVaraBala(personalBirthInfo);
		System.out.println("calcVaraBala = " + calcVaraBala);

		Map<Planet, Double> calcHoraBala = calcHoraBala(personalBirthInfo);
		System.out.println("calcHoraBala = " + calcHoraBala);

		Map<Planet, Double> calcAyanaBala = calcAyanaBala(birthChartCalcPrep);
		System.out.println("calcAyanaBala = " + calcAyanaBala);
		
		Map<Planet, Double> calcYuddhaBala = 
				calcYuddhaBala(
						birthChartCalcPrep, 
						planetPositionalStrengths, 
						planetDirectionalStrengths,
						nathonnathBalaMap,
						calcPakshaBala,
						calcTribhagBala,
						calcHoraBala);
		
		System.out.println("calcYuddhaBala = " + calcYuddhaBala);
	
		

		return false;
	}

	private Map<Planet, Double> calcNathonnathBala(
			PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date midNightTime = DateUtil.calcMidNight(personalBirthInfo.getDob(),
				personalBirthInfo.getSunriseSunsetData().getSunriseTime(),
				personalBirthInfo.getSunriseSunsetData().getSunsetTime());

		// System.out.println("midNightTime = "+ midNightTime);

		int minsDiff = DateUtil.minsBetween(DateUtil.convertDate(
				personalBirthInfo.getDob(), personalBirthInfo.getTob()),
				midNightTime);

		// System.out.println("minsDiff = "+ minsDiff);

		Double score = MathUtil.round(Math.abs(minsDiff - 1440) / 12, 2);

		planetStrengthMap.put(Planet.JUP, score);
		planetStrengthMap.put(Planet.SUN, score);
		planetStrengthMap.put(Planet.VEN, score);

		planetStrengthMap.put(Planet.MON, MathUtil.round((60.00 - score), 2));
		planetStrengthMap.put(Planet.SAT, MathUtil.round((60.00 - score), 2));
		planetStrengthMap.put(Planet.MAR, MathUtil.round((60.00 - score), 2));
		planetStrengthMap.put(Planet.MER, 60.00);

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcPakshaBala(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Double moonLong = birthChartUtil.getActualLongitude(Planet.MON,
				birthChartCalcPrep);
		Double sunLong = birthChartUtil.getActualLongitude(Planet.SUN,
				birthChartCalcPrep);

		Double score = MathUtil.round((Math.abs(moonLong - sunLong) / 3), 2);

		planetStrengthMap.put(Planet.JUP, score);
		planetStrengthMap.put(Planet.MON, 2 * score);
		planetStrengthMap.put(Planet.VEN, score);

		planetStrengthMap.put(Planet.SUN, MathUtil.round((60.00 - score), 2));
		planetStrengthMap.put(Planet.SAT, MathUtil.round((60.00 - score), 2));
		planetStrengthMap.put(Planet.MAR, MathUtil.round((60.00 - score), 2));

		Planet planet = birthChartUtil.closestPlanetOtherThanRahuKetu(
				Planet.MER, birthChartCalcPrep);
		if (planetUtil.getPlanetDetails(planet).getNature()
				.equals(PlanetNature.Benefic)) {
			planetStrengthMap.put(Planet.MER, score);
		} else {
			planetStrengthMap.put(Planet.MER,
					MathUtil.round((60.00 - score), 2));
		}
		return planetStrengthMap;
	}

	private Map<Planet, Double> calcTribhagBala(
			PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date sunriseDate = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getSunriseSunsetData().getSunriseTime());

		System.out.println("sunriseDate = " + sunriseDate);

		Date sunsetDate = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getSunriseSunsetData().getSunsetTime());

		System.out.println("sunsetDate = " + sunsetDate);

		int dayDuration = DateUtil.minsBetween(sunriseDate, sunsetDate);
		System.out.println("dayDuration = " + dayDuration);

		int nightDuration = 24 * 60 - dayDuration;
		System.out.println("nightDuration = " + nightDuration);

		int dayPart = (int) MathUtil.round(dayDuration / 3, 2);
		int nightPart = (int) MathUtil.round(nightDuration / 3, 2);

		System.out.println("dayPart = " + dayPart);
		System.out.println("nightPart = " + nightPart);

		Map<DayPortion, Planet> tripbhagBalaMatrix = new HashMap<DayPortion, Planet>();

		tripbhagBalaMatrix.put(
				new DayPortion(sunriseDate, DateUtil.getDateByMins(sunriseDate,
						dayPart)), Planet.MER);
		tripbhagBalaMatrix.put(
				new DayPortion(DateUtil.getDateByMins(sunriseDate, dayPart),
						DateUtil.getDateByMins(sunriseDate, dayPart * 2)),
				Planet.SUN);
		tripbhagBalaMatrix.put(
				new DayPortion(
						DateUtil.getDateByMins(sunriseDate, dayPart * 2),
						DateUtil.getDateByMins(sunriseDate, dayPart * 3)),
				Planet.SAT);

		tripbhagBalaMatrix.put(
				new DayPortion(DateUtil.getDateByDays(sunsetDate, -1), DateUtil
						.getDateByDays(
								DateUtil.getDateByMins(sunsetDate, nightPart),
								-1)), Planet.MON);
		tripbhagBalaMatrix.put(
				new DayPortion(DateUtil.getDateByDays(
						DateUtil.getDateByMins(sunsetDate, nightPart), -1),
						DateUtil.getDateByDays(DateUtil.getDateByMins(
								sunsetDate, 2 * nightPart), -1)), Planet.VEN);
		tripbhagBalaMatrix.put(
				new DayPortion(DateUtil.getDateByDays(
						DateUtil.getDateByMins(sunsetDate, 2 * nightPart), -1),
						DateUtil.getDateByDays(DateUtil.getDateByMins(
								sunsetDate, 3 * nightPart), -1)), Planet.MAR);

		System.out.println("tripbhagBalaMatrix = " + tripbhagBalaMatrix);

		Date dob = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getTob());
		System.out.println("dob = " + dob);

		Planet matchingPlanet = null;

		Set<Map.Entry<DayPortion, Planet>> tripbhagBalaMatrixEntries = tripbhagBalaMatrix
				.entrySet();

		for (Map.Entry<DayPortion, Planet> tripbhagBalaMatrixEntry : tripbhagBalaMatrixEntries) {
			DayPortion dayPortion = tripbhagBalaMatrixEntry.getKey();

			if (dob.after(dayPortion.getStartPortion())
					&& dob.before(dayPortion.getEndPortion())) {
				matchingPlanet = tripbhagBalaMatrixEntry.getValue();
				break;
			}
		}

		planetStrengthMap.put(matchingPlanet, 60.00);
		planetStrengthMap.put(Planet.JUP, 60.00);

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcMasaBala(PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date dob = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getTob());
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dob.getTime());

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDayOfMonth = calendar.getTime();

		DateFormat sdf = new SimpleDateFormat("EEEEEEEE");
		Weekday weekday = Weekday.valueOf(sdf.format(firstDayOfMonth));
		System.out.println("Lord of first Day of Month: " + weekday.getOwner());

		planetStrengthMap.put(weekday.getOwner(), 60.00);

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcAbdaBala(PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date dob = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getTob());
		Date start = DateUtil.toDate(AHARGANA_START_DATE, "MM/dd/yyyy");

		int daysElapsed = DateUtil.daysBetween(start, dob)
				+ AHARGANA_CORRECTION_DAYS;
		int numberOfYears = daysElapsed / 360;
		int remainder = (numberOfYears * 3 + 1) % 7;

		Planet ownerPlanet = Weekday.getOwner(remainder);
		planetStrengthMap.put(ownerPlanet, 60.00);

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcVaraBala(PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date dob = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getTob());
		Date start = DateUtil.toDate(AHARGANA_START_DATE, "MM/dd/yyyy");

		Date sunriseDate = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getSunriseSunsetData().getSunriseTime());

		if (dob.before(sunriseDate)) {
			dob = DateUtil.getDateByDays(dob, -1);
		}

		int daysElapsed = DateUtil.daysBetween(start, dob)
				+ AHARGANA_CORRECTION_DAYS;
		int remainder = daysElapsed % 7;

		Planet ownerPlanet = Weekday.getOwner(remainder);
		planetStrengthMap.put(ownerPlanet, 60.00);

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcHoraBala(PersonalBirthInfo personalBirthInfo) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		Date dob = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getTob());

		Date sunriseDate = DateUtil.convertDate(personalBirthInfo.getDob(),
				personalBirthInfo.getSunriseSunsetData().getSunriseTime());

		Date dobAdjusted = dob;

		if (dob.before(sunriseDate)) {
			dobAdjusted = DateUtil.getDateByDays(dob, -1);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dobAdjusted.getTime());

		calendar.set(Calendar.DAY_OF_MONTH, dobAdjusted.getDate());
		Date dayOfMonth = calendar.getTime();

		DateFormat sdf = new SimpleDateFormat("EEEEEEEE");
		Weekday weekday = Weekday.valueOf(sdf.format(dayOfMonth));
		System.out.println("weekday = " + weekday);
		Planet firstHoraPlanet = weekday.getOwner();

		if (dob.before(sunriseDate)) {
			dob = DateUtil.getDateByDays(dob, 1);
		}

		System.out.println("dob = " + dob);

		int minsBetween = DateUtil.minsBetween(dob, sunriseDate);
		System.out.println("minsBetween = " + minsBetween);
		int currentHora = minsBetween / 60 + 1;

		System.out.println("currentHora = " + currentHora);

		// Planet ownerPlanet = Weekday.getOwner(remainder);
		// planetStrengthMap.put(ownerPlanet, 60.00);

		Planet horaPlanet = findCurrentHoraPlanet(firstHoraPlanet, currentHora);
		System.out.println("horaPlanet = " + horaPlanet);

		planetStrengthMap.put(horaPlanet, 60.0);

		return planetStrengthMap;
	}

	private Planet findCurrentHoraPlanet(Planet startingPlanet, int currentHora) {

		List<Planet> horaPlanets = new ArrayList<Planet>();
		List<Planet> startingHoraPlanets = new ArrayList<Planet>();

		for (Planet horaPlanet : Planet.values()) {
			if (horaPlanet.getHoraWeight() > 0) {
				horaPlanets.add(horaPlanet);
			}
		}

		Collections.sort(horaPlanets, new Comparator<Planet>() {
			@Override
			public int compare(Planet p1, Planet p2) {
				return p2.getHoraWeight().compareTo(p1.getHoraWeight());
			}
		});

		System.out.println("horaPlanets =" + horaPlanets);

		startingHoraPlanets = horaPlanets.subList(
				horaPlanets.indexOf(startingPlanet), horaPlanets.size());
		startingHoraPlanets.addAll(horaPlanets.subList(0,
				horaPlanets.indexOf(startingPlanet)));

		System.out.println("horaPlanets =" + horaPlanets);

		System.out.println("startingHoraPlanets =" + startingHoraPlanets);

		int remainder = currentHora % 7;

		return startingHoraPlanets.get(remainder - 1);
	}

	private Map<Planet, Double> calcAyanaBala(
			BirthChartCalcPrep birthChartCalcPrep) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();
		Map<Planet, Double> actualLongitudeMap = birthChartUtil
				.getActualLongitudeMap(birthChartCalcPrep);

		List<Planet> group1 = new ArrayList<Planet>(4);
		group1.add(Planet.SUN);
		group1.add(Planet.VEN);
		group1.add(Planet.MAR);
		group1.add(Planet.JUP);

		List<Planet> group2 = new ArrayList<Planet>(2);
		group2.add(Planet.SAT);
		group2.add(Planet.MON);

		for (Planet planet : planetUtil.getPlanetsForConsideration(false)) {

			Double actualLongitude = actualLongitudeMap.get(planet);
			Double sayanaLongitude = actualLongitude + 23.60;

			boolean isSouth = false;

			if (sayanaLongitude > 90 && sayanaLongitude <= 180) {
				sayanaLongitude = 180 - sayanaLongitude;
			} else if (sayanaLongitude > 180 && sayanaLongitude <= 270) {
				sayanaLongitude = sayanaLongitude - 180;
				isSouth = true;
			} else if (sayanaLongitude > 270 && sayanaLongitude <= 360) {
				sayanaLongitude = 360 - sayanaLongitude;
				isSouth = true;
			}

			sayanaLongitude = MathUtil.round(sayanaLongitude, 2);

			System.out.println("planet = " + planet);
			System.out.println("sayanaLongitude = " + sayanaLongitude);

			System.out.println("declination = "
					+ planetUtil.calcDeclination(sayanaLongitude));
			Double declination = planetUtil.calcDeclination(sayanaLongitude);

			Double aryaBala = null;

			if (group1.contains(planet)) {
				if (isSouth) {
					aryaBala = 24 - declination;
				} else {
					aryaBala = 24 + declination;
				}

				if (planet.equals(Planet.SUN)) {
					aryaBala = aryaBala * 2;
				}
			} else if (group2.contains(planet)) {
				if (isSouth) {
					aryaBala = 24 + declination;
				} else {
					aryaBala = 24 - declination;
				}
			} else {
				aryaBala = 24 + declination;
			}

			planetStrengthMap.put(planet, MathUtil.round(aryaBala * 1.25, 2));
		}

		return planetStrengthMap;
	}

	private Map<Planet, Double> calcYuddhaBala(
			BirthChartCalcPrep birthChartCalcPrep, 
			Map<Planet, Double> positionalScores, 
			Map<Planet, Double> directionalScores,
			Map<Planet, Double> nathonnathBalaMap,
			Map<Planet, Double> calcPakshaBala,
			Map<Planet, Double> calcTribhagBala,
			Map<Planet, Double> calcHoraBala) {

		Map<Planet, Double> planetStrengthMap = new HashMap<Planet, Double>();

		List<Planet> planetGroup = new ArrayList<Planet>(5);
		planetGroup.add(Planet.SAT);
		planetGroup.add(Planet.VEN);
		planetGroup.add(Planet.MAR);
		planetGroup.add(Planet.JUP);
		planetGroup.add(Planet.MER);

		Set<Set<Planet>> planetCombinations = new HashSet<Set<Planet>>();
		Map<Set<Planet>, Double> degreeDiffMap = birthChartUtil
				.getPlanetDegreeDifferenceMap(planetGroup, birthChartCalcPrep);
		
		Set<Map.Entry<Set<Planet>,Double>> mapEntriesSet = degreeDiffMap.entrySet();
	
		for(Map.Entry<Set<Planet>,Double> mapEntry : mapEntriesSet){
	         if(mapEntry.getValue()<1.0){
	        	 planetCombinations.add(mapEntry.getKey());
	         }
	     }
		
		for(Set<Planet> planetCombination : planetCombinations){
			
			adjustScore(birthChartCalcPrep, planetCombination, planetStrengthMap, positionalScores, directionalScores, nathonnathBalaMap,calcPakshaBala, calcTribhagBala, calcHoraBala);
		}

		return planetStrengthMap;
	}
	
	public Map<Planet, Double> adjustScore(BirthChartCalcPrep birthChartCalcPrep,Set<Planet> planetSet, Map<Planet, Double> planetStrengthMap, Map<Planet, Double> positionalStrengthMap, 
			Map<Planet, Double> directionalStrengthMap, Map<Planet, Double> nathonnathBalaMap,
			Map<Planet, Double> calcPakshaBala,
			Map<Planet, Double> calcTribhagBala,
			Map<Planet, Double> calcHoraBala){
		
		Planet[] planet = (Planet[]) planetSet.toArray();
		
		Double totalPlanet1Score = positionalStrengthMap.get(planet[0]) + directionalStrengthMap.get(planet[0])+ nathonnathBalaMap.get(planet[0]) + calcPakshaBala.get(planet[0]) +
				calcTribhagBala.get(planet[0]) + calcHoraBala.get(planet[0]);
		
		Double totalPlanet2Score = positionalStrengthMap.get(planet[1]) + directionalStrengthMap.get(planet[1])+ nathonnathBalaMap.get(planet[1]) + calcPakshaBala.get(planet[1]) +
				calcTribhagBala.get(planet[1]) + calcHoraBala.get(planet[1]);
		
		Double degreeDiff = Math.abs(totalPlanet1Score - totalPlanet2Score);
		Double diameterDiff = Math.abs(planetUtil.getPlanetDetails(planet[0]).getDiscDiameter() - planetUtil.getPlanetDetails(planet[1]).getDiscDiameter());
		
		Double yuddhaBala = MathUtil.round(degreeDiff/diameterDiff, 2);

		Double planet1OldValue = 0.0;
		Double planet2OldValue = 0.0;
		
		if(planetStrengthMap.containsKey(planet[0])){
			planet1OldValue = planetStrengthMap.get(planet[0]);
		}
		
		if(planetStrengthMap.containsKey(planet[1])){
			planet2OldValue = planetStrengthMap.get(planet[1]);
		}

		if(birthChartCalcPrep.getAbsoluteDegrees(planet[0])<
		birthChartCalcPrep.getAbsoluteDegrees(planet[1])){
			
			planetStrengthMap.put(planet[0], yuddhaBala + planet1OldValue);
			planetStrengthMap.put(planet[1], -1*yuddhaBala + planet2OldValue);
		}
		else{
			planetStrengthMap.put(planet[1], yuddhaBala  + planet1OldValue);
			planetStrengthMap.put(planet[0], -1*yuddhaBala + planet2OldValue);
		}
		return planetStrengthMap;
	}
}