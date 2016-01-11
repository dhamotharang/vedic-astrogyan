package com.vedic.astro.domain;

import com.vedic.astro.enums.KarmicAspectCategory;
import com.vedic.astro.enums.KarmicAspectSubCategory;

public class KarmicAspectObservation extends AspectObservation{
	
	private KarmicAspectCategory category;
	private KarmicAspectSubCategory subCategory;
	public KarmicAspectCategory getCategory() {
		return category;
	}
	public void setCategory(KarmicAspectCategory category) {
		this.category = category;
	}
	public KarmicAspectSubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(KarmicAspectSubCategory subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "KarmicAspectObservation [category=" + category
				+ ", subCategory=" + subCategory + "]";
	}
}
