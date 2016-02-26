package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.FindNakAntarDashaDTO;
import com.vedic.astro.dto.FindNakMainDashaDTO;
import com.vedic.astro.dto.FindZodAntarDashaDTO;
import com.vedic.astro.dto.FindZodMainDashaDTO;
import com.vedic.astro.dto.NakDashaDTO;
import com.vedic.astro.dto.ZodDashaDTO;
import com.vedic.astro.enums.NakDashaSystem;
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
	public RestServiceResponse<List<NakDashaDTO>> getNakDashaMainPeriods(@RequestBody @Valid FindNakMainDashaDTO findMainDashaDTO)
			throws BusinessException, SystemException {
		List<NakDashaDTO> dashas = dashaService.getNakDashaMainPeriods(findMainDashaDTO.getMemberPid(), findMainDashaDTO.getAsOfDate(), findMainDashaDTO.getDashaSystem());

		return new RestServiceResponse<List<NakDashaDTO>>(dashas);
	}
	
	@RequestMapping(value = "/dashas/nak/subperiods", method = RequestMethod.POST)
	public RestServiceResponse<List<NakDashaDTO>> add(@RequestBody @Valid FindNakAntarDashaDTO findAntarDashaDTO) {
		
		List<NakDashaDTO> subperiods = dashaService.getNakDashaSubPeriods(findAntarDashaDTO);
		return new RestServiceResponse<List<NakDashaDTO>>(subperiods);
	}
	
	@RequestMapping(value = "/dashas/zod/main", method = RequestMethod.POST)
	public RestServiceResponse<List<ZodDashaDTO>> getDashaPeriods(@RequestBody @Valid FindZodMainDashaDTO findMainDashaDTO)
			throws BusinessException, SystemException {
		List<ZodDashaDTO> dashas = dashaService.getZodDashaMainPeriods(findMainDashaDTO.getMemberPid(), findMainDashaDTO.getAsOfDate(), findMainDashaDTO.getDashaSystem());

		return new RestServiceResponse<List<ZodDashaDTO>>(dashas);
	}
	
	@RequestMapping(value = "/dashas/zod/subperiods", method = RequestMethod.POST)
	public RestServiceResponse<List<ZodDashaDTO>> add(@RequestBody @Valid FindZodAntarDashaDTO findAntarDashaDTO) {
		
		List<ZodDashaDTO> subperiods = dashaService.getZodDashaSubPeriods(findAntarDashaDTO);
		return new RestServiceResponse<List<ZodDashaDTO>>(subperiods);
	}
}
