package com.vedic.astro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vedic.astro.enums.Gender;
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
@Controller
@RequestMapping("/main")
public class PersonController extends BaseController {

	@Autowired
	@Qualifier("personalInfoService")
	private PersonInfoService personalInfoService;


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
		result.setResponseData(pid);

		return result;
	}

	@RequestMapping(value = "/person/info/{id}", method = RequestMethod.GET)
	public @ResponseBody
	RestServiceResult<PersonalInfo> getPersonInfo(@PathVariable String id)
			throws BusinessException, SystemException {

		RestServiceResult<PersonalInfo> result = new RestServiceResult<PersonalInfo>();
/*		PersonalInfo personalInfo = personalInfoService.getPersonalInfo(id);
		result.setData(personalInfo);
*/
		
		PersonalInfo personalInfo = new PersonalInfo();
		
		personalInfo.setFirstName("Shailja");
		personalInfo.setLastName("Saxena");
		personalInfo.setGender(Gender.Female);
		personalInfo.setDob("10/07/1976");
		result.setResponseData(personalInfo);

		return result;

	}
}
