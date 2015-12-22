package com.vedic.astro.enums;

public enum Nakshatra {
	
	Aswini(1), Bharani(2), Krithika(3), Rohini(4) , Mrigashiras(5), Arudra(6) , Punarvasu(7), Pushyami(8), Ashlesha(9),
	Magha(10), PoorvaPhalguni(11), UthraPhalguni(12), Hastha(13), Chitra(14), Swaathi(15), Vishaakha(16), Anuraadha(17),
	Jyeshta(18), Moola(19), PoorvaShaada(20), UthraShaada(21), Shraavan(22), Dhanishta(23), Shathabhisha(24),
	PoorvaBhadra(25), UthraBhadra(26), Revathi(27);
	
	private int value;

	private Nakshatra(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
