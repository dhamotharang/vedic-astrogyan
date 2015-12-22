package com.vedic.astro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.AstroPredictiveService;
import com.vedic.astro.service.DashaPredictService;
import com.vedic.astro.service.PersonInfoService;
import com.vedic.astro.vo.PersonalInfo;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

	@Autowired
	@Qualifier("astroPredictiveService")
	private AstroPredictiveService astroPredictiveService;

	@Autowired
	@Qualifier("personalInfoService")
	private PersonInfoService personalInfoService;

	@Autowired
	@Qualifier("dashaPredictService")
	private DashaPredictService dashaPredictService;


	/**
	 * Adds the given nurse to the system.
	 * 
	 * @param nurse
	 *            <tt>Nurse</tt> object
	 * @return UUID generated for the nurse
	 */
	@RequestMapping(value = "/person/info/add", method = RequestMethod.POST)
	public @ResponseBody
	RestServiceResult<String> addPersonalInfo(
			@Validated({ Default.class }) @RequestBody PersonalInfo personalInfo,
			HttpServletRequest request) throws BusinessException,
			SystemException {

		RestServiceResult<String> result = new RestServiceResult<String>();
		// If the emailID of the given nurse is present in the system,
		// it throws a BusinessException
		String pid = personalInfoService.addPersonalInfo(personalInfo);
		result.setData(pid);

		return result;
	}

	/*
	@RequestMapping(value = "/predict/dasha", method = RequestMethod.POST)
	public @ResponseBody
	RestServiceResult<DashaPeriodPrediction> predictBasicChartInBrief(
			@Validated({ Default.class }) @RequestBody DashaPredictRequest dashaPredictRequest,
			HttpServletRequest request) throws BusinessException,
			SystemException {

		RestServiceResult<DashaPeriodPrediction> result = new RestServiceResult<DashaPeriodPrediction>();
		// If the emailID of the given nurse is present in the system,
		// it throws a BusinessException
		result.setData(dashaPredictService.predictDashaPeriod(
				dashaPredictRequest.getPid(), 
				dashaPredictRequest.getDate(), 
				dashaPredictRequest.getDashaSystem()));

		return result;
	}
	
	
	@RequestMapping(value = "/predict/event", method = RequestMethod.POST)
	public @ResponseBody
	RestServiceResult<Map<DashaTimePeriod, DashaPeriodPrediction>> predictEvent(
			@Validated({ Default.class }) @RequestBody LifeEventPrediction lifeEventPrediction,
			HttpServletRequest request) throws BusinessException,
			SystemException {

		RestServiceResult<Map<DashaTimePeriod, DashaPeriodPrediction>> result = new RestServiceResult<Map<DashaTimePeriod, DashaPeriodPrediction>>();
		// If the emailID of the given nurse is present in the system,
		// it throws a BusinessException
		result.setData(dashaPredictService.predictDashaEvent(lifeEventPrediction));

		return result;
	}

	@RequestMapping(value = "/find/dasha", method = RequestMethod.POST)
	public @ResponseBody
	RestServiceResult<DashaCombination> findDasha(
			@Validated({ Default.class }) @RequestBody DashaPredictRequest dashaPredictRequest,
			HttpServletRequest request) throws BusinessException,
			SystemException {

		RestServiceResult<DashaCombination> result = new RestServiceResult<DashaCombination>();
		// If the emailID of the given nurse is present in the system,
		// it throws a BusinessException
		result.setData(dashaPredictService.findDashaCombination(dashaPredictRequest.getPid(), 
				dashaPredictRequest.getDate(), 
				dashaPredictRequest.getDashaSystem()));

		return result;
	}
*/
}
