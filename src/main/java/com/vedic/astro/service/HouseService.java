package com.vedic.astro.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.dto.HouseStrengthDTO;
import com.vedic.astro.dto.HouseStrengthSignificanceDTO;
import com.vedic.astro.dto.HousesStrengthDTO;
import com.vedic.astro.enums.House;

@Service("houseService")
@Transactional
public class HouseService {

	public HousesStrengthDTO getHousesStrengths(String memberId) {
		
		HousesStrengthDTO housesStrengthDTO = new HousesStrengthDTO();
	
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h1", House.H1, 38.34));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h2", House.H2, 25.54));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h3", House.H3, 18.84));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h4", House.H4, 33.84));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h5", House.H5, 57.34));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h6", House.H6, 12.94));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h7", House.H7, 48.25));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h8", House.H8, 18.84));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h9", House.H9, 33.84));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h10", House.H10, 57.34));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h11", House.H11, 12.94));
		housesStrengthDTO.addStrength(new HouseStrengthDTO("h12", House.H12, 48.25));
		
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H1, "H1 body part", "H1 mental", "H1 actions", "H1 personality trait","H1 accumulate", "H1 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H2, "H2 body part", "H2 mental", "H2 actions", "H2 personality trait","H2 accumulate", "H2 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H3, "H3 body part", "H3 mental", "H3 actions", "H3 personality trait","H3 accumulate", "H3 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H4, "H4 body part", "H4 mental", "H4 actions", "H4 personality trait","H4 accumulate", "H4 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H5, "H5 body part", "H5 mental", "H5 actions", "H5 personality trait","H5 accumulate", "H5 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H6, "H6 body part", "H6 mental", "H6 actions", "H6 personality trait","H6 accumulate", "H6 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H7, "H7 body part", "H7 mental", "H7 actions", "H7 personality trait","H7 accumulate", "H7 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H8, "H8 body part", "H8 mental", "H8 actions", "H8 personality trait","H8 accumulate", "H8 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H9, "H9 body part", "H9 mental", "H9 actions", "H9 personality trait","H9 accumulate", "H9 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H10, "H10 body part", "H10 mental", "H10 actions", "H10 personality trait","H10 accumulate", "H10 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H11, "H11 body part", "H11 mental", "H11 actions", "H11 personality trait","H11 accumulate", "H11 relationship"));
		housesStrengthDTO.addSignificance(new HouseStrengthSignificanceDTO(House.H12, "H12 body part", "H12 mental", "H12 actions", "H12 personality trait","H12 accumulate", "H12 relationship"));
		
		return housesStrengthDTO;
	}
}
