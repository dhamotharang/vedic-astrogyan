package com.vedic.astro.pipeline.service;

import org.springframework.integration.annotation.Gateway;

import com.vedic.astro.vo.Member;


public interface BirthChartPipelineGateway {

	@Gateway(requestChannel="personalInfoChannel")
	public void startBirthChartPipeline(Member personalInfo);
}
