package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.EntityRelationshipRefData;
import com.vedic.astro.repository.EntityRelRepository;
import com.vedic.astro.util.BaseEntityRelationshipRefData;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class EntityRelRefDataRepositoryTest extends BaseEntityRelationshipRefData{

	@Autowired
	@Qualifier("entityRelRepository")
	private EntityRelRepository entityRelRepository;

	/**
	 * Tests the create member functionality.
	 * 
	 * @throws Exception
	 */
	//@Test
	public void testCreatePlanet_PlanetRelRefData() throws Exception {

		EntityRelationshipRefData planetRelData = super.createPlanet_PlanetRelRefData();
		entityRelRepository.add(planetRelData);

	}

	//@Test
	public void testCreatePlanet_HouseRelRefData() throws Exception {

		EntityRelationshipRefData planetRelData = super.createPlanet_HouseRelRefData();
		entityRelRepository.add(planetRelData);

	}

	//@Test
	public void testCreatePlanet_ZodiacRelRefData() throws Exception {

		EntityRelationshipRefData planetRelData = super.createPlanet_ZodiacRelRefData();
		entityRelRepository.add(planetRelData);

	}

}