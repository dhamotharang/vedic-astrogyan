package com.vedic.astro.domain;

import com.vedic.astro.enums.Zodiac;

public class ZodiacLongitude extends Longitude{

	private Zodiac zodiac;
	
	public ZodiacLongitude(int degrees, int minutes, int seconds, Zodiac zodiac){
		super(degrees, minutes, seconds);
		this.zodiac = zodiac;
	}

	protected void validate(int degrees, int minutes, int seconds){
		if(degrees > 29 || degrees <0){
			throw new IllegalArgumentException("degrees is between 0 and 30");
		}
       super.validate(degrees, minutes, seconds);		
	}

	public ZodiacLongitude(String longitude, Zodiac zodiac){
        super(longitude);
		this.zodiac = zodiac;
	}
	
	public Zodiac getZodiac() {
		return zodiac;
	}
	

	@Override
	public String toString() {
		return "ZodiacLongitude [zodiac=" + zodiac + ", toString()="
				+ super.toString() + "]";
	}

	public static void main(String args[]){
		ZodiacLongitude longitude = new ZodiacLongitude("27*55'45''", Zodiac.SAG);
	}
	
}
