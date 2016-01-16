package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.DashaCombination;
import com.vedic.astro.domain.DashaData;
import com.vedic.astro.domain.DashaPeriodSnapshot;
import com.vedic.astro.domain.DashaPlanetHouseRelationship;
import com.vedic.astro.domain.DashaPlanetPlanetRelationship;
import com.vedic.astro.domain.DashaPlanetRelationship;
import com.vedic.astro.domain.DashaTimePeriod;
import com.vedic.astro.domain.ZodiacDegreeRange;
import com.vedic.astro.enums.Dasha;
import com.vedic.astro.enums.DashaSystem;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HousePlanetRelationshipType;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetPlanetRelationshipType;
import com.vedic.astro.enums.Signification;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("vimshotriDashaUtil")
public class VimshotriDashaUtil {

	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	private static final int DAYS_IN_YEAR = 365;
	private static final int TOTAL_DASHA_YEARS = 120;

	// public Dasha getCurrentDashaPeriod(Date dob, DashaPeriod dashaAt) {

	public Dasha getNextDasha(Dasha dasha) {

		int index = dasha.ordinal() + 1;

		if (index >= 9) {
			index = index - 9;
		}
		return Dasha.values()[index];
	}

	public List<Dasha> getAllDashasAfter(Dasha dasha) {

		List<Dasha> dashas = new ArrayList<Dasha>();

		int totalYears = dasha.getYears();

		while (totalYears < 80) {
			Dasha nextDasha = getNextDasha(dasha);
			dasha = nextDasha;
			totalYears = totalYears + nextDasha.getYears();
			dashas.add(nextDasha);
		}
		return dashas;

	}

	public List<Dasha> getAllAntarDashas(Dasha dasha) {

		List<Dasha> dashas = new ArrayList<Dasha>();
		dashas.add(dasha);
		int totalYears = dasha.getYears();

		while (totalYears < 120) {
			Dasha nextDasha = getNextDasha(dasha);
			dasha = nextDasha;
			totalYears = totalYears + nextDasha.getYears();
			dashas.add(nextDasha);
		}
		return dashas;

	}

	public int daysInAntardasha(Dasha mahadasha, Dasha antardasha) {

		int daysInMahadasha = mahadasha.getYears() * DAYS_IN_YEAR;
		return Math.round(antardasha.getProportion() * daysInMahadasha);
	}

	public Map<Dasha, DashaTimePeriod> getAllAntarDashasPeriods(Dasha dasha,
			Date date) {
		Map<Dasha, DashaTimePeriod> dashaMap = new HashMap<Dasha, DashaTimePeriod>();

		List<Dasha> antarDashaList = getAllAntarDashas(dasha);
		Date calcDate = date;
		for (Dasha antardasha : antarDashaList) {

			DashaTimePeriod period = new DashaTimePeriod();
			period.setStartDate(calcDate);
			Date endDate = DateUtil.getDateByDays(calcDate,
					this.daysInAntardasha(dasha, antardasha));
			period.setEndDate(endDate);

			dashaMap.put(antardasha, period);
			calcDate = DateUtil.getDateByDays(endDate, 1);
		}

		return dashaMap;
	}

	public Map<Dasha, DashaTimePeriod> divideIntoDashasPeriods(Dasha dasha,
			Date fromDate, Date toDate) {
		Map<Dasha, DashaTimePeriod> dashaMap = new HashMap<Dasha, DashaTimePeriod>();

		List<Dasha> antarDashaList = getAllAntarDashas(dasha);
		Date calcDate = fromDate;

		int totalDays = DateUtil.daysBetween(fromDate, toDate);

		for (Dasha antardasha : antarDashaList) {

			DashaTimePeriod period = new DashaTimePeriod();
			period.setStartDate(calcDate);
			Date endDate = DateUtil.getDateByDays(calcDate,
					Math.round(totalDays * antardasha.getProportion()));
			period.setEndDate(endDate);

			dashaMap.put(antardasha, period);
			calcDate = DateUtil.getDateByDays(endDate, 1);
		}

		return dashaMap;
	}

