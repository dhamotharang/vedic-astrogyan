package migration.vedic.astro.transit.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.TransitInfoRepository;
import com.vedic.astro.service.PlanetTransitDataService;
import com.vedic.astro.util.TransitUtil;

import test.vedic.astro.data.BaseUtilTest;

public class PlanetTransitDataServiceTest extends BaseUtilTest {
 
	@Autowired
	@Qualifier("planetTransitDataService")
	private PlanetTransitDataService planetTransitDataService;

	@Autowired
	@Qualifier("transitUtil")
	private TransitUtil transitUtil;

	@Autowired
	@Qualifier("transitInfoRepository")
	private TransitInfoRepository transitInfoRepository;

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
