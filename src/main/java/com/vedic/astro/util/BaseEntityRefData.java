package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vedic.astro.domain.EntityRefData;
import com.vedic.astro.domain.HouseDetails;
import com.vedic.astro.domain.Impact;
import com.vedic.astro.domain.PlanetDetails;
import com.vedic.astro.domain.ZodiacDegreeRange;
import com.vedic.astro.domain.ZodiacDetails;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.Dasha;
import com.vedic.astro.enums.Element;
import com.vedic.astro.enums.EntityType;
import com.vedic.astro.enums.Gender;
import com.vedic.astro.enums.Goal;
import com.vedic.astro.enums.Guna;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetAge;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Relationship;
import com.vedic.astro.enums.Role;
import com.vedic.astro.enums.TravelType;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.enums.ZodiacType;
import com.vedic.astro.vo.ZodiacDegRange;

public class BaseEntityRefData {
	
	public static EntityRefData<PlanetDetails> createPlanetRefData(){
		
		EntityRefData<PlanetDetails> planetData = new EntityRefData<PlanetDetails>();
		Map<String, PlanetDetails> planetRefDataMap = new HashMap<String, PlanetDetails>(9);
		
		PlanetDetails mars = new PlanetDetails();
		mars.setGuna(Guna.TAMSIK);
		mars.setRole(Role.GENERAL);
		mars.setPlanet(Planet.MAR);
		mars.setNature(PlanetNature.Malefic);
		mars.setDebilitationPoint(118.0);
		mars.setMooltrikonSign(Zodiac.ARE);
		mars.setGender(Gender.Male);
		mars.setEpochDegree(270.22);
		mars.setInnerPlanet(false);
		mars.setRetrograde(true);
		mars.setLuminosity(25.71);
		mars.setDiscDiameter(9.4);
		
		Impact marsImpact = new Impact();
		marsImpact.setGross("Strength/Physical Fitness");
		marsImpact.setSublte("Courage, Aggression, Anger, Will power");
		marsImpact.setCausal("Ability to face ups and downs boldly, Learning to be cool minded, Helping the weak");

		mars.setImpact(marsImpact);

		Map<Planet, List<Integer>> marsBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> marsMarsBeneficPoints = new ArrayList<Integer>();
		marsMarsBeneficPoints.add(1);
		marsMarsBeneficPoints.add(2);
		marsMarsBeneficPoints.add(4);
		marsMarsBeneficPoints.add(7);
		marsMarsBeneficPoints.add(8);
		marsMarsBeneficPoints.add(10);
		marsMarsBeneficPoints.add(11);
		
		List<Integer> marsSunBeneficPoints = new ArrayList<Integer>();
		marsSunBeneficPoints.add(3);
		marsSunBeneficPoints.add(5);
		marsSunBeneficPoints.add(6);
		marsSunBeneficPoints.add(10);
		marsSunBeneficPoints.add(11);
		
		List<Integer> marsMoonBeneficPoints = new ArrayList<Integer>();
		marsMoonBeneficPoints.add(3);
		marsMoonBeneficPoints.add(6);
		marsMoonBeneficPoints.add(7);
		
		List<Integer> marsJupiterBeneficPoints = new ArrayList<Integer>();
		marsJupiterBeneficPoints.add(6);
		marsJupiterBeneficPoints.add(10);
		marsJupiterBeneficPoints.add(11);
		marsJupiterBeneficPoints.add(12);
		
		List<Integer> marsSaturnBeneficPoints = new ArrayList<Integer>();
		marsSaturnBeneficPoints.add(1);
		marsSaturnBeneficPoints.add(4);
		marsSaturnBeneficPoints.add(7);
		marsSaturnBeneficPoints.add(8);
		marsSaturnBeneficPoints.add(9);
		marsSaturnBeneficPoints.add(10);
		marsSaturnBeneficPoints.add(11);
				
		List<Integer> marsMercuryBeneficPoints = new ArrayList<Integer>();
		marsMercuryBeneficPoints.add(3);
		marsMercuryBeneficPoints.add(5);
		marsMercuryBeneficPoints.add(6);
		marsMercuryBeneficPoints.add(11);
		
		List<Integer> marsVenusBeneficPoints = new ArrayList<Integer>();
		marsVenusBeneficPoints.add(6);
		marsVenusBeneficPoints.add(8);
		marsVenusBeneficPoints.add(11);
		marsVenusBeneficPoints.add(12);
		
		List<Integer> marsAscBeneficPoints = new ArrayList<Integer>();
		marsAscBeneficPoints.add(1);
		marsAscBeneficPoints.add(3);
		marsAscBeneficPoints.add(6);
		marsAscBeneficPoints.add(10);
		marsAscBeneficPoints.add(11);
		
		marsBeneficPoints.put(Planet.MAR, marsMarsBeneficPoints);
		marsBeneficPoints.put(Planet.SUN, marsSunBeneficPoints);
		marsBeneficPoints.put(Planet.MON, marsMoonBeneficPoints);
		marsBeneficPoints.put(Planet.JUP, marsJupiterBeneficPoints);
		marsBeneficPoints.put(Planet.SAT, marsSaturnBeneficPoints);
		marsBeneficPoints.put(Planet.MER, marsMercuryBeneficPoints);
		marsBeneficPoints.put(Planet.VEN, marsVenusBeneficPoints);
		marsBeneficPoints.put(Planet.ASC, marsAscBeneficPoints);
			
		mars.setBeneficPoints(marsBeneficPoints);
		
        List<Integer> marsAspects = new ArrayList<Integer>();
		marsAspects.add(4);
		marsAspects.add(8);
		marsAspects.add(7);
		
		mars.setAspectCount(marsAspects);
		
		List<House> marsKarakaOf = new ArrayList<House>();
		marsKarakaOf.add(House.H3);
		
		mars.setKarakaOf(marsKarakaOf);
		
		List<Integer> marsBeneficPointsFromMoonNak = new ArrayList<Integer>();
		marsBeneficPointsFromMoonNak.add(6);
		marsBeneficPointsFromMoonNak.add(9);
		marsBeneficPointsFromMoonNak.add(11);
		marsBeneficPointsFromMoonNak.add(17);
		marsBeneficPointsFromMoonNak.add(18);
		marsBeneficPointsFromMoonNak.add(20);
		marsBeneficPointsFromMoonNak.add(22);
		marsBeneficPointsFromMoonNak.add(26);
		
		mars.addAshtavargaPointSignificance(0, "Accidents & chronic diseases");
		mars.addAshtavargaPointSignificance(1, "High fever, wounds, surgery & loss through enemies");
		mars.addAshtavargaPointSignificance(2, "Dispute & litigations with spouse & others/Loss of property");
		mars.addAshtavargaPointSignificance(3, "Seperation from siblings & spouse");
		mars.addAshtavargaPointSignificance(4, "Mixture of pleasures & sorrow");
		mars.addAshtavargaPointSignificance(5, "Gain through children, good finance and health");
		mars.addAshtavargaPointSignificance(6, "Prosperity & happiness through siblings");
		mars.addAshtavargaPointSignificance(7, "Honoured by rulers & acquisition of desired objects");
		mars.addAshtavargaPointSignificance(8, "Great progress in business & real estate and victory over enemies");
		
		mars.setBeneficTransitPointsFromMoonNak(marsBeneficPointsFromMoonNak);
		
		PlanetDetails jupiter = new PlanetDetails();
		jupiter.setGuna(Guna.SATVIK);
		jupiter.setRole(Role.TEACHER);
		jupiter.setPlanet(Planet.JUP);
		jupiter.setNature(PlanetNature.Benefic);
		jupiter.setDebilitationPoint(275.0);
		jupiter.setMooltrikonSign(Zodiac.SAG);
		jupiter.setGender(Gender.Male);
		jupiter.setEpochDegree(220.04);
		jupiter.setRetrograde(true);
		jupiter.setInnerPlanet(false);
		jupiter.setLuminosity(34.29);
		jupiter.setDiscDiameter(190.4);
		
		Impact jupiterImpact = new Impact();
		jupiterImpact.setGross("Big/Large expansion");
		jupiterImpact.setSublte("Wisdom, Learning ability, Philosophical abilities");
		jupiterImpact.setCausal("Expand from knowledge, Guidance and Learning from people around");

		jupiter.setImpact(jupiterImpact);
		
		Map<Planet, List<Integer>> jupiterBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> jupiterMarsBeneficPoints = new ArrayList<Integer>();
		jupiterMarsBeneficPoints.add(1);
		jupiterMarsBeneficPoints.add(2);
		jupiterMarsBeneficPoints.add(4);
		jupiterMarsBeneficPoints.add(7);
		jupiterMarsBeneficPoints.add(8);
		jupiterMarsBeneficPoints.add(10);
		jupiterMarsBeneficPoints.add(11);
		
		List<Integer> jupiterSunBeneficPoints = new ArrayList<Integer>();
		jupiterSunBeneficPoints.add(1);
		jupiterSunBeneficPoints.add(2);
		jupiterSunBeneficPoints.add(3);
		jupiterSunBeneficPoints.add(4);
		jupiterSunBeneficPoints.add(7);
		jupiterSunBeneficPoints.add(8);
		jupiterSunBeneficPoints.add(9);
		jupiterSunBeneficPoints.add(10);
		jupiterSunBeneficPoints.add(11);
		
		List<Integer> jupiterMoonBeneficPoints = new ArrayList<Integer>();
		jupiterMoonBeneficPoints.add(2);
		jupiterMoonBeneficPoints.add(5);
		jupiterMoonBeneficPoints.add(7);
		jupiterMoonBeneficPoints.add(9);
		jupiterMoonBeneficPoints.add(11);
		
		List<Integer> jupiterJupiterBeneficPoints = new ArrayList<Integer>();
		jupiterJupiterBeneficPoints.add(1);
		jupiterJupiterBeneficPoints.add(2);
		jupiterJupiterBeneficPoints.add(3);
		jupiterJupiterBeneficPoints.add(4);
		jupiterJupiterBeneficPoints.add(7);
		jupiterJupiterBeneficPoints.add(8);
		jupiterJupiterBeneficPoints.add(10);
		jupiterJupiterBeneficPoints.add(11);
		
		List<Integer> jupiterSaturnBeneficPoints = new ArrayList<Integer>();
		jupiterSaturnBeneficPoints.add(3);
		jupiterSaturnBeneficPoints.add(5);
		jupiterSaturnBeneficPoints.add(6);
		jupiterSaturnBeneficPoints.add(12);
		
		List<Integer> jupiterMercuryBeneficPoints = new ArrayList<Integer>();
		jupiterMercuryBeneficPoints.add(1);
		jupiterMercuryBeneficPoints.add(2);
		jupiterMercuryBeneficPoints.add(4);
		jupiterMercuryBeneficPoints.add(5);
		jupiterMercuryBeneficPoints.add(6);
		jupiterMercuryBeneficPoints.add(9);
		jupiterMercuryBeneficPoints.add(10);
		jupiterMercuryBeneficPoints.add(11);
		
		
		List<Integer> jupiterVenusBeneficPoints = new ArrayList<Integer>();
		jupiterVenusBeneficPoints.add(2);
		jupiterVenusBeneficPoints.add(5);
		jupiterVenusBeneficPoints.add(6);
		jupiterVenusBeneficPoints.add(9);
		jupiterVenusBeneficPoints.add(10);
		jupiterVenusBeneficPoints.add(11);
		
		List<Integer> jupiterAscBeneficPoints = new ArrayList<Integer>();
		jupiterAscBeneficPoints.add(1);
		jupiterAscBeneficPoints.add(2);
		jupiterAscBeneficPoints.add(4);
		jupiterAscBeneficPoints.add(5);
		jupiterAscBeneficPoints.add(6);
		jupiterAscBeneficPoints.add(7);
		jupiterAscBeneficPoints.add(9);
		jupiterAscBeneficPoints.add(10);
		jupiterAscBeneficPoints.add(11);
		
		jupiterBeneficPoints.put(Planet.MAR, jupiterMarsBeneficPoints);
		jupiterBeneficPoints.put(Planet.SUN, jupiterSunBeneficPoints);
		jupiterBeneficPoints.put(Planet.MON, jupiterMoonBeneficPoints);
		jupiterBeneficPoints.put(Planet.JUP, jupiterJupiterBeneficPoints);
		jupiterBeneficPoints.put(Planet.SAT, jupiterSaturnBeneficPoints);
		jupiterBeneficPoints.put(Planet.MER, jupiterMercuryBeneficPoints);
		jupiterBeneficPoints.put(Planet.VEN, jupiterVenusBeneficPoints);
		jupiterBeneficPoints.put(Planet.ASC, jupiterAscBeneficPoints);
			
		jupiter.setBeneficPoints(jupiterBeneficPoints);
	
		List<Integer> jupAspects = new ArrayList<Integer>();
		jupAspects.add(5);
		jupAspects.add(9);
		jupAspects.add(7);
		
		jupiter.setAspectCount(jupAspects);
		
		List<House> jupKarakaOf = new ArrayList<House>();
		jupKarakaOf.add(House.H5);
		jupKarakaOf.add(House.H9);
		jupKarakaOf.add(House.H11);
		
		jupiter.setKarakaOf(jupKarakaOf);

		List<Integer> jupiterBeneficPointsFromMoonNak = new ArrayList<Integer>();
		jupiterBeneficPointsFromMoonNak.add(4);
		jupiterBeneficPointsFromMoonNak.add(6);
		jupiterBeneficPointsFromMoonNak.add(8);
		jupiterBeneficPointsFromMoonNak.add(9);
		jupiterBeneficPointsFromMoonNak.add(11);
		jupiterBeneficPointsFromMoonNak.add(13);
		jupiterBeneficPointsFromMoonNak.add(15);
		jupiterBeneficPointsFromMoonNak.add(17);
		jupiterBeneficPointsFromMoonNak.add(20);
		jupiterBeneficPointsFromMoonNak.add(22);
		jupiterBeneficPointsFromMoonNak.add(24);
		jupiterBeneficPointsFromMoonNak.add(26);
		jupiterBeneficPointsFromMoonNak.add(27);
		
		jupiter.setBeneficTransitPointsFromMoonNak(jupiterBeneficPointsFromMoonNak);
		
        jupiter.addAshtavargaPointSignificance(0, "Disease & hospitalization or loss of wife, child & mental agony");
		jupiter.addAshtavargaPointSignificance(1, "Fear & loss from enemies");
		jupiter.addAshtavargaPointSignificance(2, "Loss of virility, wife, children & property");
		jupiter.addAshtavargaPointSignificance(3, "Depression ear/stomach trouble & worries");
		jupiter.addAshtavargaPointSignificance(4, "Improper use of knowledge & mixture of gain & losses");
		jupiter.addAshtavargaPointSignificance(5, "Success in understakings and gain of & from friends");
		jupiter.addAshtavargaPointSignificance(6, "Victory over enemies & acquisition of items of luxuries/comforts");
		jupiter.addAshtavargaPointSignificance(7, "Deeply attached to or begetting spouse & children");
		jupiter.addAshtavargaPointSignificance(8, "Honour or promotion to a higher post and gain from riches");
		
		PlanetDetails saturn = new PlanetDetails();
		saturn.setGuna(Guna.TAMSIK);
		saturn.setRole(Role.SOLDIER);
		saturn.setPlanet(Planet.SAT);
		saturn.setNature(PlanetNature.Malefic);
		saturn.setDebilitationPoint(20.0);
		saturn.setMooltrikonSign(Zodiac.AQU);
		saturn.setGender(Gender.Hermaphrodite);
		saturn.setEpochDegree(236.74);
		saturn.setRetrograde(true);
		saturn.setInnerPlanet(false);
		saturn.setLuminosity(8.57);
		saturn.setDiscDiameter(158.0);
		
		Impact saturnImpact = new Impact();
		saturnImpact.setGross("Slow");
		saturnImpact.setSublte("Judgement, Justice, Learning from mistakes");
		saturnImpact.setCausal("Past & Current life karmas - struggle / luck, Ability to learn from mistakes");

		saturn.setImpact(saturnImpact);
		
		Map<Planet, List<Integer>> saturnBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> saturnMarsBeneficPoints = new ArrayList<Integer>();
		saturnMarsBeneficPoints.add(3);
		saturnMarsBeneficPoints.add(5);
		saturnMarsBeneficPoints.add(6);
		saturnMarsBeneficPoints.add(10);
		saturnMarsBeneficPoints.add(11);
		saturnMarsBeneficPoints.add(12);
		
		List<Integer> saturnSunBeneficPoints = new ArrayList<Integer>();
		saturnSunBeneficPoints.add(1);
		saturnSunBeneficPoints.add(2);
		saturnSunBeneficPoints.add(4);
		saturnSunBeneficPoints.add(7);
		saturnSunBeneficPoints.add(8);
		saturnSunBeneficPoints.add(10);
		saturnSunBeneficPoints.add(11);
		
		List<Integer> saturnMoonBeneficPoints = new ArrayList<Integer>();
		saturnMoonBeneficPoints.add(3);
		saturnMoonBeneficPoints.add(6);
		saturnMoonBeneficPoints.add(11);
		
		List<Integer> saturnJupiterBeneficPoints = new ArrayList<Integer>();
		saturnJupiterBeneficPoints.add(5);
		saturnJupiterBeneficPoints.add(6);
		saturnJupiterBeneficPoints.add(11);
		saturnJupiterBeneficPoints.add(12);
		
		
		List<Integer> saturnSaturnBeneficPoints = new ArrayList<Integer>();
		saturnSaturnBeneficPoints.add(3);
		saturnSaturnBeneficPoints.add(5);
		saturnSaturnBeneficPoints.add(6);
		saturnSaturnBeneficPoints.add(11);
		
		List<Integer> saturnMercuryBeneficPoints = new ArrayList<Integer>();
		saturnMercuryBeneficPoints.add(6);
		saturnMercuryBeneficPoints.add(8);
		saturnMercuryBeneficPoints.add(9);
		saturnMercuryBeneficPoints.add(10);
		saturnMercuryBeneficPoints.add(11);
		saturnMercuryBeneficPoints.add(12);
		
		List<Integer> saturnVenusBeneficPoints = new ArrayList<Integer>();
		saturnVenusBeneficPoints.add(6);
		saturnVenusBeneficPoints.add(11);
		saturnVenusBeneficPoints.add(12);
		
		List<Integer> saturnAscBeneficPoints = new ArrayList<Integer>();
		saturnAscBeneficPoints.add(1);
		saturnAscBeneficPoints.add(3);
		saturnAscBeneficPoints.add(4);
		saturnAscBeneficPoints.add(6);
		saturnAscBeneficPoints.add(10);
		saturnAscBeneficPoints.add(11);
		
		saturnBeneficPoints.put(Planet.MAR, saturnMarsBeneficPoints);
		saturnBeneficPoints.put(Planet.SUN, saturnSunBeneficPoints);
		saturnBeneficPoints.put(Planet.MON, saturnMoonBeneficPoints);
		saturnBeneficPoints.put(Planet.JUP, saturnJupiterBeneficPoints);
		saturnBeneficPoints.put(Planet.SAT, saturnSaturnBeneficPoints);
		saturnBeneficPoints.put(Planet.MER, saturnMercuryBeneficPoints);
		saturnBeneficPoints.put(Planet.VEN, saturnVenusBeneficPoints);
		saturnBeneficPoints.put(Planet.ASC, saturnAscBeneficPoints);
			
		saturn.setBeneficPoints(saturnBeneficPoints);


		List<Integer> satAspects = new ArrayList<Integer>();
		satAspects.add(3);
		satAspects.add(10);
		satAspects.add(7);
		
		saturn.setAspectCount(satAspects);
		
		List<House> satKarakaOf = new ArrayList<House>();
		satKarakaOf.add(House.H6);
		satKarakaOf.add(House.H10);
				
		saturn.setKarakaOf(satKarakaOf);
	
		List<Integer> saturnBeneficPointsFromMoonNak = new ArrayList<Integer>();
		saturnBeneficPointsFromMoonNak.add(2);
		saturnBeneficPointsFromMoonNak.add(4);
		saturnBeneficPointsFromMoonNak.add(6);
		saturnBeneficPointsFromMoonNak.add(9);
		saturnBeneficPointsFromMoonNak.add(13);
		saturnBeneficPointsFromMoonNak.add(15);
		saturnBeneficPointsFromMoonNak.add(17);
		saturnBeneficPointsFromMoonNak.add(18);
		saturnBeneficPointsFromMoonNak.add(20);
		saturnBeneficPointsFromMoonNak.add(22);
		saturnBeneficPointsFromMoonNak.add(24);
		
		saturn.setBeneficTransitPointsFromMoonNak(saturnBeneficPointsFromMoonNak);
		
        saturn.addAshtavargaPointSignificance(0, "Heavy financial losses & humiliation");
		saturn.addAshtavargaPointSignificance(1, "Unlawful/secret & sinful activities");
		saturn.addAshtavargaPointSignificance(2, "Serious diseases and imprisonment");
		saturn.addAshtavargaPointSignificance(3, "Loss of health & wealth and seperation from spouse");
		saturn.addAshtavargaPointSignificance(4, "Troubles by the company one has");
		saturn.addAshtavargaPointSignificance(5, "Gain of wealth & prosperity from agriculture");
		saturn.addAshtavargaPointSignificance(6, "Powerful and leader of people/group");
		saturn.addAshtavargaPointSignificance(7, "Acquires skill in arts and crafts, servants and attractive appearance");
		saturn.addAshtavargaPointSignificance(8, "Knowledge of vedas and high and commanding status");
		
		PlanetDetails mercury = new PlanetDetails();
		mercury.setGuna(Guna.SATVIK);
		mercury.setRole(Role.PRINCE);
		mercury.setPlanet(Planet.MER);
		mercury.setNature(PlanetNature.Benefic);
		mercury.setDebilitationPoint(345.0);
		mercury.setMooltrikonSign(Zodiac.VIR);
		mercury.setGender(Gender.Hermaphrodite);
		mercury.setEpochDegree(164.00);
		mercury.setRetrograde(true);
		mercury.setInnerPlanet(true);
		mercury.setLuminosity(25.71);
		mercury.setDiscDiameter(6.6);
		
		Impact mercuryImpact = new Impact();
		mercuryImpact.setGross("Sharp, Quick, Communication");
		mercuryImpact.setSublte("Intelligence, Expressive, Business mindedness, Putting creativity in writing, Memorizing capability");
		mercuryImpact.setCausal("Ability to use intelligence");

		mercury.setImpact(mercuryImpact);
		
		Map<Planet, List<Integer>> mercuryBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> mercuryMarsBeneficPoints = new ArrayList<Integer>();
		mercuryMarsBeneficPoints.add(1);
		mercuryMarsBeneficPoints.add(2);
		mercuryMarsBeneficPoints.add(4);
		mercuryMarsBeneficPoints.add(7);
		mercuryMarsBeneficPoints.add(8);
		mercuryMarsBeneficPoints.add(9);
		mercuryMarsBeneficPoints.add(10);
		mercuryMarsBeneficPoints.add(11);
		
		List<Integer> mercurySunBeneficPoints = new ArrayList<Integer>();
		mercurySunBeneficPoints.add(5);
		mercurySunBeneficPoints.add(6);
		mercurySunBeneficPoints.add(9);
		mercurySunBeneficPoints.add(11);
		mercurySunBeneficPoints.add(12);
		
		List<Integer> mercuryMoonBeneficPoints = new ArrayList<Integer>();
		mercuryMoonBeneficPoints.add(2);
		mercuryMoonBeneficPoints.add(4);
		mercuryMoonBeneficPoints.add(6);
		mercuryMoonBeneficPoints.add(8);
		mercuryMoonBeneficPoints.add(10);
		mercuryMoonBeneficPoints.add(11);
		
		List<Integer> mercuryJupiterBeneficPoints = new ArrayList<Integer>();
		mercuryJupiterBeneficPoints.add(6);
		mercuryJupiterBeneficPoints.add(8);
		mercuryJupiterBeneficPoints.add(11);
		mercuryJupiterBeneficPoints.add(12);
		
		List<Integer> mercurySaturnBeneficPoints = new ArrayList<Integer>();
		mercurySaturnBeneficPoints.add(1);
		mercurySaturnBeneficPoints.add(2);
		mercurySaturnBeneficPoints.add(4);
		mercurySaturnBeneficPoints.add(7);
		mercurySaturnBeneficPoints.add(8);
		mercurySaturnBeneficPoints.add(9);
		mercurySaturnBeneficPoints.add(10);
		mercurySaturnBeneficPoints.add(11);
		
		List<Integer> mercuryMercuryBeneficPoints = new ArrayList<Integer>();
		mercuryMercuryBeneficPoints.add(1);
		mercuryMercuryBeneficPoints.add(3);
		mercuryMercuryBeneficPoints.add(5);
		mercuryMercuryBeneficPoints.add(6);
		mercuryMercuryBeneficPoints.add(9);
		mercuryMercuryBeneficPoints.add(10);
		mercuryMercuryBeneficPoints.add(11);
		mercuryMercuryBeneficPoints.add(12);
		
		List<Integer> mercuryVenusBeneficPoints = new ArrayList<Integer>();
		mercuryVenusBeneficPoints.add(1);
		mercuryVenusBeneficPoints.add(2);
		mercuryVenusBeneficPoints.add(3);
		mercuryVenusBeneficPoints.add(4);
		mercuryVenusBeneficPoints.add(5);
		mercuryVenusBeneficPoints.add(8);
		mercuryVenusBeneficPoints.add(9);
		mercuryVenusBeneficPoints.add(11);
		
		List<Integer> mercuryAscBeneficPoints = new ArrayList<Integer>();
		mercuryAscBeneficPoints.add(1);
		mercuryAscBeneficPoints.add(2);
		mercuryAscBeneficPoints.add(4);
		mercuryAscBeneficPoints.add(6);
		mercuryAscBeneficPoints.add(8);
		mercuryAscBeneficPoints.add(10);
		mercuryAscBeneficPoints.add(11);
		
		mercuryBeneficPoints.put(Planet.MAR, mercuryMarsBeneficPoints);
		mercuryBeneficPoints.put(Planet.SUN, mercurySunBeneficPoints);
		mercuryBeneficPoints.put(Planet.MON, mercuryMoonBeneficPoints);
		mercuryBeneficPoints.put(Planet.JUP, mercuryJupiterBeneficPoints);
		mercuryBeneficPoints.put(Planet.SAT, mercurySaturnBeneficPoints);
		mercuryBeneficPoints.put(Planet.MER, mercuryMercuryBeneficPoints);
		mercuryBeneficPoints.put(Planet.VEN, mercuryVenusBeneficPoints);
		mercuryBeneficPoints.put(Planet.ASC, mercuryAscBeneficPoints);
			
		mercury.setBeneficPoints(mercuryBeneficPoints);
		
		List<Integer> merAspects = new ArrayList<Integer>();
		merAspects.add(7);
		
		mercury.setAspectCount(merAspects);
		
		List<House> merKarakaOf = new ArrayList<House>();
		merKarakaOf.add(House.H10);
				
		mercury.setKarakaOf(merKarakaOf);

		List<Integer> mercuryBeneficPointsFromMoonNak = new ArrayList<Integer>();
		mercuryBeneficPointsFromMoonNak.add(4);
		mercuryBeneficPointsFromMoonNak.add(6);
		mercuryBeneficPointsFromMoonNak.add(8);
		mercuryBeneficPointsFromMoonNak.add(9);
		mercuryBeneficPointsFromMoonNak.add(11);
		mercuryBeneficPointsFromMoonNak.add(13);
		mercuryBeneficPointsFromMoonNak.add(15);
		mercuryBeneficPointsFromMoonNak.add(17);
		mercuryBeneficPointsFromMoonNak.add(20);
		mercuryBeneficPointsFromMoonNak.add(22);
		mercuryBeneficPointsFromMoonNak.add(24);
		mercuryBeneficPointsFromMoonNak.add(26);
		mercuryBeneficPointsFromMoonNak.add(27);
		
		mercury.setBeneficTransitPointsFromMoonNak(mercuryBeneficPointsFromMoonNak);
		
        mercury.addAshtavargaPointSignificance(0, "Loss of health or nervous breakdown");
		mercury.addAshtavargaPointSignificance(1, "Litigations, imprisonment and unexpected mourning");
		mercury.addAshtavargaPointSignificance(2, "Sickness & loss of wealth");
		mercury.addAshtavargaPointSignificance(3, "Disputes & worries");
		mercury.addAshtavargaPointSignificance(4, "Satisfaction but laziness");
		mercury.addAshtavargaPointSignificance(5, "Fame, courage, high position gets new friends");
		mercury.addAshtavargaPointSignificance(6, "Observance of ethics & success in undertakings & astrology");
		mercury.addAshtavargaPointSignificance(7, "Happiness due to increased income, knowledge and spouse");
		mercury.addAshtavargaPointSignificance(8, "Respect from royalty. acquisition of wealth and good fortune");
		
		PlanetDetails venus = new PlanetDetails();
		venus.setGuna(Guna.RAJSIK);
		venus.setRole(Role.PRINCESS);
		venus.setPlanet(Planet.VEN);
		venus.setNature(PlanetNature.Benefic);
		venus.setDebilitationPoint(177.0);
		venus.setMooltrikonSign(Zodiac.LIB);
		venus.setGender(Gender.Female);
		venus.setEpochDegree(328.51);
		venus.setRetrograde(true);
		venus.setInnerPlanet(true);
		venus.setLuminosity(42.86);
		venus.setDiscDiameter(16.6);

		Map<Planet, List<Integer>> venusBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> venusMarsBeneficPoints = new ArrayList<Integer>();
		venusMarsBeneficPoints.add(3);
		venusMarsBeneficPoints.add(5);
		venusMarsBeneficPoints.add(6);
		venusMarsBeneficPoints.add(9);
		venusMarsBeneficPoints.add(11);
		venusMarsBeneficPoints.add(12);
		
		List<Integer> venusSunBeneficPoints = new ArrayList<Integer>();
		venusSunBeneficPoints.add(8);
		venusSunBeneficPoints.add(10);
		venusSunBeneficPoints.add(11);
		
		List<Integer> venusMoonBeneficPoints = new ArrayList<Integer>();
		venusMoonBeneficPoints.add(1);
		venusMoonBeneficPoints.add(2);
		venusMoonBeneficPoints.add(3);
		venusMoonBeneficPoints.add(4);
		venusMoonBeneficPoints.add(5);
		venusMoonBeneficPoints.add(8);
		venusMoonBeneficPoints.add(9);
		venusMoonBeneficPoints.add(11);
		venusMoonBeneficPoints.add(12);
		
		List<Integer> venusJupiterBeneficPoints = new ArrayList<Integer>();
		venusJupiterBeneficPoints.add(5);
		venusJupiterBeneficPoints.add(8);
		venusJupiterBeneficPoints.add(9);
		venusJupiterBeneficPoints.add(10);
		venusJupiterBeneficPoints.add(11);
		
		List<Integer> venusSaturnBeneficPoints = new ArrayList<Integer>();
		venusSaturnBeneficPoints.add(3);
		venusSaturnBeneficPoints.add(4);
		venusSaturnBeneficPoints.add(5);
		venusSaturnBeneficPoints.add(8);
		venusSaturnBeneficPoints.add(9);
		venusSaturnBeneficPoints.add(10);
		venusSaturnBeneficPoints.add(11);
		
		List<Integer> venusMercuryBeneficPoints = new ArrayList<Integer>();
		venusMercuryBeneficPoints.add(3);
		venusMercuryBeneficPoints.add(5);
		venusMercuryBeneficPoints.add(6);
		venusMercuryBeneficPoints.add(9);
		venusMercuryBeneficPoints.add(11);
		
		List<Integer> venusVenusBeneficPoints = new ArrayList<Integer>();
		venusVenusBeneficPoints.add(1);
		venusVenusBeneficPoints.add(2);
		venusVenusBeneficPoints.add(3);
		venusVenusBeneficPoints.add(4);
		venusVenusBeneficPoints.add(5);
		venusVenusBeneficPoints.add(8);
		venusVenusBeneficPoints.add(9);
		venusVenusBeneficPoints.add(10);
		venusVenusBeneficPoints.add(11);
		
		List<Integer> venusAscBeneficPoints = new ArrayList<Integer>();
		venusAscBeneficPoints.add(1);
		venusAscBeneficPoints.add(2);
		venusAscBeneficPoints.add(3);
		venusAscBeneficPoints.add(4);
		venusAscBeneficPoints.add(5);
		venusAscBeneficPoints.add(8);
		venusAscBeneficPoints.add(9);
		venusAscBeneficPoints.add(11);
		
		venusBeneficPoints.put(Planet.MAR, venusMarsBeneficPoints);
		venusBeneficPoints.put(Planet.SUN, venusSunBeneficPoints);
		venusBeneficPoints.put(Planet.MON, venusMoonBeneficPoints);
		venusBeneficPoints.put(Planet.JUP, venusJupiterBeneficPoints);
		venusBeneficPoints.put(Planet.SAT, venusSaturnBeneficPoints);
		venusBeneficPoints.put(Planet.MER, venusMercuryBeneficPoints);
		venusBeneficPoints.put(Planet.VEN, venusVenusBeneficPoints);
		venusBeneficPoints.put(Planet.ASC, venusAscBeneficPoints);
			
		venus.setBeneficPoints(venusBeneficPoints);

		Impact venusImpact = new Impact();
		venusImpact.setGross("Glamourous, Fashionable, Beauty, Happy, Comfortable");
		venusImpact.setSublte("Happiness, Desire for oppposite sex, Desire for materialistic, Comfortable, Peace of mind");
		venusImpact.setCausal("Materialistic desires pursuit");

		venus.setImpact(venusImpact);

		
		List<Integer> venAspects = new ArrayList<Integer>();
		venAspects.add(7);
		
		venus.setAspectCount(venAspects);

		List<House> venKarakaOf = new ArrayList<House>();
		venKarakaOf.add(House.H7);
				
		venus.setKarakaOf(venKarakaOf);

		List<Integer> venusBeneficPointsFromMoonNak = new ArrayList<Integer>();
		venusBeneficPointsFromMoonNak.add(4);
		venusBeneficPointsFromMoonNak.add(6);
		venusBeneficPointsFromMoonNak.add(8);
		venusBeneficPointsFromMoonNak.add(9);
		venusBeneficPointsFromMoonNak.add(11);
		venusBeneficPointsFromMoonNak.add(13);
		venusBeneficPointsFromMoonNak.add(15);
		venusBeneficPointsFromMoonNak.add(17);
		venusBeneficPointsFromMoonNak.add(20);
		venusBeneficPointsFromMoonNak.add(22);
		venusBeneficPointsFromMoonNak.add(24);
		venusBeneficPointsFromMoonNak.add(26);
		venusBeneficPointsFromMoonNak.add(27);
		
		venus.setBeneficTransitPointsFromMoonNak(venusBeneficPointsFromMoonNak);
		
        venus.addAshtavargaPointSignificance(0, "Suffers from calamities and all types of mourning");
		venus.addAshtavargaPointSignificance(1, "Sickness & humiliation and danger of drowning/poison");
		venus.addAshtavargaPointSignificance(2, "Dishonour/disrespect caused due to opposite sex");
		venus.addAshtavargaPointSignificance(3, "Trouble from neighbours & friends");
		venus.addAshtavargaPointSignificance(4, "Normal business activities");
		venus.addAshtavargaPointSignificance(5, "Increase in status in society and help from friends");
		venus.addAshtavargaPointSignificance(6, "Popular & wide circle of friends & opposite sex");
		venus.addAshtavargaPointSignificance(7, "Get precious jewels, items & vehicles");
		venus.addAshtavargaPointSignificance(8, "Radiant personality & acquisition of sophisticated luxurous items");
		
		PlanetDetails sun = new PlanetDetails();
		sun.setGuna(Guna.RAJSIK);
		sun.setRole(Role.KING);
		sun.setPlanet(Planet.SUN);
		sun.setNature(PlanetNature.Malefic);
		sun.setDebilitationPoint(190.0);
		sun.setMooltrikonSign(Zodiac.LEO);
		sun.setGender(Gender.Male);
		sun.setEpochDegree(257.4568);
		sun.setRetrograde(false);
		sun.setInnerPlanet(true);
		sun.setLuminosity(60.00);
		
		Impact sunImpact = new Impact();
		sunImpact.setGross("Vitality, Confidence, Lead by example");
		sunImpact.setSublte("Self confidence, Ability to lead, Ego");
		sunImpact.setCausal("Ability to use authority & power, What soul wants");

		sun.setImpact(sunImpact);
		
		Map<Planet, List<Integer>> sunBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> sunMarsBeneficPoints = new ArrayList<Integer>();
		sunMarsBeneficPoints.add(1);
		sunMarsBeneficPoints.add(2);
		sunMarsBeneficPoints.add(4);
		sunMarsBeneficPoints.add(7);
		sunMarsBeneficPoints.add(8);
		sunMarsBeneficPoints.add(9);
		sunMarsBeneficPoints.add(10);
		sunMarsBeneficPoints.add(11);
		
		List<Integer> sunSunBeneficPoints = new ArrayList<Integer>();
		sunSunBeneficPoints.add(1);
		sunSunBeneficPoints.add(2);
		sunSunBeneficPoints.add(4);
		sunSunBeneficPoints.add(7);
		sunSunBeneficPoints.add(8);
		sunSunBeneficPoints.add(9);
		sunSunBeneficPoints.add(10);
		sunSunBeneficPoints.add(11);
		
		List<Integer> sunMoonBeneficPoints = new ArrayList<Integer>();
		sunMoonBeneficPoints.add(3);
		sunMoonBeneficPoints.add(6);
		sunMoonBeneficPoints.add(10);
		sunMoonBeneficPoints.add(11);
		
		List<Integer> sunJupiterBeneficPoints = new ArrayList<Integer>();
		sunJupiterBeneficPoints.add(5);
		sunJupiterBeneficPoints.add(6);
		sunJupiterBeneficPoints.add(9);
		sunJupiterBeneficPoints.add(11);
		
		List<Integer> sunSaturnBeneficPoints = new ArrayList<Integer>();
		sunSaturnBeneficPoints.add(1);
		sunSaturnBeneficPoints.add(2);
		sunSaturnBeneficPoints.add(4);
		sunSaturnBeneficPoints.add(7);
		sunSaturnBeneficPoints.add(8);
		sunSaturnBeneficPoints.add(9);
		sunSaturnBeneficPoints.add(10);
		sunSaturnBeneficPoints.add(11);
		
		List<Integer> sunMercuryBeneficPoints = new ArrayList<Integer>();
		sunMercuryBeneficPoints.add(3);
		sunMercuryBeneficPoints.add(5);
		sunMercuryBeneficPoints.add(6);
		sunMercuryBeneficPoints.add(9);
		sunMercuryBeneficPoints.add(10);
		sunMercuryBeneficPoints.add(11);
		sunMercuryBeneficPoints.add(12);
		
		List<Integer> sunVenusBeneficPoints = new ArrayList<Integer>();
		sunVenusBeneficPoints.add(6);
		sunVenusBeneficPoints.add(7);
		sunVenusBeneficPoints.add(12);
		
		List<Integer> sunAscBeneficPoints = new ArrayList<Integer>();
		sunAscBeneficPoints.add(3);
		sunAscBeneficPoints.add(4);
		sunAscBeneficPoints.add(6);
		sunAscBeneficPoints.add(10);
		sunAscBeneficPoints.add(11);
		sunAscBeneficPoints.add(12);
		
		sunBeneficPoints.put(Planet.MAR, sunMarsBeneficPoints);
		sunBeneficPoints.put(Planet.SUN, sunSunBeneficPoints);
		sunBeneficPoints.put(Planet.MON, sunMoonBeneficPoints);
		sunBeneficPoints.put(Planet.JUP, sunJupiterBeneficPoints);
		sunBeneficPoints.put(Planet.SAT, sunSaturnBeneficPoints);
		sunBeneficPoints.put(Planet.MER, sunMercuryBeneficPoints);
		sunBeneficPoints.put(Planet.VEN, sunVenusBeneficPoints);
		sunBeneficPoints.put(Planet.ASC, sunAscBeneficPoints);
			
		sun.setBeneficPoints(sunBeneficPoints);

		List<Integer> sunAspects = new ArrayList<Integer>();
		sunAspects.add(7);
		
		sun.setAspectCount(sunAspects);
		
		List<House> sunKarakaOf = new ArrayList<House>();
		sunKarakaOf.add(House.H1);
		sunKarakaOf.add(House.H10);
		
		sun.setKarakaOf(sunKarakaOf);

		List<Integer> sunBeneficPointsFromMoonNak = new ArrayList<Integer>();
		sunBeneficPointsFromMoonNak.add(2);
		sunBeneficPointsFromMoonNak.add(4);
		sunBeneficPointsFromMoonNak.add(6);
		sunBeneficPointsFromMoonNak.add(8);
		sunBeneficPointsFromMoonNak.add(9);
		sunBeneficPointsFromMoonNak.add(17);
		sunBeneficPointsFromMoonNak.add(18);
		sunBeneficPointsFromMoonNak.add(24);
		
		sun.setBeneficTransitPointsFromMoonNak(sunBeneficPointsFromMoonNak);
		
        sun.addAshtavargaPointSignificance(0, "All sort of troubles, mental agony and untold miseries");
		sun.addAshtavargaPointSignificance(1, "Diseases & worries/harassment from government");
		sun.addAshtavargaPointSignificance(2, "Dishonour, disappointments, theft & losses ");
		sun.addAshtavargaPointSignificance(3, "Heavy expenditure, unwanted travel & lack of peace of mind");
		sun.addAshtavargaPointSignificance(4, "Good character & moderate gains from expenditure");
		sun.addAshtavargaPointSignificance(5, "Devoted to religion & success in academic field");
		sun.addAshtavargaPointSignificance(6, "Acquisition of wealth, success in all efforts and better oppurtunity");
		sun.addAshtavargaPointSignificance(7, "Increase in name, fame, courage & prestige");
		sun.addAshtavargaPointSignificance(8, "Higher status, gain of money & favours from government");
		
		PlanetDetails moon = new PlanetDetails();
		moon.setGuna(Guna.RAJSIK);
		moon.setRole(Role.QUEEN);
		moon.setPlanet(Planet.MON);
		moon.setNature(PlanetNature.Benefic);
		moon.setDebilitationPoint(213.0);
		moon.setMooltrikonSign(Zodiac.CAN);
		moon.setGender(Gender.Female);
		moon.setRetrograde(false);
		moon.setInnerPlanet(true);
		moon.setLuminosity(51.43);
		
		Impact moonImpact = new Impact();
		moonImpact.setGross("Beauty, Fertility");
		moonImpact.setSublte("Mind, Emotions, Creativity/Imagination, Selfless love");
		moonImpact.setCausal("Emotional experiences/weakness of the mind ");

		moon.setImpact(moonImpact);

		Map<Planet, List<Integer>> moonBeneficPoints = new HashMap<Planet, List<Integer>>();
		
		List<Integer> moonMarsBeneficPoints = new ArrayList<Integer>();
		moonMarsBeneficPoints.add(2);
		moonMarsBeneficPoints.add(3);
		moonMarsBeneficPoints.add(5);
		moonMarsBeneficPoints.add(6);
		moonMarsBeneficPoints.add(9);
		moonMarsBeneficPoints.add(10);
		moonMarsBeneficPoints.add(11);
		
		List<Integer> moonSunBeneficPoints = new ArrayList<Integer>();
		moonSunBeneficPoints.add(3);
		moonSunBeneficPoints.add(6);
		moonSunBeneficPoints.add(7);
		moonSunBeneficPoints.add(8);
		moonSunBeneficPoints.add(10);
		moonSunBeneficPoints.add(11);
		
		List<Integer> moonMoonBeneficPoints = new ArrayList<Integer>();
		moonMoonBeneficPoints.add(1);
		moonMoonBeneficPoints.add(3);
		moonMoonBeneficPoints.add(6);
		moonMoonBeneficPoints.add(7);
		moonMoonBeneficPoints.add(10);
		moonMoonBeneficPoints.add(11);
		
		List<Integer> moonJupiterBeneficPoints = new ArrayList<Integer>();
		moonJupiterBeneficPoints.add(1);
		moonJupiterBeneficPoints.add(4);
		moonJupiterBeneficPoints.add(7);
		moonJupiterBeneficPoints.add(8);
		moonJupiterBeneficPoints.add(10);
		moonJupiterBeneficPoints.add(11);
		moonJupiterBeneficPoints.add(12);
		
		List<Integer> moonSaturnBeneficPoints = new ArrayList<Integer>();
		moonSaturnBeneficPoints.add(3);
		moonSaturnBeneficPoints.add(5);
		moonSaturnBeneficPoints.add(6);
		moonSaturnBeneficPoints.add(11);
		
		List<Integer> moonMercuryBeneficPoints = new ArrayList<Integer>();
		moonMercuryBeneficPoints.add(1);
		moonMercuryBeneficPoints.add(3);
		moonMercuryBeneficPoints.add(4);
		moonMercuryBeneficPoints.add(5);
		moonMercuryBeneficPoints.add(7);
		moonMercuryBeneficPoints.add(8);
		moonMercuryBeneficPoints.add(10);
		moonMercuryBeneficPoints.add(11);
		
		List<Integer> moonVenusBeneficPoints = new ArrayList<Integer>();
		moonVenusBeneficPoints.add(3);
		moonVenusBeneficPoints.add(4);
		moonVenusBeneficPoints.add(5);
		moonVenusBeneficPoints.add(7);
		moonVenusBeneficPoints.add(9);
		moonVenusBeneficPoints.add(10);
		moonVenusBeneficPoints.add(11);
		
		List<Integer> moonAscBeneficPoints = new ArrayList<Integer>();
		moonAscBeneficPoints.add(3);
		moonAscBeneficPoints.add(6);
		moonAscBeneficPoints.add(10);
		moonAscBeneficPoints.add(11);
		
		moonBeneficPoints.put(Planet.MAR, moonMarsBeneficPoints);
		moonBeneficPoints.put(Planet.SUN, moonSunBeneficPoints);
		moonBeneficPoints.put(Planet.MON, moonMoonBeneficPoints);
		moonBeneficPoints.put(Planet.JUP, moonJupiterBeneficPoints);
		moonBeneficPoints.put(Planet.SAT, moonSaturnBeneficPoints);
		moonBeneficPoints.put(Planet.MER, moonMercuryBeneficPoints);
		moonBeneficPoints.put(Planet.VEN, moonVenusBeneficPoints);
		moonBeneficPoints.put(Planet.ASC, moonAscBeneficPoints);
			
		moon.setBeneficPoints(moonBeneficPoints);

		List<Integer> monAspects = new ArrayList<Integer>();
		monAspects.add(7);
		
		moon.setAspectCount(monAspects);
		
		List<House> moonKarakaOf = new ArrayList<House>();
		moonKarakaOf.add(House.H4);
				
		moon.setKarakaOf(moonKarakaOf);
		
		List<Integer> moonBeneficPointsFromMoonNak = 
				new ArrayList<Integer>();
		
		moonBeneficPointsFromMoonNak.add(4);
		moonBeneficPointsFromMoonNak.add(6);
		moonBeneficPointsFromMoonNak.add(8);
		moonBeneficPointsFromMoonNak.add(9);
		moonBeneficPointsFromMoonNak.add(11);
		moonBeneficPointsFromMoonNak.add(13);
		moonBeneficPointsFromMoonNak.add(15);
		moonBeneficPointsFromMoonNak.add(18);
		moonBeneficPointsFromMoonNak.add(24);
		
		moon.setBeneficTransitPointsFromMoonNak(
				moonBeneficPointsFromMoonNak);
		
        moon.addAshtavargaPointSignificance(0, "Misery & nervous breakdown");
		moon.addAshtavargaPointSignificance(1, "Disease & depression");
		moon.addAshtavargaPointSignificance(2, "Loss of honour, health and wealth");
		moon.addAshtavargaPointSignificance(3, "Family discord and quarrel with others");
		moon.addAshtavargaPointSignificance(4, "Satisfied & contended with moderate results");
		moon.addAshtavargaPointSignificance(5, "Great patience, endurance & moral courage");
		moon.addAshtavargaPointSignificance(6, "Virtous/religious qualities, gain of wealth & adept in occult science");
		moon.addAshtavargaPointSignificance(7, "Charitable, tranquil heart, luxuries and happy get together");
		moon.addAshtavargaPointSignificance(8, "Liked by superiors, honour, respect, status and all comforts");
		
		PlanetDetails rahu = new PlanetDetails();
		
		rahu.setGuna(Guna.TAMSIK);
		rahu.setRole(Role.THIEF);
		rahu.setPlanet(Planet.RAH);
		rahu.setNature(PlanetNature.Malefic);
		rahu.setRetrograde(false);
		rahu.setInnerPlanet(true);
		
		Impact rahuImpact = new Impact();
		rahuImpact.setGross("Lusciousness, Rich in worldy possessions");
		rahuImpact.setSublte("Intense interest, Research capability, In-depth understanding");
		rahuImpact.setCausal("Unfulfilled desires from previous lives");

		rahu.setImpact(rahuImpact);
		List<Integer> rahAspects = new ArrayList<Integer>();
		rahAspects.add(5);
		rahAspects.add(7);
		rahAspects.add(9);
		rahu.setAspectCount(rahAspects);
	
		PlanetDetails ketu = new PlanetDetails();
		ketu.setGuna(Guna.TAMSIK);
		ketu.setRole(Role.BHIKSHU);
		ketu.setPlanet(Planet.KET);
		ketu.setNature(PlanetNature.Malefic);
		ketu.setRetrograde(false);
		ketu.setInnerPlanet(true);
		
		Impact ketuImpact = new Impact();
		ketuImpact.setGross("Poor in possessions, Wanderer, Isolation");
		ketuImpact.setSublte("Lack of interest, No desire, Indecisiveness");
		ketuImpact.setCausal("Areas conquered in previous lives");

		ketu.setImpact(ketuImpact);

		List<Integer> ketAspects = new ArrayList<Integer>();
		ketAspects.add(5);
		ketAspects.add(7);
		ketAspects.add(9);
		
		ketu.setAspectCount(ketAspects);
			
		planetRefDataMap.put(Planet.MAR.name(), mars);
		planetRefDataMap.put(Planet.JUP.name(), jupiter);
		planetRefDataMap.put(Planet.SAT.name(), saturn);
		planetRefDataMap.put(Planet.VEN.name(), venus);
		planetRefDataMap.put(Planet.MER.name(), mercury);
		planetRefDataMap.put(Planet.SUN.name(), sun);
		planetRefDataMap.put(Planet.MON.name(), moon);
		planetRefDataMap.put(Planet.RAH.name(), rahu);
		planetRefDataMap.put(Planet.KET.name(), ketu);
		
		planetData.setEntityType(EntityType.Planet);
		planetData.setData(planetRefDataMap);
				
		return planetData;
	}

	
	public static EntityRefData<HouseDetails> createHouseRefData(){
		
		EntityRefData<HouseDetails> houseData = new EntityRefData<HouseDetails>();
		Map<String, HouseDetails> houseRefDataMap = new HashMap<String, HouseDetails>(12);
		
		HouseDetails h1 = new HouseDetails();
		h1.setBodyParts("Head");
		h1.setCharacteristics("Self");
		h1.setRelationship(Relationship.Self);
		h1.addHouseType(HouseType.Kendra);
		h1.addHouseType(HouseType.Trikona);
		h1.addKaraka(Planet.SUN);
		h1.setKendraPowerlessPosition(86.43);
		
		HouseDetails h2 = new HouseDetails();
		h2.setBodyParts("Eyes, Ears & Mouth");
		h2.setCharacteristics("Food, Shelter and Clothing");
		h2.setRelationship(Relationship.Parents);
		h2.addHouseType(HouseType.Wealth);
		h2.addHouseType(HouseType.Death);
		h2.addHouseType(HouseType.Panapara);
		h2.addKaraka(Planet.JUP);
		h2.addKaraka(Planet.MER);
	
		HouseDetails h3 = new HouseDetails();
		h3.setBodyParts("Hands, arms");
		h3.setCharacteristics("Support system, people working as servants");
		h3.setRelationship(Relationship.Sibling);
		h3.setTravelImpact(TravelType.ShortDomestic);
		h3.addHouseType(HouseType.Upachaya);
		h3.addHouseType(HouseType.Kama);
		h3.addHouseType(HouseType.Apoklim);
		h3.addKaraka(Planet.MAR);
	
		HouseDetails h4 = new HouseDetails();
		h4.setBodyParts("Chest, Breast, Lungs, Heart");
		h4.setCharacteristics("Luxurious assets, Vehicles, Schooling");
		h4.setRelationship(Relationship.Mother);
		h4.addHouseType(HouseType.Kendra);
		h4.addHouseType(HouseType.Moksha);
		h4.addKaraka(Planet.MON);
		h4.addKaraka(Planet.VEN);
		h4.setKendraPowerlessPosition(166.15);
		
		HouseDetails h5 = new HouseDetails();
		h5.setBodyParts("Stomach, Liver");
		h5.setCharacteristics("Mass support, People support, Use of luck/skills");
		h5.setRelationship(Relationship.Children);
		h5.addHouseType(HouseType.Trikona);
		h5.addHouseType(HouseType.Panapara);
		h5.addKaraka(Planet.JUP);
	
		HouseDetails h6 = new HouseDetails();
		h6.setBodyParts("Upper interstine, Kidneys");
		h6.setCharacteristics("Day to day obstracles");
		h6.setRelationship(Relationship.Collegues);
		h6.addHouseType(HouseType.Upachaya);
		h6.addHouseType(HouseType.Dusthana);
		h6.addHouseType(HouseType.Apoklim);
		h6.addKaraka(Planet.MAR);
		h6.addKaraka(Planet.SAT);
	
		HouseDetails h7 = new HouseDetails();
		h7.setBodyParts("Pelvic");
		h7.setCharacteristics("Worldy affairs, Business");
		h7.setRelationship(Relationship.Wife);
		h7.setTravelImpact(TravelType.BusinessTravel);
		h7.addHouseType(HouseType.Kendra);
		h7.addHouseType(HouseType.Kama);
		h7.addHouseType(HouseType.Death);
		h7.addKaraka(Planet.VEN);
		h7.setKendraPowerlessPosition(266.43);
		
		HouseDetails h8 = new HouseDetails();
		h8.setBodyParts("Anus, Reproductive organs");
		h8.setCharacteristics("Debts, Loans, Ups and Downs, Away from society, Hidden talents");
		h8.setRelationship(Relationship.InLaws);
		h8.addHouseType(HouseType.Dusthana);
		h8.addHouseType(HouseType.Moksha);
		h8.addHouseType(HouseType.Death);
		h8.addHouseType(HouseType.Panapara);
		h8.addKaraka(Planet.SAT);
		
		HouseDetails h9 = new HouseDetails();
		h9.setBodyParts("Thighs");
		h9.setCharacteristics("Higher education, Philosophy, Religion");
		h9.setRelationship(Relationship.Teacher);
		h9.setTravelImpact(TravelType.LongDomestic);
		h9.addHouseType(HouseType.Trikona);
		h9.addHouseType(HouseType.Wealth);
		h9.addHouseType(HouseType.Apoklim);
		h9.addKaraka(Planet.JUP);
		
		HouseDetails h10 = new HouseDetails();
		h10.setBodyParts("Knees/Joints/Muscle");
		h10.setCharacteristics("Profession, Workplace, Society karmas");
		h10.setRelationship(Relationship.Father);
		h10.addHouseType(HouseType.Kendra);
		h10.addHouseType(HouseType.Upachaya);
		h10.addKaraka(Planet.SAT);
		h10.addKaraka(Planet.MER);
		h10.addKaraka(Planet.SUN);
		h10.setKendraPowerlessPosition(346.15);
	
		HouseDetails h11 = new HouseDetails();
		h11.setBodyParts("Ankle");
		h11.setCharacteristics("Permanent income, Networking");
		h11.setRelationship(Relationship.Friends);
		h11.addHouseType(HouseType.Upachaya);
		h11.addHouseType(HouseType.Kama);
		h11.addHouseType(HouseType.Wealth);
		h11.addHouseType(HouseType.Panapara);
		h11.addKaraka(Planet.JUP);
		
		HouseDetails h12 = new HouseDetails();
		h12.setBodyParts("Feet");
		h12.setCharacteristics("Foreign settlements");
		h12.setTravelImpact(TravelType.International);
		h12.addHouseType(HouseType.Dusthana);
		h12.addHouseType(HouseType.Moksha);
		h12.addHouseType(HouseType.Apoklim);
		h12.addKaraka(Planet.SAT);
		
		houseRefDataMap.put(House.H1.name(), h1);
		houseRefDataMap.put(House.H2.name(), h2);
		houseRefDataMap.put(House.H3.name(), h3);
		houseRefDataMap.put(House.H4.name(), h4);
		houseRefDataMap.put(House.H5.name(), h5);
		houseRefDataMap.put(House.H6.name(), h6);
		houseRefDataMap.put(House.H7.name(), h7);
		houseRefDataMap.put(House.H8.name(), h8);
		houseRefDataMap.put(House.H9.name(), h9);
		houseRefDataMap.put(House.H10.name(), h10);
		houseRefDataMap.put(House.H11.name(), h11);
		houseRefDataMap.put(House.H12.name(), h12);
		
		houseData.setEntityType(EntityType.House);
		houseData.setData(houseRefDataMap);
		
		return houseData;
	}

