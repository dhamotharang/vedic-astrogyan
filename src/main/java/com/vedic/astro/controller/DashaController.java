package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.DashaDTO;
import com.vedic.astro.dto.FindAntarDashaDTO;
import com.vedic.astro.dto.FindMainDashaDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.DashaService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class DashaController extends BaseController {

	@Autowired
	@Qualifier("dashaService")
	private DashaService dashaService;

	@RequestMapping(value = "/dashas/nak/main", method = RequestMethod.POST)
	public RestServiceResponse<List<DashaDTO>> getDashaPeriods(@RequestBody @Valid FindMainDashaDTO findMainDashaDTO)
			throws BusinessException, SystemException {
		List<DashaDTO> dashas = dashaService.getMainPeriods(findMainDashaDTO.getMemberPid(), findMainDashaDTO.getDate());

		return new RestServiceResponse<List<DashaDTO>>(dashas);
	}
	
	@RequestMapping(value = "/dashas/nak/subperiods", method = RequestMethod.POST)
	public RestServiceResponse<List<DashaDTO>> add(@RequestBody @Valid FindAntarDashaDTO findAntarDashaDTO) {
		
		List<DashaDTO> subperiods = dashaService.getSubPeriods(findAntarDashaDTO);
		return new RestServiceResponse<List<DashaDTO>>(subperiods);
	}
}
