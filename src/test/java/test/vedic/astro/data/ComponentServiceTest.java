package test.vedic.astro.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.PredictionObservationDTO;
import com.vedic.astro.dto.PredictionOutcomeDTO;
import com.vedic.astro.dto.PredictionTemplateDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.service.AnalysisComponentService;

/**
 * Test case for unit testing the Member repository.
 * 
 * @author Sumeer Saxena
 *
 */
public class ComponentServiceTest extends BaseUtilTest{

	@Autowired
	@Qualifier("analysisComponentService")
	private AnalysisComponentService analysisComponentService;
	
	@Test
	public void testCreateAnalysisComponent() throws Exception {
		
		ComponentDTO componentDTO = new ComponentDTO();
		componentDTO.setAnalysisGroup(AnalysisGroup.HouseAnalysis);
		componentDTO.setCode("COMP1");
		componentDTO.setName("Component 1");
		componentDTO.setConditionChecked("Condition 1 checked");
		componentDTO.setPredictionTemplateCode("TST1");
		componentDTO.setEnabled(false);
		
		analysisComponentService.save(componentDTO);
 	}
}