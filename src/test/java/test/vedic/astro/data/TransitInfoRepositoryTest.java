package test.vedic.astro.data;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.repository.TransitInfoRepository;
import com.vedic.astro.util.ZodiacUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class TransitInfoRepositoryTest extends BaseUtilTest{

	@Autowired
	@Qualifier("transitInfoRepository")
	private TransitInfoRepository transitInfoRepository;
	
	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;
	

	@Test
	public void testGetPlanetTransitDataByDateAndPlanet() throws Exception {
		Optional<PlanetTransitData> transitData = transitInfoRepository.findByDateAndPlanet(new Date(), Planet.SAT);
		PlanetTransitData planetTransitData = transitData.get();
		Integer distanceFrom = zodiacUtil.distanceBetween(Zodiac.ARE, planetTransitData.getZodiac()) - 1;
		Integer distanceTo = zodiacUtil.distanceBetween(planetTransitData.getZodiac(), Zodiac.PIS) - 1;
        System.out.println("distanceFrom =" + distanceFrom);
        System.out.println("distanceTo =" + distanceTo);
        Integer sequenceFrom = planetTransitData.getSequence() - distanceFrom;
        Integer sequenceTo = planetTransitData.getSequence() + distanceTo;
        System.out.println("sequenceFrom =" + sequenceFrom);
        System.out.println("sequenceTo =" + sequenceTo);
        
        Optional<List<PlanetTransitData>> satTransitData = transitInfoRepository.findByPlanetAndSequence(Planet.SAT, sequenceFrom, sequenceTo);
        System.out.println(satTransitData.get());
	}
	
	//@Test
	public void testGetPlanetTransitData() throws Exception {
		Optional<List<PlanetTransitData>> transitData = transitInfoRepository.findByPlanetAndSequence(Planet.SAT, 50, 62);
        System.out.println(transitData.get());    		
	}
}