	public static EntityRefData<ZodiacDetails> createZodiacRefData(){
		
		EntityRefData<ZodiacDetails> zodiacData = new EntityRefData<ZodiacDetails>();
		Map<String, ZodiacDetails> zodiacRefDataMap = new HashMap<String, ZodiacDetails>(12);
		
		ZodiacDetails aries = new ZodiacDetails();
		aries.setElement(Element.Fire);
		aries.setGoal(Goal.Duty);
		aries.setRulingPlanet(Planet.MAR);
		aries.setClosestHouse(House.H1);
		aries.setGender(Gender.Male);
		aries.setEnvironment("Task oriented, workholic, task masters, non emotional");
	
		ZodiacDetails taurus = new ZodiacDetails();
		taurus.setElement(Element.Earth);
		taurus.setGoal(Goal.Wealth);
		taurus.setRulingPlanet(Planet.VEN);
		taurus.setClosestHouse(House.H2);
		taurus.setGender(Gender.Female);
		taurus.setEnvironment("Show love by working hard, Good financial capability");

		ZodiacDetails gemini = new ZodiacDetails();
		gemini.setElement(Element.Air);
		gemini.setGoal(Goal.Pleasure);
		gemini.setRulingPlanet(Planet.MER);
		gemini.setClosestHouse(House.H3);
		gemini.setEnvironment("Diversity in putting minds in different directions, Variety");

		ZodiacDetails cancer = new ZodiacDetails();
		cancer.setElement(Element.Water);
		cancer.setGoal(Goal.Spiritual);
		cancer.setRulingPlanet(Planet.MON);
		cancer.setClosestHouse(House.H4);
		cancer.setGender(Gender.Female);
		cancer.setEnvironment("Caring nature, Emotional");
	
	
		ZodiacDetails leo = new ZodiacDetails();
		leo.setElement(Element.Fire);
		leo.setGoal(Goal.Duty);
		leo.setRulingPlanet(Planet.SUN);
		leo.setClosestHouse(House.H5);
		leo.setGender(Gender.Male);
		leo.setEnvironment("Command, Center of attraction/power");
	
		ZodiacDetails virgo = new ZodiacDetails();
		virgo.setElement(Element.Earth);
		virgo.setGoal(Goal.Wealth);
		virgo.setRulingPlanet(Planet.MER);
		virgo.setClosestHouse(House.H6);
		virgo.setGender(Gender.Female);
		virgo.setEnvironment("Hardworker, focussed on one thing");
	
		ZodiacDetails libra = new ZodiacDetails();
		libra.setElement(Element.Air);
		libra.setGoal(Goal.Pleasure);
		libra.setRulingPlanet(Planet.VEN);
		libra.setClosestHouse(House.H7);
		libra.setGender(Gender.Male);
		libra.setEnvironment("Business bent of mind with enjoyment");
	
		ZodiacDetails scorpio = new ZodiacDetails();
		scorpio.setElement(Element.Water);
		scorpio.setGoal(Goal.Spiritual);
		scorpio.setRulingPlanet(Planet.MAR);
		scorpio.setClosestHouse(House.H8);
		scorpio.setGender(Gender.Female);
		scorpio.setEnvironment("Contradictions, Deep thinking");
	
		ZodiacDetails sagitarius = new ZodiacDetails();
		sagitarius.setElement(Element.Fire);
		sagitarius.setGoal(Goal.Duty);
		sagitarius.setRulingPlanet(Planet.JUP);
		sagitarius.setClosestHouse(House.H9);
		sagitarius.setGender(Gender.Male);
		sagitarius.setEnvironment("Philospher");
	
		ZodiacDetails capricon = new ZodiacDetails();
		capricon.setElement(Element.Earth);
		capricon.setGoal(Goal.Wealth);
		capricon.setRulingPlanet(Planet.SAT);
		capricon.setClosestHouse(House.H10);
		capricon.setGender(Gender.Female);
		capricon.setEnvironment("Real hardworker");
	
		ZodiacDetails aquarius = new ZodiacDetails();
		aquarius.setElement(Element.Air);
		aquarius.setGoal(Goal.Pleasure);
		aquarius.setRulingPlanet(Planet.SAT);
		aquarius.setClosestHouse(House.H11);
		aquarius.setGender(Gender.Male);
		aquarius.setEnvironment("Ability to influence others, Get things done");
	
		ZodiacDetails pisces = new ZodiacDetails();
		pisces.setElement(Element.Water);
		pisces.setGoal(Goal.Spiritual);
		pisces.setRulingPlanet(Planet.JUP);
		pisces.setClosestHouse(House.H12);
		pisces.setGender(Gender.Female);
		pisces.setEnvironment("Investigating sprituality as hidden talent, Dreamer");
		
		zodiacRefDataMap.put(Zodiac.ARE.name(), aries);
		zodiacRefDataMap.put(Zodiac.TAU.name(), taurus);
		zodiacRefDataMap.put(Zodiac.GEM.name(), gemini);
		zodiacRefDataMap.put(Zodiac.CAN.name(), cancer);
		zodiacRefDataMap.put(Zodiac.LEO.name(), leo);
		zodiacRefDataMap.put(Zodiac.VIR.name(), virgo);
		zodiacRefDataMap.put(Zodiac.LIB.name(), libra);
		zodiacRefDataMap.put(Zodiac.SCO.name(), scorpio);
		zodiacRefDataMap.put(Zodiac.SAG.name(), sagitarius);
		zodiacRefDataMap.put(Zodiac.CAP.name(), capricon);
		zodiacRefDataMap.put(Zodiac.AQU.name(), aquarius);
		zodiacRefDataMap.put(Zodiac.PIS.name(), pisces);
		
		zodiacData.setEntityType(EntityType.Zodiac);
		zodiacData.setData(zodiacRefDataMap);
		
		return zodiacData;
	}
	