	public Map<DashaTimePeriod, Dasha> dividePeriodIntoDashas(Dasha dasha,
			Date fromDate, Date toDate) {
		Map<DashaTimePeriod, Dasha> dashaMap = new HashMap<DashaTimePeriod, Dasha>();

		List<Dasha> antarDashaList = getAllAntarDashas(dasha);

		// System.out.println("dasha =" + dasha + "antardashas = " +
		// antarDashaList);

		Date calcDate = fromDate;

		int totalDays = DateUtil.daysBetween(fromDate, toDate);

		for (Dasha antardasha : antarDashaList) {

			DashaTimePeriod period = new DashaTimePeriod();
			period.setStartDate(calcDate);
			Date endDate = DateUtil.getDateByDays(calcDate,
					Math.round(totalDays * antardasha.getProportion()));

			System.out.println("endDate ="
					+ DateUtil.fromDate(endDate, "MM/dd/yyyy"));

			period.setEndDate(endDate);

			dashaMap.put(period, antardasha);
			calcDate = DateUtil.getDateByDays(endDate, 1);

		}

		return dashaMap;
	}

	public int daysToCompleteDasha(Zodiac zodiac, Nakshatra nakshatra,
			Double degs) {

		Map<ZodiacDegreeRange, Nakshatra> nakMap = BaseEntityRefData
				.createNakshatraRefData().get(zodiac);

		Double maxDegrees = null;
		for (Map.Entry<ZodiacDegreeRange, Nakshatra> entry : nakMap.entrySet()) {

			if (entry.getValue().equals(nakshatra)) {
				maxDegrees = entry.getKey().getEndDeg();
				break;
			}
		}

		// System.out.println("maxDegrees =" + maxDegrees);

		Integer maxDegreesInMinutes = MathUtil.calcDegreesInMinutes(maxDegrees);
		// System.out.println("maxDegreesInMinutes =" + maxDegreesInMinutes);

		Integer currentDegreesInMinutes = MathUtil.calcDegreesInMinutes(degs);
		// System.out.println("currentDegreesInMinutes =" +
		// currentDegreesInMinutes);

		Integer diff = maxDegreesInMinutes - currentDegreesInMinutes;

		// System.out.println("diff =" + diff);

		Planet lordPlanet = nakshatraUtil.getNakshatraLord(nakshatra);
		Dasha dasha = this.getDasha(lordPlanet);

		// System.out.println("dasha =" + dasha);
		// System.out.println("dasha yrs =" + dasha.getYears());

		float daysInFloat = dasha.getYears() * DAYS_IN_YEAR
				* ((float) diff / 800);

		return Math.round(daysInFloat);
	}

	public Date calcLastDateForCompletionOfFirstDasha(Zodiac zodiac,
			Nakshatra nakshatra, Double degs, Date dob) {

		return DateUtil.getDateByDays(dob,
				daysToCompleteDasha(zodiac, nakshatra, degs));
	}

