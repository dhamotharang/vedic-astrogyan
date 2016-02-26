package com.vedic.astro.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.Member;
import com.vedic.astro.dto.FindNakAntarDashaDTO;
import com.vedic.astro.dto.FindZodAntarDashaDTO;
import com.vedic.astro.dto.NakDashaDTO;
import com.vedic.astro.dto.ZodDashaDTO;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.NakDashaSystem;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.ZodDashaSystem;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.MemberRepository;
import com.vedic.astro.util.CharaDashaUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.util.VimshotriDashaUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Service("dashaService")
@Transactional
public class DashaService {

	@Autowired
	@Qualifier("vimshotriDashaUtil")
	private VimshotriDashaUtil vimshotriDashaUtil;

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;

	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("charaDashaUtil")
	private CharaDashaUtil charaDashaUtil;

	public List<NakDashaDTO> getNakDashaSubPeriods(FindNakAntarDashaDTO findAntarDashaDTO) {
		List<NakDashaDTO> dashas = null;

		if (findAntarDashaDTO.getDashaSystem().equals(NakDashaSystem.VIMSHOTTRI)) {
			dashas = vimshotriDashaUtil.getSubPeriods(findAntarDashaDTO.getPlanet(),
					DateUtil.toDate(findAntarDashaDTO.getStartDate(), "dd/MM/yyyy"),
					DateUtil.toDate(findAntarDashaDTO.getEndDate(), "dd/MM/yyyy"), findAntarDashaDTO.getAsOfDate());
		}
		return dashas;
	}

	public List<NakDashaDTO> getNakDashaMainPeriods(String memberId, Date asOfDate, NakDashaSystem dashaSystem) {
		List<NakDashaDTO> dashas = null;

		if (dashaSystem.equals(NakDashaSystem.VIMSHOTTRI)) {
			Optional<BirthChartData> rashiChartOpt = birthChartRepository.findByPid(memberId);
			Member member = memberRepository.findOne(memberId);
			if (rashiChartOpt.isPresent()) {
				BirthChartData rashiChart = rashiChartOpt.get();

				BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
						.preparePlanetsForCalc(rashiChart.getChartHouses());

				House house = birthChartCalcPrep.getPlanetHouseMapping().get(Planet.MON);
				Zodiac moonZodiac = birthChartCalcPrep.getHouseZodiacMapping().get(house);
				Nakshatra moonNakshatra = birthChartCalcPrep.getPlanetNakshatrasMapping().get(Planet.MON);
				Double degrees = birthChartCalcPrep.getPlanetAgeMapping().get(Planet.MON);

				dashas = vimshotriDashaUtil.getMainPeriods(moonZodiac, moonNakshatra, degrees, member.getDateOfBirth(),
						memberId, asOfDate);
			}
		}

		return dashas;
	}

	public List<ZodDashaDTO> getZodDashaMainPeriods(String memberId, Date asOfDate, ZodDashaSystem zodDashaSystem) {
		List<ZodDashaDTO> dashas = null;

		if (zodDashaSystem.equals(ZodDashaSystem.CHARA)) {

			Optional<BirthChartData> rashiChartOpt = birthChartRepository.findByPid(memberId);
			Member member = memberRepository.findOne(memberId);
			if (rashiChartOpt.isPresent()) {
				BirthChartData rashiChart = rashiChartOpt.get();
				BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
						.preparePlanetsForCalc(rashiChart.getChartHouses());
				dashas = charaDashaUtil.getMainPeriods(member.getDateOfBirth(), birthChartCalcPrep, asOfDate);
			}
		}

		return dashas;
	}
	
	public List<ZodDashaDTO> getZodDashaSubPeriods(FindZodAntarDashaDTO findAntarDashaDTO) {
		List<ZodDashaDTO> dashas = null;

		if (findAntarDashaDTO.getDashaSystem().equals(ZodDashaSystem.CHARA)) {
			dashas = charaDashaUtil.getSubPeriods(findAntarDashaDTO.getZodiac(),
					DateUtil.toDate(findAntarDashaDTO.getStartDate(), "dd/MM/yyyy"),
					DateUtil.toDate(findAntarDashaDTO.getEndDate(), "dd/MM/yyyy"), findAntarDashaDTO.getAsOfDate());
		}
		return dashas;
	}
}