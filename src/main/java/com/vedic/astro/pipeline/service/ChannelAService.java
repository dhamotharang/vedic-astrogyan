package com.vedic.astro.pipeline.service;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;

public class ChannelAService {
	
	@Async
	public void calculateStrengths(BirthChartMsg msg){
		
		System.out.println("Inside ChannelAService: " + msg);
		
	}

}
