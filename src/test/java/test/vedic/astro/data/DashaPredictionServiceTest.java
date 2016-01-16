package test.vedic.astro.data;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.DashaPlanetRelationship;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.service.DashaPredictService;
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
import com.vedic.astro.vo.BirthChartCalcPrep;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class DashaPredictionServiceTest extends BaseUtilTest {
	
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
	
	@Autowired
	@Qualifier("planetPositionsDataService")
	private PlanetPositionsDataService planetPositionsDataService;


	@Autowired
	@Qualifier("dashaPredictService")
	private DashaPredictService dashaPredictService;
	
    //@Test
	public void testDashaPlanetWithService() throws Exception {
    
    	dashaPredictService.predictDashaPeriod(null, Planet.SAT, Planet.SAT, Planet.SAT);

    }
    
    //@Test
  	public void testDashaPlanet() throws Exception {
          	
  		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
  				planetPositionsDataService.getPlanetPositionsData(
  						"20/12/1972", "17:10:00", 10304);
  		System.out.println("absolutePlanetaryPositions =" + 
  				absolutePlanetaryPositions);
  		
  		BirthChartData d1Chart = birthChartUtil.generateD1Chart(
  				absolutePlanetaryPositions);
  		System.out.println("d1chart = " + d1Chart);
  		BirthChartCalcPrep birthChartCalcPrep =
  				relationshipUtil.preparePlanetsForCalc(
  						d1Chart.getChartHouses());
  		
  		System.out.println("birthChartCalcPrep = " + birthChartCalcPrep);
  		
  /*		System.out.println("dasha planet = " + 
  		vimshotriDashaUtil.predictDasha(Planet.SAT, birthChartCalcPrep));
  		
  		AshtakvargaChart ashtakvargaChart = ashtakvargaChartUtil.prepareCharts(
  				relationshipUtil.preparePlanetsForCalc(
  						d1Chart.getChartHouses()));
  		
//  		System.out.println("planet score = " + ashtakvargaChart.getPlanetScoreInChart(
//  				Planet.SAT, Planet.VEN));

  		System.out.println("SAT planet chart for house = " + ashtakvargaChartUtil.getHouseChartForPlanet(Planet.SAT, ashtakvargaChart, birthChartCalcPrep));
  		System.out.println("VEN planet chart for house = " + ashtakvargaChartUtil.getHouseChartForPlanet(Planet.VEN, ashtakvargaChart, birthChartCalcPrep));
  		System.out.println("MER planet chart for house = " + ashtakvargaChartUtil.getHouseChartForPlanet(Planet.MER, ashtakvargaChart, birthChartCalcPrep));
  		System.out.println("MAR planet chart for house = " + ashtakvargaChartUtil.getHouseChartForPlanet(Planet.MAR, ashtakvargaChart, birthChartCalcPrep));
    */
  		DashaPlanetRelationship dashaPlanetRelationship = 
  				vimshotriDashaUtil.getDashaPlanetRelationships(
  						Planet.SAT, birthChartCalcPrep);
  		
  		System.out.println("dasha planet relationships = " + 
  				dashaPlanetRelationship);

  		System.out.println("dasha planet impacted houses = " + 
  				dashaPlanetRelationship.getMostImpactedHouses());
  		
  		System.out.println("dasha planet significations = " + 
  				vimshotriDashaUtil.predictDasha(Planet.SAT, birthChartCalcPrep));

      }
}