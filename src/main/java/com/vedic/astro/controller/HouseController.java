package com.vedic.astro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.HousesStrengthDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.HouseService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class HouseController extends BaseController {

	@Autowired
	@Qualifier("houseService")
	private HouseService houseService;

	@RequestMapping(value = "/houses/strength/{memberPid}", method = 
			RequestMethod.GET)
	public RestServiceResponse<HousesStrengthDTO> 
						get(@PathVariable String memberPid)
			throws BusinessException, SystemException {

		HousesStrengthDTO housesStrengthDTO = 
				houseService.getHousesStrengths(memberPid);
		return new RestServiceResponse<HousesStrengthDTO>(
				housesStrengthDTO);
	}
}
