package com.vedic.astro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedic.astro.dto.ChartProfileDTO;
import com.vedic.astro.dto.LevelProfileAspectDTO;
import com.vedic.astro.dto.PathProfileAspectDTO;
import com.vedic.astro.dto.ProfileAspectDTO;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.exception.BusinessException;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.service.ProfileService;

/**
 * The Main controller which handles all the incoming GET and POST RESTFul web
 * service calls.
 * 
 * @author Sumeer Saxena
 */
@RestController
@RequestMapping("/api")
final public class ProfileController extends BaseController {

	@Autowired
	@Qualifier("profileService")
	private ProfileService profileService;

	@RequestMapping(value = "/profile/chart/{memberPid}", method = RequestMethod.GET)
	public RestServiceResponse<ChartProfileDTO> getChartProfile(@PathVariable String memberPid)
			throws BusinessException, SystemException {

		ChartProfileDTO chartProfileDTO = profileService.getChartProfile(memberPid);

		return new RestServiceResponse<ChartProfileDTO>(chartProfileDTO);
	}

	@RequestMapping(value = "/profile/tree", method = RequestMethod.GET)
	public RestServiceResponse<List<ProfileAspectDTO>> getProfileHeirarchy() throws BusinessException, SystemException {

		List<ProfileAspectDTO> profileHeirarchy = profileService.getProfileHierachyTree(PredictionSystem.Prashara);

		return new RestServiceResponse<List<ProfileAspectDTO>>(profileHeirarchy);
	}
	
	@RequestMapping(value = "/profile/flat", method = RequestMethod.GET)
	public RestServiceResponse<List<PathProfileAspectDTO>> getProfileHeirarchyFlat() throws BusinessException, SystemException {

		List<PathProfileAspectDTO> profileHeirarchy = profileService.getProfileHierachyFlat(PredictionSystem.Prashara);

		return new RestServiceResponse<List<PathProfileAspectDTO>>(profileHeirarchy);
	}


	@RequestMapping(value = "/profile/parents", method = RequestMethod.GET)
	public RestServiceResponse<List<LevelProfileAspectDTO>> getAllParents() throws BusinessException, SystemException {

		List<LevelProfileAspectDTO> parentsList = profileService.getAllParents();

		return new RestServiceResponse<List<LevelProfileAspectDTO>>(parentsList);
	}

	@RequestMapping(value = "/profile/children/{parentCode}", method = RequestMethod.GET)
	public RestServiceResponse<List<LevelProfileAspectDTO>> getChildren(@PathVariable String parentCode)
			throws BusinessException, SystemException {
		List<LevelProfileAspectDTO> children = profileService.getImmediateChildren(parentCode);
		return new RestServiceResponse<List<LevelProfileAspectDTO>>(children);
	}

	@RequestMapping(value = "/profile/save", method = RequestMethod.POST)
	public RestServiceResponse<String> addAspect(@RequestBody @Valid LevelProfileAspectDTO profileAspectDTO) throws BusinessException, SystemException {

		profileService.saveAspect(profileAspectDTO);
		String returnValue = "Aspect saved successfully";
		return new RestServiceResponse<String>(returnValue);
	}

	@RequestMapping(value = "/profile/delete/{id}", method = RequestMethod.POST)
	public RestServiceResponse<String> deleteAspect(@PathVariable String id)
			throws BusinessException, SystemException {

		profileService.deleteAspect(id);
		String returnValue = "Aspect deleted successfully";
		
		return new RestServiceResponse<String>(returnValue);
	}

}
