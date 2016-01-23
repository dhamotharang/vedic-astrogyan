package com.vedic.astro.pipeline.service;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class DashaStrengthsCalcService {
	
	@Async
	public void calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside DashaStrengthsCalcService: " + msg);
		
	}

}