	public DashaData generateDashaData(Zodiac zodiac, Nakshatra nakshatra,
			Double degs, Date dob, String pid) {

		DashaData dashaData = new DashaData();

		Date lastDate = calcLastDateForCompletionOfFirstDasha(zodiac,
				nakshatra, degs, dob);
		// System.out.println("lastDate = " + lastDate);

		Planet lordPlanet = nakshatraUtil.getNakshatraLord(nakshatra);
		Dasha dasha = this.getDasha(lordPlanet);

		List<Dasha> dashasAfter = getAllDashasAfter(dasha);

		// System.out.println("dashasAfter = " + dashasAfter);

		Date fromDate = lastDate;
		Long sequence = 0L;
		for (Dasha dashaAfter : dashasAfter) {

			int daysOfDasha = dashaAfter.getYears() * DAYS_IN_YEAR;
			Date toDate = DateUtil.getDateByDays(fromDate, daysOfDasha);

			Map<DashaTimePeriod, Dasha> level2Dasha = this
					.dividePeriodIntoDashas(dashaAfter, fromDate, toDate);

			// System.out.println("antarDasha = " + level2Dasha);

			fromDate = DateUtil.getDateByDays(toDate, 1);

			for (Map.Entry<DashaTimePeriod, Dasha> level2DashaEntry : level2Dasha
					.entrySet()) {

				Map<DashaTimePeriod, Dasha> level3Dasha = this
						.dividePeriodIntoDashas(level2DashaEntry.getValue(),
								level2DashaEntry.getKey().getStartDate(),
								level2DashaEntry.getKey().getEndDate());
				for (Map.Entry<DashaTimePeriod, Dasha> level3DashaEntry : level3Dasha
						.entrySet()) {

					Map<DashaTimePeriod, Dasha> level4Dasha = this
							.dividePeriodIntoDashas(
									level3DashaEntry.getValue(),
									level3DashaEntry.getKey().getStartDate(),
									level3DashaEntry.getKey().getEndDate());

					for (Map.Entry<DashaTimePeriod, Dasha> level4DashaEntry : level4Dasha
							.entrySet()) {
						sequence++;
						dashaData.add(new DashaPeriodSnapshot(pid, sequence,
								DashaSystem.Vimshottri, level4DashaEntry
										.getKey(), new DashaCombination(
										dashaAfter,
										level2DashaEntry.getValue(),
										level3DashaEntry.getValue(),
										level4DashaEntry.getValue())));
					}
				}
			}
		}

		return dashaData;
	}

	public DashaCombination getDashaCombination(Zodiac zodiac,
			Nakshatra nakshatra, Double degs, Date dob, Date eventDate) {
		DashaData dashaData = generateDashaData(zodiac, nakshatra, degs, dob,
				null);

		DashaCombination combination = null;
		for (DashaPeriodSnapshot dashaPeriodSnapshot : dashaData.getData()) {

			Date startDate = dashaPeriodSnapshot.getDashaPeriod()
					.getStartDate();
			Date endDate = dashaPeriodSnapshot.getDashaPeriod().getEndDate();

			if (eventDate.after(startDate)
					&& (eventDate.before(endDate))
					|| (eventDate.equals(startDate) || (eventDate
							.equals(endDate)))) {
				combination = dashaPeriodSnapshot.getDashaCombination();
				break;
			}

		}

		return combination;
	}

	public Planet getPlanet(Dasha dasha) {
		return BaseEntityRefData.createDashaToPlanetMap().get(dasha);
	}

	public Dasha getDasha(Planet planet) {
		return BaseEntityRefData.createPlanetToDashaMap().get(planet);
	}

