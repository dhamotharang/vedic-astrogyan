package com.vedic.astro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.dto.RashiChartHouseDTO;
import com.vedic.astro.dto.RashiHouseContentDTO;
import com.vedic.astro.dto.VargaChartHouseDTO;
import com.vedic.astro.dto.VargaHouseContentDTO;
import com.vedic.astro.enums.Arudha;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.VargaChartRepository;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Service("chartService")
public class ChartService {

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;
	
	@Autowired
	@Qualifier("vargaChartRepository")
	private VargaChartRepository vargaChartRepository;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	
	public List<RashiChartHouseDTO> getRashiChart(String memberId) {

		List<RashiChartHouseDTO> chartHouseDTOList = new ArrayList<RashiChartHouseDTO>();

		BirthChartData birthChartData = null;
		Optional<BirthChartData> birthChartDataOpt = birthChartRepository.findByPid(memberId);

		if (birthChartDataOpt.isPresent()) {
			birthChartData = birthChartDataOpt.get();
			BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
					.preparePlanetsForCalc(birthChartData.getChartHouses());

			Map<House, Arudha> houseToArudhaMap = relationshipUtil.prepareArudhas(birthChartCalcPrep);
			for (House house : House.values()) {

				List<Planet> planets = new ArrayList<Planet>();
				List<Double> longs = new ArrayList<Double>();
				List<Integer> naks = new ArrayList<Integer>();

				Set<Planet> inhabitants = birthChartCalcPrep.getHouseInhabitantsMapping().get(house);
				if (!inhabitants.isEmpty()) {
					for (Planet inhabitant : inhabitants) {
						planets.add(inhabitant);
						longs.add(birthChartCalcPrep.getPlanetAgeMapping().get(inhabitant));
						naks.add(birthChartCalcPrep.getPlanetNakshatrasMapping().get(inhabitant).getValue());
					}
				}
				
				Zodiac zodiac = birthChartCalcPrep.getHouseZodiacMapping().get(house);
				Planet lord = birthChartCalcPrep.getHouseOwnerMapping().get(house);
				Arudha arudha = houseToArudhaMap.get(house);
				
				int arudhaNumber = -1;
				if(arudha!=null){
					arudhaNumber = arudha.getValue();
				}
				
				chartHouseDTOList
				.add(new RashiChartHouseDTO(house, new RashiHouseContentDTO(zodiac.getNumber(), planets, naks, longs, arudhaNumber, lord)));
		
			}
		}
		return chartHouseDTOList;
	}

	public List<VargaChartHouseDTO> getVargaChart(BirthChartType chartType, String memberId) {

		List<VargaChartHouseDTO> chartHouseDTOList = new ArrayList<VargaChartHouseDTO>();

		VargaBirthChartData vargaBirthChartData = null;
		Optional<VargaBirthChartData> vargaChartDataOpt = vargaChartRepository.findByPidAndChartType(memberId, chartType);

		if (vargaChartDataOpt.isPresent()) {
			vargaBirthChartData = vargaChartDataOpt.get();
			BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
					.prepareVargaChartForCalc(vargaBirthChartData.getChartHouses());

			for (House house : House.values()) {

				List<Planet> planets = new ArrayList<Planet>();

				Set<Planet> inhabitants = birthChartCalcPrep.getHouseInhabitantsMapping().get(house);
				if (!inhabitants.isEmpty()) {
					for (Planet inhabitant : inhabitants) {
						planets.add(inhabitant);
					}
				}
				
				Zodiac zodiac = birthChartCalcPrep.getHouseZodiacMapping().get(house);
				Planet lord = birthChartCalcPrep.getHouseOwnerMapping().get(house);
				
				chartHouseDTOList
				.add(new VargaChartHouseDTO(house, new VargaHouseContentDTO(zodiac.getNumber(), planets, lord)));
		
			}
		}
		return chartHouseDTOList;
	}
}
