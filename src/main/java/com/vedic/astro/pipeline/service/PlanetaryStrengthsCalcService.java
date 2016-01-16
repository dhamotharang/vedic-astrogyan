package com.vedic.astro.pipeline.service;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class PlanetaryStrengthsCalcService {
	
	
	public BirthChartMsg calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside PlanetaryStrengthsCalcService: " + msg);
		
		return new BirthChartMsg("123", "Router test");
		
	}

}
