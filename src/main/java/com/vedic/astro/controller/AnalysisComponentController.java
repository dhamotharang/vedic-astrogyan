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
import com.vedic.astro.dto.ComponentInfoDTO;
import com.vedic.astro.enums.AnalysisGroup;
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

	@RequestMapping(value = "/component/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveComponent(@RequestBody @Valid ComponentDTO componentDTO) throws BusinessException, SystemException {
		analysisComponentService.save(componentDTO);
		String returnValue = "Component saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/component/delete", method = RequestMethod.POST)
	public RestServiceResponse<String> deleteComponent(@RequestBody @Valid ComponentDTO componentDTO) throws BusinessException, SystemException {

		analysisComponentService.delete(componentDTO);
		String returnValue = "Component deleted successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/components/{analysisGroup}", method = RequestMethod.GET)
	public RestServiceResponse<List<ComponentInfoDTO>> getComponents(
			@PathVariable AnalysisGroup analysisGroup) throws BusinessException, SystemException {

		List<ComponentInfoDTO> componentDTOList = 
				analysisComponentService.findBySource(analysisGroup);
		return new RestServiceResponse<List<ComponentInfoDTO>>(
				componentDTOList);
	}
	
	@RequestMapping(value = "/components/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveComponents(@RequestBody @Valid List<ComponentInfoDTO> componentDTOList) throws BusinessException, SystemException {
		analysisComponentService.save(componentDTOList);
		String returnValue = "Components saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}
}
