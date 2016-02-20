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
import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.ComponentInfoDTO;
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

	public List<ComponentInfoDTO> getAll() {
		Iterable<AnalysisComponent> componentList = analysisComponentRepository.findAll();
		List<ComponentInfoDTO> componentInfoList = new ArrayList<ComponentInfoDTO>();
		for (AnalysisComponent analysisComponent : componentList) {
			ComponentInfoDTO componentInfoDTO = new ComponentInfoDTO();
			BeanUtils.copyProperties(analysisComponent, componentInfoDTO);
			componentInfoDTO.setPredictionTemplateName(predictionTemplateRepository
					.getTemplate(analysisComponent.getPredictionTemplateCode()).get().getName());
			for (String outcomeCode : analysisComponent.getPredictionOutcomes()) {
				componentInfoDTO
						.addPredictionOutcomeName(predictionOutcomeRepository.findByCode(
								outcomeCode).get().getName());
			}
		}
		return componentInfoList;
	}
}
