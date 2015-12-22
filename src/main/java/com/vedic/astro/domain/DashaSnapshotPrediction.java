package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

public class DashaSnapshotPrediction {

	private List<DashaHousePrediction> dashaHousePredictions = 
			new ArrayList<DashaHousePrediction>();

	public List<DashaHousePrediction> getDashaHousePredictions() {
		return dashaHousePredictions;
	}

	public void setDashaHousePredictions(
			List<DashaHousePrediction> dashaHousePredictions) {
		this.dashaHousePredictions = dashaHousePredictions;
	}

	@Override
	public String toString() {
		return "DashaSnapshotPrediction [dashaHousePredictions="
				+ dashaHousePredictions + "]";
	}
}
