package com.vedic.astro.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.dto.PlanetStrengthDTO;
import com.vedic.astro.dto.PlanetStrengthSignificanceDTO;
import com.vedic.astro.dto.PlanetaryStrengthDTO;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetAge;

@Service("planetService")
@Transactional
public class PlanetService {

	public PlanetaryStrengthDTO getPlanetaryStrengths(String memberId) {
		
		PlanetaryStrengthDTO planetaryStrengthDTO = new PlanetaryStrengthDTO();
	
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("sun", Planet.SUN, PlanetAge.Mature, 38.34));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("mon", Planet.MON, PlanetAge.Teen, 25.54));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("mer", Planet.MER, PlanetAge.Young, 18.84));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("ven", Planet.VEN, PlanetAge.Old, 33.84));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("mar", Planet.MAR, PlanetAge.Mature, 57.34));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("jup", Planet.JUP, PlanetAge.Young, 12.94));
		planetaryStrengthDTO.addStrength(new PlanetStrengthDTO("sat", Planet.SAT, PlanetAge.Infant, 48.25));
		
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.SUN, "SUN body", "SUN mind", "SUN actions", "SUN age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.MON, "MON body", "MON mind", "MON actions", "MON age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.MER, "MER body", "MER mind", "MER actions", "MER age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.VEN, "VEN body", "VEN mind", "VEN actions", "VEN age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.MAR, "MAR body", "MAR mind", "MAR actions", "MAR age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.JUP, "JUP body", "JUP mind", "JUP actions", "JUP age"));
		planetaryStrengthDTO.addSignificance(new PlanetStrengthSignificanceDTO(Planet.SAT, "SAT body", "SAT mind", "SAT actions", "SAT age"));
		
		
		return planetaryStrengthDTO;
	}
}
