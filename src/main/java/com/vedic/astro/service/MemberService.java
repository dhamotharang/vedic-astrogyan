package com.vedic.astro.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.pipeline.service.BirthChartPipelineGateway;
import com.vedic.astro.repository.MemberRepository;
import com.vedic.astro.vo.Member;

@Service("memberService")
@Transactional
public class MemberService {

	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;

	@Autowired
	private BirthChartPipelineGateway birthChartPipelineGateway;

	public String addMember(MemberDTO memberDTO) {
		Member member = new Member();
		BeanUtils.copyProperties(memberDTO, member);
		member = this.memberRepository.save(member);
		birthChartPipelineGateway.startBirthChartPipeline(member);

		return member.getPid();
	}

	public MemberDTO getMember(String id) throws BusinessException {
		Member member = this.memberRepository.findOne(id);
		if (member == null) {
			throw new BusinessException(
					Constants.MEMBER_NOT_FOUND, 
					"Member with this id does not exist");
		}
		MemberDTO memberDTO = new MemberDTO();
		BeanUtils.copyProperties(member, memberDTO);
		
		return memberDTO;
	}
}
