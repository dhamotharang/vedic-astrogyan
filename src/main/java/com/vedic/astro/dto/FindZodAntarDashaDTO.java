package com.vedic.astro.dto;

import com.vedic.astro.enums.ZodDashaSystem;
import com.vedic.astro.enums.Zodiac;

public class FindZodAntarDashaDTO extends BaseFindAntarDashaDTO{
	
	private Zodiac zodiac = null;
	private ZodDashaSystem dashaSystem = null;

	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}
	public ZodDashaSystem getDashaSystem() {
		return dashaSystem;
	}
	public void setDashaSystem(ZodDashaSystem dashaSystem) {
		this.dashaSystem = dashaSystem;
	}
	@Override
	public String toString() {
		return "FindZodAntarDashaDTO [zodiac=" + zodiac + ", dashaSystem=" + dashaSystem + "]";
	}
}
