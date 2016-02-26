package com.vedic.astro.dto;

import com.vedic.astro.enums.NakDashaSystem;

public class FindNakMainDashaDTO extends BaseFindMainDashaDTO {
	
	private NakDashaSystem dashaSystem = null;
	
	public NakDashaSystem getDashaSystem() {
		return dashaSystem;
	}

	public void setDashaSystem(NakDashaSystem dashaSystem) {
		this.dashaSystem = dashaSystem;
	}

	@Override
	public String toString() {
		return "FindNakMainDashaDTO [dashaSystem=" + dashaSystem + "]";
	}
}