	/*
	 * public DashaImpactedHouses predictChartInDasha(BirthChartCalcPrep
	 * prepData, Set<Planet> planetsFilter) {
	 * 
	 * // System.out.println("prepData =" + prepData);
	 * 
	 * Map<Planet, Collection<House>> housesImpactedAsOwnerMap = new
	 * HashMap<Planet, Collection<House>>(); Map<Planet, Collection<House>>
	 * housesImpactedAsInhabitantMap = new HashMap<Planet, Collection<House>>();
	 * Map<Planet, Collection<House>> housesImpactedAsAspectMap = new
	 * HashMap<Planet, Collection<House>>(); Map<Planet, Collection<House>>
	 * housesImpactedAsKarakaMap = new HashMap<Planet, Collection<House>>();
	 * 
	 * for (Planet planet : planetsFilter) {
	 * 
	 * Collection<House> housesImpactedAsOwner = new ArrayList<House>();
	 * Collection<House> housesImpactedAsInhabitant = new ArrayList<House>();
	 * Collection<House> housesImpactedAsAspect = new ArrayList<House>();
	 * Collection<House> housesImpactedAsKaraka = new ArrayList<House>();
	 * 
	 * housesImpactedAsInhabitant.add(prepData.getPlanetHouseMapping()
	 * .get(planet)); housesImpactedAsInhabitantMap.put(planet,
	 * housesImpactedAsInhabitant); if
	 * (prepData.getPlanetOwnedHouse().get(planet) != null) {
	 * housesImpactedAsOwner.addAll(prepData.getPlanetOwnedHouse()
	 * .get(planet)); housesImpactedAsOwnerMap.put(planet,
	 * housesImpactedAsOwner); } housesImpactedAsAspect.addAll(prepData
	 * .getAspectPlanetHousesMapping().get(planet));
	 * housesImpactedAsAspectMap.put(planet, housesImpactedAsAspect);
	 * PlanetDetails planetDetails = planetUtil.getPlanetDetails(planet);
	 * 
	 * if (planetDetails.getKarakaOf() != null) {
	 * housesImpactedAsKaraka.addAll(planetDetails.getKarakaOf());
	 * housesImpactedAsKarakaMap.put(planet, housesImpactedAsKaraka); } }
	 * 
	 * DashaImpactedHouses dashaImpactedHouses = new DashaImpactedHouses(
	 * housesImpactedAsOwnerMap, housesImpactedAsInhabitantMap,
	 * housesImpactedAsAspectMap, housesImpactedAsKarakaMap);
	 * 
	 * return dashaImpactedHouses; }
	 * 
	 * public Map<House, DashaHouseImpact> getMostImpactedHouses(
	 * BirthChartCalcPrep prepData, Map<Planet, Integer> planetImpactMap) {
	 * 
	 * DashaImpactedHouses dashaImpactedHouses = this.predictChartInDasha(
	 * prepData, planetImpactMap.keySet());
	 * 
	 * Set<House> allHousesImpactedSet = new HashSet<House>();
	 * 
	 * for (Map.Entry<Planet, Collection<House>> karakaMapEntry :
	 * dashaImpactedHouses .getHousesImpactedAsKaraka().entrySet()) {
	 * allHousesImpactedSet.addAll(karakaMapEntry.getValue()); }
	 * 
	 * for (Map.Entry<Planet, Collection<House>> ownerMapEntry :
	 * dashaImpactedHouses .getHousesImpactedAsOwner().entrySet()) {
	 * allHousesImpactedSet.addAll(ownerMapEntry.getValue()); }
	 * 
	 * for (Map.Entry<Planet, Collection<House>> inhabitantMapEntry :
	 * dashaImpactedHouses .getHousesImpactedAsInhabitant().entrySet()) {
	 * allHousesImpactedSet.addAll(inhabitantMapEntry.getValue()); }
	 * 
	 * for (Map.Entry<Planet, Collection<House>> aspectMapEntry :
	 * dashaImpactedHouses .getHousesImpactedAsAspect().entrySet()) {
	 * allHousesImpactedSet.addAll(aspectMapEntry.getValue()); }
	 * 
	 * Map<House, DashaHouseImpact> housesImpacted = new HashMap<House,
	 * DashaHouseImpact>();
	 * 
	 * for (House house : allHousesImpactedSet) {
	 * 
	 * DashaPlanetImpact karakaImpact = new DashaPlanetImpact();
	 * DashaPlanetImpact inhabitantsImpact = new DashaPlanetImpact();
	 * DashaPlanetImpact ownerImpact = new DashaPlanetImpact();
	 * DashaPlanetImpact aspectImpact = new DashaPlanetImpact();
	 * 
	 * List<Planet> karakaPlanets = prepData.getHousePlanetKarakasMap()
	 * .get(house);
	 * 
	 * for (Planet karakaPlanet : karakaPlanets) { if
	 * (planetImpactMap.containsKey(karakaPlanet)) {
	 * karakaImpact.addPlanetCount(karakaPlanet,
	 * planetImpactMap.get(karakaPlanet)); } }
	 * 
	 * Planet ownerPlanet = prepData.getHouseOwnerMapping().get(house);
	 * 
	 * if (planetImpactMap.containsKey(ownerPlanet)) {
	 * ownerImpact.addPlanetCount(ownerPlanet,
	 * planetImpactMap.get(ownerPlanet)); }
	 * 
	 * Set<Planet> inhabitantPlanets = prepData
	 * .getHouseInhabitantsMapping().get(house);
	 * 
	 * for (Planet inhabitantPlanet : inhabitantPlanets) { if
	 * (planetImpactMap.containsKey(inhabitantPlanet)) {
	 * inhabitantsImpact.addPlanetCount(inhabitantPlanet,
	 * planetImpactMap.get(inhabitantPlanet)); } }
	 * 
	 * List<Planet> aspectPlanets = prepData.getHouseAspectsMapping().get(
	 * house);
	 * 
	 * if (aspectPlanets != null) {
	 * 
	 * for (Planet aspectPlanet : aspectPlanets) { if
	 * (planetImpactMap.containsKey(aspectPlanet)) {
	 * aspectImpact.addPlanetCount(aspectPlanet,
	 * planetImpactMap.get(aspectPlanet)); } } }
	 * 
	 * DashaHouseImpact dashaHouseImpact = new DashaHouseImpact( karakaImpact,
	 * inhabitantsImpact, ownerImpact, aspectImpact);
	 * 
	 * if (dashaHouseImpact.isImpacted()) {
	 * dashaHouseImpact.setTotalScore(this.evaluateDashaHouseScore
	 * (dashaHouseImpact)); housesImpacted.put(house, dashaHouseImpact); } }
	 * 
	 * return housesImpacted; }
	 */
	public List<Signification> getSignifications(Planet planet, House house) {
		return BaseEntityRelationshipRefData.getPlanetSignificationsMap()
				.get(planet).get(house);
	}

