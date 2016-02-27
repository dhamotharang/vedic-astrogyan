package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.dto.TransitDTO;
import com.vedic.astro.dto.ZodDashaDTO;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.repository.TransitInfoRepository;
import com.vedic.astro.util.DateUtil;

@Service("transitService")
@Transactional
public class TransitService {

	@Autowired
	@Qualifier("transitInfoRepository")
	private TransitInfoRepository transitInfoRepository;

	public TransitDTO getTransit(Planet planet, Date asOfDate) throws BusinessException {
		TransitDTO transitInfo = null;
		Optional<PlanetTransitData> planetTransitData = transitInfoRepository.findByDateAndPlanet(asOfDate, planet);
		
		if(planetTransitData.isPresent()){
			PlanetTransitData transitData = planetTransitData.get();
			transitInfo = new TransitDTO(
					transitData.getZodiac(), 
					DateUtil.fromDate(transitData.getStartDate(), "dd/MM/yyyy"), 
					DateUtil.fromDate(transitData.getEndDate(), "dd/MM/yyyy"));
			
			if(transitData.getStartDate().before(asOfDate) && transitData.getEndDate().after(asOfDate)){
				transitInfo.setCurrent(true);
			}
		}
		return transitInfo;
	}
	
}
