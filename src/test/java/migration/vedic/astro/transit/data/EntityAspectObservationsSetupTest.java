package migration.vedic.astro.transit.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.EntityAspectMappingDTO;
import com.vedic.astro.enums.EntityType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.EntityAspectObservationRepository;
import com.vedic.astro.service.ProfileService;

import test.vedic.astro.data.BaseUtilTest;

public class EntityAspectObservationsSetupTest extends BaseUtilTest {
 
	@Autowired
	@Qualifier("entityAspectObservationRepository")
	private EntityAspectObservationRepository entityAspectObservationRepository;

	@Autowired
	@Qualifier("profileService")
	private ProfileService profileService;

	@Test
	public void setupEntityMapping() {
		List<EntityAspectMappingDTO> entityMapping = new ArrayList<EntityAspectMappingDTO>();

		entityMapping.add(new EntityAspectMappingDTO("2.1", EntityType.House, House.H1.name()));
		entityMapping.add(new EntityAspectMappingDTO("2.2", EntityType.House, House.H2.name()));
		entityMapping.add(new EntityAspectMappingDTO("3.1", EntityType.House, House.H3.name()));
		entityMapping.add(new EntityAspectMappingDTO("3.2", EntityType.House, House.H4.name()));
		entityMapping.add(new EntityAspectMappingDTO("1.1.1", EntityType.House, House.H5.name()));
		entityMapping.add(new EntityAspectMappingDTO("1.1.2", EntityType.House, House.H6.name()));
		
		entityMapping.add(new EntityAspectMappingDTO("2.1", EntityType.Planet, Planet.JUP.name()));
		entityMapping.add(new EntityAspectMappingDTO("2.2", EntityType.Planet, Planet.SUN.name()));
		entityMapping.add(new EntityAspectMappingDTO("3.1", EntityType.Planet, Planet.SAT.name()));
		entityMapping.add(new EntityAspectMappingDTO("3.2", EntityType.Planet, Planet.MER.name()));
		entityMapping.add(new EntityAspectMappingDTO("1.1.1", EntityType.Planet, Planet.MAR.name()));
		entityMapping.add(new EntityAspectMappingDTO("1.1.2", EntityType.Planet, Planet.MON.name()));
		
		profileService.mapEntityToAspect(entityMapping);
	}
	
	}
