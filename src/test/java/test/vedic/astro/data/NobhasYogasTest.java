package test.vedic.astro.data;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.NabhasYogaUtil;
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
public class NobhasYogasTest extends BaseUtilTest {

	@Autowired
	@Qualifier("nabhasYogaUtil")
	private NabhasYogaUtil nabhasYogaUtil;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Resource
	PlanetPositionsDataService planetPositionsDataService;

	@Test
	public void testNobhasYogas() throws Exception {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());
		System.out.println("birthChartCalcPrep" + birthChartCalcPrep);

		System.out.println("Yogas present = "
				+ nabhasYogaUtil.findAshrayaYogaPresent(birthChartCalcPrep));
		System.out.println("Yogas present = "
				+ nabhasYogaUtil.findDalaYogaPresent(birthChartCalcPrep));
		List<Yoga> yogas = nabhasYogaUtil
				.findAkritiYogaPresent(birthChartCalcPrep);

		System.out.println("Yogas present = " + yogas);

		for (Yoga yoga : yogas) {
			System.out.println("Yogas present = "
					+ nabhasYogaUtil.getYogaDetails(yoga));
		}
	}
}