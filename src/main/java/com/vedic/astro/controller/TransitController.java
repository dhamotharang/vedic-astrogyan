package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.NakDashaDTO;
import com.vedic.astro.dto.PlanetTransitInputDTO;
import com.vedic.astro.dto.TransitDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.TransitService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class TransitController extends BaseController {

	@Autowired
	@Qualifier("transitService")
	private TransitService transitService;

	@RequestMapping(value = "/transit/planet", method = RequestMethod.POST)
	public RestServiceResponse<TransitDTO> getPlanetTransit(@RequestBody @Valid PlanetTransitInputDTO planetTransitInputDTO)
			throws BusinessException, SystemException {
		TransitDTO transitInfo = transitService.getTransit(
				planetTransitInputDTO.getPlanet(), 
				planetTransitInputDTO.getAsOfDate());

		return new RestServiceResponse<TransitDTO>(transitInfo);
	}
}
