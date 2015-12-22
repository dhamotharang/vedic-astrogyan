package com.vedic.astro.util;

import java.util.HashMap;
import java.util.Map;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.TransitImpact;
import com.vedic.astro.enums.TransitReference;
import com.vedic.astro.vo.TransitOutcome;

public class BaseTransitRefData {

	private static Map<Planet,Map<Integer,TransitOutcome>> transitOutcomes = new HashMap<Planet,Map<Integer,TransitOutcome>>();
	
	static{
		populateTransitRefDataFromMoon();
	}
	
	private static void populateTransitRefDataFromMoon() {
		
		Map<Integer,TransitOutcome> sunTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> monTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> jupTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> merTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> marTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> satTransitData = new HashMap<Integer, TransitOutcome>();
		Map<Integer,TransitOutcome> venTransitData = new HashMap<Integer, TransitOutcome>();
		
		sunTransitData.put(1, new TransitOutcome(TransitImpact.Bad, "Financial loss, many travels, discomfort",1,TransitReference.NatalMoon));
		sunTransitData.put(2, new TransitOutcome(TransitImpact.Bad, "Unhappiness, eye troubles, fear",2,TransitReference.NatalMoon));
		sunTransitData.put(3, new TransitOutcome(TransitImpact.Good, "Wealth, good health, victory",3,TransitReference.NatalMoon));
		sunTransitData.put(4, new TransitOutcome(TransitImpact.Bad, "Marital disharmony, loss of name",4,TransitReference.NatalMoon));
		sunTransitData.put(5, new TransitOutcome(TransitImpact.Bad, "Bad health, fear from enemies",5,TransitReference.NatalMoon));
		sunTransitData.put(6, new TransitOutcome(TransitImpact.Good, "Success over enemies, good health",6,TransitReference.NatalMoon));
		sunTransitData.put(7, new TransitOutcome(TransitImpact.Bad, "Travels, physical pain",7,TransitReference.NatalMoon));
		sunTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Disease, setbacks in marriage",8,TransitReference.NatalMoon));
		sunTransitData.put(9, new TransitOutcome(TransitImpact.Bad, "Mental worries, obstacles",9,TransitReference.NatalMoon));
		sunTransitData.put(10, new TransitOutcome(TransitImpact.Good, "Success, honors, gains",10,TransitReference.NatalMoon));
		sunTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Good health, prosperity, honors",11,TransitReference.NatalMoon));
		sunTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Expenditure, losses",12,TransitReference.NatalMoon));
		
		monTransitData.put(1, new TransitOutcome(TransitImpact.Good, "Comfort, good spirits",1,TransitReference.NatalMoon));
		monTransitData.put(2, new TransitOutcome(TransitImpact.Bad, "Obstacles, losses",2,TransitReference.NatalMoon));
		monTransitData.put(3, new TransitOutcome(TransitImpact.Good, "Gains, happiness",3,TransitReference.NatalMoon));
		monTransitData.put(4, new TransitOutcome(TransitImpact.Bad, "Lack of peace of mind, distrust",4,TransitReference.NatalMoon));
		monTransitData.put(5, new TransitOutcome(TransitImpact.Bad, "Failures, disappointments, sadness",5,TransitReference.NatalMoon));
		monTransitData.put(6, new TransitOutcome(TransitImpact.Good, "Happiness, health, wealth",6,TransitReference.NatalMoon));
		monTransitData.put(7, new TransitOutcome(TransitImpact.Good, "Respect, gains",7,TransitReference.NatalMoon));
		monTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Losses, tension, worries",8,TransitReference.NatalMoon));
		monTransitData.put(9, new TransitOutcome(TransitImpact.Bad, "Mental uneasiness",9,TransitReference.NatalMoon));
		monTransitData.put(10, new TransitOutcome(TransitImpact.Good, "Success, gains, authority",10,TransitReference.NatalMoon));
		monTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Prosperity, comforts, gains",11,TransitReference.NatalMoon));
		monTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Injuries, expenditure, sadness",12,TransitReference.NatalMoon));
		
		jupTransitData.put(1, new TransitOutcome(TransitImpact.Bad, "Loss of money and intelligence, Wandering",1,TransitReference.NatalMoon));
		jupTransitData.put(2, new TransitOutcome(TransitImpact.Good, "Happiness, domestic harmony, success",2,TransitReference.NatalMoon));
		jupTransitData.put(3, new TransitOutcome(TransitImpact.Bad, "Obstacles, loss of position, travels",3,TransitReference.NatalMoon));
		jupTransitData.put(4, new TransitOutcome(TransitImpact.Bad, "Troubles, defeat, losses",4,TransitReference.NatalMoon));
		jupTransitData.put(5, new TransitOutcome(TransitImpact.Good, "Childbirth, intelligence, prosperity, wealth",5,TransitReference.NatalMoon));
		jupTransitData.put(6, new TransitOutcome(TransitImpact.Bad, "Mental uneasiness, enemies, worries",6,TransitReference.NatalMoon));
		jupTransitData.put(7, new TransitOutcome(TransitImpact.Good, "Health, happiness, erotic pleasures, sense of well-being",7,TransitReference.NatalMoon));
		jupTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Disease, imprisonment, illness, grief",8,TransitReference.NatalMoon));
		jupTransitData.put(9, new TransitOutcome(TransitImpact.Good, "Success, wealth, childbirth, religiousness",9,TransitReference.NatalMoon));
		jupTransitData.put(10, new TransitOutcome(TransitImpact.Bad, "Loss of position and money, ill-health, wandering",10,TransitReference.NatalMoon));
		jupTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Recovery of health and position, happiness",11,TransitReference.NatalMoon));
		jupTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Fall from grace, misconduct, grief",12,TransitReference.NatalMoon));
		
		merTransitData.put(1, new TransitOutcome(TransitImpact.Bad, "Quarrels, imprisonment, losses, poor advice",1,TransitReference.NatalMoon));
		merTransitData.put(2, new TransitOutcome(TransitImpact.Good, "Success, wealth, gains",2,TransitReference.NatalMoon));
		merTransitData.put(3, new TransitOutcome(TransitImpact.Bad, "Wandering, losses, trouble from authorities",3,TransitReference.NatalMoon));
		merTransitData.put(4, new TransitOutcome(TransitImpact.Good, "Prosperity in family, gains",4,TransitReference.NatalMoon));
		merTransitData.put(5, new TransitOutcome(TransitImpact.Bad, "Quarrels with wife and children, suffering",5,TransitReference.NatalMoon));
		merTransitData.put(6, new TransitOutcome(TransitImpact.Good, "Renown, success, ornaments",6,TransitReference.NatalMoon));
		merTransitData.put(7, new TransitOutcome(TransitImpact.Bad, "Quarrels, mental discomfort, addictions",7,TransitReference.NatalMoon));
		merTransitData.put(8, new TransitOutcome(TransitImpact.Good, "Childbirth, happiness, gains, success",8,TransitReference.NatalMoon));
		merTransitData.put(9, new TransitOutcome(TransitImpact.Bad, "Mental worries, obstacles",9,TransitReference.NatalMoon));
		merTransitData.put(10, new TransitOutcome(TransitImpact.Good, "Money, happiness, domestic harmony, success",10,TransitReference.NatalMoon));
		merTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Childbirth, happiness, wealth",11,TransitReference.NatalMoon));
		merTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Disease, domestic disharmony, disease, losses",12,TransitReference.NatalMoon));
		
		marTransitData.put(1, new TransitOutcome(TransitImpact.Bad, "Troubles, bodily afflictions",1,TransitReference.NatalMoon));
		marTransitData.put(2, new TransitOutcome(TransitImpact.Bad, "Accidents, losses, thefts, quarrels",2,TransitReference.NatalMoon));
		marTransitData.put(3, new TransitOutcome(TransitImpact.Good, "Gains, power, wealth",3,TransitReference.NatalMoon));
		marTransitData.put(4, new TransitOutcome(TransitImpact.Bad, "Stomach problems, fevers, bad health",4,TransitReference.NatalMoon));
		marTransitData.put(5, new TransitOutcome(TransitImpact.Bad, "Troubles from enemies, trouble with children",5,TransitReference.NatalMoon));
		marTransitData.put(6, new TransitOutcome(TransitImpact.Good, "Success over enemies, wealth, success, well-being",6,TransitReference.NatalMoon));
		marTransitData.put(7, new TransitOutcome(TransitImpact.Bad, "Quarrels, marital troubles, eye problems",7,TransitReference.NatalMoon));
		marTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Worries, accidents, bad name, losses",8,TransitReference.NatalMoon));
		marTransitData.put(9, new TransitOutcome(TransitImpact.Bad, "Losses, insults, illness",9,TransitReference.NatalMoon));
		marTransitData.put(10, new TransitOutcome(TransitImpact.Bad, "Change of place, unexpected wealth",10,TransitReference.NatalMoon));
		marTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Authority, gains, good name",11,TransitReference.NatalMoon));
		marTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Expenses, quarrels with wife, diseases",12,TransitReference.NatalMoon));
		
		venTransitData.put(1, new TransitOutcome(TransitImpact.Good, "Comforts, pleasures, happiness, good spirits",1,TransitReference.NatalMoon));
		venTransitData.put(2, new TransitOutcome(TransitImpact.Good, "Money, fortune, erotic pleasures, childbirth",2,TransitReference.NatalMoon));
		venTransitData.put(3, new TransitOutcome(TransitImpact.Good, "Respect, wealth, good spirits",3,TransitReference.NatalMoon));
		venTransitData.put(4, new TransitOutcome(TransitImpact.Good, "Prosperity, success over enemies, comforts",4,TransitReference.NatalMoon));
		venTransitData.put(5, new TransitOutcome(TransitImpact.Good, "Fame, power, good name",5,TransitReference.NatalMoon));
		venTransitData.put(6, new TransitOutcome(TransitImpact.Bad, "Loss of fame, bad name, quarrels",6,TransitReference.NatalMoon));
		venTransitData.put(7, new TransitOutcome(TransitImpact.Bad, "Humiliation, disease, troubles",7,TransitReference.NatalMoon));
		venTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Fears, mental worries, injuries, troubles from women",8,TransitReference.NatalMoon));
		venTransitData.put(9, new TransitOutcome(TransitImpact.Good, "Fortune, luxuries, marital happiness",9,TransitReference.NatalMoon));
		venTransitData.put(10, new TransitOutcome(TransitImpact.Bad, "Virtuous acts, troubles, unpleasant events, disgrace",10,TransitReference.NatalMoon));
		venTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Gains, happiness, prosperity, comforts",11,TransitReference.NatalMoon));
		venTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "New friends, money, pleasures, gains",12,TransitReference.NatalMoon));
		
		satTransitData.put(1, new TransitOutcome(TransitImpact.Bad, "Fear of incarceration, worries, foreign trips",1,TransitReference.NatalMoon));
		satTransitData.put(2, new TransitOutcome(TransitImpact.Bad, "Physical weakness, discomfort, wealth, unhappiness",2,TransitReference.NatalMoon));
		satTransitData.put(3, new TransitOutcome(TransitImpact.Good, "Wealth, health, happiness, all-round success",3,TransitReference.NatalMoon));
		satTransitData.put(4, new TransitOutcome(TransitImpact.Bad, "Stomach problems, wickedness, separation from family",4,TransitReference.NatalMoon));
		satTransitData.put(5, new TransitOutcome(TransitImpact.Bad, "Separation from children, uneasiness, quarrels",5,TransitReference.NatalMoon));
		satTransitData.put(6, new TransitOutcome(TransitImpact.Good, "Freedom from disease and enemies, success",6,TransitReference.NatalMoon));
		satTransitData.put(7, new TransitOutcome(TransitImpact.Bad, "Wandering, quarrels with spouse, trouble from authorities",7,TransitReference.NatalMoon));
		satTransitData.put(8, new TransitOutcome(TransitImpact.Bad, "Suffering, loss of status and balance, imprisonment",8,TransitReference.NatalMoon));
		satTransitData.put(9, new TransitOutcome(TransitImpact.Bad, "Diseases, suffering, loss of status",9,TransitReference.NatalMoon));
		satTransitData.put(10, new TransitOutcome(TransitImpact.Bad, "Loss of money, bad name, changes in career, laziness",10,TransitReference.NatalMoon));
		satTransitData.put(11, new TransitOutcome(TransitImpact.Good, "Wealth, success, gains",11,TransitReference.NatalMoon));
		satTransitData.put(12, new TransitOutcome(TransitImpact.Bad, "Grief, misery, losses, ill-health, frustration",12,TransitReference.NatalMoon));
		
		transitOutcomes.put(Planet.SUN, sunTransitData);
		transitOutcomes.put(Planet.SAT, satTransitData);
		transitOutcomes.put(Planet.MON, monTransitData);
		transitOutcomes.put(Planet.VEN, venTransitData);
		transitOutcomes.put(Planet.JUP, jupTransitData);
		transitOutcomes.put(Planet.MAR, marTransitData);
		transitOutcomes.put(Planet.MER, merTransitData);
		
	}
	
	public static Map<Integer,TransitOutcome> getTransitOutcomesFromMoon(Planet planet){
		return transitOutcomes.get(planet);
	}
}