package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vedic.astro.domain.AshtakvargaChart;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.BirthPlanetaryPositions;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.service.AstroPredictiveService;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.AshtakvargaChartUtil;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.DivChartUtil;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.NakshatraUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.VimshotriDashaUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.PlanetPosition;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class AllUtilClassesTest extends BaseUtilTest {
	
	@Autowired
	AstroPredictiveService astroPredictiveService;

	@Autowired
	HouseUtil houseUtil;
	
	@Autowired
	NakshatraUtil nakshatraUtil;
	
	@Autowired
	PlanetUtil planetUtil;

	@Autowired
	RelationshipUtil relationshipUtil;

	@Autowired
	BirthChartUtil birthChartUtil;

	@Autowired
	VimshotriDashaUtil vimshotriDashaUtil;
	
	@Autowired
	DivChartUtil divChartUtil;
	
	@Autowired
	AshtakvargaChartUtil ashtakvargaChartUtil;
	
	@Autowired
	PlanetPositionsDataService planetPositionsDataService;

	
	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testGetAspectedHouses() throws Exception {
		
		Map<House, Set<Planet>> houseToPlanetMap = new HashMap<House, Set<Planet>>();

		Set<Planet> planetList1 = new HashSet<Planet>();
		planetList1.add(Planet.JUP);
		planetList1.add(Planet.SUN);

		Set<Planet> planetList2 = new HashSet<Planet>();
		planetList2.add(Planet.SAT);

		Set<Planet> planetList3 = new HashSet<Planet>();
		planetList3.add(Planet.MAR);

		houseToPlanetMap.put(House.H7, planetList1);
		houseToPlanetMap.put(House.H12, planetList2);
		houseToPlanetMap.put(House.H5, planetList3);

		System.out.println(houseUtil.getAspectedHouses(houseToPlanetMap));
		
	}
	
	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testGetHouseAtDistance() throws Exception {

		System.out.println(houseUtil.getHouseAtDistance(7, House.H7));

	}
	
	

	//@Test
	public void testPreparePlanetsForCalc() throws Exception {

		
		System.out.println(relationshipUtil.preparePlanetsForCalc(
				super.prepareData().getChartHouses()));

	}

	//@Test
	public void testNakCalc() throws Exception {

		Nakshatra nak = nakshatraUtil.getNakshatra(Zodiac.GEM, 6.2);
		System.out.println(nak);
		System.out.println(nakshatraUtil.getNakshatraLord(nak));
		System.out.println(nakshatraUtil.getNakshatraSubLord(Zodiac.GEM, 6.2));
	}
	
	//@Test
	public void testGenerateBirthChart() throws Exception {

	/*	BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.GEM);
		birthPlanetaryPositions.setLagna(lagna);
		
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(5.13,Zodiac.SAG,Planet.SUN));
		planetPostions.add(new PlanetPosition(6.20,Zodiac.GEM,Planet.MON));
		planetPostions.add(new PlanetPosition(29.36,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(15.01,Zodiac.SCO,Planet.MER));
		planetPostions.add(new PlanetPosition(21.40,Zodiac.SAG,Planet.JUP));
		planetPostions.add(new PlanetPosition(8.38,Zodiac.SCO,Planet.VEN));
		planetPostions.add(new PlanetPosition(22.41,Zodiac.TAU,Planet.SAT));
		planetPostions.add(new PlanetPosition(23.18,Zodiac.SAG,Planet.RAH));
		planetPostions.add(new PlanetPosition(23.18,Zodiac.GEM,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);
		*/
		BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.VIR);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(20.18,Zodiac.VIR,Planet.SUN));
		planetPostions.add(new PlanetPosition(7.03,Zodiac.PIS,Planet.MON));
		planetPostions.add(new PlanetPosition(5.12,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(2.24,Zodiac.VIR,Planet.MER));
		planetPostions.add(new PlanetPosition(7.10,Zodiac.TAU,Planet.JUP));
		planetPostions.add(new PlanetPosition(19.42,Zodiac.LIB,Planet.VEN));
		planetPostions.add(new PlanetPosition(20.58,Zodiac.CAN,Planet.SAT));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.LIB,Planet.RAH));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.ARE,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);


		
		System.out.println(birthChartUtil.generateD1Chart(birthPlanetaryPositions));
	}
	
    //@Test
	public void testGetHousesOfType() throws Exception {

		System.out.println(HouseType.Dusthana + "=" + houseUtil.getHousesOfType(HouseType.Dusthana));
		System.out.println(HouseType.Kendra + "=" + houseUtil.getHousesOfType(HouseType.Kendra));
		System.out.println(HouseType.Trikona + "=" + houseUtil.getHousesOfType(HouseType.Trikona));
	}

    //@Test
	public void testGetNextDasha() throws Exception {

		/*System.out.println("Next dasha to Dasha.SATURN" + vimshotriDashaUtil.getNextDasha(Dasha.SATURN));
		System.out.println("Dashas after" + vimshotriDashaUtil.getAllDashasAfter(Dasha.MARS));
		System.out.println("Get all antardashas" + vimshotriDashaUtil.getAllAntarDashas(Dasha.SATURN));
		System.out.println("Days in antardasha" + vimshotriDashaUtil.daysInAntardasha(Dasha.SATURN, Dasha.VENUS));
		System.out.println("Antardasha periods" + vimshotriDashaUtil.getAllAntarDashasPeriods(Dasha.SATURN, DateUtil.toDate("02/22/2007", "MM/dd/yyyy")));
		*/
		//System.out.println("Days to complete" + vimshotriDashaUtil.calcLastDateForCompletionOfFirstDasha(Zodiac.PIS, Nakshatra.UthraBhadra, 7.03,DateUtil.toDate("10/07/1976", "MM/dd/yyyy")));
		//System.out.println("Days to complete" + vimshotriDashaUtil.calcLastDateForCompletionOfFirstDasha(Zodiac.GEM, Nakshatra.Mrigashiras, 6.20, DateUtil.toDate("12/20/1972", "MM/dd/yyyy")));
		
//    	System.out.println("Dasha calc" + vimshotriDashaUtil.generateDashaData(Zodiac.PIS, Nakshatra.UthraBhadra, 7.03, DateUtil.toDate("10/07/1976", "MM/dd/yyyy")));
//		System.out.println("Dasha calc" + vimshotriDashaUtil.getDashaCombination(Zodiac.PIS, Nakshatra.UthraBhadra, 7.03, DateUtil.toDate("10/07/1976", "MM/dd/yyyy"), DateUtil.toDate("02/22/2000", "MM/dd/yyyy")));
//		
    	System.out.println("Dasha calc" + vimshotriDashaUtil.getDashaCombination(Zodiac.GEM, Nakshatra.Mrigashiras, 6.20, DateUtil.toDate("12/20/1972", "MM/dd/yyyy"),DateUtil.toDate("04/09/2013", "MM/dd/yyyy")));
    	//System.out.println("Dasha calc" + vimshotriDashaUtil.getDashaCombination(Zodiac.GEM, Nakshatra.Mrigashiras, 6.20, DateUtil.toDate("12/20/1972", "MM/dd/yyyy"),DateUtil.toDate("04/09/2013", "MM/dd/yyyy")));
//		
		List<Planet> planets = new ArrayList<Planet>();
		planets.add(Planet.JUP);
				
//		
//		DashaImpactedHouses impactedPlanets = astroPredictiveService.predictChartInDasha(super
//				.prepareLagnaData(), planets);
//		
//		System.out.println("impactedPlanets =" + impactedPlanets);
//	
//	
//		System.out.println("House 2 :" + astroPredictiveService.getHouseSummary(super
//				.prepareLagnaData(), House.H2));
//	
//
//		System.out.println("House 10 :" + astroPredictiveService.getHouseSummary(super
//				.prepareLagnaData(), House.H10));
//		
//		System.out.println("House 4 :" + astroPredictiveService.getHouseSummary(super
//				.prepareLagnaData(), House.H4));
//		
//		
//		System.out.println("House 4 :" + astroPredictiveService.getHouseSummary(super
//				.prepareLagnaData(), House.H4));
	
	
	}
    
	//@Test
	public void testGenerateD3Chart() throws Exception {

		BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.VIR);
		lagna.setDegrees(8.05);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(20.18,Zodiac.VIR,Planet.SUN));
		planetPostions.add(new PlanetPosition(7.03,Zodiac.PIS,Planet.MON));
		planetPostions.add(new PlanetPosition(5.12,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(2.24,Zodiac.VIR,Planet.MER));
		planetPostions.add(new PlanetPosition(7.10,Zodiac.TAU,Planet.JUP));
		planetPostions.add(new PlanetPosition(19.42,Zodiac.LIB,Planet.VEN));
		planetPostions.add(new PlanetPosition(20.58,Zodiac.CAN,Planet.SAT));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.LIB,Planet.RAH));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.ARE,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);
		BirthChartData d1Chart = birthChartUtil.generateD1Chart(birthPlanetaryPositions);
		
		System.out.println("d3Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D3,
				d1Chart));
		
		System.out.println("d4Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D4,
				d1Chart));

	}

   @Test
	public void testAshtakVarga() throws Exception {
    /*	BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.VIR);
		lagna.setDegrees(8.05);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(20.18,Zodiac.VIR,Planet.SUN));
		planetPostions.add(new PlanetPosition(7.03,Zodiac.PIS,Planet.MON));
		planetPostions.add(new PlanetPosition(5.12,Zodiac.LIB,Planet.MAR));
		planetPostions.add(new PlanetPosition(2.24,Zodiac.VIR,Planet.MER));
		planetPostions.add(new PlanetPosition(7.10,Zodiac.TAU,Planet.JUP));
		planetPostions.add(new PlanetPosition(19.42,Zodiac.LIB,Planet.VEN));
		planetPostions.add(new PlanetPosition(20.58,Zodiac.CAN,Planet.SAT));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.LIB,Planet.RAH));
		planetPostions.add(new PlanetPosition(10.01,Zodiac.ARE,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);
		BirthChartData d1Chart = birthChartUtil.generateD1Chart(birthPlanetaryPositions);
	*/
    	
		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		System.out.println("absolutePlanetaryPositions =" + absolutePlanetaryPositions);
		
		BirthChartData d1Chart = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		AshtakvargaChart ashtakvargaChart = ashtakvargaChartUtil.prepareCharts(
				relationshipUtil.preparePlanetsForCalc(
						d1Chart.getChartHouses()));
		
		System.out.println("planet score = " + ashtakvargaChart.getPlanetScoreInChart(
				Planet.SAT, Planet.VEN));

		System.out.println("house score = " + ashtakvargaChart.getZodiacScoreInChart(
				Planet.SAT, Zodiac.TAU));
		
		System.out.println("full chart = " + ashtakvargaChart.getFullChart());
		System.out.println("zodiac chart = " + ashtakvargaChart.getFullZodiacChart());
		System.out.println("house chart = " + ashtakvargaChartUtil.getHouseStrengthChart(ashtakvargaChart, relationshipUtil.preparePlanetsForCalc(
				d1Chart.getChartHouses())));
		
		System.out.println("Planet strengths = " + ashtakvargaChartUtil.getPlanetStrengths(ashtakvargaChart, relationshipUtil.preparePlanetsForCalc(
				d1Chart.getChartHouses())));
	}
	
	  // @Test
		public void testDistanceBetweenHouses() throws Exception {
		   System.out.println("distance between houses =" + houseUtil.distanceBetween(House.H2, House.H10));
		   System.out.println("House at distance =" + houseUtil.getHouseAtDistance(9, House.H2));
		   System.out.println("distance between houses =" + houseUtil.distanceBetween(House.H11, House.H4));
	   }			

}