	public DashaPlanetRelationship getDashaPlanetRelationships(
			Planet dashaPlanet, BirthChartCalcPrep birthChartCalcPrep) {
		DashaPlanetRelationship dashaPlanetRelationship = new DashaPlanetRelationship();
		dashaPlanetRelationship.setDashaPlanet(dashaPlanet);

		Map<Planet, List<DashaPlanetHouseRelationship>> relationships = new HashMap<Planet, List<DashaPlanetHouseRelationship>>();
		List<DashaPlanetPlanetRelationship> relatedPlanets = new ArrayList<DashaPlanetPlanetRelationship>();

		List<Planet> otherInhabitants = birthChartCalcPrep
				.getInhabitantsOtherThan(birthChartCalcPrep
						.getPlanetHouseMapping().get(dashaPlanet), dashaPlanet);

		if (otherInhabitants != null) {
			for (Planet otherInhabitant : otherInhabitants) {
				relatedPlanets.add(new DashaPlanetPlanetRelationship(
						otherInhabitant,
						PlanetPlanetRelationshipType.CoInhabitant));
			}
		}

		List<House> ownedHouses = birthChartCalcPrep.getPlanetOwnedHouse().get(
				dashaPlanet);
		if (ownedHouses != null) {
			for (House ownedHouse : ownedHouses) {
				Set<Planet> inhabitantsInOwnedHouse = birthChartCalcPrep
						.getHouseInhabitantsMapping().get(ownedHouse);
				if (inhabitantsInOwnedHouse != null) {
					for (Planet inhabitantInOwnedHouse : inhabitantsInOwnedHouse) {
						relatedPlanets
								.add(new DashaPlanetPlanetRelationship(
										inhabitantInOwnedHouse,
										PlanetPlanetRelationshipType.InhabitantOfOwnedHouse));
					}
				}
			}
		}

/*		Nakshatra nakshatra = birthChartCalcPrep.getPlanetNakshatrasMapping()
				.get(dashaPlanet);

		if (nakshatra != null) {
			relatedPlanets.add(new DashaPlanetPlanetRelationship(nakshatraUtil
					.getNakshatraLord(nakshatra),
					PlanetPlanetRelationshipType.LordOfNakshatra));
		}
*/		
		List<House> aspectedHouses = birthChartCalcPrep
				.getAspectPlanetHousesMapping().get(dashaPlanet);

		if (aspectedHouses != null) {
			for (House aspectedHouse : aspectedHouses) {
				Set<Planet> inhabitantsInAspectedHouse = birthChartCalcPrep
						.getHouseInhabitantsMapping().get(aspectedHouse);
				if (inhabitantsInAspectedHouse != null) {
					for (Planet inhabitantInAspectedHouse : inhabitantsInAspectedHouse) {
						relatedPlanets
								.add(new DashaPlanetPlanetRelationship(
										inhabitantInAspectedHouse,
										PlanetPlanetRelationshipType.InhabitantOfAspectedHouse));
					}
				}
			}
		}

		House house = birthChartCalcPrep.getPlanetHouseMapping().get(
				dashaPlanet);
		Planet ownerPlanet = birthChartCalcPrep.getHouseOwnerMapping().get(
				house);
		relatedPlanets.add(new DashaPlanetPlanetRelationship(ownerPlanet,
				PlanetPlanetRelationshipType.LordOfHouse));

		Set<Planet> allPlanetSet = new HashSet<Planet>();
		for (DashaPlanetPlanetRelationship dashaPlanetPlanetRelationship : relatedPlanets) {
			allPlanetSet.add(dashaPlanetPlanetRelationship.getPlanet());
		}
		allPlanetSet.add(dashaPlanet);

		for (Planet planet : allPlanetSet) {
			relationships.put(planet,
					getPlanetHouseRelationships(planet, birthChartCalcPrep));
		}

		dashaPlanetRelationship.setRelatedPlanets(relatedPlanets);
		dashaPlanetRelationship.setRelationships(relationships);

		return dashaPlanetRelationship;
	}