	public static Map<PlanetAge, List<Planet>> createPlanetAgeToPlanetMatrix(){
		
		Map<PlanetAge, List<Planet>> planetAgeToPlanetMap = new HashMap<PlanetAge, List<Planet>>();
		

        List<Planet> planetsGoodForTeenAge = new ArrayList<Planet>();
        planetsGoodForTeenAge.add(Planet.MON);
        planetsGoodForTeenAge.add(Planet.MER);
        
        List<Planet> planetsGoodForYoungAge = new ArrayList<Planet>();
        planetsGoodForYoungAge.add(Planet.MAR);
        planetsGoodForYoungAge.add(Planet.VEN);
        
        List<Planet> planetsGoodForMatureAge = new ArrayList<Planet>();
        planetsGoodForMatureAge.add(Planet.SAT);
        planetsGoodForMatureAge.add(Planet.SUN);
        planetsGoodForMatureAge.add(Planet.JUP);
        
        List<Planet> planetsGoodForOldAge = new ArrayList<Planet>();
        planetsGoodForOldAge.add(Planet.SAT);
        planetsGoodForOldAge.add(Planet.RAH);
        planetsGoodForOldAge.add(Planet.KET);

        planetAgeToPlanetMap.put(PlanetAge.Teen, planetsGoodForTeenAge);
        planetAgeToPlanetMap.put(PlanetAge.Young, planetsGoodForYoungAge);
        planetAgeToPlanetMap.put(PlanetAge.Mature, planetsGoodForMatureAge);
        planetAgeToPlanetMap.put(PlanetAge.Old, planetsGoodForOldAge);
		
        return planetAgeToPlanetMap;
	}
	
