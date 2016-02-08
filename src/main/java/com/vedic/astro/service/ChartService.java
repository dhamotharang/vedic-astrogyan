package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedic.astro.dto.ChartHouseDTO;
import com.vedic.astro.dto.HouseContentDTO;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;

@Service("chartService")
public class ChartService {

	public List<ChartHouseDTO> getChart(BirthChartType chartType, String memberId) {
		
		List<ChartHouseDTO> chartHouseDTOList = new ArrayList<ChartHouseDTO>();
		
		List<Planet> h1Planets = new ArrayList<Planet>();
		h1Planets.add(Planet.MON);
		h1Planets.add(Planet.KET);
		
		List<Double> h1Longs = new ArrayList<Double>();
		h1Longs.add(13.45);
		h1Longs.add(18.45);
		
		List<Integer> h1Naks = new ArrayList<Integer>();
		h1Naks.add(13);
		h1Naks.add(14);
		
		List<Planet> h5Planets = new ArrayList<Planet>();
		h5Planets.add(Planet.MAR);
		
		List<Double> h5Longs = new ArrayList<Double>();
		h5Longs.add(28.55);
		
		List<Integer> h5Naks = new ArrayList<Integer>();
		h5Naks.add(17);
		
		
		List<Planet> h6Planets = new ArrayList<Planet>();
		h6Planets.add(Planet.MER);
		h6Planets.add(Planet.VEN);
		
		List<Double> h6Longs = new ArrayList<Double>();
		h6Longs.add(8.23);
		h6Longs.add(12.42);
	
		List<Integer> h6Naks = new ArrayList<Integer>();
		h6Naks.add(19);
		h6Naks.add(19);
	
		List<Planet> h7Planets = new ArrayList<Planet>();
		h7Planets.add(Planet.JUP);
		h7Planets.add(Planet.SUN);
		h7Planets.add(Planet.RAH);
		
		List<Double> h7Longs = new ArrayList<Double>();
		h7Longs.add(8.23);
		h7Longs.add(12.42);
		h7Longs.add(22.42);
		
		List<Integer> h7Naks = new ArrayList<Integer>();
		h7Naks.add(20);
		h7Naks.add(21);
		h7Naks.add(21);
	
		List<Planet> h12Planets = new ArrayList<Planet>();
		h12Planets.add(Planet.SAT);
		
		List<Double> h12Longs = new ArrayList<Double>();
		h12Longs.add(27.05);
		
		List<Integer> h12Naks = new ArrayList<Integer>();
		h12Naks.add(4);
		
		chartHouseDTOList.add(new ChartHouseDTO(House.H1, new HouseContentDTO(3, h1Planets, h1Naks, h1Longs, 3, Planet.MER)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H2, new HouseContentDTO(4, 1, Planet.MON)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H3, new HouseContentDTO(5, 5, Planet.SUN)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H4, new HouseContentDTO(6, 6, Planet.MER)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H5, new HouseContentDTO(7, h5Planets, h5Naks, h5Longs, 2, Planet.VEN)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H6, new HouseContentDTO(8, h6Planets, h6Naks, h6Longs, 12, Planet.MAR)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H7, new HouseContentDTO(9, h7Planets, h7Naks, h7Longs, 10, Planet.JUP)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H8, new HouseContentDTO(10, 7, Planet.SAT)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H9, new HouseContentDTO(11, 9, Planet.SAT)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H10, new HouseContentDTO(12, 8, Planet.JUP)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H11, new HouseContentDTO(1, 4, Planet.MAR)));
		chartHouseDTOList.add(new ChartHouseDTO(House.H12, new HouseContentDTO(2, h12Planets, h12Naks, h12Longs, 11, Planet.VEN)));
		
		return chartHouseDTOList;
	}
}