	public List<DashaPlanetHouseRelationship> getPlanetHouseRelationships(
			Planet planet, BirthChartCalcPrep birthChartCalcPrep) {

		List<DashaPlanetHouseRelationship> houseRelationships = new ArrayList<DashaPlanetHouseRelationship>();

		DashaPlanetHouseRelationship planetAsInhabitant = new DashaPlanetHouseRelationship();

		planetAsInhabitant.setHouse(birthChartCalcPrep.getPlanetHouseMapping()
				.get(planet));
		planetAsInhabitant.setPlanet(planet);
		planetAsInhabitant
				.setHousePlanetRelationship(HousePlanetRelationshipType.Inhabitant);

		houseRelationships.add(planetAsInhabitant);

		List<House> ownedHouses = birthChartCalcPrep.getPlanetOwnedHouse().get(
				planet);

		if (ownedHouses != null) {
			for (House ownedHouse : ownedHouses) {
				DashaPlanetHouseRelationship planetAsLord = new DashaPlanetHouseRelationship();
				planetAsLord.setHouse(ownedHouse);
				planetAsLord.setPlanet(planet);
				planetAsLord
						.setHousePlanetRelationship(HousePlanetRelationshipType.Owner);
				houseRelationships.add(planetAsLord);
			}
		}

		List<House> aspectedHouses = birthChartCalcPrep
				.getAspectPlanetHousesMapping().get(planet);

		for (House aspectedHouse : aspectedHouses) {
			DashaPlanetHouseRelationship planetAsAspectingHouse = new DashaPlanetHouseRelationship();
			planetAsAspectingHouse.setHouse(aspectedHouse);
			planetAsAspectingHouse.setPlanet(planet);
			planetAsAspectingHouse
					.setHousePlanetRelationship(HousePlanetRelationshipType.Aspect);
			houseRelationships.add(planetAsAspectingHouse);
		}

		House nakshatraLordHouse = birthChartCalcPrep
				.getNakshatraLordHouseMapping().get(planet);

		if (nakshatraLordHouse != null) {

			DashaPlanetHouseRelationship planetAsNakshatraLord = new DashaPlanetHouseRelationship();
			planetAsNakshatraLord.setHouse(nakshatraLordHouse);
			planetAsNakshatraLord.setPlanet(planet);
			planetAsNakshatraLord
					.setHousePlanetRelationship(HousePlanetRelationshipType.LordOfNakshatra);
			houseRelationships.add(planetAsNakshatraLord);
		}

		List<House> karakaOfHouses = planetUtil.getPlanetDetails(planet)
				.getKarakaOf();

		if (karakaOfHouses != null) {

			for (House karakaOfHouse : karakaOfHouses) {
				DashaPlanetHouseRelationship planetAsKaraka = new DashaPlanetHouseRelationship();
				planetAsKaraka.setHouse(karakaOfHouse);
				planetAsKaraka.setPlanet(planet);
				planetAsKaraka
						.setHousePlanetRelationship(HousePlanetRelationshipType.Karaka);
				houseRelationships.add(planetAsKaraka);
			}
		}

		return houseRelationships;
	}