	public static EntityRefData<Planet> createNakshatraLordsRefData(){
		
		EntityRefData<Planet> nakshatraData = new EntityRefData<Planet>();
		Map<String, Planet> nakshatraRefDataMap = new HashMap<String, Planet>(27);

		nakshatraRefDataMap.put(Nakshatra.Aswini.name(), Planet.KET);
		nakshatraRefDataMap.put(Nakshatra.Bharani.name(), Planet.VEN);
		nakshatraRefDataMap.put(Nakshatra.Krithika.name(), Planet.SUN);
		nakshatraRefDataMap.put(Nakshatra.Rohini.name(), Planet.MON);
		nakshatraRefDataMap.put(Nakshatra.Mrigashiras.name(), Planet.MAR);
		nakshatraRefDataMap.put(Nakshatra.Arudra.name(), Planet.RAH);
		nakshatraRefDataMap.put(Nakshatra.Punarvasu.name(), Planet.JUP);
		nakshatraRefDataMap.put(Nakshatra.Pushyami.name(), Planet.SAT);
		nakshatraRefDataMap.put(Nakshatra.Ashlesha.name(), Planet.MER);
		
		nakshatraRefDataMap.put(Nakshatra.Magha.name(), Planet.KET);
		nakshatraRefDataMap.put(Nakshatra.PoorvaPhalguni.name(), Planet.VEN);
		nakshatraRefDataMap.put(Nakshatra.UthraPhalguni.name(), Planet.SUN);
		nakshatraRefDataMap.put(Nakshatra.Hastha.name(), Planet.MON);
		nakshatraRefDataMap.put(Nakshatra.Chitra.name(), Planet.MAR);
		nakshatraRefDataMap.put(Nakshatra.Swaathi.name(), Planet.RAH);
		nakshatraRefDataMap.put(Nakshatra.Vishaakha.name(), Planet.JUP);
		nakshatraRefDataMap.put(Nakshatra.Anuraadha.name(), Planet.SAT);
		nakshatraRefDataMap.put(Nakshatra.Jyeshta.name(), Planet.MER);
		
		nakshatraRefDataMap.put(Nakshatra.Moola.name(), Planet.KET);
		nakshatraRefDataMap.put(Nakshatra.PoorvaShaada.name(), Planet.VEN);
		nakshatraRefDataMap.put(Nakshatra.UthraShaada.name(), Planet.SUN);
		nakshatraRefDataMap.put(Nakshatra.Shraavan.name(), Planet.MON);
		nakshatraRefDataMap.put(Nakshatra.Dhanishta.name(), Planet.MAR);
		nakshatraRefDataMap.put(Nakshatra.Shathabhisha.name(), Planet.RAH);
		nakshatraRefDataMap.put(Nakshatra.PoorvaBhadra.name(), Planet.JUP);
		nakshatraRefDataMap.put(Nakshatra.UthraBhadra.name(), Planet.SAT);
		nakshatraRefDataMap.put(Nakshatra.Revathi.name(), Planet.MER);
		
		nakshatraData.setData(nakshatraRefDataMap);
	
		return nakshatraData;
}

