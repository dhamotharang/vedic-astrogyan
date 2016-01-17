package com.vedic.astro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.PersonInfoService;
import com.vedic.astro.vo.PersonalInfo;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api/person")
final public class PersonController extends BaseController {

	@Autowired
	@Qualifier("personalInfoService")
	private PersonInfoService personalInfoService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestServiceResult<PersonalInfo> add(@RequestBody @Valid PersonalInfo personalInfo) {
		PersonalInfo savedPersonalInfo = personalInfoService.addPersonalInfo(personalInfo);
		return new RestServiceResult<PersonalInfo>(savedPersonalInfo);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public RestServiceResult<PersonalInfo> get(@PathVariable String id)
			throws BusinessException, SystemException {
		PersonalInfo personalInfo = personalInfoService.getPersonalInfo(id);
		return new RestServiceResult<PersonalInfo>(personalInfo);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public RestServiceResult<PersonalInfo> update(@PathVariable String id)
			throws BusinessException, SystemException {
		PersonalInfo personalInfo = personalInfoService.getPersonalInfo(id);
		return new RestServiceResult<PersonalInfo>(personalInfo);
	}
}
