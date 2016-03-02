package com.vedic.astro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.PlanetaryStrengthDTO;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.PlanetService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class PlanetController extends BaseController {

	@Autowired
	@Qualifier("planetService")
	private PlanetService planetService;

	@RequestMapping(value = "planets/strength/{predictionSystem}/{memberPid}", method = 
			RequestMethod.GET)
	public RestServiceResponse<PlanetaryStrengthDTO> 
						get(@PathVariable PredictionSystem predictionSystem, @PathVariable String memberPid)
			throws BusinessException, SystemException {

		PlanetaryStrengthDTO planetaryStrengthDTO = 
				planetService.getPlanetaryStrengths(predictionSystem, memberPid);
		return new RestServiceResponse<PlanetaryStrengthDTO>(
				planetaryStrengthDTO);
	}
}