	public static Map<Zodiac,Map<ZodiacDegreeRange,Nakshatra>> createNakshatraRefData(){
		
		Map<Zodiac,Map<ZodiacDegreeRange,Nakshatra>> zodiacNakshatraRefDataMap = new HashMap<Zodiac,Map<ZodiacDegreeRange,Nakshatra>>(12);
	
		Map<ZodiacDegreeRange,Nakshatra> areMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		areMap.put(new ZodiacDegreeRange(0.0, 13.2), Nakshatra.Aswini);
		areMap.put(new ZodiacDegreeRange(13.2, 26.4), Nakshatra.Bharani);
		areMap.put(new ZodiacDegreeRange(26.4, 30.0), Nakshatra.Krithika);
		
		Map<ZodiacDegreeRange,Nakshatra> tauMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		tauMap.put(new ZodiacDegreeRange(0.0, 10.0), Nakshatra.Krithika);
		tauMap.put(new ZodiacDegreeRange(10.0, 23.2), Nakshatra.Rohini);
		tauMap.put(new ZodiacDegreeRange(23.2, 30.0), Nakshatra.Mrigashiras);
		
		Map<ZodiacDegreeRange,Nakshatra> gemMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		gemMap.put(new ZodiacDegreeRange(0.0, 6.4), Nakshatra.Mrigashiras);
		gemMap.put(new ZodiacDegreeRange(6.4, 20.0), Nakshatra.Arudra);
		gemMap.put(new ZodiacDegreeRange(20.0, 30.0), Nakshatra.Punarvasu);
		
		Map<ZodiacDegreeRange,Nakshatra> canMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		canMap.put(new ZodiacDegreeRange(0.0, 3.2), Nakshatra.Punarvasu);
		canMap.put(new ZodiacDegreeRange(3.2, 16.4), Nakshatra.Pushyami);
		canMap.put(new ZodiacDegreeRange(16.4, 30.0), Nakshatra.Ashlesha);
		
		Map<ZodiacDegreeRange,Nakshatra> leoMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		leoMap.put(new ZodiacDegreeRange(0.0, 13.2), Nakshatra.Magha);
		leoMap.put(new ZodiacDegreeRange(13.2, 26.4), Nakshatra.PoorvaPhalguni);
		leoMap.put(new ZodiacDegreeRange(26.4, 30.0), Nakshatra.UthraPhalguni);
		
		Map<ZodiacDegreeRange,Nakshatra> virMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		virMap.put(new ZodiacDegreeRange(0.0, 10.0), Nakshatra.UthraPhalguni);
		virMap.put(new ZodiacDegreeRange(10.0, 23.2), Nakshatra.Hastha);
		virMap.put(new ZodiacDegreeRange(23.2, 30.0), Nakshatra.Chitra);
		
		Map<ZodiacDegreeRange,Nakshatra> libMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		libMap.put(new ZodiacDegreeRange(0.0, 6.4), Nakshatra.Chitra);
		libMap.put(new ZodiacDegreeRange(6.4, 20.0), Nakshatra.Swaathi);
		libMap.put(new ZodiacDegreeRange(20.0, 30.0), Nakshatra.Vishaakha);
		
		Map<ZodiacDegreeRange,Nakshatra> scoMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		scoMap.put(new ZodiacDegreeRange(0.0, 3.2), Nakshatra.Vishaakha);
		scoMap.put(new ZodiacDegreeRange(3.2, 16.4), Nakshatra.Anuraadha);
		scoMap.put(new ZodiacDegreeRange(16.4, 30.0), Nakshatra.Jyeshta);
	
		Map<ZodiacDegreeRange,Nakshatra> sagMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		sagMap.put(new ZodiacDegreeRange(0.0, 13.2), Nakshatra.Moola);
		sagMap.put(new ZodiacDegreeRange(13.2, 26.4), Nakshatra.PoorvaShaada);
		sagMap.put(new ZodiacDegreeRange(26.4, 30.0), Nakshatra.UthraShaada);
		
		Map<ZodiacDegreeRange,Nakshatra> capMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		capMap.put(new ZodiacDegreeRange(0.0, 10.0), Nakshatra.UthraShaada);
		capMap.put(new ZodiacDegreeRange(10.0, 23.2), Nakshatra.Shraavan);
		capMap.put(new ZodiacDegreeRange(23.2, 30.0), Nakshatra.Dhanishta);
		
		Map<ZodiacDegreeRange,Nakshatra> aquMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		aquMap.put(new ZodiacDegreeRange(0.0, 6.4), Nakshatra.Dhanishta);
		aquMap.put(new ZodiacDegreeRange(6.4, 20.0), Nakshatra.Shathabhisha);
		aquMap.put(new ZodiacDegreeRange(20.0, 30.0), Nakshatra.PoorvaBhadra);
		
		Map<ZodiacDegreeRange,Nakshatra> pisMap = new HashMap<ZodiacDegreeRange,Nakshatra>(3);
		pisMap.put(new ZodiacDegreeRange(0.0, 3.2), Nakshatra.PoorvaBhadra);
		pisMap.put(new ZodiacDegreeRange(3.2, 16.4), Nakshatra.UthraBhadra);
		pisMap.put(new ZodiacDegreeRange(16.4, 30.0), Nakshatra.Revathi);
		
		
		zodiacNakshatraRefDataMap.put(Zodiac.ARE, areMap);
		zodiacNakshatraRefDataMap.put(Zodiac.AQU, aquMap);
		zodiacNakshatraRefDataMap.put(Zodiac.CAN, canMap);
		zodiacNakshatraRefDataMap.put(Zodiac.CAP, capMap);
		zodiacNakshatraRefDataMap.put(Zodiac.GEM, gemMap);
		zodiacNakshatraRefDataMap.put(Zodiac.LEO, leoMap);
		zodiacNakshatraRefDataMap.put(Zodiac.LIB, libMap);
		zodiacNakshatraRefDataMap.put(Zodiac.PIS, pisMap);
		zodiacNakshatraRefDataMap.put(Zodiac.SAG, sagMap);
		zodiacNakshatraRefDataMap.put(Zodiac.SCO, scoMap);
		zodiacNakshatraRefDataMap.put(Zodiac.TAU, tauMap);
		zodiacNakshatraRefDataMap.put(Zodiac.VIR, virMap);
		
		return zodiacNakshatraRefDataMap;
 }
	
	
	public static Map<Zodiac,Map<ZodiacDegreeRange,Zodiac>> createNakshatraSubLordsRefData(){
		
		Map<Zodiac,Map<ZodiacDegreeRange,Zodiac>> zodiacNakshatraSubLordsRefDataMap = new HashMap<Zodiac,Map<ZodiacDegreeRange,Zodiac>>(12);
	
		Map<ZodiacDegreeRange,Zodiac> areMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		areMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.ARE);
		areMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.TAU);
		areMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.GEM);
		areMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAN);
		
		areMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.LEO);
		areMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.VIR);
		areMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.LIB);
		areMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.SCO);
		
		areMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.SAG);
		
		
		Map<ZodiacDegreeRange,Zodiac> tauMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		
		tauMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAP);
		tauMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.AQU);
		tauMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.PIS);
		tauMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.ARE);
		
		tauMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.TAU);
		tauMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.GEM);
		tauMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAN);
		tauMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.LEO);
		
		tauMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.VIR);
		
		Map<ZodiacDegreeRange,Zodiac> gemMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		gemMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.LIB);
		gemMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.SCO);
		gemMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.SAG);
		gemMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAP);
		
		gemMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.AQU);
		gemMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.PIS);
		gemMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.ARE);
		gemMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.TAU);
		
		gemMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.GEM);
		
		Map<ZodiacDegreeRange,Zodiac> canMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		canMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAN);
		canMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.LEO);
		canMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.VIR);
		canMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.LIB);
		
		canMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.SCO);
		canMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.SAG);
		canMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAP);
		canMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.AQU);
		
		canMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.PIS);
		
		Map<ZodiacDegreeRange,Zodiac> leoMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		leoMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.ARE);
		leoMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.TAU);
		leoMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.GEM);
		leoMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAN);
		
		leoMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.LEO);
		leoMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.VIR);
		leoMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.LIB);
		leoMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.SCO);
		
		leoMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.SAG);
		
		
		Map<ZodiacDegreeRange,Zodiac> virMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		
		virMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAP);
		virMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.AQU);
		virMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.PIS);
		virMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.ARE);
		
		virMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.TAU);
		virMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.GEM);
		virMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAN);
		virMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.LEO);
		
		virMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.VIR);
		
		Map<ZodiacDegreeRange,Zodiac> libMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		libMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.LIB);
		libMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.SCO);
		libMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.SAG);
		libMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAP);
		
		libMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.AQU);
		libMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.PIS);
		libMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.ARE);
		libMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.TAU);
		
		libMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.GEM);
		
		Map<ZodiacDegreeRange,Zodiac> scoMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		scoMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAN);
		scoMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.LEO);
		scoMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.VIR);
		scoMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.LIB);
		
		scoMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.SCO);
		scoMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.SAG);
		scoMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAP);
		scoMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.AQU);
		
		scoMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.PIS);
		
		Map<ZodiacDegreeRange,Zodiac> sagMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		sagMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.ARE);
		sagMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.TAU);
		sagMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.GEM);
		sagMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAN);
		
		sagMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.LEO);
		sagMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.VIR);
		sagMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.LIB);
		sagMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.SCO);
		
		sagMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.SAG);
		
		
		Map<ZodiacDegreeRange,Zodiac> capMap = new HashMap<ZodiacDegreeRange,Zodiac>();
		
		capMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAP);
		capMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.AQU);
		capMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.PIS);
		capMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.ARE);
		
		capMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.TAU);
		capMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.GEM);
		capMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAN);
		capMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.LEO);
		
		capMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.VIR);
		
		Map<ZodiacDegreeRange,Zodiac> aquMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		aquMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.LIB);
		aquMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.SCO);
		aquMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.SAG);
		aquMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.CAP);
		
		aquMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.AQU);
		aquMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.PIS);
		aquMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.ARE);
		aquMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.TAU);
		
		aquMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.GEM);
		
		Map<ZodiacDegreeRange,Zodiac> pisMap = new HashMap<ZodiacDegreeRange,Zodiac>();

		pisMap.put(new ZodiacDegreeRange(0.0, 3.2), Zodiac.CAN);
		pisMap.put(new ZodiacDegreeRange(3.2, 6.4), Zodiac.LEO);
		pisMap.put(new ZodiacDegreeRange(6.4, 10.0), Zodiac.VIR);
		pisMap.put(new ZodiacDegreeRange(10.0, 13.2), Zodiac.LIB);
		
		pisMap.put(new ZodiacDegreeRange(13.2, 16.4), Zodiac.SCO);
		pisMap.put(new ZodiacDegreeRange(16.4, 20.0), Zodiac.SAG);
		pisMap.put(new ZodiacDegreeRange(20.0, 23.2), Zodiac.CAP);
		pisMap.put(new ZodiacDegreeRange(23.2, 26.4), Zodiac.AQU);
		
		pisMap.put(new ZodiacDegreeRange(26.4, 30.0), Zodiac.PIS);
						
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.ARE, areMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.AQU, aquMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.CAN, canMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.CAP, capMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.GEM, gemMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.LEO, leoMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.LIB, libMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.PIS, pisMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.SAG, sagMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.SCO, scoMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.TAU, tauMap);
		zodiacNakshatraSubLordsRefDataMap.put(Zodiac.VIR, virMap);
		
		return zodiacNakshatraSubLordsRefDataMap;
 }
	
	public static Map<Planet, Dasha> createPlanetToDashaMap(){
		
		Map<Planet, Dasha> planetToDashaMap = new HashMap<Planet, Dasha>();
		
		planetToDashaMap.put(Planet.JUP,Dasha.JUPITER);
		planetToDashaMap.put(Planet.KET,Dasha.KETU);
		planetToDashaMap.put(Planet.MAR,Dasha.MARS);
		planetToDashaMap.put(Planet.MER,Dasha.MERCURY);
		planetToDashaMap.put(Planet.MON,Dasha.MOON);
		planetToDashaMap.put(Planet.RAH,Dasha.RAHU);
		planetToDashaMap.put(Planet.SAT,Dasha.SATURN);
		planetToDashaMap.put(Planet.SUN,Dasha.SUN);
		planetToDashaMap.put(Planet.VEN,Dasha.VENUS);
		
		return planetToDashaMap;
		
	}

	public static Map<Dasha, Planet> createDashaToPlanetMap(){
		
		Map<Dasha, Planet> dashaToPlanetMap = new HashMap<Dasha, Planet>();
		
		dashaToPlanetMap.put(Dasha.JUPITER, Planet.JUP);
		dashaToPlanetMap.put(Dasha.KETU, Planet.KET);
		dashaToPlanetMap.put(Dasha.MARS, Planet.MAR);
		dashaToPlanetMap.put(Dasha.MERCURY, Planet.MER);
		dashaToPlanetMap.put(Dasha.MOON, Planet.MON);
		dashaToPlanetMap.put(Dasha.RAHU, Planet.RAH);
		dashaToPlanetMap.put(Dasha.SATURN, Planet.SAT);
		dashaToPlanetMap.put(Dasha.SUN, Planet.SUN);
		dashaToPlanetMap.put(Dasha.VENUS, Planet.VEN);
		
		return dashaToPlanetMap;
		
	}
	
		
	public static Map<Planet,Map<Integer, Double>> getDailyMotionDegreesData(){
		Map<Planet,Map<Integer, Double>> dailyMotionDegreesMap = new HashMap<Planet,Map<Integer, Double>>();
		
		Map<Integer, Double> sunMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> marMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> monMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> jupMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> satMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> merMotionData = new HashMap<Integer, Double>();
		Map<Integer, Double> venMotionData = new HashMap<Integer, Double>();
		
		sunMotionData.put(1, 0.9856);
		sunMotionData.put(2, 1.9712);
		sunMotionData.put(3, 2.9568);
		sunMotionData.put(4, 3.9424);
		sunMotionData.put(5, 4.9280);
		sunMotionData.put(6, 5.9136);
		sunMotionData.put(7, 6.8992);
		sunMotionData.put(8, 7.8848);
		sunMotionData.put(9, 8.8704);

		sunMotionData.put(10, 9.856);
		sunMotionData.put(20, 19.712);
		sunMotionData.put(30, 29.568);
		sunMotionData.put(40, 39.424);
		sunMotionData.put(50, 49.280);
		sunMotionData.put(60, 59.136);
		sunMotionData.put(70, 68.992);
		sunMotionData.put(80, 78.848);
		sunMotionData.put(90, 88.704);

		sunMotionData.put(100, 98.5602);
		sunMotionData.put(200, 197.1205);
		sunMotionData.put(300, 295.6808);
		sunMotionData.put(400, 34.2411);
		sunMotionData.put(500, 132.8013);
		sunMotionData.put(600, 231.3616);
		sunMotionData.put(700, 329.9218);
		sunMotionData.put(800, 68.4821);
		sunMotionData.put(900, 167.0424);
		
		sunMotionData.put(1000, 265.6026);
		sunMotionData.put(2000, 171.2053);
		sunMotionData.put(3000, 76.8080);
		sunMotionData.put(4000, 342.4106);
		sunMotionData.put(5000, 248.0133);
		sunMotionData.put(6000, 153.6159);
		sunMotionData.put(7000, 59.2186);
		sunMotionData.put(8000, 324.8212);
		sunMotionData.put(9000, 230.4239);
		
		sunMotionData.put(10000, 136.0265);
		sunMotionData.put(20000, 272.0531);
		sunMotionData.put(30000, 48.0796);
		sunMotionData.put(40000, 184.1062);
		sunMotionData.put(50000, 320.1327);
		sunMotionData.put(60000, 96.1593);
		sunMotionData.put(70000, 232.1868);
		sunMotionData.put(80000, 8.2124);
		sunMotionData.put(90000, 144.2389);
		
		marMotionData.put(1, 0.524);
		marMotionData.put(2, 1.048);
		marMotionData.put(3, 1.572);
		marMotionData.put(4, 2.096);
		marMotionData.put(5, 2.620);
		marMotionData.put(6, 3.144);
		marMotionData.put(7, 3.668);
		marMotionData.put(8, 4.192);
		marMotionData.put(9, 4.716);

		marMotionData.put(10, 5.24);
		marMotionData.put(20, 10.48);
		marMotionData.put(30, 15.72);
		marMotionData.put(40, 20.96);
		marMotionData.put(50, 26.20);
		marMotionData.put(60, 31.44);
		marMotionData.put(70, 36.68);
		marMotionData.put(80, 41.92);
		marMotionData.put(90, 47.16);
		
		marMotionData.put(100, 52.40);
		marMotionData.put(200, 104.80);
		marMotionData.put(300, 157.21);
		marMotionData.put(400, 209.61);
		marMotionData.put(500, 262.01);
		marMotionData.put(600, 314.41);
		marMotionData.put(700, 6.81);
		marMotionData.put(800, 59.22);
		marMotionData.put(900, 111.62);
		
		marMotionData.put(1000, 164.02);
		marMotionData.put(2000, 328.04);
		marMotionData.put(3000, 132.06);
		marMotionData.put(4000, 296.08);
		marMotionData.put(5000, 100.10);
		marMotionData.put(6000, 264.12);
		marMotionData.put(7000, 68.14);
		marMotionData.put(8000, 232.15);
		marMotionData.put(9000, 36.17);
		
		marMotionData.put(10000, 200.19);
		marMotionData.put(20000, 40.39);
		marMotionData.put(30000, 240.58);
		marMotionData.put(40000, 80.78);
		marMotionData.put(50000, 280.97);
		marMotionData.put(60000, 121.16);
		marMotionData.put(70000, 321.36);
		marMotionData.put(80000, 161.55);
		marMotionData.put(90000, 1.74);
		
		jupMotionData.put(1, 0.08);
		jupMotionData.put(2, 0.17);
		jupMotionData.put(3, 0.25);
		jupMotionData.put(4, 0.33);
		jupMotionData.put(5, 0.41);
		jupMotionData.put(6, 0.50);
		jupMotionData.put(7, 0.58);
		jupMotionData.put(8, 0.66);
		jupMotionData.put(9, 0.75);
		
		jupMotionData.put(10, 0.83);
		jupMotionData.put(20, 1.66);
		jupMotionData.put(30, 2.49);
		jupMotionData.put(40, 3.32);
		jupMotionData.put(50, 4.15);
		jupMotionData.put(60, 4.99);
		jupMotionData.put(70, 5.82);
		jupMotionData.put(80, 6.65);
		jupMotionData.put(90, 7.48);
		
		jupMotionData.put(100, 8.31);
		jupMotionData.put(200, 16.62);
		jupMotionData.put(300, 24.93);
		jupMotionData.put(400, 33.24);
		jupMotionData.put(500, 41.55);
		jupMotionData.put(600, 49.86);
		jupMotionData.put(700, 58.17);
		jupMotionData.put(800, 66.48);
		jupMotionData.put(900, 74.79);
		
		jupMotionData.put(1000, 83.1);
		jupMotionData.put(2000, 166.19);
		jupMotionData.put(3000, 249.29);
		jupMotionData.put(4000, 332.39);
		jupMotionData.put(5000, 55.48);
		jupMotionData.put(6000, 138.58);
		jupMotionData.put(7000, 221.67);
		jupMotionData.put(8000, 304.77);
		jupMotionData.put(9000, 27.87);
		
		jupMotionData.put(10000, 110.96);
		jupMotionData.put(20000, 221.93);
		jupMotionData.put(30000, 332.89);
		jupMotionData.put(40000, 83.85);
		jupMotionData.put(50000, 194.82);
		jupMotionData.put(60000, 305.78);
		jupMotionData.put(70000, 56.74);
		jupMotionData.put(80000, 167.71);
		jupMotionData.put(90000, 278.67);

		satMotionData.put(1, 0.03);
		satMotionData.put(2, 0.07);
		satMotionData.put(3, 0.10);
		satMotionData.put(4, 0.13);
		satMotionData.put(5, 0.17);
		satMotionData.put(6, 0.20);
		satMotionData.put(7, 0.23);
		satMotionData.put(8, 0.27);
		satMotionData.put(9, 0.30);
		
		satMotionData.put(10, 0.33);
		satMotionData.put(20, 0.67);
		satMotionData.put(30, 1.00);
		satMotionData.put(40, 1.34);
		satMotionData.put(50, 1.67);
		satMotionData.put(60, 2.01);
		satMotionData.put(70, 2.34);
		satMotionData.put(80, 2.68);
		satMotionData.put(90, 3.01);
		
		satMotionData.put(100, 3.34);
		satMotionData.put(200, 6.69);
		satMotionData.put(300, 10.03);
		satMotionData.put(400, 13.38);
		satMotionData.put(500, 16.72);
		satMotionData.put(600, 20.06);
		satMotionData.put(700, 23.41);
		satMotionData.put(800, 26.75);
		satMotionData.put(900, 30.10);
	
		satMotionData.put(1000, 33.44);
		satMotionData.put(2000, 66.88);
		satMotionData.put(3000, 100.32);
		satMotionData.put(4000, 133.76);
		satMotionData.put(5000, 167.20);
		satMotionData.put(6000, 200.64);
		satMotionData.put(7000, 234.08);
		satMotionData.put(8000, 267.51);
		satMotionData.put(9000, 300.95);
		
		satMotionData.put(10000, 334.39);
		satMotionData.put(20000, 308.79);
		satMotionData.put(30000, 283.18);
		satMotionData.put(40000, 257.57);
		satMotionData.put(50000, 231.97);
		satMotionData.put(60000, 206.36);
		satMotionData.put(70000, 180.75);
		satMotionData.put(80000, 155.14);
		satMotionData.put(90000, 129.54);
		
		merMotionData.put(1, 4.09);
		merMotionData.put(2, 8.18);
		merMotionData.put(3, 12.28);
		merMotionData.put(4, 16.37);
		merMotionData.put(5, 20.46);
		merMotionData.put(6, 24.55);
		merMotionData.put(7, 28.65);
		merMotionData.put(8, 32.74);
		merMotionData.put(9, 36.83);
		
		merMotionData.put(10, 40.92);
		merMotionData.put(20, 81.84);
		merMotionData.put(30, 122.77);
		merMotionData.put(40, 163.69);
		merMotionData.put(50, 204.62);
		merMotionData.put(60, 245.54);
		merMotionData.put(70, 286.46);
		merMotionData.put(80, 327.38);
		merMotionData.put(90, 8.31);
		
		merMotionData.put(100, 49.23);
		merMotionData.put(200, 98.46);
		merMotionData.put(300, 147.70);
		merMotionData.put(400, 196.93);
		merMotionData.put(500, 246.16);
		merMotionData.put(600, 295.39);
		merMotionData.put(700, 344.62);
		merMotionData.put(800, 33.85);
		merMotionData.put(900, 83.09);
	
		merMotionData.put(1000, 132.32);
		merMotionData.put(2000, 264.64);
		merMotionData.put(3000, 36.95);
		merMotionData.put(4000, 169.27);
		merMotionData.put(5000, 301.59);
		merMotionData.put(6000, 73.91);
		merMotionData.put(7000, 206.23);
		merMotionData.put(8000, 338.54);
		merMotionData.put(9000, 110.86);
		
		merMotionData.put(10000, 243.18);
		merMotionData.put(20000, 126.36);
		merMotionData.put(30000, 9.54);
		merMotionData.put(40000, 252.72);
		merMotionData.put(50000, 135.90);
		merMotionData.put(60000, 19.08);
		merMotionData.put(70000, 262.26);
		merMotionData.put(80000, 145.44);
		merMotionData.put(90000, 28.63);
		
		venMotionData.put(1, 1.60);
		venMotionData.put(2, 3.20);
		venMotionData.put(3, 4.81);
		venMotionData.put(4, 6.41);
		venMotionData.put(5, 8.01);
		venMotionData.put(6, 9.61);
		venMotionData.put(7, 11.21);
		venMotionData.put(8, 12.82);
		venMotionData.put(9, 14.42);
		
		venMotionData.put(10, 16.02);
		venMotionData.put(20, 32.04);
		venMotionData.put(30, 48.06);
		venMotionData.put(40, 64.09);
		venMotionData.put(50, 80.11);
		venMotionData.put(60, 96.13);
		venMotionData.put(70, 112.15);
		venMotionData.put(80, 128.17);
		venMotionData.put(90, 144.19);
		
		venMotionData.put(100, 160.21);
		venMotionData.put(200, 320.43);
		venMotionData.put(300, 120.64);
		venMotionData.put(400, 280.86);
		venMotionData.put(500, 81.07);
		venMotionData.put(600, 241.29);
		venMotionData.put(700, 41.50);
		venMotionData.put(800, 201.72);
		venMotionData.put(900, 1.93);
	
		venMotionData.put(1000, 162.15);
		venMotionData.put(2000, 324.29);
		venMotionData.put(3000, 126.44);
		venMotionData.put(4000, 288.59);
		venMotionData.put(5000, 90.73);
		venMotionData.put(6000, 252.88);
		venMotionData.put(7000, 55.02);
		venMotionData.put(8000, 217.17);
		venMotionData.put(9000, 19.32);
		
		venMotionData.put(10000, 181.46);
		venMotionData.put(20000, 2.93);
		venMotionData.put(30000, 184.39);
		venMotionData.put(40000, 5.86);
		venMotionData.put(50000, 187.32);
		venMotionData.put(60000, 8.78);
		venMotionData.put(70000, 190.25);
		venMotionData.put(80000, 11.71);
		venMotionData.put(90000, 193.18);

		dailyMotionDegreesMap.put(Planet.SUN, sunMotionData);
		dailyMotionDegreesMap.put(Planet.MAR, marMotionData);
		dailyMotionDegreesMap.put(Planet.MON, monMotionData);
		dailyMotionDegreesMap.put(Planet.JUP, jupMotionData);
		dailyMotionDegreesMap.put(Planet.SAT, satMotionData);
		dailyMotionDegreesMap.put(Planet.MER, merMotionData);
		dailyMotionDegreesMap.put(Planet.VEN, venMotionData);
		
		return dailyMotionDegreesMap;
	}
	
	public static Map<CharaKaraka,List<House>> getCharaKarakaHouseMapping(){
		Map<CharaKaraka,List<House>> charaKarakaHouseMapping = 
				new HashMap<CharaKaraka,List<House>>();
		
		List<House> atmakarakaHouses = new ArrayList<House>();
		atmakarakaHouses.add(House.H1);
		
		List<House> amatyaKarakaHouses = new ArrayList<House>();
		amatyaKarakaHouses.add(House.H2);
		amatyaKarakaHouses.add(House.H10);
		
		List<House> bhratruKarakaHouses = new ArrayList<House>();
		bhratruKarakaHouses.add(House.H3);
		
		List<House> matruKarakaHouses = new ArrayList<House>();
		matruKarakaHouses.add(House.H4);
		
		List<House> putruKarakaHouses = new ArrayList<House>();
		putruKarakaHouses.add(House.H5);
		putruKarakaHouses.add(House.H9);
		
		List<House> gnatiKarakaHouses = new ArrayList<House>();
		gnatiKarakaHouses.add(House.H6);
		gnatiKarakaHouses.add(House.H8);
		gnatiKarakaHouses.add(House.H12);
		
		List<House> streeDaraKarakaHouses = new ArrayList<House>();
		streeDaraKarakaHouses.add(House.H7);
		
		charaKarakaHouseMapping.put(CharaKaraka.AtmaKarka, atmakarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.AmatyaKaraka, amatyaKarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.BhratruKaraka, bhratruKarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.MatruKaraka, matruKarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.PutraKaraka, putruKarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.GnatiKaraka, gnatiKarakaHouses);
		charaKarakaHouseMapping.put(CharaKaraka.StreeDaraKaraka, streeDaraKarakaHouses);
		
		return charaKarakaHouseMapping;
	}
	
	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD3(){

		Map<Zodiac, Map<ZodiacDegRange, Integer>> d3ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			
			Double degreeBreakup = MathUtil.round((30.0/3), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
		
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , 0);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, 2*degreeBreakup) , 5);
			zodiacChartMap.put(new ZodiacDegRange(2*degreeBreakup, 30.0) , 9);
			
			d3ChartMap.put(zodiac, zodiacChartMap);
		}
		
		
		return d3ChartMap;

	}

	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD4(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d4ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			
			Double degreeBreakup = MathUtil.round((30.0/4), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
		
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , 0);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, 2*degreeBreakup) , 4);
			zodiacChartMap.put(new ZodiacDegRange(2*degreeBreakup, 3*degreeBreakup) , 7);
			zodiacChartMap.put(new ZodiacDegRange(3*degreeBreakup, 30.0) , 10);
			
			d4ChartMap.put(zodiac, zodiacChartMap);
		}
		
		return d4ChartMap;		
	}
	
	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD5(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d5ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			int movtBy = 1;
			if(zodiac.getZodiacType().equals(ZodiacType.Movable)){
				movtBy = 1;
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Fixed)){
				movtBy = 5;
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Dual)){
				movtBy = 9;
			}
			Double degreeBreakup = MathUtil.round((30.0/5), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), 30.0) , movtBy+4);
			
			d5ChartMap.put(zodiac, zodiacChartMap);
		}
		return d5ChartMap;
	}

	
	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD7(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d7ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			int movtBy = 1;
			if(zodiac.isEven()){
				movtBy = 7;
			}
			Double degreeBreakup = MathUtil.round((30.0/7), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), MathUtil.round(5*degreeBreakup, 2)) , movtBy+4);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(5*degreeBreakup, 2), MathUtil.round(6*degreeBreakup, 2)) , movtBy+5);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(6*degreeBreakup, 2), 30.0) , movtBy+6);
			
			d7ChartMap.put(zodiac, zodiacChartMap);
		}
		return d7ChartMap;
	}

	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD10(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d10ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			int movtBy = 1;
			if(zodiac.isEven()){
				movtBy = 9;
			}
			Double degreeBreakup = MathUtil.round((30.0/10), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), MathUtil.round(5*degreeBreakup, 2)) , movtBy+4);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(5*degreeBreakup, 2), MathUtil.round(6*degreeBreakup, 2)) , movtBy+5);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(6*degreeBreakup, 2), MathUtil.round(7*degreeBreakup, 2)) , movtBy+6);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(7*degreeBreakup, 2), MathUtil.round(8*degreeBreakup, 2)) , movtBy+7);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(8*degreeBreakup, 2), MathUtil.round(9*degreeBreakup, 2)) , movtBy+8);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(9*degreeBreakup, 2), 30.0) , movtBy+9);
			
			d10ChartMap.put(zodiac, zodiacChartMap);
		}
		return d10ChartMap;
	}
	
	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD9(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d9ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			int movtBy = 1;
			if(zodiac.getZodiacType().equals(ZodiacType.Movable)){
				movtBy = 1;
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Fixed)){
				movtBy = 9;
			}
			else if(zodiac.getZodiacType().equals(ZodiacType.Dual)){
				movtBy = 5;
			}
			Double degreeBreakup = MathUtil.round((30.0/9), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), MathUtil.round(5*degreeBreakup, 2)) , movtBy+4);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(5*degreeBreakup, 2), MathUtil.round(6*degreeBreakup, 2)) , movtBy+5);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(6*degreeBreakup, 2), MathUtil.round(7*degreeBreakup, 2)) , movtBy+6);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(7*degreeBreakup, 2), MathUtil.round(8*degreeBreakup, 2)) , movtBy+7);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(8*degreeBreakup, 2), 30.0) , movtBy+8);
			
			
			d9ChartMap.put(zodiac, zodiacChartMap);
		}
		return d9ChartMap;
	}

	public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD12(){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d12ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			int movtBy = 1;
			
			Double degreeBreakup = MathUtil.round((30.0/12), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), MathUtil.round(5*degreeBreakup, 2)) , movtBy+4);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(5*degreeBreakup, 2), MathUtil.round(6*degreeBreakup, 2)) , movtBy+5);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(6*degreeBreakup, 2), MathUtil.round(7*degreeBreakup, 2)) , movtBy+6);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(7*degreeBreakup, 2), MathUtil.round(8*degreeBreakup, 2)) , movtBy+7);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(8*degreeBreakup, 2), MathUtil.round(9*degreeBreakup, 2)) , movtBy+8);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(9*degreeBreakup, 2), MathUtil.round(10*degreeBreakup, 2)) , movtBy+9);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(10*degreeBreakup, 2), MathUtil.round(11*degreeBreakup, 2)) , movtBy+10);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(11*degreeBreakup, 2), 30.0) , movtBy+11);
			
			d12ChartMap.put(zodiac, zodiacChartMap);
		}
		return d12ChartMap;
	}
	
    public static Map<Zodiac, Map<ZodiacDegRange, Integer>> createDivisionalChartRefDataForD16(Map<Zodiac, Integer> movtMap){
		
		Map<Zodiac, Map<ZodiacDegRange, Integer>> d16ChartMap = new LinkedHashMap<Zodiac, Map<ZodiacDegRange, Integer>>();
		
		for(Zodiac zodiac : Zodiac.values()){
			
			int movtBy = movtMap.get(zodiac);
			
			Double degreeBreakup = MathUtil.round((30.0/16), 2);
			Map<ZodiacDegRange, Integer> zodiacChartMap = new LinkedHashMap<ZodiacDegRange, Integer>();
			
			zodiacChartMap.put(new ZodiacDegRange(0.0, degreeBreakup) , movtBy);
			zodiacChartMap.put(new ZodiacDegRange(degreeBreakup, MathUtil.round(2*degreeBreakup, 2)) , movtBy+1);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(2*degreeBreakup, 2), MathUtil.round(3*degreeBreakup, 2)) , movtBy+2);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(3*degreeBreakup, 2), MathUtil.round(4*degreeBreakup, 2)) , movtBy+3);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(4*degreeBreakup, 2), MathUtil.round(5*degreeBreakup, 2)) , movtBy+4);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(5*degreeBreakup, 2), MathUtil.round(6*degreeBreakup, 2)) , movtBy+5);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(6*degreeBreakup, 2), MathUtil.round(7*degreeBreakup, 2)) , movtBy+6);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(7*degreeBreakup, 2), MathUtil.round(8*degreeBreakup, 2)) , movtBy+7);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(8*degreeBreakup, 2), MathUtil.round(9*degreeBreakup, 2)) , movtBy+8);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(9*degreeBreakup, 2), MathUtil.round(10*degreeBreakup, 2)) , movtBy+9);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(10*degreeBreakup, 2), MathUtil.round(11*degreeBreakup, 2)) , movtBy+10);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(11*degreeBreakup, 2), MathUtil.round(12*degreeBreakup, 2)) , movtBy+11);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(12*degreeBreakup, 2), MathUtil.round(13*degreeBreakup, 2)) , movtBy+12);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(13*degreeBreakup, 2), MathUtil.round(14*degreeBreakup, 2)) , movtBy+13);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(14*degreeBreakup, 2), MathUtil.round(15*degreeBreakup, 2)) , movtBy+14);
			zodiacChartMap.put(new ZodiacDegRange(MathUtil.round(15*degreeBreakup, 2), 30.0) , movtBy+15);
			
			d16ChartMap.put(zodiac, zodiacChartMap);
		}
		return d16ChartMap;
	}

	public static Map<BirthChartType, Map<Zodiac, Map<ZodiacDegRange, Integer>>> getAllMovtRules(Map<BirthChartType, Map<Zodiac, Integer>> movtMap){
		
		Map<BirthChartType, Map<Zodiac, Map<ZodiacDegRange, Integer>>> allMovtMap = new LinkedHashMap<BirthChartType, Map<Zodiac, Map<ZodiacDegRange, Integer>>>();
		
		allMovtMap.put(BirthChartType.D3, createDivisionalChartRefDataForD3());
		allMovtMap.put(BirthChartType.D4, createDivisionalChartRefDataForD4());
		allMovtMap.put(BirthChartType.D5, createDivisionalChartRefDataForD5());
		allMovtMap.put(BirthChartType.D7, createDivisionalChartRefDataForD7());
		allMovtMap.put(BirthChartType.D9, createDivisionalChartRefDataForD9());
		allMovtMap.put(BirthChartType.D10, createDivisionalChartRefDataForD10());
		allMovtMap.put(BirthChartType.D12, createDivisionalChartRefDataForD12());
		allMovtMap.put(BirthChartType.D16, createDivisionalChartRefDataForD16(movtMap.get(BirthChartType.D16)));
		
		return allMovtMap;
	}
}