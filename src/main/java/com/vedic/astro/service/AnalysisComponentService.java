package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.domain.PredictionOutcome;
import com.vedic.astro.domain.PredictionTemplate;
import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.ComponentInfoDTO;
import com.vedic.astro.dto.PredictionOutcomeDTO;
import com.vedic.astro.dto.PredictionTemplateDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.repository.AnalysisComponentRepository;
import com.vedic.astro.repository.PredictionOutcomeRepository;
import com.vedic.astro.repository.PredictionTemplateRepository;

@Service("analysisComponentService")
@Transactional
public class AnalysisComponentService {

	@Autowired
	@Qualifier("analysisComponentRepository")
	private AnalysisComponentRepository analysisComponentRepository;

	@Autowired
	@Qualifier("predictionTemplateRepository")
	private PredictionTemplateRepository predictionTemplateRepository;

	@Autowired
	@Qualifier("predictionOutcomeRepository")
	private PredictionOutcomeRepository predictionOutcomeRepository;

	public void save(ComponentDTO componentDTO) {
		Optional<AnalysisComponent> component = analysisComponentRepository.findByCode(componentDTO.getCode());
		AnalysisComponent analysisComponent = new AnalysisComponent();
		BeanUtils.copyProperties(componentDTO, analysisComponent);

		List<String> outcomes = new ArrayList<String>();
		Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
				.getOutcomesForTemplate(componentDTO.getPredictionTemplateCode());

		for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
			outcomes.add(predictionOutcome.getCode());
		}
		analysisComponent.setPredictionOutcomes(outcomes);

		if (component.isPresent()) {
			analysisComponent.setId(component.get().getId());
		}
		analysisComponentRepository.save(analysisComponent);
	}

	public void delete(ComponentDTO componentDTO) {
		Optional<AnalysisComponent> component = analysisComponentRepository.findByCode(componentDTO.getCode());
		AnalysisComponent analysisComponent = new AnalysisComponent();
		BeanUtils.copyProperties(componentDTO, analysisComponent);

		if (component.isPresent()) {
			analysisComponent.setId(component.get().getId());
		}
		analysisComponentRepository.delete(analysisComponent);
	}

	public List<ComponentInfoDTO> findBySource(AnalysisGroup analysisGroup) {
		Optional<List<AnalysisComponent>> componentList = analysisComponentRepository.findBySource(analysisGroup);
		List<ComponentInfoDTO> componentInfoList = new ArrayList<ComponentInfoDTO>();
		for (AnalysisComponent analysisComponent : componentList.get()) {
			ComponentInfoDTO componentInfoDTO = new ComponentInfoDTO();
			BeanUtils.copyProperties(analysisComponent, componentInfoDTO);
			if (analysisComponent.getPredictionTemplateCode() != null) {
				componentInfoDTO
						.setPredictionTemplate(getPredictionTemplateDTO(analysisComponent.getPredictionTemplateCode()));
				Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(componentInfoDTO.getPredictionTemplate().getCode());

				List<PredictionOutcomeDTO> dtoList = new ArrayList<PredictionOutcomeDTO>();
				
				for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
					PredictionOutcomeDTO predictionOutcomeDTO = new PredictionOutcomeDTO();
					BeanUtils.copyProperties(predictionOutcome, predictionOutcomeDTO);
					dtoList.add(predictionOutcomeDTO);
				}
				
				componentInfoDTO.setPredictionOutcomes(dtoList);
			}
			componentInfoList.add(componentInfoDTO);
		}
		return componentInfoList;
	}

	public void save(List<ComponentInfoDTO> componentInfoDTOList) {

		List<AnalysisComponent> analysisComponents = new ArrayList<AnalysisComponent>();
		for (ComponentInfoDTO componentInfoDTO : componentInfoDTOList) {
			Optional<AnalysisComponent> component = 
					analysisComponentRepository.findByCode(componentInfoDTO.getCode());
			AnalysisComponent analysisComponent = new AnalysisComponent();
			BeanUtils.copyProperties(componentInfoDTO, analysisComponent);

			List<String> outcomes = new ArrayList<String>();
			Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
					.getOutcomesForTemplate(componentInfoDTO.getPredictionTemplate().getCode());

			for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
				outcomes.add(predictionOutcome.getCode());
			}
			analysisComponent.setPredictionOutcomes(outcomes);
			analysisComponent.setPredictionTemplateCode(
					componentInfoDTO.getPredictionTemplate().getCode());
			if (component.isPresent()) {
				analysisComponent.setId(component.get().getId());
			}
			analysisComponents.add(analysisComponent);
		}
		analysisComponentRepository.save(analysisComponents);
	}
	
	private PredictionTemplateDTO getPredictionTemplateDTO(String code) {

		PredictionTemplateDTO predictionTemplateDTO = new PredictionTemplateDTO();
		Optional<PredictionTemplate> template = 
				predictionTemplateRepository.findByCode(code);
		BeanUtils.copyProperties(template.get(), predictionTemplateDTO);

		return predictionTemplateDTO;
	}
}
