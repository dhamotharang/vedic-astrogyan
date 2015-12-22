package com.vedic.astro.domain;

import com.vedic.astro.enums.Zodiac;

public class ZodiacDashaPeriod {

	private Zodiac mahadashaZodiac = null;
	private Zodiac antardashaZodiac = null;

	private DashaTimePeriod antardashaPeriod = null;
	private DashaTimePeriod mahadashaPeriod = null;

	public ZodiacDashaPeriod(Zodiac mahadashaZodiac, Zodiac antardashaZodiac,
			DashaTimePeriod antardashaPeriod, DashaTimePeriod mahadashaPeriod) {
		super();
		this.mahadashaZodiac = mahadashaZodiac;
		this.antardashaZodiac = antardashaZodiac;
		this.antardashaPeriod = antardashaPeriod;
		this.mahadashaPeriod = mahadashaPeriod;
	}

	public Zodiac getMahadashaZodiac() {
		return mahadashaZodiac;
	}

	public Zodiac getAntardashaZodiac() {
		return antardashaZodiac;
	}

	public DashaTimePeriod getAntardashaPeriod() {
		return antardashaPeriod;
	}

	public DashaTimePeriod getMahadashaPeriod() {
		return mahadashaPeriod;
	}

	@Override
	public String toString() {
		return "ZodiacDashaPeriod [mahadashaZodiac=" + mahadashaZodiac
				+ ", antardashaZodiac=" + antardashaZodiac
				+ ", antardashaPeriod=" + antardashaPeriod
				+ ", mahadashaPeriod=" + mahadashaPeriod + "]";
	}
}