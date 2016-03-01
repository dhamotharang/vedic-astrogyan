package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.domain.MemberAnalysis;
import com.vedic.astro.domain.PredictionObservation;
import com.vedic.astro.domain.PredictionOutcome;
import com.vedic.astro.domain.PredictionTemplate;
import com.vedic.astro.domain.ProfileAspect;
import com.vedic.astro.dto.AnalysisResultDTO;
import com.vedic.astro.dto.SubComponentOutcomeDTO;
import com.vedic.astro.dto.LevelProfileAspectDTO;
import com.vedic.astro.dto.PathProfileAspectDTO;
import com.vedic.astro.dto.PredictionObservationDTO;
import com.vedic.astro.dto.PredictionOutcomeDTO;
import com.vedic.astro.dto.PredictionTemplateDTO;
import com.vedic.astro.dto.ProfileAspectDTO;
import com.vedic.astro.dto.ProfileFilterDTO;
import com.vedic.astro.dto.ProfileFilterTypeDTO;
import com.vedic.astro.dto.ProfilePredictionDTO;
import com.vedic.astro.dto.TemplateAspectDTO;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.ObservationNature;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.SubComponentRepository;
import com.vedic.astro.repository.ComponentRepository;
import com.vedic.astro.repository.MemberAnalysisRepository;
import com.vedic.astro.repository.PredictionOutcomeRepository;
import com.vedic.astro.repository.PredictionTemplateRepository;
import com.vedic.astro.repository.ProfileAspectRepository;

@Service("profileService")
@Transactional
public class ProfileService {

	@Autowired
	@Qualifier("profileAspectRepository")
	private ProfileAspectRepository profileAspectRepository;

	@Autowired
	@Qualifier("predictionTemplateRepository")
	private PredictionTemplateRepository predictionTemplateRepository;

	@Autowired
	@Qualifier("predictionOutcomeRepository")
	private PredictionOutcomeRepository predictionOutcomeRepository;

	@Autowired
	@Qualifier("subComponentRepository")
	private SubComponentRepository subComponentRepository;

	@Autowired
	@Qualifier("memberAnalysisRepository")
	private MemberAnalysisRepository memberAnalysisRepository;

	@Autowired
	@Qualifier("componentRepository")
	private ComponentRepository componentRepository;

