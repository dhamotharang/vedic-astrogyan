package com.vedic.astro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.ReferenceData;
import com.vedic.astro.dto.ReferenceDataDTO;
import com.vedic.astro.repository.ReferenceDataRepository;

@Service("referenceDataService")
@Transactional
public class ReferenceDataService {

	@Autowired
	@Qualifier("referenceDataRepository")
	private ReferenceDataRepository referenceDataRepository;

	
	public List<ReferenceDataDTO> getReferenceData(String type) {
		 Optional<ReferenceData> referenceData = referenceDataRepository.getReferenceData(type);
		
		return referenceData.get().getData();
	}
	
	public ReferenceDataDTO getReferenceData(String type, String code) {
		 Optional<ReferenceData> referenceData = referenceDataRepository.getReferenceData(type);
		 ReferenceDataDTO returnData = null;
		 
		 for(ReferenceDataDTO referenceDataDTO : referenceData.get().getData()){
			 if(referenceDataDTO.getCode().equals(code)){
				 returnData = referenceDataDTO;
			 }
		 }
		return returnData;
	}
}
