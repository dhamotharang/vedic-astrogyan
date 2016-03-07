package com.vedic.astro.calc.component;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.LocationInfo;
import com.vedic.astro.domain.Member;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.LocationInfoRepository;
import com.vedic.astro.service.PlanetPositionsDataService;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;

public class BirthChartCalcComponent {
	
	@Autowired
	@Qualifier("planetPositionsDataService")
	private PlanetPositionsDataService planetPositionsDataService;

	@Autowired
	@Qualifier("locationInfoRepository")
	private LocationInfoRepository locationInfoRepository;

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;
 
	@Async
	public BirthChartData calcBirthChart(Member member){
		
		Optional<List<LocationInfo>> locationList = locationInfoRepository.getLocationByCountryAndCity(
				member.getCountryCode(), 
				member.getCityCode());
		
		Integer locationId = null;
		
		if(locationList.isPresent()){
		   locationId = locationList.get().get(0).getLocationId();
		}
		
		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService.getPlanetPositionsData(
						DateUtil.fromDate(member.getDateOfBirth(), "dd/MM/yyyy"), 
						DateUtil.fromDate(member.getDateOfBirth(), "kk:mm:ss"), 
						locationId);
		
		System.out.println("absolutePlanetaryPositions =" + absolutePlanetaryPositions);
		
		BirthChartData birthChartData = birthChartUtil.generateD1Chart(absolutePlanetaryPositions);
		birthChartData.setPid(member.getPid());
		
		birthChartRepository.save(birthChartData);
		
		return birthChartData;
		
	}

}
