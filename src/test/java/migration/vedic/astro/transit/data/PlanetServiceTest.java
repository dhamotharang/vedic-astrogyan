package migration.vedic.astro.transit.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.PlanetStrength;
import com.vedic.astro.domain.PlanetStrengths;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.PlanetStrengthRepository;

import test.vedic.astro.data.BaseUtilTest;

public class PlanetServiceTest extends BaseUtilTest {

	@Autowired
	@Qualifier("planetStrengthRepository")
	private PlanetStrengthRepository planetStrengthRepository;

	@Test
	public void setupPlanetStrength() {
		
		PlanetStrengths planetStrengths1 = new PlanetStrengths();
		planetStrengths1.setMemberId("56b5029c1b3a745432b941e3");
		planetStrengths1.setPredictionSystem(PredictionSystem.Prashara);
		
		List<PlanetStrength> planetStrengthList1 = new ArrayList<PlanetStrength>();
		
		planetStrengthList1.add(new PlanetStrength(Planet.SUN, 26.89));
		planetStrengthList1.add(new PlanetStrength(Planet.MON, 12.67));
		planetStrengthList1.add(new PlanetStrength(Planet.MER, 36.00));
		planetStrengthList1.add(new PlanetStrength(Planet.VEN, 45.67));
		planetStrengthList1.add(new PlanetStrength(Planet.SAT, 20.23));
		planetStrengthList1.add(new PlanetStrength(Planet.JUP, 45.70));
		planetStrengthList1.add(new PlanetStrength(Planet.MAR, 52.56));
		
		planetStrengths1.setStrengths(planetStrengthList1);
		planetStrengthRepository.save(planetStrengths1);
		
		PlanetStrengths planetStrengths2 = new PlanetStrengths();
		planetStrengths2.setMemberId("56b5029c1b3a745432b941e3");
		planetStrengths2.setPredictionSystem(PredictionSystem.Ashtavarga);
		
		List<PlanetStrength> planetStrengthList2 = new ArrayList<PlanetStrength>();
		
		planetStrengthList2.add(new PlanetStrength(Planet.SUN, 12.67));
		planetStrengthList2.add(new PlanetStrength(Planet.MON, 36.00));
		planetStrengthList2.add(new PlanetStrength(Planet.MER, 36.00));
		planetStrengthList2.add(new PlanetStrength(Planet.VEN, 20.23));
		planetStrengthList2.add(new PlanetStrength(Planet.SAT, 45.67));
		planetStrengthList2.add(new PlanetStrength(Planet.JUP, 52.56));
		planetStrengthList2.add(new PlanetStrength(Planet.MAR, 45.70));
		
		planetStrengths2.setStrengths(planetStrengthList2);
		planetStrengthRepository.save(planetStrengths2);
	}


}