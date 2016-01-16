package com.vedic.astro.pipeline.service;

import com.vedic.astro.pipeline.msg.BirthChartMsg;
import com.vedic.astro.pipeline.msg.DivChartMsg;

public class DivChartCalcService {
	
	
	public DivChartMsg calculateDivCharts(BirthChartMsg msg){
		
		System.out.println("Inside DivChartCalcService: " + msg);
		
		return new DivChartMsg("1", "description1");
		
	}

}
