package com.vedic.astro.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.PlanetStrength;
import com.vedic.astro.domain.PlanetStrengths;
import com.vedic.astro.dto.PlanetStrengthDTO;
import com.vedic.astro.dto.PlanetaryStrengthDTO;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetAge;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.PlanetStrengthRepository;
import com.vedic.astro.util.PlanetUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Service("planetService")
@Transactional
public class PlanetService {

	@Autowired
	@Qualifier("planetStrengthRepository")
	private PlanetStrengthRepository planetStrengthRepository;

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	public PlanetaryStrengthDTO getPlanetaryStrengths(PredictionSystem predictionSystem, String memberId) {

		PlanetaryStrengthDTO planetaryStrengthDTO = new PlanetaryStrengthDTO();

		Optional<BirthChartData> birthChartData = birthChartRepository.findByPid(memberId);
		Map<Planet, Double> planetLongsMap = null;
		if (birthChartData.isPresent()) {
			BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
					.preparePlanetsForCalc(birthChartData.get().getChartHouses());
			planetLongsMap = birthChartCalcPrep.getPlanetAgeMapping();
		}

		Optional<PlanetStrengths> planetStrengths = planetStrengthRepository.findByMemberIdAndPredictionSystem(memberId,
				predictionSystem);
		if (planetStrengths.isPresent()) {
			for (PlanetStrength planetStrength : planetStrengths.get().getStrengths()) {

				planetaryStrengthDTO.addStrength(new PlanetStrengthDTO(planetStrength.getPlanet().name().toLowerCase(),
						planetStrength.getPlanet(), planetUtil.findAge(planetLongsMap.get(planetStrength.getPlanet())),
						planetStrength.getStrength()));

			}
		}

		return planetaryStrengthDTO;
	}
}
