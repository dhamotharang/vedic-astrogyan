package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.Member;
import com.vedic.astro.repository.MemberRepository;

@Service("birthChartService")
@Transactional
public class BirthChartService {

	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;

    
	public String addPersonalInfo(Member personalInfo){
		
		String pid = this.memberRepository.save(personalInfo).getPid();
		return pid;
	}
}