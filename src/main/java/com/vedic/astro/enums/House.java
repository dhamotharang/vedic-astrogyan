package com.vedic.astro.enums;

public enum House {
	H1(1), H2(2), H3(3), H4(4), H5(5), H6(6), H7(7), H8(8), H9(9), H10(10), H11(11), H12(12);

	private int value;

	private House(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
