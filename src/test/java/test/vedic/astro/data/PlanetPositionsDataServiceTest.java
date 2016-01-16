package test.vedic.astro.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.service.SunriseSunsetDataService;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
 
public class PlanetPositionsDataServiceTest extends BaseUtilTest{
 
	@Autowired
	@Qualifier("planetPositionsDataService")
	private PlanetPositionsDataService planetPositionsDataService;


	@Autowired
	@Qualifier("sunriseSunsetDataService")
	private SunriseSunsetDataService sunriseSunsetDataService;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;
 
	//@Test
	public void migrateTransitDataForSAT() {
		System.out.println("Starting up ...      [Ok]");
		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService.getPlanetPositionsData("17/11/2015", "17:10:10", 20940);
		System.out.println("absolutePlanetaryPositions =" + absolutePlanetaryPositions);
		
		BirthChartData birthChartData = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("birthChartData =" + birthChartData);
		
		System.out.println("Finised ...          [Ok]");
	}

	//@Test
	public void generateD1forSambhav() {
		System.out.println("Starting up ...      [Ok]");
		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService.getPlanetPositionsData("16/08/2004", "09:16:10", 10304);
		System.out.println("absolutePlanetaryPositions =" + absolutePlanetaryPositions);
		
		BirthChartData birthChartData = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("birthChartData =" + birthChartData);
		
		System.out.println("Finised ...          [Ok]");
	}
	
	//@Test
	public void testSunriseSunset() {
		System.out.println("Starting up ...      [Ok]");
		
		sunriseSunsetDataService.getSunriseSunsetData(7191, "20/12/1972");

		System.out.println("Finised ...          [Ok]");
	}
}
