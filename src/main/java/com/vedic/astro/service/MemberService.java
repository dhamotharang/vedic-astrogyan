package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.calc.component.BirthChartPipelineGateway;
import com.vedic.astro.constant.Constants;
import com.vedic.astro.domain.LocationInfo;
import com.vedic.astro.domain.Member;
import com.vedic.astro.domain.SunriseSunsetData;
import com.vedic.astro.dto.MemberDTO;
import com.vedic.astro.dto.MemberSummaryDTO;
import com.vedic.astro.enums.MemberType;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.repository.LocationInfoRepository;
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

	@Autowired
	@Qualifier("sunriseSunsetDataService")
	private SunriseSunsetDataService sunriseSunsetDataService;

	@Autowired
	@Qualifier("locationInfoRepository")
	private LocationInfoRepository locationInfoRepository;

	@Async
	public void saveMember(MemberDTO memberDTO) {
		boolean firePipeline = true;
		
		if(memberDTO.getPid()!=null){
		Member existingMember = this.memberRepository.findOne(memberDTO.getPid());
		Member updatedMember = convertfromDTO(memberDTO);

		if (existingMember != null) {

			String cityCode = existingMember.getCityCode();
			String countryCode = existingMember.getCountryCode();
			Date dob = existingMember.getDateOfBirth();

			if (cityCode.equals(updatedMember.getCityCode()) && countryCode.equals(updatedMember.getCountryCode())
					&& dob.equals(updatedMember.getDateOfBirth())) {
				firePipeline = true;
			}
		}
		}
		Member member = this.memberRepository.save(convertfromDTO(memberDTO));
		if (firePipeline) {
			birthChartPipelineGateway.startBirthChartPipeline(member);
		}

	}

	public MemberDTO getMember(String id) throws BusinessException {
		Member member = this.memberRepository.findOne(id);
		if (member == null) {
			throw new BusinessException(Constants.MEMBER_NOT_FOUND, 
					"Member with this id does not exist");
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
			memberSummaryDTO.setName(member.getFirstName() + " " + 
			member.getLastName());
			if (member.getDateOfBirth() != null) {
				memberSummaryDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), 
						"MM/dd/yyyy hh:mm a"));
			}
			memberSummaryDTO.setId(member.getPid());

			memberList.add(memberSummaryDTO);
		}

		return memberList;
	}

	public List<MemberSummaryDTO> getAllMembersSummary(String adminId) throws BusinessException {
		Optional<List<Member>> members = this.memberRepository.findByAdminId(adminId);
		List<MemberSummaryDTO> memberList = new ArrayList<MemberSummaryDTO>();

		if (members.isPresent()) {
			for (Member member : members.get()) {

				String firstName = "";
				String lastName = "";

				MemberSummaryDTO memberSummaryDTO = new MemberSummaryDTO();
				if (member.getFirstName() != null) {
					firstName = member.getFirstName();
				}
				if (member.getLastName() != null) {
					lastName = member.getLastName();
				}
				memberSummaryDTO.setName(firstName + " " + lastName);
				if (member.getDateOfBirth() != null) {
					memberSummaryDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), "MM/dd/yyyy hh:mm a"));
				}
				memberSummaryDTO.setId(member.getPid());

				memberList.add(memberSummaryDTO);
			}
		}

		return memberList;
	}

	public List<MemberSummaryDTO> getAllMembersSummary(String adminId, MemberType memberType) throws BusinessException {
		Optional<List<Member>> members = this.memberRepository.findByAdminIdAndMemberType(adminId, memberType);
		List<MemberSummaryDTO> memberList = new ArrayList<MemberSummaryDTO>();

		if (members.isPresent()) {
			for (Member member : members.get()) {

				String firstName = "";
				String lastName = "";

				MemberSummaryDTO memberSummaryDTO = new MemberSummaryDTO();
				if (member.getFirstName() != null) {
					firstName = member.getFirstName();
				}
				if (member.getLastName() != null) {
					lastName = member.getLastName();
				}
				memberSummaryDTO.setName(firstName + " " + lastName);
				if (member.getDateOfBirth() != null) {
					memberSummaryDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), "MM/dd/yyyy hh:mm a"));
				}
				memberSummaryDTO.setId(member.getPid());

				memberList.add(memberSummaryDTO);
			}
		}

		return memberList;
	}

	public List<MemberSummaryDTO> getAllMembersSummaryNotIn(String adminId, MemberType memberType)
			throws BusinessException {
		Optional<List<Member>> members = this.memberRepository.findByAdminIdNotMemberType(adminId, memberType);
		List<MemberSummaryDTO> memberList = new ArrayList<MemberSummaryDTO>();

		if (members.isPresent()) {
			for (Member member : members.get()) {

				String firstName = "";
				String lastName = "";

				MemberSummaryDTO memberSummaryDTO = new MemberSummaryDTO();
				if (member.getFirstName() != null) {
					firstName = member.getFirstName();
				}
				if (member.getLastName() != null) {
					lastName = member.getLastName();
				}
				memberSummaryDTO.setName(firstName + " " + lastName);
				if (member.getDateOfBirth() != null) {
					memberSummaryDTO.setDob(DateUtil.fromDate(member.getDateOfBirth(), "MM/dd/yyyy hh:mm a"));
				}
				memberSummaryDTO.setId(member.getPid());

				memberList.add(memberSummaryDTO);
			}
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
		Date dateOfBirth = DateUtil.toDate(memberDTO.getDob(), "MM/dd/yyyy hh:mm a");
		member.setDateOfBirth(dateOfBirth);

		Optional<List<LocationInfo>> locationList = locationInfoRepository
				.getLocationByCountryAndCity(memberDTO.getCountry().getCode(), memberDTO.getCity().getCode());

		Integer locationId = null;

		if (locationList.isPresent()) {
			locationId = locationList.get().get(0).getLocationId();
		}

		SunriseSunsetData sunriseSunsetData = sunriseSunsetDataService.getSunriseSunsetData(locationId,
				DateUtil.fromDate(dateOfBirth, "dd/MM/yyyy"));
		member.setSunriseSunset(sunriseSunsetData);

		if (memberDTO.getPid() != null) {
			member.setUpdatedDt(new Date());
		} else {
			member.setCreatedDt(new Date());
		}

		if (memberDTO.getBlocked().equals("Y")) {
			member.setActive(false);
		} else if (memberDTO.getBlocked().equals("N")) {
			member.setActive(true);
		}
		return member;
	}
}
