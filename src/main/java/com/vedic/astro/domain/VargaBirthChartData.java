package com.vedic.astro.domain;

import java.io.Serializable;
import java.util.List;

import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.vo.VargaChartHouse;

public class VargaBirthChartData implements Serializable {

	private String pid;
	
	private BirthChartType birthChartType;
	
	private List<VargaChartHouse> chartHouses;

	public List<VargaChartHouse> getChartHouses() {
		return chartHouses;
	}

	public void setChartHouses(List<VargaChartHouse> chartHouses) {
		this.chartHouses = chartHouses;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public BirthChartType getBirthChartType() {
		return birthChartType;
	}

	public void setBirthChartType(BirthChartType birthChartType) {
		this.birthChartType = birthChartType;
	}

	@Override
	public String toString() {
		return "BirthChartData [pid=" + pid + ", birthChartType="
				+ birthChartType + ", chartHouses=" + chartHouses + "]";
	}
}
