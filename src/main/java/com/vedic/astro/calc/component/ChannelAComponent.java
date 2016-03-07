package com.vedic.astro.calc.component;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class ChannelAComponent {
	
	@Async
	public void calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside ChannelAService: " + msg);
		
	}

}