	public AnalysisResultDTO getAnalysisResult(String memberId) {

		AnalysisResultDTO analysisResultDTO = new AnalysisResultDTO();

		analysisResultDTO.addNakAnalysis(new SubComponentOutcomeDTO("MoonNakEvaluator", "Rohini", "Impact of Moon Nak"));
		analysisResultDTO.addNakAnalysis(new SubComponentOutcomeDTO("SunNakEvaluator", "Mrigshira", "Impact of Sun Nak"));
		analysisResultDTO.addNakAnalysis(new SubComponentOutcomeDTO("AscNakEvaluator", "Hastha", "Impact of Asc Nak"));

		analysisResultDTO.addZodAnalysis(new SubComponentOutcomeDTO("MoonZodEvaluator", "Rohini", "Impact of Moon Zod"));
		analysisResultDTO.addZodAnalysis(new SubComponentOutcomeDTO("SunZodEvaluator", "Mrigshira", "Impact of Sun Zod"));
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
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("JupStrengthEvaluator", "Jupiter high strength", "Impact of Jupiter strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("MarStrengthEvaluator", "Mars high strength", "Impact of Mars strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("MerStrengthEvaluator", "Mercury high strength", "Impact of Mercury strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("SatStrengthEvaluator", "Saturn high strength", "Impact of Saturn strength"));
		analysisResultDTO.addPlanetStrengthAnalysis(
				new SubComponentOutcomeDTO("VenStrengthEvaluator", "Venus high strength", "Impact of Venus strength"));

		return analysisResultDTO;
	}

	public List<LevelProfileAspectDTO> getAllParents() {
		List<LevelProfileAspectDTO> parents = new ArrayList<LevelProfileAspectDTO>();
		Optional<List<ProfileAspect>> profileAspects = profileAspectRepository.getAllParents();

		for (ProfileAspect profileAspect : profileAspects.get()) {
			LevelProfileAspectDTO parent = new LevelProfileAspectDTO();

			BeanUtils.copyProperties(profileAspect, parent);
			parents.add(parent);
		}

		return parents;
	}

	public void saveAspect(LevelProfileAspectDTO aspect) {

		ProfileAspect profileAspect = new ProfileAspect();
		BeanUtils.copyProperties(aspect, profileAspect);

		profileAspectRepository.save(profileAspect);
	}

	public void deleteAspect(String id) {
		ProfileAspect aspect = profileAspectRepository.findOne(id);
		profileAspectRepository.delete(findAllChildren(aspect));
	}

	private List<ProfileAspect> findAllChildren(ProfileAspect aspect) {

		List<ProfileAspect> allAspectsToBeDeleted = new ArrayList<ProfileAspect>();
		allAspectsToBeDeleted.add(aspect);
		Optional<List<ProfileAspect>> immediateChildren = profileAspectRepository
				.getImmediateChildren(aspect.getCode());
		if ((immediateChildren != null) && immediateChildren.isPresent()) {
			for (ProfileAspect immediateChild : immediateChildren.get()) {
				allAspectsToBeDeleted.addAll(immediateChildren.get());
				Optional<List<ProfileAspect>> furtherChildren = profileAspectRepository
						.getImmediateChildren(immediateChild.getCode());
				if ((furtherChildren != null) && furtherChildren.isPresent()) {
					allAspectsToBeDeleted.addAll(furtherChildren.get());
				}
			}
		}
		return allAspectsToBeDeleted;
	}

	public List<LevelProfileAspectDTO> getImmediateChildren(String parentCode) {
		List<LevelProfileAspectDTO> children = new ArrayList<LevelProfileAspectDTO>();
		Optional<List<ProfileAspect>> profileAspects = profileAspectRepository.getImmediateChildren(parentCode);

		for (ProfileAspect profileAspect : profileAspects.get()) {
			LevelProfileAspectDTO child = new LevelProfileAspectDTO();
			BeanUtils.copyProperties(profileAspect, child);
			children.add(child);
		}

		return children;
	}

	public List<ProfileAspectDTO> getProfileHierachyTree(PredictionSystem model, boolean populateInfo,
			ProfileFilterDTO profileFilterDTO) {
		Iterable<ProfileAspect> profileAspects = profileAspectRepository.findAll();
		return constructTree(profileAspects, model, populateInfo, profileFilterDTO);
	}

	public List<PathProfileAspectDTO> getProfileHierachyFlat(PredictionSystem model) {
		Iterable<ProfileAspect> profileAspects = profileAspectRepository.findAll();
		return constructFlat(profileAspects);
	}

	private Map<String, String> getCodeToPathMap(PredictionSystem model) {
		List<PathProfileAspectDTO> dtoList = getProfileHierachyFlat(model);
		Map<String, String> codeToPathMap = new HashMap<String, String>();
		for (PathProfileAspectDTO pathProfileAspectDTO : dtoList) {
			codeToPathMap.put(pathProfileAspectDTO.getCode(), pathProfileAspectDTO.getPath());
		}
		return codeToPathMap;
	}

	private List<ProfileAspectDTO> constructTree(Iterable<ProfileAspect> profileHierachy, PredictionSystem model,
			boolean populateInfo, ProfileFilterDTO profileFilterDTO) {
		List<ProfileAspectDTO> profileHierachyDTO = new ArrayList<ProfileAspectDTO>();

		Map<String, Set<ProfileAspect>> parentMap = new HashMap<String, Set<ProfileAspect>>();
		Set<ProfileAspect> parentSet = new HashSet<ProfileAspect>();

		for (ProfileAspect profileAspect : profileHierachy) {
			if (profileAspect.getParentCode() != null) {
				Set<ProfileAspect> children = parentMap.get(profileAspect.getParentCode());
				if (children == null) {
					children = new HashSet<ProfileAspect>();
				}
				children.add(profileAspect);
				parentMap.put(profileAspect.getParentCode(), children);
			} else {
				parentSet.add(profileAspect);
			}
		}

		for (ProfileAspect parentAspect : parentSet) {
			ProfileAspectDTO parent = new ProfileAspectDTO();

			BeanUtils.copyProperties(parentAspect, parent);

			if (populateInfo) {
				populateInfo(parent, profileFilterDTO);
			}

			parent = populateChildren(parent, parentMap, model, populateInfo, profileFilterDTO);
			profileHierachyDTO.add(parent);
		}
		return profileHierachyDTO;
	}

	private ProfileAspectDTO populateChildren(ProfileAspectDTO parent, Map<String, Set<ProfileAspect>> parentMap,
			PredictionSystem model, boolean populateInfo, ProfileFilterDTO profileFilterDTO) {

		Set<ProfileAspect> children = parentMap.get(parent.getCode());

		if (children != null) {
			for (ProfileAspect profileAspect : children) {

				ProfileAspectDTO child = new ProfileAspectDTO();
				BeanUtils.copyProperties(profileAspect, child);
				parent.addChild(child);

				if (populateInfo) {
					populateInfo(child, profileFilterDTO);
				}

				if (parentMap.get(profileAspect.getCode()) != null) {
					populateChildren(child, parentMap, model, populateInfo, profileFilterDTO);
				} else {
					populateChildInfo(child, model);
				}
			}
		}
		return parent;
	}

	private void populateChildInfo(ProfileAspectDTO child, PredictionSystem model) {
		/*
		 * Optional<List<EntityProfileMapping>> entityAspectObs =
		 * entityAspectObservationRepository
		 * .getAllMappedEntities(child.getCode()); for (EntityProfileMapping
		 * entityAspectObservation : entityAspectObs.get()) {
		 * child.addMappedEntity(entityAspectObservation.getEntityName()); }
		 */
	}

	private List<PathProfileAspectDTO> constructFlat(Iterable<ProfileAspect> profileHierachy) {
		List<PathProfileAspectDTO> profileHierachyDTO = new ArrayList<PathProfileAspectDTO>();

		Map<String, ProfileAspect> codeToObjectMap = new HashMap<String, ProfileAspect>();

		for (ProfileAspect profileAspect : profileHierachy) {
			codeToObjectMap.put(profileAspect.getCode(), profileAspect);
		}

		for (ProfileAspect profileAspect : profileHierachy) {
			PathProfileAspectDTO pathProfileAspectDTO = new PathProfileAspectDTO();

			pathProfileAspectDTO.addToPath(profileAspect.getName());
			pathProfileAspectDTO.setCode(profileAspect.getCode());

			if (profileAspect.getParentCode() != null) {
				ProfileAspect parentAspect = codeToObjectMap.get(profileAspect.getParentCode());
				pathProfileAspectDTO.addToPath(parentAspect.getName());

				if (parentAspect.getParentCode() != null) {
					ProfileAspect parentParentAspect = codeToObjectMap.get(parentAspect.getParentCode());
					pathProfileAspectDTO.addToPath(parentParentAspect.getName());
				}
			}
			profileHierachyDTO.add(pathProfileAspectDTO);
		}
		return profileHierachyDTO;
	}

	private List<PathProfileAspectDTO> populateChildren(PathProfileAspectDTO parent,
			Map<String, Set<ProfileAspect>> parentMap, PredictionSystem model,
			List<PathProfileAspectDTO> profileHierachyDTO) {

		Set<ProfileAspect> children = parentMap.get(parent.getCode());

		if (children != null) {
			for (ProfileAspect profileAspect : children) {

				PathProfileAspectDTO child = new PathProfileAspectDTO();
				child.addToPath(profileAspect.getName());
				child.setCode(profileAspect.getCode());
				profileHierachyDTO.add(parent);

				if (parentMap.get(profileAspect.getCode()) != null) {
					populateChildren(child, parentMap, model, profileHierachyDTO);
				}
			}
		}
		return profileHierachyDTO;
	}

	public void saveTemplate(PredictionTemplateDTO predictionTemplateDTO) {

		Optional<PredictionTemplate> template = predictionTemplateRepository
				.findByCode(predictionTemplateDTO.getCode());
		PredictionTemplate predictionTemplate = new PredictionTemplate();
		BeanUtils.copyProperties(predictionTemplateDTO, predictionTemplate);

		if (template.isPresent()) {
			predictionTemplate.setId(template.get().getId());
		}
		predictionTemplateRepository.save(predictionTemplate);
	}

	public List<PredictionTemplateDTO> getAll() {

		List<PredictionTemplateDTO> predictionTemplateDTOList = new ArrayList<PredictionTemplateDTO>();
		Iterable<PredictionTemplate> templates = predictionTemplateRepository.findAll();

		for (PredictionTemplate template : templates) {
			PredictionTemplateDTO predictionTemplateDTO = new PredictionTemplateDTO();
			BeanUtils.copyProperties(template, predictionTemplateDTO);
			predictionTemplateDTOList.add(predictionTemplateDTO);
		}
		return predictionTemplateDTOList;
	}

	public List<TemplateAspectDTO> getAllAspects(String templateCode) {

		List<PathProfileAspectDTO> profileAspects = constructFlat(profileAspectRepository.findAll());
		List<TemplateAspectDTO> templateAspectDTOList = new ArrayList<TemplateAspectDTO>();
		Optional<PredictionTemplate> template = predictionTemplateRepository.findByCode(templateCode);
		List<String> aspectCodes = null;

		if (template.isPresent()) {
			aspectCodes = template.get().getAspectCodes();
		}

		for (PathProfileAspectDTO pathProfileAspectDTO : profileAspects) {
			TemplateAspectDTO templateAspectDTO = new TemplateAspectDTO();
			BeanUtils.copyProperties(pathProfileAspectDTO, templateAspectDTO);

			if ((aspectCodes != null) && aspectCodes.contains(pathProfileAspectDTO.getCode())) {
				templateAspectDTO.setSelected(true);
			}
			templateAspectDTOList.add(templateAspectDTO);
		}
		return templateAspectDTOList;
	}

	public void deleteTemplate(PredictionTemplateDTO predictionTemplateDTO) {

		Optional<PredictionTemplate> template = predictionTemplateRepository
				.findByCode(predictionTemplateDTO.getCode());

		if (template.isPresent()) {
			predictionTemplateRepository.delete(template.get().getId());

			Optional<List<PredictionOutcome>> predictionOutcomes = predictionOutcomeRepository
					.getOutcomesForTemplate(predictionTemplateDTO.getCode());
			if (predictionOutcomes.isPresent()) {
				for (PredictionOutcome predictionOutcome : predictionOutcomes.get()) {
					predictionOutcomeRepository.delete(predictionOutcome);
				}
			}

			Optional<AnalysisSubComponent> components = subComponentRepository
					.findByTemplate(predictionTemplateDTO.getCode());
			if (components.isPresent()) {
				AnalysisSubComponent subComponent = components.get();
				subComponentRepository.delete(subComponent);

			}

			Optional<List<MemberAnalysis>> memberData = memberAnalysisRepository
					.getAnalysisByTemplate(predictionTemplateDTO.getCode());
			if (memberData.isPresent()) {
				for (MemberAnalysis memberAnalysis : memberData.get()) {
					memberAnalysisRepository.delete(memberAnalysis);
				}
			}
		}
	}

	public void savePredictionOutcome(PredictionOutcomeDTO predictionOutcomeDTO) {

		Optional<PredictionOutcome> outcome = predictionOutcomeRepository.findByCode(predictionOutcomeDTO.getCode());
		PredictionOutcome predictionOutcome = new PredictionOutcome();
		BeanUtils.copyProperties(predictionOutcomeDTO, predictionOutcome);

		Map<String, PredictionObservation> aspectToObsMap = new HashMap<String, PredictionObservation>();
		for (PredictionObservationDTO predictionObservationDTO : predictionOutcomeDTO.getObservations()) {
			PredictionObservation predictionObservation = new PredictionObservation();
			BeanUtils.copyProperties(predictionObservationDTO, predictionObservation);
			aspectToObsMap.put(predictionObservationDTO.getAspectCode(), predictionObservation);
		}
		predictionOutcome.setPredictionObservations(aspectToObsMap);
		if (outcome.isPresent()) {
			predictionOutcome.setId(outcome.get().getId());
		}
		predictionOutcomeRepository.save(predictionOutcome);
	}

	public void createPredictionOutcome(PredictionOutcomeDTO predictionOutcomeDTO) {

		PredictionOutcome predictionOutcome = new PredictionOutcome();
		BeanUtils.copyProperties(predictionOutcomeDTO, predictionOutcome);

		Optional<PredictionTemplate> predictionTemplate = predictionTemplateRepository
				.findByCode(predictionOutcomeDTO.getTemplateCode());

		Map<String, PredictionObservation> aspectToObsMap = new HashMap<String, PredictionObservation>();
		for (String aspectCode : predictionTemplate.get().getAspectCodes()) {
			PredictionObservation predictionObservation = new PredictionObservation();
			predictionObservation.setObservation("");
			predictionObservation.setNature(ObservationNature.Benefic);
			aspectToObsMap.put(aspectCode, predictionObservation);
		}

		predictionOutcome.setPredictionObservations(aspectToObsMap);
		predictionOutcomeRepository.save(predictionOutcome);
	}

	public void deleteOutcome(PredictionOutcomeDTO predictionOutcomeDTO) {

		Optional<PredictionOutcome> outcome = predictionOutcomeRepository.findByCode(predictionOutcomeDTO.getCode());

		if (outcome.isPresent()) {
			predictionOutcomeRepository.delete(outcome.get().getId());

			Optional<AnalysisSubComponent> components = subComponentRepository
					.findByTemplate(predictionOutcomeDTO.getTemplateCode());
			if (components.isPresent()) {
				AnalysisSubComponent subComponent = components.get();
				subComponentRepository.delete(subComponent);

			}

			Optional<List<MemberAnalysis>> memberData = memberAnalysisRepository
					.getAnalysisByTemplate(predictionOutcomeDTO.getTemplateCode());
			if (memberData.isPresent()) {
				for (MemberAnalysis memberAnalysis : memberData.get()) {
					memberAnalysisRepository.delete(memberAnalysis);
				}
			}
		}
	}

	public List<PredictionOutcomeDTO> getOutcomes(String templateCode) {

		Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository.getOutcomesForTemplate(templateCode);
		List<PredictionOutcomeDTO> outcomeDTOList = new ArrayList<PredictionOutcomeDTO>();
		Map<String, String> codeToPathMap = getCodeToPathMap(PredictionSystem.Prashara);
		for (PredictionOutcome predictionOutcome : outcomes.get()) {
			PredictionOutcomeDTO predictionOutcomeDTO = new PredictionOutcomeDTO();
			BeanUtils.copyProperties(predictionOutcome, predictionOutcomeDTO);
			Map<String, PredictionObservation> predictionOutcomeMap = predictionOutcome.getPredictionObservations();
			List<PredictionObservationDTO> dtoList = new ArrayList<PredictionObservationDTO>();

			for (Map.Entry<String, PredictionObservation> predictionOutcomeEntry : predictionOutcomeMap.entrySet()) {

				PredictionObservationDTO predictionObservationDTO = new PredictionObservationDTO();
				predictionObservationDTO.setAspectCode(predictionOutcomeEntry.getKey());
				predictionObservationDTO.setNature(predictionOutcomeEntry.getValue().getNature());
				predictionObservationDTO.setObservation(predictionOutcomeEntry.getValue().getObservation());
				predictionObservationDTO.setTimeDependent(predictionOutcomeEntry.getValue().isTimeDependent());
				predictionObservationDTO.setAspectPath(codeToPathMap.get(predictionOutcomeEntry.getKey()));

				dtoList.add(predictionObservationDTO);
			}
			predictionOutcomeDTO.setObservations(dtoList);
			outcomeDTOList.add(predictionOutcomeDTO);
		}
		return outcomeDTOList;
	}

	private void populateInfoFilterByTemplates(ProfileAspectDTO parent, List<String> templateCodes) {

		List<String> templates = new ArrayList<String>();
		List<ProfilePredictionDTO> observations = null;
		Optional<List<PredictionTemplate>> predictionTemplateList = predictionTemplateRepository
				.findByAspectCode(parent.getCode());

		if (predictionTemplateList.isPresent() && !predictionTemplateList.get().isEmpty()) {

			observations = new ArrayList<ProfilePredictionDTO>();

			for (PredictionTemplate predictionTemplate : predictionTemplateList.get()) {

				if (!templateCodes.isEmpty() && templateCodes.contains(predictionTemplate.getCode())) {

					templates.add(predictionTemplate.getName());
					Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository
							.getOutcomesForTemplate(predictionTemplate.getCode());
					Optional<AnalysisSubComponent> subComp = subComponentRepository
							.findByTemplate(predictionTemplate.getCode());

					if (outcomes.isPresent()) {
						for (PredictionOutcome outcome : outcomes.get()) {

							ProfilePredictionDTO profilePredictDTO = new ProfilePredictionDTO();

							if (subComp.isPresent()) {

								AnalysisSubComponent subComponent = subComp.get();

								Optional<AnalysisComponent> component = componentRepository
										.findByCode(subComponent.getComponentCode());

								if (component.isPresent()) {
									profilePredictDTO.setAnalysisGroup(component.get().getAnalysisGroup());
									profilePredictDTO.setComponentName(component.get().getName());
								}
								profilePredictDTO.setSubComponentName(subComponent.getName());
								profilePredictDTO.setConditionChecked(subComponent.getConditionChecked());
							}

							Map<String, PredictionObservation> observationMap = outcome.getPredictionObservations();
							PredictionObservation observation = observationMap.get(parent.getCode());

							profilePredictDTO.setNature(observation.getNature());
							profilePredictDTO.setOutcome(outcome.getName());
							profilePredictDTO.setObservation(observation.getObservation());
							profilePredictDTO.setTimeDependent(observation.isTimeDependent());

							observations.add(profilePredictDTO);
						}
					}
					parent.setPredictions(observations);
				}
			}
		}
		parent.setMappedTemplates(templates.toString());
	}

	private void populateInfoFilterByOutcomes(ProfileAspectDTO parent, Map<String, String> componentToOutcomeMap) {

		List<String> templates = new ArrayList<String>();
		List<ProfilePredictionDTO> observations = null;
		Optional<List<PredictionTemplate>> predictionTemplateList = predictionTemplateRepository
				.findByAspectCode(parent.getCode());

		if (predictionTemplateList.isPresent() && !predictionTemplateList.get().isEmpty()) {

			observations = new ArrayList<ProfilePredictionDTO>();

			for (PredictionTemplate predictionTemplate : predictionTemplateList.get()) {

				templates.add(predictionTemplate.getName());
				Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(predictionTemplate.getCode());
				Optional<AnalysisSubComponent> subComp = subComponentRepository
						.findByTemplate(predictionTemplate.getCode());

				if (outcomes.isPresent()) {

					for (PredictionOutcome outcome : outcomes.get()) {

						if (!componentToOutcomeMap.values().isEmpty()
								&& componentToOutcomeMap.values().contains(outcome.getCode())
								&& !componentToOutcomeMap.keySet().isEmpty()
								&& componentToOutcomeMap.keySet().contains(outcome.getCode())) {
							ProfilePredictionDTO profilePredictDTO = new ProfilePredictionDTO();

							if (subComp.isPresent()) {

								AnalysisSubComponent subComponent = subComp.get();

								Optional<AnalysisComponent> component = componentRepository
										.findByCode(subComponent.getComponentCode());

								if (component.isPresent()) {
									profilePredictDTO.setAnalysisGroup(component.get().getAnalysisGroup());
									profilePredictDTO.setComponentName(component.get().getName());
								}

								profilePredictDTO.setSubComponentName(subComponent.getName());
								profilePredictDTO.setConditionChecked(subComponent.getConditionChecked());
							}

							Map<String, PredictionObservation> observationMap = outcome.getPredictionObservations();
							PredictionObservation observation = observationMap.get(parent.getCode());

							profilePredictDTO.setNature(observation.getNature());
							profilePredictDTO.setOutcome(outcome.getName());
							profilePredictDTO.setObservation(observation.getObservation());
							profilePredictDTO.setTimeDependent(observation.isTimeDependent());

							observations.add(profilePredictDTO);
						}
					}
				}
			}
		}
	}

	private void populateInfoFilterByOutcomes(ProfileAspectDTO parent, Map<String, String> componentToOutcomeMap,
			AnalysisGroup analysisGroup) {

		List<String> templates = new ArrayList<String>();
		List<ProfilePredictionDTO> observations = null;
		Optional<List<PredictionTemplate>> predictionTemplateList = predictionTemplateRepository
				.findByAspectCode(parent.getCode());

		if (predictionTemplateList.isPresent() && !predictionTemplateList.get().isEmpty()) {

			observations = new ArrayList<ProfilePredictionDTO>();

			for (PredictionTemplate predictionTemplate : predictionTemplateList.get()) {

				templates.add(predictionTemplate.getName());
				Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(predictionTemplate.getCode());
				Optional<AnalysisSubComponent> subComp = subComponentRepository
						.findByTemplate(predictionTemplate.getCode());
				Optional<AnalysisComponent> component = null;
				if (subComp.isPresent()) {
					component = componentRepository.findByCode(subComp.get().getComponentCode());

				}
				if (outcomes.isPresent()) {

					for (PredictionOutcome outcome : outcomes.get()) {

						if (!componentToOutcomeMap.values().isEmpty()
								&& componentToOutcomeMap.values().contains(outcome.getCode())
								&& !componentToOutcomeMap.keySet().isEmpty()
								&& componentToOutcomeMap.keySet().contains(subComp.get().getCode())
								&& analysisGroup.equals(component.get().getAnalysisGroup())) {
							ProfilePredictionDTO profilePredictDTO = new ProfilePredictionDTO();

							if (subComp.isPresent()) {

								AnalysisSubComponent subComponent = subComp.get();

								if (component.isPresent()) {
									profilePredictDTO.setAnalysisGroup(component.get().getAnalysisGroup());
									profilePredictDTO.setComponentName(component.get().getName());
								}
								profilePredictDTO.setSubComponentName(subComponent.getName());
								profilePredictDTO.setConditionChecked(subComponent.getConditionChecked());
							}

							Map<String, PredictionObservation> observationMap = outcome.getPredictionObservations();
							PredictionObservation observation = observationMap.get(parent.getCode());

							profilePredictDTO.setNature(observation.getNature());
							profilePredictDTO.setOutcome(outcome.getName());
							profilePredictDTO.setObservation(observation.getObservation());
							profilePredictDTO.setTimeDependent(observation.isTimeDependent());

							observations.add(profilePredictDTO);
						}
					}
					parent.setMappedTemplates(templates.toString());
					parent.setPredictions(observations);
				}
			}
		}
	}

	private void populateInfoFilterBySource(ProfileAspectDTO parent, List<AnalysisGroup> analysisGroups) {

		List<String> templates = new ArrayList<String>();
		List<ProfilePredictionDTO> observations = null;
		Optional<List<PredictionTemplate>> predictionTemplateList = predictionTemplateRepository
				.findByAspectCode(parent.getCode());

		if (predictionTemplateList.isPresent() && !predictionTemplateList.get().isEmpty()) {

			observations = new ArrayList<ProfilePredictionDTO>();

			for (PredictionTemplate predictionTemplate : predictionTemplateList.get()) {

				templates.add(predictionTemplate.getName());
				Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(predictionTemplate.getCode());
				Optional<AnalysisSubComponent> subComp = subComponentRepository
						.findByTemplate(predictionTemplate.getCode());
				Optional<AnalysisComponent> component = componentRepository
						.findByCode(subComp.get().getComponentCode());

				if (subComp.isPresent() && component.isPresent()) {
					if (!analysisGroups.isEmpty() && analysisGroups.contains(component.get().getAnalysisGroup())) {
						if (outcomes.isPresent()) {

							for (PredictionOutcome outcome : outcomes.get()) {

								ProfilePredictionDTO profilePredictDTO = new ProfilePredictionDTO();

								if (subComp.isPresent()) {

									AnalysisSubComponent subComponent = subComp.get();
									if (component.isPresent()) {
										profilePredictDTO.setAnalysisGroup(component.get().getAnalysisGroup());
										profilePredictDTO.setComponentName(component.get().getName());
									}
									profilePredictDTO.setSubComponentName(subComponent.getName());
									profilePredictDTO.setConditionChecked(subComponent.getConditionChecked());
								}

								Map<String, PredictionObservation> observationMap = outcome.getPredictionObservations();
								PredictionObservation observation = observationMap.get(parent.getCode());

								profilePredictDTO.setNature(observation.getNature());
								profilePredictDTO.setOutcome(outcome.getName());
								profilePredictDTO.setObservation(observation.getObservation());
								profilePredictDTO.setTimeDependent(observation.isTimeDependent());

								observations.add(profilePredictDTO);
							}
						}
						parent.setMappedTemplates(templates.toString());

					}
				}
			}
		}
		parent.setPredictions(observations);

	}

	private void populateInfo(ProfileAspectDTO parent, ProfileFilterDTO profileFilterDTO) {

		if (profileFilterDTO == null) {
			this.populateInfo(parent);
		} else if (profileFilterDTO.getFilterType().equals(ProfileFilterTypeDTO.Template)) {

			List<String> templateCodes = new ArrayList<String>();
			templateCodes.add(profileFilterDTO.getFilterValue());

			this.populateInfoFilterByTemplates(parent, templateCodes);
		} else if (profileFilterDTO.getFilterType().equals(ProfileFilterTypeDTO.AnalysisGroup)) {

			List<AnalysisGroup> analysisGroups = new ArrayList<AnalysisGroup>();
			analysisGroups.add(AnalysisGroup.valueOf(profileFilterDTO.getFilterValue()));

			this.populateInfoFilterBySource(parent, analysisGroups);
		} else {

		}
	}

	private void populateInfo(ProfileAspectDTO parent) {

		List<String> templates = new ArrayList<String>();
		List<ProfilePredictionDTO> observations = null;
		Optional<List<PredictionTemplate>> predictionTemplateList = predictionTemplateRepository
				.findByAspectCode(parent.getCode());

		if (predictionTemplateList.isPresent() && !predictionTemplateList.get().isEmpty()) {

			observations = new ArrayList<ProfilePredictionDTO>();

			for (PredictionTemplate predictionTemplate : predictionTemplateList.get()) {

				templates.add(predictionTemplate.getName());
				Optional<List<PredictionOutcome>> outcomes = predictionOutcomeRepository
						.getOutcomesForTemplate(predictionTemplate.getCode());
				Optional<AnalysisSubComponent> subComp = subComponentRepository
						.findByTemplate(predictionTemplate.getCode());

				if (outcomes.isPresent()) {
					for (PredictionOutcome outcome : outcomes.get()) {

						ProfilePredictionDTO profilePredictDTO = new ProfilePredictionDTO();

						if (subComp.isPresent()) {

							AnalysisSubComponent subComponent = subComp.get();
							Optional<AnalysisComponent> component = componentRepository
									.findByCode(subComponent.getComponentCode());

							if (component.isPresent()) {
								profilePredictDTO.setAnalysisGroup(component.get().getAnalysisGroup());
								profilePredictDTO.setComponentName(component.get().getName());
							}
							profilePredictDTO.setSubComponentName(subComponent.getName());
							profilePredictDTO.setConditionChecked(subComponent.getConditionChecked());
						}

						Map<String, PredictionObservation> observationMap = outcome.getPredictionObservations();
						PredictionObservation observation = observationMap.get(parent.getCode());

						profilePredictDTO.setNature(observation.getNature());
						profilePredictDTO.setOutcome(outcome.getName());
						profilePredictDTO.setObservation(observation.getObservation());
						profilePredictDTO.setTimeDependent(observation.isTimeDependent());

						observations.add(profilePredictDTO);
					}
				}
			}
		}
		parent.setMappedTemplates(templates.toString());
		parent.setPredictions(observations);
	}
}
