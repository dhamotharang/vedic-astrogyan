package test.vedic.astro.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.SubComponentDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;
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
	public void testCreateAnalysisSubComponent() throws Exception {
		
		SubComponentDTO subComponentDTO = new SubComponentDTO();
		subComponentDTO.setCode("SUB-COMP1");
		subComponentDTO.setComponentCode("COMP1");
		subComponentDTO.setName("Sub Component 1");
		subComponentDTO.setConditionChecked("Condition 1 checked");
		subComponentDTO.setPredictionTemplateCode("TST1");
		
		analysisComponentService.saveSubComponent(subComponentDTO);
 	}
	
	@Test
	public void testCreateAnalysisComponent() throws Exception {
		
		ComponentDTO componentDTO = new ComponentDTO();
		componentDTO.setCode("COMP1");
		componentDTO.setName("Component 1");
		componentDTO.setAnalysisGroup(AnalysisGroup.ChartAnalysis);
		componentDTO.setPredictionSystem(PredictionSystem.Prashara);
		
		analysisComponentService.saveComponent(componentDTO);
 	}
}