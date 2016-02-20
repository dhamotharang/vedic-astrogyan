package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.PredictionObservationDTO;
import com.vedic.astro.dto.PredictionOutcomeDTO;
import com.vedic.astro.dto.PredictionTemplateDTO;
import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.service.ProfileService;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class ProfileServiceTest extends BaseUtilTest{

	@Autowired
	@Qualifier("profileService")
	private ProfileService profileService;
	
	//@Test
	public void testCreatePredictionTemplate() throws Exception {
		
		PredictionTemplateDTO predictionTemplateDTO = new PredictionTemplateDTO();
		predictionTemplateDTO.setCode("TST1");
		predictionTemplateDTO.setName("TST1-Name");
		
		List<String> aspectCodes = new ArrayList<String>();
		aspectCodes.add("6-PA");
		aspectCodes.add("4-4-SL");
		aspectCodes.add("5-WL");
		
		predictionTemplateDTO.setAspectCodes(aspectCodes);
		profileService.saveTemplate(predictionTemplateDTO);
 	}

	//@Test
	public void testGetAllPredictionTemplates() throws Exception {
		
		System.out.println(profileService.getAll());
 	}

	  // @Test
		public void testDeletePredictionTemplate() throws Exception {
			
			PredictionTemplateDTO predictionTemplateDTO = new PredictionTemplateDTO();
			predictionTemplateDTO.setCode("TST1");
			profileService.deleteTemplate(predictionTemplateDTO);
	 	}
	
		//@Test
		public void testSavePredictionOutcome() throws Exception {
			
			PredictionOutcomeDTO predictionOutcomeDTO = new PredictionOutcomeDTO();
			predictionOutcomeDTO.setCode("SUN-OUT1");
			predictionOutcomeDTO.setName("SUN-Outcome1");
			
			predictionOutcomeDTO.setTemplateCode("SUN");
			
			List<PredictionObservationDTO> observations = 
					new ArrayList<PredictionObservationDTO>();
			
			PredictionObservationDTO ob1 = new PredictionObservationDTO();
			ob1.setAspectCode("6-PA"); 
			ob1.setNature(ObservationNature.Benefic);
			ob1.setObservation("Observation 11");
			ob1.setTimeDependent(true);

			PredictionObservationDTO ob2 = new PredictionObservationDTO();
			ob2.setAspectCode("4-4-SL"); 
			ob2.setNature(ObservationNature.Malefic);
			ob2.setObservation("Observation 21");
			ob2.setTimeDependent(false);
			
			PredictionObservationDTO ob3 = new PredictionObservationDTO();
			ob3.setAspectCode("5-WL"); 
			ob3.setNature(ObservationNature.Benefic);
			ob3.setObservation("Observation 31");
			ob3.setTimeDependent(true);
			
			observations.add(ob1);
			observations.add(ob2);
			observations.add(ob3);
			
			List<String> aspectCodes = new ArrayList<String>();
			aspectCodes.add("6-PA");
			aspectCodes.add("4-4-SL");
			aspectCodes.add("5-WL");
			
			predictionOutcomeDTO.setObservations(observations);
			profileService.savePredictionOutcome(predictionOutcomeDTO);
	 	}
		
		@Test
		public void testCreatePredictionOutcome() throws Exception {
			
			PredictionOutcomeDTO predictionOutcomeDTO = new PredictionOutcomeDTO();
			predictionOutcomeDTO.setCode("SUN-OUT1");
			predictionOutcomeDTO.setName("SUN-Outcome1");
			
			predictionOutcomeDTO.setTemplateCode("SUN");
			
			profileService.createPredictionOutcome(predictionOutcomeDTO);
	 	}
}