package com.vedic.astro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.RashiChartHouseDTO;
import com.vedic.astro.dto.VargaChartHouseDTO;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.ChartService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class ChartController extends BaseController {

	@Autowired
	@Qualifier("chartService")
	private ChartService chartService;

	@RequestMapping(value = "/chart/rashi/{memberPid}", method = 
			RequestMethod.GET)
	public RestServiceResponse<List<RashiChartHouseDTO>> 
						getRashiChartData(@PathVariable String memberPid)
			throws BusinessException, SystemException {

		List<RashiChartHouseDTO> chartHouseDTOList = 
				chartService.getRashiChart(memberPid);
		
		return new RestServiceResponse<List<RashiChartHouseDTO>>(
				chartHouseDTOList);
	}
	
	@RequestMapping(value = "/chart/{chartType}/{memberPid}", method = 
			RequestMethod.GET)
	public RestServiceResponse<List<VargaChartHouseDTO>> 
						getChartData(@PathVariable BirthChartType chartType, @PathVariable String memberPid)
			throws BusinessException, SystemException {

		List<VargaChartHouseDTO> chartHouseDTOList = 
				chartService.getVargaChart(chartType, memberPid);
		
		return new RestServiceResponse<List<VargaChartHouseDTO>>(
				chartHouseDTOList);
	}
}
