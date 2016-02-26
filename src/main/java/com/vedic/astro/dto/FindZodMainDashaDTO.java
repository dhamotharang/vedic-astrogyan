package com.vedic.astro.dto;

import com.vedic.astro.enums.ZodDashaSystem;

public class FindZodMainDashaDTO extends BaseFindMainDashaDTO{
	
	private ZodDashaSystem dashaSystem = null;

	public ZodDashaSystem getDashaSystem() {
		return dashaSystem;
	}
	public void setDashaSystem(ZodDashaSystem dashaSystem) {
		this.dashaSystem = dashaSystem;
	}

	@Override
	public String toString() {
		return "FindZodMainDashaDTO [dashaSystem=" + dashaSystem + "]";
	}
}
