package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.repository.PersonalInfoRepository;
import com.vedic.astro.vo.PersonalInfo;

@Service("personalInfoService")
@Transactional
public class PersonInfoService {

	@Autowired
	@Qualifier("personalInfoRepository")
	private PersonalInfoRepository personalInfoRepository;

	public String addPersonalInfo(PersonalInfo personalInfo){
		
		String pid = this.personalInfoRepository.add(personalInfo);

		return pid;
	}

	public PersonalInfo getPersonalInfo(String pid){
		
		PersonalInfo personalInfo  = this.personalInfoRepository.findBy(pid);

		return personalInfo;
	}

}
