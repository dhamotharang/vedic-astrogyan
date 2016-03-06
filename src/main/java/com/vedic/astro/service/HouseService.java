package com.vedic.astro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.HouseStrength;
import com.vedic.astro.domain.HouseStrengths;
import com.vedic.astro.dto.HouseStrengthDTO;
import com.vedic.astro.dto.HousesStrengthDTO;
import com.vedic.astro.enums.PredictionSystem;
import com.vedic.astro.repository.HouseStrengthRepository;

@Service("houseService")
@Transactional
public class HouseService {

	@Autowired
	@Qualifier("houseStrengthRepository")
	private HouseStrengthRepository houseStrengthRepository;

	public HousesStrengthDTO getHousesStrengths(PredictionSystem predictionSystem, String memberId) {

		HousesStrengthDTO housesStrengthDTO = new HousesStrengthDTO();

		Optional<HouseStrengths> houseStrengths = houseStrengthRepository.findByMemberIdAndPredictionSystem(memberId,
				predictionSystem);

		if (houseStrengths.isPresent()) {
			for (HouseStrength houseStrength : houseStrengths.get().getStrengths()) {

				housesStrengthDTO.addStrength(new HouseStrengthDTO(houseStrength.getHouse().name().toLowerCase(),
						houseStrength.getHouse(), houseStrength.getStrength()));
			}
		}
		return housesStrengthDTO;
	}
}
