package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.Member;
import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.dto.MemberSummaryDTO;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.pipeline.service.BirthChartPipelineGateway;
import com.vedic.astro.repository.MemberRepository;
import com.vedic.astro.util.DateUtil;

@Service("memberService")
@Transactional
public class MemberService {

	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;

	@Autowired
	@Qualifier("referenceDataService")
	private ReferenceDataService referenceDataService;

	@Autowired
	@Qualifier("birthChartPipelineGateway")
	private BirthChartPipelineGateway birthChartPipelineGateway;

	public String saveMember(MemberDTO memberDTO) {

		Member member = this.memberRepository.save(convertfromDTO(memberDTO));
		birthChartPipelineGateway.startBirthChartPipeline(member);

		return member.getPid();
	}

	public MemberDTO getMember(String id) throws BusinessException {
		Member member = this.memberRepository.findOne(id);
		if (member == null) {
			throw new BusinessException(Constants.MEMBER_NOT_FOUND, "Member with this id does not exist");
		}

		return convertToDTO(member);
	}

	public List<MemberDTO> getAllMembers() throws BusinessException {
		Iterable<Member> members = this.memberRepository.findAll();
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();

		for (Member member : members) {
			memberList.add(convertToDTO(member));
		}

		return memberList;
	}

	public List<MemberSummaryDTO> getAllMembersSummary() throws BusinessException {
		Iterable<Member> members = this.memberRepository.findAll();
		List<MemberSummaryDTO> memberList = new ArrayList<MemberSummaryDTO>();

		for (Member member : members) {

			MemberSummaryDTO memberSummaryDTO = new MemberSummaryDTO();
			memberSummaryDTO.setName(member.getFirstName() + " " + member.getLastName());
			memberSummaryDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), "MM/dd/yyyy hh:mm a"));
			memberSummaryDTO.setId(member.getPid());

			memberList.add(memberSummaryDTO);
		}

		return memberList;
	}

	private MemberDTO convertToDTO(Member member) {

		MemberDTO memberDTO = new MemberDTO();
		BeanUtils.copyProperties(member, memberDTO);
		memberDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), "MM/dd/yyyy hh:mm a"));
		memberDTO.setCountry(referenceDataService.getReferenceData("countries", member.getCountryCode()));
		memberDTO.setCity(referenceDataService.getReferenceData("cities", member.getCityCode()));

		if (member.isActive()) {
			memberDTO.setBlocked("N");
		} else {
			memberDTO.setBlocked("Y");
		}
		
		return memberDTO;
	}

	private Member convertfromDTO(MemberDTO memberDTO) {

		Member member = new Member();
		BeanUtils.copyProperties(memberDTO, member);

		member.setCityCode(memberDTO.getCity().getCode());
		member.setCountryCode(memberDTO.getCountry().getCode());
		member.setDateOfBirth(DateUtil.toDate(memberDTO.getDob(), "MM/dd/yyyy hh:mm a"));
		
		if (memberDTO.getBlocked().equals("Y")) {
			member.setActive(false);
		} else if (memberDTO.getBlocked().equals("N")) {
			member.setActive(true);
		}
		return member;
	}
}
