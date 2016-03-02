package com.vedic.astro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.AnalysisResultDTO;
import com.vedic.astro.dto.ComponentAnalysisResultDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.MemberProfileService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class MemberProfileController extends BaseController {

	@Autowired
	@Qualifier("memberProfileService")
	private MemberProfileService memberProfileService;


	@RequestMapping(value = "/analysis/result/{memberPid}", method = RequestMethod.GET)
	public RestServiceResponse<AnalysisResultDTO> getChartProfile(@PathVariable String memberPid)
			throws BusinessException, SystemException {

		AnalysisResultDTO analysisResultDTO = memberProfileService.getAnalysisResult(memberPid);

		return new RestServiceResponse<AnalysisResultDTO>(analysisResultDTO);
	}
	
	@RequestMapping(value = "/analysis/{predictionSystem}/{analysisGroup}/{memberId}", method = RequestMethod.GET)
	public RestServiceResponse<List<ComponentAnalysisResultDTO>> getAnalysis(@PathVariable PredictionSystem predictionSystem, @PathVariable AnalysisGroup analysisGroup, @PathVariable String memberId)
			throws BusinessException, SystemException {

		List<ComponentAnalysisResultDTO> analysisResultDTO = memberProfileService.getAnalysisResult(predictionSystem, analysisGroup, memberId);

		return new RestServiceResponse<List<ComponentAnalysisResultDTO>>(analysisResultDTO);
	}
}
