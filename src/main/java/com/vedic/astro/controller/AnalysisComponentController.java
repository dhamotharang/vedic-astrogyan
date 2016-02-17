package com.vedic.astro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.service.AnalysisComponentService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class AnalysisComponentController extends BaseController {

	@Autowired
	@Qualifier("analysisComponentService")
	private AnalysisComponentService analysisComponentService;

}
