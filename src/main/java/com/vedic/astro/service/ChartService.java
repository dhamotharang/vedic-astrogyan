package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedic.astro.dto.ChartHouseDTO;
import com.vedic.astro.dto.HouseContentDTO;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;

@Service("chartService")
public class ChartService {

	public List<ChartHouseDTO> getChart(BirthChartType chartType, String memberId) {
		
		List<ChartHouseDTO> chartHouseDTOList = new ArrayList<ChartHouseDTO>();
		
		List<String> h1Planets = new ArrayList<String>();
		h1Planets.add("MON");
		h1Planets.add("KET");
		
		List<String> h5Planets = new ArrayList<String>();
		h5Planets.add("MAR");
		
		List<String> h6Planets = new ArrayList<String>();
		h6Planets.add("MER");
		h6Planets.add("VEN");
		
		List<String> h7Planets = new ArrayList<String>();
		h7Planets.add("JUP");
		h7Planets.add("SUN");
		h7Planets.add("RAH");
		
		List<String> h12Planets = new ArrayList<String>();
		h12Planets.add("SAT");
		
		chartHouseDTOList.add(new ChartHouseDTO(House.H1, new HouseContentDTO(3, h1Planets, 3)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H2, new HouseContentDTO(4, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H3, new HouseContentDTO(5, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H4, new HouseContentDTO(6, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H5, new HouseContentDTO(7, h5Planets, 4)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H6, new HouseContentDTO(8, h6Planets, 12)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H7, new HouseContentDTO(9, h7Planets, 23)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H8, new HouseContentDTO(10, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H9, new HouseContentDTO(11, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H10, new HouseContentDTO(12, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H11, new HouseContentDTO(1, 0)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H12, new HouseContentDTO(2, h12Planets, 17)));
		
		return chartHouseDTOList;
	}
}
