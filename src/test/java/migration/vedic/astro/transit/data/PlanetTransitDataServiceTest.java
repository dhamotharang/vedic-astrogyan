package migration.vedic.astro.transit.data;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.TransitInfoRepository;
import com.vedic.astro.service.PlanetTransitDataService;
import com.vedic.astro.util.TransitUtil;
 
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class PlanetTransitDataServiceTest {
 
	@Resource
	PlanetTransitDataService planetTransitDataService;

	@Resource
	TransitUtil transitUtil;
	
	@Resource
	TransitInfoRepository transitInfoRepository;
	
 
	//@Test
	public void migrateTransitDataForSAT() {
		System.out.println("Starting up for SAT...      [Ok]");
		List<PlanetTransitData> planetTransitData = planetTransitDataService.getPlanetTransitData(Planet.SAT, 1980, 2030);
		transitInfoRepository.add(transitUtil.setDateRange(planetTransitData));
		System.out.println("Finised for SAT...          [Ok]");
	}
	
	//@Test
	public void migrateTransitDataForMAR() {
		System.out.println("Starting up for MAR...      [Ok]");
		List<PlanetTransitData> planetTransitData = planetTransitDataService.getPlanetTransitData(Planet.MAR, 1980, 2030);
		transitInfoRepository.add(transitUtil.setDateRange(planetTransitData));
		System.out.println("Finised for MAR...          [Ok]");
	}

	//@Test
	public void migrateTransitDataForJUP() {
		System.out.println("Starting up for JUP...      [Ok]");
		List<PlanetTransitData> planetTransitData = planetTransitDataService.getPlanetTransitData(Planet.JUP, 1980, 2030);
		transitInfoRepository.add(transitUtil.setDateRange(planetTransitData));
		System.out.println("Finised for JUP...          [Ok]");
	}

	//@Test
	public void migrateTransitDataForVEN() {
		System.out.println("Starting up for VEN...      [Ok]");
		List<PlanetTransitData> planetTransitData = planetTransitDataService.getPlanetTransitData(Planet.VEN, 1980, 2030);
		transitInfoRepository.add(transitUtil.setDateRange(planetTransitData));
		System.out.println("Finised for VEN...          [Ok]");
	}

	//@Test
	public void migrateTransitDataForMER() {
		System.out.println("Starting up for MER...      [Ok]");
		List<PlanetTransitData> planetTransitData = planetTransitDataService.getPlanetTransitData(Planet.MER, 1980, 2030);
		transitInfoRepository.add(transitUtil.setDateRange(planetTransitData));
		System.out.println("Finised for MER...          [Ok]");
	}

}
