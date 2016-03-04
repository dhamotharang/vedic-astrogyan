package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.UserCredentialsDTO;
import com.vedic.astro.dto.UserDTO;
import com.vedic.astro.dto.UserInfoDTO;
import com.vedic.astro.dto.UserSummaryDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.AdminService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class AdminController extends BaseController {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestServiceResponse<UserDTO> login(@RequestBody @Valid UserCredentialsDTO userCredentials)
			throws BusinessException {
		UserDTO userDTO = adminService.login(userCredentials);
		return new RestServiceResponse<UserDTO>(userDTO);
	}
	
	@RequestMapping(value = "/update/lastViewedMember", method = RequestMethod.POST)
	public RestServiceResponse<String> login(@RequestBody @Valid UserDTO userDTO)
			throws BusinessException {
		adminService.updateLastViewedMember(userDTO);
		String msg = "Last viewed member updated successfully";
		return new RestServiceResponse<String>(msg);
	}
	
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public RestServiceResponse<String> saveUser(@RequestBody @Valid UserInfoDTO userInfoDTO)
			throws BusinessException {
		adminService.save(userInfoDTO);
		String msg = "User saved successfully";
		return new RestServiceResponse<String>(msg);
	}
	
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public RestServiceResponse<List<UserSummaryDTO>> getAll()
			throws BusinessException {
		List<UserSummaryDTO> userSummaryList =  adminService.getAll();
		return new RestServiceResponse<List<UserSummaryDTO>>(userSummaryList);
	}
	
	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	public RestServiceResponse<UserInfoDTO> get(@PathVariable String id)
			throws BusinessException, SystemException {
		
		UserInfoDTO userInfoDTO = adminService.get(id);
		return new RestServiceResponse<UserInfoDTO>(userInfoDTO);
	}
}
