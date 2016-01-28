package com.vedic.astro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.MemberService;
import com.vedic.astro.vo.Member;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api/member")
final public class MemberController extends BaseController {

	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RestServiceResponse<String> add(@RequestBody @Valid MemberDTO memberDTO) {
		
		String pid = memberService.addMember(memberDTO);
		return new RestServiceResponse<String>(pid);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public RestServiceResponse<MemberDTO> get(@PathVariable String id)
			throws BusinessException, SystemException {
		
		MemberDTO memberDTO = memberService.getMember(id);
		return new RestServiceResponse<MemberDTO>(memberDTO);
	}
}
