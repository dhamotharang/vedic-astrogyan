package com.vedic.astro.enums;

public enum Dasha {
	
	MARS(7),RAHU(18),JUPITER(16),SATURN(19),MERCURY(17),KETU(7),VENUS(20),SUN(6),MOON(10);
	
	private int years;
	
	private Dasha(int years){
		this.years = years;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}
	
	public float getProportion(){
		return (float)years/120;
	}
}