	public Map<Planet, Map<House,List<Signification>>> predictDasha(Planet dashaPlanet,
			BirthChartCalcPrep birthChartCalcPrep) {
		DashaPlanetRelationship dashaPlanetRelationship = getDashaPlanetRelationships(
				dashaPlanet, birthChartCalcPrep);
		System.out.println("dashaPlanetRelationship = " + dashaPlanetRelationship);
		Map<Planet, Map<House,List<Signification>>> planetSignifications = new HashMap<Planet, Map<House,List<Signification>>>();
		Map<Planet, List<DashaPlanetHouseRelationship>> relationships = dashaPlanetRelationship
				.getRelationships();
		
		for (Map.Entry<Planet, List<DashaPlanetHouseRelationship>> planetEntry : relationships.entrySet()) {

			List<DashaPlanetHouseRelationship> dashaPlanetHouseRelationships = planetEntry
					.getValue();
			Map<House, List<Signification>> houseSignificationMap = new HashMap<House, List<Signification>>();
			
			for (DashaPlanetHouseRelationship dashaPlanetHouseRelationship : dashaPlanetHouseRelationships) {
				houseSignificationMap.put(dashaPlanetHouseRelationship.getHouse(), new ArrayList<Signification>());
			}
			planetSignifications.put(planetEntry.getKey(), houseSignificationMap);
		}
		
		System.out.println("planetSignifications before = " +  planetSignifications);

		for (Map.Entry<Planet, Map<House, List<Signification>>> mapEntry : planetSignifications.entrySet()) {
		
			Map<House, List<Signification>> dashaPlanetHouseRelationships = mapEntry
					.getValue();
			for (Map.Entry<House, List<Signification>> dashaPlanetHouseRelationship : dashaPlanetHouseRelationships.entrySet()) {
				dashaPlanetHouseRelationship.setValue(this.getSignifications(
						mapEntry.getKey(),
						dashaPlanetHouseRelationship.getKey()));
			}
		}
		System.out.println("planetSignifications after = " +  planetSignifications);
		
		return planetSignifications;
	}

	/*
	 * public Double evaluateDashaHouseScore(DashaHouseImpact dashaHouseScore){
	 * 
	 * return
	 * dashaHouseScore.getInhabitantsImpact().getTotalCount()*inhabitantWeight +
	 * dashaHouseScore.getOwnerImpact().getTotalCount()*ownerWeight +
	 * dashaHouseScore.getAspectImpact().getTotalCount()*aspectWeight +
	 * dashaHouseScore.getKarakaImpact().getTotalCount()*karakaWeight; }
	 */
}
