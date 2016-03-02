package com.vedic.astro.enums;

public enum AnalysisGroup {

	ChartAnalysis("Chart Analysis"), HouseAnalysis("House Analysis"), YogasAnalysis("Yoga Analysis"), DashaAnalysis("Dasha Analysis"), VargaAnalysis("Varga Analysis"), TransitAnalysis("Transit Analysis"), ArgalaAnalysis("Argala Analysis"), ArudhaAnalysis("Arudha Analysis");
	
	private String desc;
	
	private AnalysisGroup(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
