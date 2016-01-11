package com.vedic.astro.domain;

import com.vedic.astro.enums.PhysicalAspectCategory;
import com.vedic.astro.enums.PhysicalAspectSubCategory;

public class PhysicalAspectObservation extends AspectObservation{
	
	private PhysicalAspectCategory category;
	private PhysicalAspectSubCategory subCategory;
	
	public PhysicalAspectCategory getCategory() {
		return category;
	}
	public void setCategory(PhysicalAspectCategory category) {
		this.category = category;
	}
	public PhysicalAspectSubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(PhysicalAspectSubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "PhysicalAspectObservation [category=" + category
				+ ", subCategory=" + subCategory + "]";
	}
}
