package com.vedic.astro.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vedic.astro.enums.KarmicAspectCategory;
import com.vedic.astro.enums.KarmicAspectSubCategory;
import com.vedic.astro.enums.MentalAspectCategory;
import com.vedic.astro.enums.MentalAspectSubCategory;
import com.vedic.astro.enums.PhysicalAspectCategory;
import com.vedic.astro.enums.PhysicalAspectSubCategory;

public class PersonProfile {
	
	private String pid = null;
	
	private Map<KarmicAspectCategory, Map<KarmicAspectSubCategory,List<PredictionObservation>>> karmicAspects = new
			HashMap<KarmicAspectCategory, Map<KarmicAspectSubCategory,List<PredictionObservation>>>();

	private Map<PhysicalAspectCategory, Map<PhysicalAspectSubCategory,List<PredictionObservation>>> physicalAspects = new
			HashMap<PhysicalAspectCategory, Map<PhysicalAspectSubCategory,List<PredictionObservation>>>();

	private Map<MentalAspectCategory, Map<MentalAspectSubCategory,List<PredictionObservation>>> mentalAspects = new
			HashMap<MentalAspectCategory, Map<MentalAspectSubCategory,List<PredictionObservation>>>();

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Map<KarmicAspectCategory, Map<KarmicAspectSubCategory, List<PredictionObservation>>> getKarmicAspects() {
		return karmicAspects;
	}

	public void setKarmicAspects(
			Map<KarmicAspectCategory, Map<KarmicAspectSubCategory, List<PredictionObservation>>> karmicAspects) {
		this.karmicAspects = karmicAspects;
	}

	public Map<PhysicalAspectCategory, Map<PhysicalAspectSubCategory, List<PredictionObservation>>> getPhysicalAspects() {
		return physicalAspects;
	}

	public void setPhysicalAspects(
			Map<PhysicalAspectCategory, Map<PhysicalAspectSubCategory, List<PredictionObservation>>> physicalAspects) {
		this.physicalAspects = physicalAspects;
	}

	public Map<MentalAspectCategory, Map<MentalAspectSubCategory, List<PredictionObservation>>> getMentalAspects() {
		return mentalAspects;
	}

	public void setMentalAspects(
			Map<MentalAspectCategory, Map<MentalAspectSubCategory, List<PredictionObservation>>> mentalAspects) {
		this.mentalAspects = mentalAspects;
	}

	@Override
	public String toString() {
		return "PersonProfile [pid=" + pid + ", karmicAspects=" + karmicAspects
				+ ", physicalAspects=" + physicalAspects + ", mentalAspects="
				+ mentalAspects + "]";
	}
}