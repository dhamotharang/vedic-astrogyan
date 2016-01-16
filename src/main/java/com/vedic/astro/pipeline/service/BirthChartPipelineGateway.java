package com.vedic.astro.pipeline.service;

import org.springframework.integration.annotation.Gateway;

import com.vedic.astro.pipeline.msg.BirthChartMsg;


public interface BirthChartPipelineGateway {
	
	@Gateway(requestChannel="birthChartChannel")
	void placeOrder(BirthChartMsg birthChartMsg);


}
