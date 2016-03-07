package com.vedic.astro.analysis.component;

import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.pipeline.msg.BirthChartMsg;
import com.vedic.astro.pipeline.msg.DivChartMsg;

public class DivChartAnalysisComponent {
	
	@Async
	public BirthChartMsg analyzeDivCharts(DivChartMsg msg){
		System.out.println("Inside DivChartAnalysisService: " + msg);
		
		return new BirthChartMsg("123", "Testing Pub-Sub channel");
	}

}
