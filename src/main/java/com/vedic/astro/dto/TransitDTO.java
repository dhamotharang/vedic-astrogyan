package com.vedic.astro.dto;

import com.vedic.astro.enums.Zodiac;

public class TransitDTO extends ZodDashaDTO{
	
	public TransitDTO(){};
	
	public TransitDTO(Zodiac zodiac, String startDate, String endDate) {
		this.zodiac = zodiac;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
