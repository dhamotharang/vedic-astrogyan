package com.vedic.astro.pipeline.service;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.pipeline.msg.DivChartMsg;

public class DivChartCalcService {
	
	@Async
	public DivChartMsg calculateDivCharts(BirthChartData msg){
		
		System.out.println("Inside DivChartCalcService: " + msg);
		return new DivChartMsg("1", "description1");
	}
}
