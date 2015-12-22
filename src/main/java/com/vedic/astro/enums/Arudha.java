package com.vedic.astro.enums;

public enum Arudha {
	AL(1), A2(2), A3(3), A4(4), A5(5), A6(6), A7(7), A8(8), A9(9), A10(10), A11(
			11), A12(12);

	private int value;

	private Arudha(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Arudha getArudhaAt(int index) {
		int i = 0;
		Arudha returnArudha = null;
		for (Arudha arudha : Arudha.values()) {
			i++;
			if (index == i) {
				returnArudha = arudha;
				break;
			}
		}
		return returnArudha;
	}
}