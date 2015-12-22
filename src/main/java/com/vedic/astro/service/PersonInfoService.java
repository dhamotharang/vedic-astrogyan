package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.DashaData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.DashaInfoRepository;
import com.vedic.astro.repository.PersonalInfoRepository;
import com.vedic.astro.util.BirthChartAnalysisUtil;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.VimshotriDashaUtil;
import com.vedic.astro.util.DateUtil;
import com.vedic.astro.util.NakshatraUtil;
import com.vedic.astro.vo.PersonalInfo;
import com.vedic.astro.vo.PlanetPosition;

@Service("personalInfoService")
@Transactional
public class PersonInfoService {

	@Autowired
	@Qualifier("personalInfoRepository")
	private PersonalInfoRepository personalInfoRepository;

	@Autowired
	@Qualifier("dashaInfoRepository")
	private DashaInfoRepository dashaInfoRepository;
	
	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;
	
	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("vimshotriDashaUtil")
	private VimshotriDashaUtil vimshotriDashaUtil;
	
	@Autowired
	@Qualifier("nakshatraUtil")
	private NakshatraUtil nakshatraUtil;

	@Autowired
	@Qualifier("birthChartAnalysisUtil")
	private BirthChartAnalysisUtil birthChartAnalysisUtil;
	
	public String addPersonalInfo(PersonalInfo personalInfo){
		
		String pid = this.personalInfoRepository.add(personalInfo);
		
		BirthChartData birthChartData = birthChartUtil.generateD1Chart(personalInfo.getBirthPlanetaryPositions());
		birthChartData.setPid(pid);
		
		birthChartRepository.add(birthChartData);
		
/*		BirthBriefChartAnalysis birthBriefChartAnalysis = birthChartAnalysisUtil.predictChartInBrief(birthChartData, pid);
		
		birthChartAnalysisRepository.add(birthBriefChartAnalysis.getHouseAnalysis());
*/
		PlanetPosition moonPosition = null;
		
		for (PlanetPosition planetPosition : personalInfo.getBirthPlanetaryPositions().getPlanetPositions()){
			if(planetPosition.getPlanet().equals(Planet.MON)){
			
				moonPosition = planetPosition;
				break;
			}
		}
		
		DashaData dashaData = vimshotriDashaUtil.generateDashaData(moonPosition.getZodiac(), 
				nakshatraUtil.getNakshatra(moonPosition.getZodiac(),
						moonPosition.getDegrees()), moonPosition.getDegrees(), 
						DateUtil.toDate(personalInfo.getDob(), "MM/dd/yyyy"),
						pid);
		
		dashaInfoRepository.add(dashaData.getData());
		

		return pid;
	}

	public PersonalInfo getPersonalInfo(String pid){
		
		PersonalInfo personalInfo  = this.personalInfoRepository.findBy(pid);

		return personalInfo;
	}

}
