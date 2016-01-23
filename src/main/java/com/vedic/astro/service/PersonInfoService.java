package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.pipeline.service.BirthChartPipelineGateway;
import com.vedic.astro.repository.PersonalInfoRepository;
import com.vedic.astro.vo.PersonalInfo;

@Service("personalInfoService")
@Transactional
public class PersonInfoService {

	@Autowired
	@Qualifier("personalInfoRepository")
	private PersonalInfoRepository personalInfoRepository;

	@Autowired
	private BirthChartPipelineGateway birthChartPipelineGateway;

	public PersonalInfo addPersonalInfo(PersonalInfo personalInfo) {
		PersonalInfo savedPersonalInfo = this.personalInfoRepository.save(personalInfo);
		birthChartPipelineGateway.startBirthChartPipeline(savedPersonalInfo);

		return savedPersonalInfo;
	}

	public PersonalInfo getPersonalInfo(String id) throws BusinessException {
		PersonalInfo personalInfo = this.personalInfoRepository.findOne(id);
		if (personalInfo == null) {
			throw new BusinessException("personDoesNotExist", "Person with this pid does not exist");
		}
		return personalInfo;
	}

}
