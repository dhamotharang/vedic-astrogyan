package test.vedic.astro.data;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RajaYogaUtil;
import com.vedic.astro.util.RelationshipUtil;
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
public class RajaYogasTest extends BaseUtilTest {

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;
	
	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;


	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("rajaYogaUtil")
	private RajaYogaUtil rajaYogaUtil;

	@Resource
	PlanetPositionsDataService planetPositionsDataService;

	@Test
	public void testRajaYogas() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());
		System.out.println("Raja yogas = " + rajaYogaUtil.findRajaYogaPresent(birthChartCalcPrep));

		System.out.println("Vipreet Raja yogas = " + rajaYogaUtil.findVipreetRajaYogaPresent(birthChartCalcPrep));

		for(Planet planet : planetUtil.getPlanetsForConsideration(false)){
			System.out.println("planet " + planet + "is " + birthChartUtil.findLordNature(planet, birthChartCalcPrep));
		}
	}
}