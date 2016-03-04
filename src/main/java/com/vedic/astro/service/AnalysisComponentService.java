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
import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.domain.PredictionOutcome;
import com.vedic.astro.domain.PredictionTemplate;
import com.vedic.astro.dto.ComponentDTO;
import com.vedic.astro.dto.PredictionOutcomeDTO;
import com.vedic.astro.dto.PredictionTemplateDTO;
import com.vedic.astro.dto.SubComponentDTO;
import com.vedic.astro.dto.SubComponentInfoDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.MemberType;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.ComponentRepository;
import com.vedic.astro.repository.PredictionOutcomeRepository;
import com.vedic.astro.repository.PredictionTemplateRepository;
import com.vedic.astro.repository.SubComponentRepository;

@Service("analysisComponentService")
@Transactional
public class AnalysisComponentService {

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

	public void saveSubComponent(SubComponentDTO subComponentDTO) {
		Optional<AnalysisSubComponent> subcomponent = subComponentRepository.findByCode(subComponentDTO.getCode());
		AnalysisSubComponent subComponent = new AnalysisSubComponent();
		BeanUtils.copyProperties(subComponentDTO, subComponent);

		List<String> outcomes = new ArrayList<String>();
		Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
				.getOutcomesForTemplate(subComponentDTO.getPredictionTemplateCode());

		for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
			outcomes.add(predictionOutcome.getCode());
		}
		subComponent.setPredictionOutcomes(outcomes);

		if (subcomponent.isPresent()) {
			subComponent.setId(subcomponent.get().getId());
		}
		subComponentRepository.save(subComponent);
	}

	public void deleteSubComponent(SubComponentDTO subComponentDTO) {
		Optional<AnalysisSubComponent> subcomponent = subComponentRepository.findByCode(subComponentDTO.getCode());
		AnalysisSubComponent subComponent = new AnalysisSubComponent();
		BeanUtils.copyProperties(subComponentDTO, subComponent);

		if (subcomponent.isPresent()) {
			subComponent.setId(subcomponent.get().getId());
		}
		subComponentRepository.delete(subComponent);
	}

	public void saveComponent(ComponentDTO componentDTO) {
		Optional<AnalysisComponent> componentOpt = componentRepository.findByCode(componentDTO.getCode());
		AnalysisComponent component = new AnalysisComponent();
		BeanUtils.copyProperties(componentDTO, component);

		if (componentOpt.isPresent()) {
			component.setId(componentOpt.get().getId());
		}
		componentRepository.save(component);
	}

	public void deleteComponent(ComponentDTO componentDTO) {
		Optional<AnalysisComponent> componentOpt = componentRepository.findByCode(componentDTO.getCode());
		AnalysisComponent component = new AnalysisComponent();
		BeanUtils.copyProperties(componentDTO, component);

		if (componentOpt.isPresent()) {
			component.setId(componentOpt.get().getId());
		}
		componentRepository.delete(component);
		
		Optional<List<AnalysisSubComponent>> subComponentOpt = subComponentRepository.findByComponent(componentDTO.getCode());
		if(subComponentOpt.isPresent()){
			subComponentRepository.delete(subComponentOpt.get());
		}
	}

	public List<SubComponentInfoDTO> findByComponent(String componentCode, MemberType memberType) {
		List<SubComponentInfoDTO> subComponentInfoList = new ArrayList<SubComponentInfoDTO>();	
	

		Optional<List<AnalysisSubComponent>> subComponentList = subComponentRepository.findByComponent(componentCode);
		
		for (AnalysisSubComponent subComponent : subComponentList.get()) {
			SubComponentInfoDTO subComponentInfoDTO = new SubComponentInfoDTO();
			
			BeanUtils.copyProperties(subComponent, subComponentInfoDTO);
			
			subComponentInfoDTO.setCode(subComponent.getCode());
			subComponentInfoDTO.setName(subComponent.getName());
			
			AnalysisComponent component = componentRepository.findByCode(subComponent.getComponentCode()).get();
			
			subComponentInfoDTO.setComponentName(component.getName());
			subComponentInfoDTO.setComponentCode(component.getCode());
			
			if (subComponent.getPredictionTemplateCode() != null) {
				subComponentInfoDTO
						.setPredictionTemplate(getPredictionTemplateDTO(subComponent.getPredictionTemplateCode()));
				Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(subComponentInfoDTO.getPredictionTemplate().getCode(), memberType);

				List<PredictionOutcomeDTO> dtoList = new ArrayList<PredictionOutcomeDTO>();
				
				for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
					PredictionOutcomeDTO predictionOutcomeDTO = new PredictionOutcomeDTO();
					BeanUtils.copyProperties(predictionOutcome, predictionOutcomeDTO);
					dtoList.add(predictionOutcomeDTO);
				}
				
				subComponentInfoDTO.setPredictionOutcomes(dtoList);
			}
		
			subComponentInfoList.add(subComponentInfoDTO);
		}
		
		
		return subComponentInfoList;
	}
	
	public List<ComponentDTO> findBySource(AnalysisGroup analysisGroup, PredictionSystem predictionSystem) {
		List<ComponentDTO> componentList = new ArrayList<ComponentDTO>();	
	
		Optional<List<AnalysisComponent>> components = 
				componentRepository.findByAnalysisGroupAndPredictionSystem(
						analysisGroup, predictionSystem);
		
		for(AnalysisComponent component : components.get()){
			ComponentDTO componentDTO = new ComponentDTO();
			BeanUtils.copyProperties(component, componentDTO);
			componentList.add(componentDTO);
		}
		
		return componentList;
	}


	public void save(List<SubComponentInfoDTO> subComponentInfoDTOList) {

		List<AnalysisSubComponent> subComponents = new ArrayList<AnalysisSubComponent>();
		for (SubComponentInfoDTO subComponentInfoDTO : subComponentInfoDTOList) {
			Optional<AnalysisSubComponent> subcomponent = 
					subComponentRepository.findByCode(subComponentInfoDTO.getCode());
			AnalysisSubComponent subComponent = new AnalysisSubComponent();
			BeanUtils.copyProperties(subComponentInfoDTO, subComponent);
			
			List<String> outcomes = new ArrayList<String>();
			Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
					.getOutcomesForTemplate(subComponentInfoDTO.getPredictionTemplate().getCode());

			for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
				outcomes.add(predictionOutcome.getCode());
			}
			subComponent.setPredictionOutcomes(outcomes);
			subComponent.setPredictionTemplateCode(
					subComponentInfoDTO.getPredictionTemplate().getCode());
			if (subcomponent.isPresent()) {
				subComponent.setId(subcomponent.get().getId());
			}
			subComponents.add(subComponent);
		}
		subComponentRepository.save(subComponents);
	}
	
	private PredictionTemplateDTO getPredictionTemplateDTO(String code) {

		PredictionTemplateDTO predictionTemplateDTO = new PredictionTemplateDTO();
		Optional<PredictionTemplate> template = 
				predictionTemplateRepository.findByCode(code);
		BeanUtils.copyProperties(template.get(), predictionTemplateDTO);

		return predictionTemplateDTO;
	}
}
