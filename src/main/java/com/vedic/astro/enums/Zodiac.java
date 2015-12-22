package com.vedic.astro.enums;

public enum Zodiac {
	ARE(1, "Mesha", ZodiacType.Movable, CharaType.Direct), TAU(2, "Vrishabha", ZodiacType.Fixed, CharaType.Direct), GEM(3, "Mithuna", ZodiacType.Dual, CharaType.Direct), CAN(4, "Karka", ZodiacType.Movable, CharaType.Indirect), LEO(
			5, "Simha", ZodiacType.Fixed, CharaType.Indirect), VIR(6, "Kanya", ZodiacType.Dual, CharaType.Indirect), LIB(7, "Tula",  ZodiacType.Movable, CharaType.Direct), SCO(8, "Vrischika", ZodiacType.Fixed, CharaType.Direct), SAG(
			9, "Dhanu", ZodiacType.Dual, CharaType.Direct), CAP(10, "Makara", ZodiacType.Movable, CharaType.Indirect), AQU(11, "Kumbha", ZodiacType.Fixed, CharaType.Indirect), PIS(12, "Meena", ZodiacType.Dual, CharaType.Indirect);

	private int number;
	private String hindiName;
	private ZodiacType zodiacType;
	private CharaType charaType; 


	public int getNumber() {
		return number;
	}

	public String getHindiName() {
		return hindiName;
	}

	public ZodiacType getZodiacType() {
		return zodiacType;
	}

	private Zodiac(int number, String hindiName, ZodiacType zodiacType, CharaType charaType) {
		this.number = number;
		this.hindiName = hindiName;
		this.zodiacType = zodiacType;
		this.charaType = charaType;
	}

	public static Zodiac fromHindiName(String hindiName) {
		Zodiac returnZod = null;
		Zodiac[] zodiac = Zodiac.values();
		for (int i = 0; i < zodiac.length; i++) {
			if (zodiac[i].getHindiName().equalsIgnoreCase(hindiName)) {
				returnZod = zodiac[i];
				break;
			}

		}
		return returnZod;
	}
	
	public int getMaxDegrees() {
		return this.number * 30;
	}
	
	public int getMinDegrees() {
		return (this.number-1) * 30;
	}

	public boolean isEven(){
		return ( this.number % 2 == 0 );
	}

	public CharaType getCharaType() {
		return charaType;
	}
}
