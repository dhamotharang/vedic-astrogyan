package com.vedic.astro.domain;

import com.vedic.astro.enums.MentalAspectCategory;
import com.vedic.astro.enums.MentalAspectSubCategory;
import com.vedic.astro.enums.PhysicalAspectCategory;
import com.vedic.astro.enums.PhysicalAspectSubCategory;

public class MentalAspectObservation extends AspectObservation{
	
	private MentalAspectCategory category;
	private MentalAspectSubCategory subCategory;

	public MentalAspectCategory getCategory() {
		return category;
	}
	public void setCategory(MentalAspectCategory category) {
		this.category = category;
	}
	public MentalAspectSubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(MentalAspectSubCategory subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "MentalAspectObservation [category=" + category
				+ ", subCategory=" + subCategory + "]";
	}
}
