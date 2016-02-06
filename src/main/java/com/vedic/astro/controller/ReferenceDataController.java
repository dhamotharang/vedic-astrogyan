package com.vedic.astro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.dto.ReferenceDataDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.ReferenceDataService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class ReferenceDataController extends BaseController {

	@Autowired
	@Qualifier("referenceDataService")
	private ReferenceDataService referenceDataService;

	@RequestMapping(value = "/lookup/{referenceDataType}", method = 
			RequestMethod.GET)
	public RestServiceResponse<List<ReferenceDataDTO>> 
						get(@PathVariable String referenceDataType)
			throws BusinessException, SystemException {

		List<ReferenceDataDTO> lookupData = 
				referenceDataService.getReferenceData(referenceDataType);
		return new RestServiceResponse<List<ReferenceDataDTO>>(lookupData);
	}
}
