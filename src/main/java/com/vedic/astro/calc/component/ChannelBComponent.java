package com.vedic.astro.calc.component;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class ChannelBComponent {
	
	@Async
	public void calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside ChannelBService: " + msg);
		
	}

}
