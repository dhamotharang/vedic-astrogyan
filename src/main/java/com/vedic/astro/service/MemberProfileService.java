package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.domain.MemberAnalysis;
import com.vedic.astro.domain.PredictionOutcome;
import com.vedic.astro.domain.SubComponentOutcome;
import com.vedic.astro.dto.AnalysisResultDTO;
import com.vedic.astro.dto.ComponentAnalysisResultDTO;
import com.vedic.astro.dto.SubComponentOutcomeDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.ComponentRepository;
import com.vedic.astro.repository.MemberAnalysisRepository;
import com.vedic.astro.repository.PredictionOutcomeRepository;
import com.vedic.astro.repository.PredictionTemplateRepository;
import com.vedic.astro.repository.ProfileAspectRepository;
import com.vedic.astro.repository.SubComponentRepository;

@Service("memberProfileService")
@Transactional
public class MemberProfileService {

	@Autowired
	@Qualifier("subComponentRepository")
	private SubComponentRepository subComponentRepository;

	@Autowired
	@Qualifier("componentRepository")
	private ComponentRepository componentRepository;

	@Autowired
	@Qualifier("predictionTemplateRepository")
	private PredictionTemplateRepository predictionTemplateRepository;

	@Autowired
	@Qualifier("predictionOutcomeRepository")
	private PredictionOutcomeRepository predictionOutcomeRepository;

	@Autowired
	@Qualifier("profileAspectRepository")
	private ProfileAspectRepository profileAspectRepository;

	@Autowired
	@Qualifier("memberAnalysisRepository")
	private MemberAnalysisRepository memberAnalysisRepository;

	public AnalysisResultDTO getAnalysisResult(String memberId) {

		AnalysisResultDTO analysisResultDTO = new AnalysisResultDTO();

		analysisResultDTO
				.addNakAnalysis(new SubComponentOutcomeDTO("MoonNakEvaluator", "Rohini", "Impact of Moon Nak"));
		analysisResultDTO
				.addNakAnalysis(new SubComponentOutcomeDTO("SunNakEvaluator", "Mrigshira", "Impact of Sun Nak"));
		analysisResultDTO.addNakAnalysis(new SubComponentOutcomeDTO("AscNakEvaluator", "Hastha", "Impact of Asc Nak"));

		analysisResultDTO
				.addZodAnalysis(new SubComponentOutcomeDTO("MoonZodEvaluator", "Rohini", "Impact of Moon Zod"));
		analysisResultDTO
				.addZodAnalysis(new SubComponentOutcomeDTO("SunZodEvaluator", "Mrigshira", "Impact of Sun Zod"));
		analysisResultDTO.addZodAnalysis(new SubComponentOutcomeDTO("AscZodEvaluator", "Hastha", "Impact of Asc Zod"));

		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H1StrengthEvaluator", "H1 High strength", "Impact of H1 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H2StrengthEvaluator", "H2 Low strength", "Impact of H2 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H3StrengthEvaluator", "H3 Medium strength", "Impact of H3 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H4StrengthEvaluator", "H4 Low strength", "Impact of H4 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H5StrengthEvaluator", "H5 Low strength", "Impact of H5 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H6StrengthEvaluator", "H6 High strength", "Impact of H6 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H7StrengthEvaluator", "H7 High strength", "Impact of H7 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H8StrengthEvaluator", "H8 Medium strength", "Impact of H8 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H9StrengthEvaluator", "H9 Low strength", "Impact of H9 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H10StrengthEvaluator", "H10 High strength", "Impact of H10 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H11StrengthEvaluator", "H11 High strength", "Impact of H11 strength"));
		analysisResultDTO.addHouseStrengthAnalysis(
				new SubComponentOutcomeDTO("H12StrengthEvaluator", "H12 Medium strength", "Impact of H12 strength"));

		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("SunStrengthEvaluator", "Sun high strength", "Impact of Sun strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("MonStrengthEvaluator", "Moon high strength", "Impact of Moon strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(new SubComponentOutcomeDTO("JupStrengthEvaluator",
				"Jupiter high strength", "Impact of Jupiter strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("MarStrengthEvaluator", "Mars high strength", "Impact of Mars strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(new SubComponentOutcomeDTO("MerStrengthEvaluator",
				"Mercury high strength", "Impact of Mercury strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(new SubComponentOutcomeDTO("SatStrengthEvaluator",
				"Saturn high strength", "Impact of Saturn strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("VenStrengthEvaluator", "Venus high strength", "Impact of Venus strength"));

		return analysisResultDTO;
	}

	public List<ComponentAnalysisResultDTO> getAnalysisResult(PredictionSystem predictionSystem,
			AnalysisGroup analysisGroup, String memberId) {
		List<ComponentAnalysisResultDTO> analysisResultDTO = new ArrayList<ComponentAnalysisResultDTO>();
		Optional<List<MemberAnalysis>> memberAnalysisOpt = memberAnalysisRepository
				.findByAnalysisGroupAndPredictionSystem(predictionSystem, analysisGroup, memberId);

		if (memberAnalysisOpt.isPresent()) {
			List<MemberAnalysis> memberAnalysisList = memberAnalysisOpt.get();
			for (MemberAnalysis memberAnalysis : memberAnalysisList) {
				ComponentAnalysisResultDTO componentAnalysisResultDTO = new ComponentAnalysisResultDTO();
				componentAnalysisResultDTO.setCode(memberAnalysis.getComponentCode());

				AnalysisComponent analysisComponent = componentRepository.findByCode(memberAnalysis.getComponentCode())
						.get();

				componentAnalysisResultDTO.setName(analysisComponent.getName());
				List<SubComponentOutcomeDTO> subComponentOutcomeDTOList = new ArrayList<SubComponentOutcomeDTO>();

				List<SubComponentOutcome> subComponentOutcomeList = memberAnalysis.getSubcomponentOutcomes();
				for (SubComponentOutcome subComponentOutcome : subComponentOutcomeList) {
					SubComponentOutcomeDTO subComponentOutcomeDTO = new SubComponentOutcomeDTO();
					AnalysisSubComponent analysisSubComponent = subComponentRepository
							.findByCode(subComponentOutcome.getSubComponentCode()).get();

					subComponentOutcomeDTO.setComponent(analysisSubComponent.getName());
					subComponentOutcomeDTO.setConditionChecked(analysisSubComponent.getConditionChecked());

					PredictionOutcome predictionOutcome = predictionOutcomeRepository
							.findByCode(subComponentOutcome.getPredictionOutcomeCode()).get();
					subComponentOutcomeDTO.setOutcome(predictionOutcome.getName());

					subComponentOutcomeDTOList.add(subComponentOutcomeDTO);
				}
				componentAnalysisResultDTO.setOutcomes(subComponentOutcomeDTOList);
				analysisResultDTO.add(componentAnalysisResultDTO);

			}
		}

		return analysisResultDTO;
	}

}
