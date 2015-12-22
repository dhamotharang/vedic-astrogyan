package com.vedic.astro.enums;

public enum DecimalPlace {

	Unit(1), Tens(10), Hundreds(100), Thousands(1000), TenThousands(10000);
	
	private int value;

	private DecimalPlace(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
