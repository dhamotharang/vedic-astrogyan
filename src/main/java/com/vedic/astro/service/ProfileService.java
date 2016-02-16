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

import com.vedic.astro.domain.ProfileAspect;
import com.vedic.astro.dto.ChartImpactDTO;
import com.vedic.astro.dto.ChartProfileDTO;
import com.vedic.astro.dto.LevelProfileAspectDTO;
import com.vedic.astro.dto.PathProfileAspectDTO;
import com.vedic.astro.dto.ProfileAspectDTO;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.ProfileAspectRepository;

@Service("profileService")
@Transactional
public class ProfileService {

	@Autowired
	@Qualifier("profileAspectRepository")
	private ProfileAspectRepository profileAspectRepository;


	public ChartProfileDTO getChartProfile(String memberId) {

		ChartProfileDTO chartProfileDTO = new ChartProfileDTO();

		chartProfileDTO.addBodyImpact(new ChartImpactDTO("B-Planet", "Mars", "Strength", "Strong physically"));
		chartProfileDTO.addBodyImpact(new ChartImpactDTO("B-Nakshatra", "Mrighshira", "Asc", "Lunatic"));
		chartProfileDTO.addBodyImpact(new ChartImpactDTO("B-Zod", "Mars", "Strength", "Strong physically"));

		chartProfileDTO.addMindImpact(new ChartImpactDTO("M-Planet", "Mars", "Strength", "Strong physically"));
		chartProfileDTO.addMindImpact(new ChartImpactDTO("M-Nakshatra", "Mrighshira", "Asc", "Lunatic"));
		chartProfileDTO.addMindImpact(new ChartImpactDTO("M-Zod", "Mars", "Strength", "Strong physically"));

		chartProfileDTO.addSoulImpact(new ChartImpactDTO("S-Planet", "Mars", "Strength", "Strong physically"));
		chartProfileDTO.addSoulImpact(new ChartImpactDTO("S-Nakshatra", "Mrighshira", "Asc", "Lunatic"));
		chartProfileDTO.addSoulImpact(new ChartImpactDTO("S-Zod", "Mars", "Strength", "Strong physically"));

		return chartProfileDTO;
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

	public List<ProfileAspectDTO> getProfileHierachyTree(PredictionSystem model) {
		Iterable<ProfileAspect> profileAspects = profileAspectRepository.findAll();
		return constructTree(profileAspects, model);
	}
	
	public List<PathProfileAspectDTO> getProfileHierachyFlat(PredictionSystem model) {
		Iterable<ProfileAspect> profileAspects = profileAspectRepository.findAll();
		return constructFlat(profileAspects, model);
	}

	public List<ProfileAspectDTO> getProfileHierachyForEntity(PredictionSystem model, String entityType,
			String entityName) {
		Iterable<ProfileAspect> profileAspects = profileAspectRepository.findAll();
		return constructTree(profileAspects, model);
	}

	private List<ProfileAspectDTO> constructTree(Iterable<ProfileAspect> profileHierachy, PredictionSystem model) {
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

			parent = populateChildren(parent, parentMap, model);
			profileHierachyDTO.add(parent);
		}
		return profileHierachyDTO;
	}


	private ProfileAspectDTO populateChildren(ProfileAspectDTO parent, Map<String, Set<ProfileAspect>> parentMap,
			PredictionSystem model) {

		Set<ProfileAspect> children = parentMap.get(parent.getCode());

		if (children != null) {
			for (ProfileAspect profileAspect : children) {

				ProfileAspectDTO child = new ProfileAspectDTO();
				BeanUtils.copyProperties(profileAspect, child);

				parent.addChild(child);

				if (parentMap.get(profileAspect.getCode()) != null) {
					populateChildren(child, parentMap, model);
				} else {
					populateChildInfo(child, model);
				}
			}
		}
		return parent;
	}


	private void populateChildInfo(ProfileAspectDTO child, PredictionSystem model) {
/*		Optional<List<EntityProfileMapping>> entityAspectObs = entityAspectObservationRepository
				.getAllMappedEntities(child.getCode());
		for (EntityProfileMapping entityAspectObservation : entityAspectObs.get()) {
			child.addMappedEntity(entityAspectObservation.getEntityName());
		}
*/		
	}


	private List<PathProfileAspectDTO> constructFlat(Iterable<ProfileAspect> profileHierachy, PredictionSystem model) {
		List<PathProfileAspectDTO> profileHierachyDTO = 
				new ArrayList<PathProfileAspectDTO>();

		Map<String, ProfileAspect> codeToObjectMap = 
				new HashMap<String, ProfileAspect>();
		
		for (ProfileAspect profileAspect : profileHierachy) {
			codeToObjectMap.put(profileAspect.getCode(), profileAspect);
		}

		for (ProfileAspect profileAspect : profileHierachy) {
			PathProfileAspectDTO pathProfileAspectDTO = new PathProfileAspectDTO();

			pathProfileAspectDTO.addToPath(profileAspect.getName());
			pathProfileAspectDTO.setCode(profileAspect.getCode());
			
			if(profileAspect.getParentCode()!=null){
				ProfileAspect parentAspect = 
						codeToObjectMap.get(profileAspect.getParentCode());
				pathProfileAspectDTO.addToPath(parentAspect.getName());
				
				if(parentAspect.getParentCode()!=null){
					ProfileAspect parentParentAspect = 
							codeToObjectMap.get(parentAspect.getParentCode());
					pathProfileAspectDTO.addToPath(parentParentAspect.getName());
			
				}
			}
	
			profileHierachyDTO.add(pathProfileAspectDTO);
		}
		return profileHierachyDTO;
	}
	private List<PathProfileAspectDTO> populateChildren(PathProfileAspectDTO parent,
			Map<String, Set<ProfileAspect>> parentMap, PredictionSystem model, List<PathProfileAspectDTO> profileHierachyDTO) {

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

}
