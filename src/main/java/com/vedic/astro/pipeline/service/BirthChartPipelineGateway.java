package com.vedic.astro.pipeline.service;

import org.springframework.integration.annotation.Gateway;

import com.vedic.astro.vo.PersonalInfo;


public interface BirthChartPipelineGateway {

	@Gateway(requestChannel="personalInfoChannel")
	public void startBirthChartPipeline(PersonalInfo personalInfo);
}
