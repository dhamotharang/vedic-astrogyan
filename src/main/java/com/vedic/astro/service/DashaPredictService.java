package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.DashaPlanetRelationship;
import com.vedic.astro.domain.DashaSnapshotPrediction;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.repository.BirthChartRepository;
import com.vedic.astro.repository.DashaInfoRepository;
import com.vedic.astro.util.AshtakvargaChartUtil;
import com.vedic.astro.util.BirthChartUtil;
import com.vedic.astro.util.VimshotriDashaUtil;
import com.vedic.astro.util.LifeEventUtil;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.AbsolutePlanetaryPositions;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Service("dashaPredictService")
@Transactional
public class DashaPredictService {

	@Autowired
	@Qualifier("dashaInfoRepository")
	private DashaInfoRepository dashaInfoRepository;

	@Autowired
	@Qualifier("birthChartRepository")
	private BirthChartRepository birthChartRepository;

	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	@Autowired
	@Qualifier("vimshotriDashaUtil")
	private VimshotriDashaUtil vimshotriDashaUtil;

	@Autowired
	@Qualifier("birthChartUtil")
	private BirthChartUtil birthChartUtil;

	@Autowired
	@Qualifier("lifeEventUtil")
	private LifeEventUtil lifeEventUtil;

	@Autowired
	@Qualifier("ashtakvargaChartUtil")
	private AshtakvargaChartUtil ashtakvargaChartUtil;

	@Autowired
	@Qualifier("planetPositionsDataService")
	private PlanetPositionsDataService planetPositionsDataService;


	public DashaSnapshotPrediction predictDashaPeriod(String pid,
			Planet mainDashaPlanet, Planet antardashaPlanet,
			Planet interPeriodPlanet) {

		DashaSnapshotPrediction dashaSnapshotPrediction = 
				new DashaSnapshotPrediction();

		BirthChartCalcPrep birthChartCalcPrep = prepareBirthChartCalcPrep();
		System.out.println("birthChartCalcPrep = " + birthChartCalcPrep);
		
		DashaPlanetRelationship dashaPlanetRelationship = 
				vimshotriDashaUtil.getDashaPlanetRelationships(
						mainDashaPlanet, birthChartCalcPrep);
		
		System.out.println("dasha planet relationships = " + 
				dashaPlanetRelationship);

		System.out.println("dasha planet impacted houses = " + 
				dashaPlanetRelationship.getMostImpactedHouses());
		
		System.out.println("dasha planet significations = " + 
				vimshotriDashaUtil.predictDasha(Planet.SAT, birthChartCalcPrep));


		return dashaSnapshotPrediction;
	}

	private BirthChartCalcPrep prepareBirthChartCalcPrep() {

		AbsolutePlanetaryPositions absolutePlanetaryPositions = 
				planetPositionsDataService
				.getPlanetPositionsData("20/12/1972", "17:10:00", 10304);
		System.out.println("absolutePlanetaryPositions ="
				+ absolutePlanetaryPositions);

		BirthChartData d1Chart = birthChartUtil
				.generateD1Chart(absolutePlanetaryPositions);
		System.out.println("d1chart = " + d1Chart);
		BirthChartCalcPrep birthChartCalcPrep = relationshipUtil
				.preparePlanetsForCalc(d1Chart.getChartHouses());
		return birthChartCalcPrep;
	}
}