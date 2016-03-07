package com.vedic.astro.calc.component;

import org.springframework.integration.annotation.Gateway;

import com.vedic.astro.domain.Member;


public interface BirthChartPipelineGateway {

	@Gateway(requestChannel="personalInfoChannel")
	public void startBirthChartPipeline(Member member);
}
