package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.EntityRefData;
import com.vedic.astro.domain.HouseDetails;
import com.vedic.astro.domain.PlanetDetails;
import com.vedic.astro.domain.ZodiacDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.repository.EntityRepository;
import com.vedic.astro.util.BaseEntityRefData;
import com.vedic.astro.util.HouseUtil;
import com.vedic.astro.util.PlanetUtil;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class EntityRefDataRepositoryTest extends BaseUtilTest{

	@Autowired
	@Qualifier("entityRepository")
	private EntityRepository entityRepository;
	
	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;
	
	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testCreatePlanetRefData() throws Exception {

		EntityRefData<PlanetDetails> planetData = BaseEntityRefData.createPlanetRefData();
		entityRepository.addPlanetRefData(planetData);

	}
	
	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testCreateHouseRefData() throws Exception {

		EntityRefData<HouseDetails> houseData = BaseEntityRefData.createHouseRefData();
		entityRepository.addHouseRefData(houseData);

	}
	
	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testCreateZodiacRefData() throws Exception {

		EntityRefData<ZodiacDetails> zodiacData = BaseEntityRefData.createZodiacRefData();
		entityRepository.addZodiacRefData(zodiacData);

	}
	
	@Test
	public void testGetHouseRefData() throws Exception {

	  HouseDetails house1 = houseUtil.getHouseDetails(House.H1);
	  System.out.println(house1);
	  
	  HouseDetails house2 = houseUtil.getHouseDetails(House.H2);
	  System.out.println(house2);	

	  HouseDetails house3 = houseUtil.getHouseDetails(House.H3);
	  System.out.println(house3);	

		
	}
	
}