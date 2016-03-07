package com.vedic.astro.calc.component;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class PlanetaryStrengthsCalcComponent {
	
	@Async
	public BirthChartMsg calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside PlanetaryStrengthsCalcService: " + msg);
		
		return new BirthChartMsg("123", "Router test");
		
	}

}
