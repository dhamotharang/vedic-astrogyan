package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.SubComponentDTO;
import com.vedic.astro.dto.SubComponentInfoDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.AnalysisComponentService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class AnalysisComponentController extends BaseController {

	@Autowired
	@Qualifier("analysisComponentService")
	private AnalysisComponentService analysisComponentService;

	@RequestMapping(value = "/subComponent/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveSubComponent(@RequestBody @Valid SubComponentDTO subComponentDTO) throws BusinessException, SystemException {
		analysisComponentService.saveSubComponent(subComponentDTO);
		String returnValue = "Subcomponent saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/subComponent/delete", method = RequestMethod.POST)
	public RestServiceResponse<String> deleteSubComponent(@RequestBody @Valid SubComponentDTO subComponentDTO) throws BusinessException, SystemException {

		analysisComponentService.deleteSubComponent(subComponentDTO);
		String returnValue = "Subcomponent deleted successfully";
		return new RestServiceResponse<String>(returnValue);
	}
	
	@RequestMapping(value = "/component/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveComponent(@RequestBody @Valid ComponentDTO componentDTO) throws BusinessException, SystemException {
		analysisComponentService.saveComponent(componentDTO);
		String returnValue = "Component saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/component/delete", method = RequestMethod.POST)
	public RestServiceResponse<String> deleteComponent(@RequestBody @Valid ComponentDTO componentDTO) throws BusinessException, SystemException {

		analysisComponentService.deleteComponent(componentDTO);
		String returnValue = "Component deleted successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/subComponents/{componentCode}", method = RequestMethod.GET)
	public RestServiceResponse<List<SubComponentInfoDTO>> getSubComponents(
			@PathVariable String componentCode) throws BusinessException, SystemException {

		List<SubComponentInfoDTO> componentDTOList = 
				analysisComponentService.findByComponent(componentCode);
		return new RestServiceResponse<List<SubComponentInfoDTO>>(
				componentDTOList);
	}
	
	@RequestMapping(value = "/components/{predictionSystem}/{analysisGroup}", method = RequestMethod.GET)
	public RestServiceResponse<List<ComponentDTO>> getComponents(
			@PathVariable PredictionSystem predictionSystem, @PathVariable AnalysisGroup analysisGroup) throws BusinessException, SystemException {

		List<ComponentDTO> componentDTOList = 
				analysisComponentService.findBySource(analysisGroup, predictionSystem);
		return new RestServiceResponse<List<ComponentDTO>>(
				componentDTOList);
	}

	@RequestMapping(value = "/subComponents/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveComponents(@RequestBody @Valid List<SubComponentInfoDTO> componentDTOList) throws BusinessException, SystemException {
		analysisComponentService.save(componentDTOList);
		String returnValue = "Components saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}
}
