package com.vedic.astro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.UserCredentialsDTO;
import com.vedic.astro.dto.UserDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.service.AuthService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api/auth")
final public class LoginController extends BaseController {

	@Autowired
	@Qualifier("authService")
	private AuthService authService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public RestServiceResponse<UserDTO> login(@RequestBody @Valid UserCredentialsDTO userCredentials)
			throws BusinessException {
		UserDTO userDTO = authService.login(userCredentials);
		return new RestServiceResponse<UserDTO>(userDTO);
	}
}
