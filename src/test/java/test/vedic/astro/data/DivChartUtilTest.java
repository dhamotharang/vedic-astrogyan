package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.BirthPlanetaryPositions;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.service.AstroPredictiveService;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.AshtakvargaChartUtil;
import com.vedic.astro.util.BirthChartUtil;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class DivChartUtilTest extends BaseUtilTest {
	
	@Autowired
	@Qualifier("astroPredictiveService")
	private AstroPredictiveService astroPredictiveService;


	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;
	
	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;
	
	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("vimshotriDashaUtil")
	private VimshotriDashaUtil vimshotriDashaUtil;
	
	@Autowired
	@Qualifier("divChartUtil")
	private DivChartUtil divChartUtil;
	
	@Autowired
	@Qualifier("ashtakvargaChartUtil")
	private AshtakvargaChartUtil ashtakvargaChartUtil;
	
	@Resource
	PlanetPositionsDataService planetPositionsDataService;

	
    
	@Test
	public void testGenerateD3Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		
		System.out.println("d3Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D3,
				d1Chart));
	}
	
	@Test
	public void testGenerateD4Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		
		System.out.println("d4Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D4,
				d1Chart));

	}
	
	@Test
	public void testGenerateD7Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("16/08/2004", "09:16:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d7Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D7,
				d1Chart));

	}
	
	@Test
	public void testGenerateD10Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("16/08/2004", "09:16:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d10Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D10,
				d1Chart));

	}
	
	@Test
	public void testGenerateD9Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d9Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D9,
				d1Chart));
	}
	
	@Test
	public void testGenerateD12Chart() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("28/10/1955", "21:25:00", 21932);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d12Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D12,
				d1Chart));
	}

	@Test
	public void testGenerateD16Chart() throws Exception {

	    	BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
			PlanetPosition lagna = new PlanetPosition();
			lagna.setZodiac(Zodiac.LIB);
			lagna.setDegrees(13.92);
			birthPlanetaryPositions.setLagna(lagna);
			
			List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
			planetPostions.add(new PlanetPosition(16.92,Zodiac.VIR,Planet.SUN));
			planetPostions.add(new PlanetPosition(28.33,Zodiac.CAN,Planet.MON));
			planetPostions.add(new PlanetPosition(26.38,Zodiac.LIB,Planet.MAR));
			planetPostions.add(new PlanetPosition(11.75,Zodiac.LIB,Planet.MER));
			planetPostions.add(new PlanetPosition(28.13,Zodiac.PIS,Planet.JUP));
			planetPostions.add(new PlanetPosition(24.43,Zodiac.LIB,Planet.VEN));
			planetPostions.add(new PlanetPosition(20.32,Zodiac.SCO,Planet.SAT));
			planetPostions.add(new PlanetPosition(13.65,Zodiac.CAN,Planet.RAH));
			planetPostions.add(new PlanetPosition(13.65,Zodiac.CAP,Planet.KET));
			
			birthPlanetaryPositions.setPlanetPositions(planetPostions);
			BirthChartData d1Chart = birthChartUtil.generateD1Chart(birthPlanetaryPositions);
		

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d16Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D16,
				d1Chart));
	}

	@Test
	public void testGenerateD5Chart() throws Exception {

    	BirthPlanetaryPositions birthPlanetaryPositions = new BirthPlanetaryPositions();
		PlanetPosition lagna = new PlanetPosition();
		lagna.setZodiac(Zodiac.LEO);
		lagna.setDegrees(18.45);
		birthPlanetaryPositions.setLagna(lagna);
		
		List<PlanetPosition> planetPostions = new ArrayList<PlanetPosition>();
		planetPostions.add(new PlanetPosition(09.60,Zodiac.SCO,Planet.SUN));
		planetPostions.add(new PlanetPosition(04.07,Zodiac.AQU,Planet.MON));
		planetPostions.add(new PlanetPosition(25.20,Zodiac.GEM,Planet.MAR));
		planetPostions.add(new PlanetPosition(19.92,Zodiac.LIB,Planet.MER));
		planetPostions.add(new PlanetPosition(12.50,Zodiac.SAG,Planet.JUP));
		planetPostions.add(new PlanetPosition(18.59,Zodiac.SAG,Planet.VEN));
		planetPostions.add(new PlanetPosition(22.23,Zodiac.SAG,Planet.SAT));
		planetPostions.add(new PlanetPosition(18.45,Zodiac.LEO,Planet.RAH));
		planetPostions.add(new PlanetPosition(18.45,Zodiac.AQU,Planet.KET));
		
		birthPlanetaryPositions.setPlanetPositions(planetPostions);
		BirthChartData d1Chart = birthChartUtil.generateD1Chart(birthPlanetaryPositions);

		System.out.println("d1Chart = " + d1Chart);
		
		System.out.println("d5Chart = " + divChartUtil.generateDivChart(
				BirthChartType.D5,
				d1Chart));
	}

}