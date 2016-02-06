package com.vedic.astro.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.dto.ChartImpactDTO;
import com.vedic.astro.dto.ChartProfileDTO;

@Service("profileService")
@Transactional
public class ProfileService {

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
}
