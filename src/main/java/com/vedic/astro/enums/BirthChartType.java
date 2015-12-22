package com.vedic.astro.enums;

public enum BirthChartType {

	D1("Rashi", "Basic chart of person"), D2("Hora", "Wealth, Family, Speech"), D3(
			"Drekkana", "Co-born, ability and power, courage"), D4("Chaturthamsha",
			"Destiny, immovable property, home"), D5("Panchamsha", "Spiritual inclination, Poorva Punya"), D6(
			"Shashtamsha", "Proneness to disease, debt and disputes"), D7("Saptamsha",
			"Children & grandchildren"), D8("Ashtamsha", "Longevity, accident"), D9(
			"Navamsha", "Spouse and married life, partners"), D10("Dashamsha",
			"Professional career, honour, success, status"), D12("Dwadashamsa", "Parents lineage"), D16(
			"Shodashamsha", "Movable assets, happiness"), D30("Trimshamsha",
			"Miseries, evil, seperation"), D60("Shastiamsha", "All effects, benefic/malefic");

	private String name;
	private String description;

	private BirthChartType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
