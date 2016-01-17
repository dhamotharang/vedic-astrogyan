package test.vedic.astro.data;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.LocationInfo;
import com.vedic.astro.repository.LocationInfoRepository;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class LocationRepositoryTest extends BaseUtilTest{

	@Autowired
	@Qualifier("locationInfoRepository")
	private LocationInfoRepository locationInfoRepository;
	

	//@Test
	public void testCreateLocationInfo() throws Exception {
		LocationInfo locationInfo = new LocationInfo("IND","DL", 10304);
		LocationInfo savedLocationInfo = locationInfoRepository.save(locationInfo);
        System.out.println(savedLocationInfo);    		
	}
	
	@Test
	public void testfindLocationInfo() throws Exception {
		
		List<LocationInfo> locations = locationInfoRepository.getLocationByCountryAndCity("IND", "DL");
        System.out.println(locations);    		
	}
}