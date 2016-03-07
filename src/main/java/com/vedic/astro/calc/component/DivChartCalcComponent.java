package com.vedic.astro.calc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.pipeline.msg.DivChartMsg;
import com.vedic.astro.repository.VargaChartRepository;
import com.vedic.astro.util.DivChartUtil;

public class DivChartCalcComponent {
	
	@Autowired
	@Qualifier("vargaChartRepository")
	private VargaChartRepository vargaChartRepository;

	@Autowired
	@Qualifier("divChartUtil")
	private DivChartUtil divChartUtil;
	
	@Async
	public DivChartMsg calculateDivCharts(BirthChartData birthChartData){
		
		VargaBirthChartData d2Chart = divChartUtil.generateDivChart(BirthChartType.D2, birthChartData);
		vargaChartRepository.save(d2Chart);
	
		VargaBirthChartData d3Chart = divChartUtil.generateDivChart(BirthChartType.D3, birthChartData);
		vargaChartRepository.save(d3Chart);

		VargaBirthChartData d4Chart = divChartUtil.generateDivChart(BirthChartType.D4, birthChartData);
		vargaChartRepository.save(d4Chart);

		VargaBirthChartData d5Chart = divChartUtil.generateDivChart(BirthChartType.D5, birthChartData);
		vargaChartRepository.save(d5Chart);

		VargaBirthChartData d7Chart = divChartUtil.generateDivChart(BirthChartType.D7, birthChartData);
		vargaChartRepository.save(d7Chart);

		VargaBirthChartData d9Chart = divChartUtil.generateDivChart(BirthChartType.D9, birthChartData);
		vargaChartRepository.save(d9Chart);

		VargaBirthChartData d10Chart = divChartUtil.generateDivChart(BirthChartType.D10, birthChartData);
		vargaChartRepository.save(d10Chart);

		VargaBirthChartData d12Chart = divChartUtil.generateDivChart(BirthChartType.D12, birthChartData);
		vargaChartRepository.save(d12Chart);

		VargaBirthChartData d16Chart = divChartUtil.generateDivChart(BirthChartType.D16, birthChartData);
		vargaChartRepository.save(d16Chart);

		return new DivChartMsg("1", "description1");
	}
}
