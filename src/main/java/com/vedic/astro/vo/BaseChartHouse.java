package com.vedic.astro.vo;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Zodiac;

public class BaseChartHouse {

	protected Zodiac zodiac;
	protected House house;
	
	public Zodiac getZodiac() {
		return zodiac;
	}
	public void setZodiac(Zodiac zodiac) {
		this.zodiac = zodiac;
	}

	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "BaseChartHouse [zodiac=" + zodiac + ", house=" + house + "]";
	}
}
