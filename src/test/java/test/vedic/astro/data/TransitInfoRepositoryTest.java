package test.vedic.astro.data;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.TransitInfoRepository;
import com.vedic.astro.util.BaseEntityRefData;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class TransitInfoRepositoryTest extends BaseEntityRefData{

	@Autowired
	@Qualifier("transitInfoRepository")
	private TransitInfoRepository transitInfoRepository;
	

	@Test
	public void testGetPlanetTransitData() throws Exception {
		PlanetTransitData transitData = transitInfoRepository.findBy(new Date(), Planet.SAT);
        System.out.println(transitData);    		
	}
}