package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.service.AstroPredictiveService;
import com.vedic.astro.util.JsonUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 * 
 */

public class AstroPredictiveServiceTest extends BaseUtilTest {

	@Autowired
	@Qualifier("astroPredictiveService")
	private AstroPredictiveService astroPredictiveService;

	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
//	@Test
	public void testPredictChart() throws Exception {
//		System.out.println(astroPredictiveService.predictChart(super
//				.prepareData()));

	}

    
	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
//    @Test
	public void testPredictChartInDasha() throws Exception {
		
		List<Planet> planets = new ArrayList<Planet>();
		//planets.add(Planet.VEN);
		planets.add(Planet.MON);
		
//		DashaImpactedHouses impactedPlanets = astroPredictiveService.predictChartInDasha(super
//				.prepareLagnaData(), planets);
		
//		System.out.println(impactedPlanets);
//		System.out.println(impactedPlanets.getAllHousesImpacted());
		

	}

    
	//@Test
	public void testInputJson() throws Exception {
		System.out.println(JsonUtil.toJson(super
				.prepareMember()));

	}



}