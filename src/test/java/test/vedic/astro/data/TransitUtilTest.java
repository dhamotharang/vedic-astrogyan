package test.vedic.astro.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.AshtakvargaChartUtil;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.CharaDashaUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.DivChartUtil;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.NakshatraUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.TransitUtil;
import com.vedic.astro.util.ZodiacUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.BirthChartCalcPrep;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class TransitUtilTest extends BaseUtilTest {

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

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
	@Qualifier("charaDashaUtil")
	private CharaDashaUtil charaDashaUtil;

	@Autowired
	@Qualifier("divChartUtil")
	private DivChartUtil divChartUtil;

	@Autowired
	@Qualifier("ashtakvargaChartUtil")
	private AshtakvargaChartUtil ashtakvargaChartUtil;

	@Resource
	PlanetPositionsDataService planetPositionsDataService;

	@Autowired
	@Qualifier("transitUtil")
	private TransitUtil transitUtil;

	@Test
	public void testPlanetTransits() throws Exception {

		AbsolutePlanetaryPositions birthAbsolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(birthAbsolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());
		
		AbsolutePlanetaryPositions transitAbsolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("11/12/2015", "12:00:00", 10304);
		BirthChartData transitChart = birthChartUtil
				.generateD1Chart(transitAbsolutePlanetaryPositions);
		BirthChartCalcPrep transitChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(transitChart.getChartHouses());
		
		Map<Planet, Zodiac> transitDataZod = new HashMap<Planet, Zodiac>();
		Map<Planet, Nakshatra> transitDataNak = new HashMap<Planet, Nakshatra>();
		
		Map<Planet, House> transitPlanetToHouseMap = transitChartCalcPrep.getPlanetHouseMapping();
		Map<House, Zodiac> transitHousetoZodiacMap = transitChartCalcPrep.getHouseZodiacMapping();
		Map<Planet, Nakshatra> transitPlanetToNakMap = transitChartCalcPrep.getPlanetNakshatrasMapping();
		
		for(Planet transitPlanet: planetUtil.getPlanetsForConsideration(false)){
			Zodiac transitZodiac = transitHousetoZodiacMap.get(transitPlanetToHouseMap.get(transitPlanet));
			transitDataZod.put(transitPlanet, transitZodiac);
		}

		for(Planet transitPlanet: planetUtil.getPlanetsForConsideration(false)){
			Nakshatra transitNakshatra = transitPlanetToNakMap.get(transitPlanet);
			transitDataNak.put(transitPlanet, transitNakshatra);
		}

		System.out.println("birthChartCalcPrep = " + birthChartCalcPrep);
		System.out.println("transitChartCalcPrep = " + transitChartCalcPrep);
		
		System.out.println("transitOutcomes from Moon = " + 
		transitUtil.findTransitOutcomesFromMoon(
				birthChartCalcPrep, transitDataZod));

		System.out.println("transitOutcomes from Ashtavarga = " + 
		transitUtil.findTransitOutcomesFromAshtavarga(birthChartCalcPrep, transitDataZod, transitChartCalcPrep.getPlanetAgeMapping()));

		System.out.println("transitOutcomes from Nakshatra = " + 
		transitUtil.findTransitOutcomesFromNak(birthChartCalcPrep, transitDataNak));

	}
}