package com.vedic.astro.dto;

import com.vedic.astro.enums.Zodiac;

public class ZodDashaDTO extends BaseDashaDTO{

	protected Zodiac zodiac = null;
	
	public ZodDashaDTO(Zodiac zodiac, String startDate, String endDate) {
		this.zodiac = zodiac;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public ZodDashaDTO() {}
	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}
	@Override
	public String toString() {
		return "ZodDashaDTO [zodiac=" + zodiac + "]";
	}
}
