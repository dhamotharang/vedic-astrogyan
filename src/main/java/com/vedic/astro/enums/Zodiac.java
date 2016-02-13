package com.vedic.astro.enums;

public enum Zodiac {
	ARE(1, "Mesha", ZodiacType.Movable, CharaType.Direct, "Aries"), TAU(2, "Vrishabha", ZodiacType.Fixed, CharaType.Direct,"Taurus"), GEM(3, "Mithuna", ZodiacType.Dual, CharaType.Direct, "Gemini"), CAN(4, "Karka", ZodiacType.Movable, CharaType.Indirect, "Cancer"), LEO(
			5, "Simha", ZodiacType.Fixed, CharaType.Indirect,"Leo"), VIR(6, "Kanya", ZodiacType.Dual, CharaType.Indirect, "Virgo"), LIB(7, "Tula",  ZodiacType.Movable, CharaType.Direct, "Libra"), SCO(8, "Vrischika", ZodiacType.Fixed, CharaType.Direct, "Scorpio"), SAG(
			9, "Dhanu", ZodiacType.Dual, CharaType.Direct, "Sagitarius"), CAP(10, "Makara", ZodiacType.Movable, CharaType.Indirect, "Capricon"), AQU(11, "Kumbha", ZodiacType.Fixed, CharaType.Indirect, "Aquarius"), PIS(12, "Meena", ZodiacType.Dual, CharaType.Indirect, "Pisces");

	private int number;
	private String hindiName;
	private String englishName;
	private ZodiacType zodiacType;
	private CharaType charaType; 


	public int getNumber() {
		return number;
	}

	public String getHindiName() {
		return hindiName;
	}

	
	public String getEnglishName() {
		return englishName;
	}

	public ZodiacType getZodiacType() {
		return zodiacType;
	}

	private Zodiac(int number, String hindiName, ZodiacType zodiacType, CharaType charaType, String englishName) {
		this.number = number;
		this.hindiName = hindiName;
		this.zodiacType = zodiacType;
		this.charaType = charaType;
		this.englishName = englishName;
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
