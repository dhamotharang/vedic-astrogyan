package com.vedic.astro.vo;

import com.vedic.astro.enums.Zodiac;

public class ZodiacPosition {
	
	private Double degrees;
	private Zodiac zodiac;
	
	public ZodiacPosition(){}
	
	public ZodiacPosition(Double degrees, Zodiac zodiac) {
		super();
		this.degrees = degrees;
		this.zodiac = zodiac;
	}
	public Double getDegrees() {
		return degrees;
	}
	public void setDegrees(Double degrees) {
		this.degrees = degrees;
	}
	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}

	@Override
	public String toString() {
		return "ZodiacPosition [degrees=" + degrees + ", zodiac=" + zodiac
				+ "]";
	}
}
