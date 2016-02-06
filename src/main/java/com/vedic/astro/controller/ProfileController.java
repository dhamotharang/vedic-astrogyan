package com.vedic.astro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.ChartProfileDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.ProfileService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class ProfileController extends BaseController {

	@Autowired
	@Qualifier("profileService")
	private ProfileService profileService;

	@RequestMapping(value = "/profile/chart/{memberPid}", method = 
			RequestMethod.GET)
	public RestServiceResponse<ChartProfileDTO> 
						getChartProfile(@PathVariable String memberPid)
			throws BusinessException, SystemException {

		ChartProfileDTO chartProfileDTO = 
				profileService.getChartProfile(memberPid);
		
		return new RestServiceResponse<ChartProfileDTO>(
				chartProfileDTO);
	}
}
