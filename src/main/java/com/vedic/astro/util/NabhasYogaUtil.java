package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.YogaDetails;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.HouseType;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.PlanetNature;
import com.vedic.astro.enums.Yoga;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.enums.ZodiacType;
import com.vedic.astro.vo.BirthChartCalcPrep;

@Component("nabhasYogaUtil")
public class NabhasYogaUtil {

	@Autowired
	@Qualifier("houseUtil")
	private HouseUtil houseUtil;

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	private NabhasYogaUtil() {
	}

	public Yoga findAshrayaYogaPresent(BirthChartCalcPrep birthChartCalcPrep) {

		Yoga yogaPresent = null;

		Map<House, Set<Planet>> houseToPlanetMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();
		Map<Zodiac, House> zodiacToHouseMap = birthChartCalcPrep
				.getZodiacToHouseMapping();
		Map<House, Zodiac> houseToZodiacMap = birthChartCalcPrep
				.getHouseZodiacMapping();

		Zodiac ascZodiac = houseToZodiacMap.get(House.H1);

		Integer movableCount = 0;
		Integer fixedCount = 0;
		Integer dualCount = 0;

		for (Zodiac zodiac : Zodiac.values()) {

			Set<Planet> planets = houseToPlanetMap.get(zodiacToHouseMap
					.get(zodiac));

			if (zodiac.getZodiacType().equals(ZodiacType.Movable)) {
				movableCount = movableCount + planets.size();
			} else if (zodiac.getZodiacType().equals(ZodiacType.Fixed)) {
				fixedCount = fixedCount + planets.size();
			} else if (zodiac.getZodiacType().equals(ZodiacType.Dual)) {
				dualCount = dualCount + planets.size();
			}
		}

		if ((movableCount > fixedCount) && (movableCount > dualCount)
				&& ascZodiac.getZodiacType().equals(ZodiacType.Movable)) {
			yogaPresent = Yoga.Rajju;
		} else if ((fixedCount > movableCount) && (fixedCount > dualCount)
				&& ascZodiac.getZodiacType().equals(ZodiacType.Fixed)) {
			yogaPresent = Yoga.Moosal;
		} else if ((dualCount > fixedCount) && (dualCount > movableCount)
				&& ascZodiac.getZodiacType().equals(ZodiacType.Dual)) {
			yogaPresent = Yoga.Nala;
		}

		System.out.println("movable count = " + movableCount);
		System.out.println("fixed count = " + fixedCount);
		System.out.println("dual count = " + dualCount);
		System.out.println("Asc zodiac = " + ascZodiac.getZodiacType());

		return yogaPresent;
	}

	public Yoga findDalaYogaPresent(BirthChartCalcPrep birthChartCalcPrep) {

		Yoga yogaPresent = null;

		List<Planet> benefics = new ArrayList<Planet>();
		List<Planet> malefics = new ArrayList<Planet>();

		Map<House, Set<Planet>> houseToPlanetMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		for (Planet planet : Planet.values()) {

			if (!planet.equals(Planet.MON) && !planet.equals(Planet.ASC)) {
				if (planetUtil.getPlanetDetails(planet).getNature()
						.equals(PlanetNature.Benefic)) {
					benefics.add(planet);
				} else {
					malefics.add(planet);
				}
			}
		}

		int maleficsCount = malefics.size();
		int beneficsCount = benefics.size();

		System.out.println("benefics= " + benefics);
		System.out.println("malefics = " + malefics);

		for (House house : houseUtil.getHousesOfType(HouseType.Kendra)) {
			Set<Planet> planets = houseToPlanetMap.get(house);
			for (Planet planet : planets) {
				if (planetUtil.getPlanetDetails(planet).getNature()
						.equals(PlanetNature.Benefic)) {
					benefics.remove(planet);
				} else {
					malefics.remove(planet);
				}
			}
		}

		System.out.println("benefics= " + benefics);
		System.out.println("malefics = " + malefics);

		System.out.println("maleficsCount= " + maleficsCount);
		System.out.println("beneficsCount = " + beneficsCount);

		if (benefics.isEmpty() && malefics.size() == maleficsCount) {
			yogaPresent = Yoga.Maala;
		} else if (malefics.isEmpty() && benefics.size() == beneficsCount) {
			yogaPresent = Yoga.Sarpa;
		}

		return yogaPresent;
	}

	public List<Yoga> findAkritiYogaPresent(
			BirthChartCalcPrep birthChartCalcPrep) {

		List<Yoga> yogasPresent = new ArrayList<Yoga>();

		Map<House, Set<Planet>> houseToPlanetMap = birthChartCalcPrep
				.getHouseInhabitantsMapping();

		Set<Planet> h1Planets = houseToPlanetMap.get(House.H1);
		Set<Planet> h4Planets = houseToPlanetMap.get(House.H4);
		Set<Planet> h7Planets = houseToPlanetMap.get(House.H7);
		Set<Planet> h10Planets = houseToPlanetMap.get(House.H10);

		Set<Planet> h2Planets = houseToPlanetMap.get(House.H2);
		Set<Planet> h5Planets = houseToPlanetMap.get(House.H5);
		Set<Planet> h8Planets = houseToPlanetMap.get(House.H8);
		Set<Planet> h11Planets = houseToPlanetMap.get(House.H11);

		Set<Planet> h3Planets = houseToPlanetMap.get(House.H3);
		Set<Planet> h6Planets = houseToPlanetMap.get(House.H6);
		Set<Planet> h9Planets = houseToPlanetMap.get(House.H9);
		Set<Planet> h12Planets = houseToPlanetMap.get(House.H12);

		boolean allH1PlanetsBenefic = true;
		boolean allH7PlanetsBenefic = true;
		boolean allH10PlanetsBenefic = true;
		boolean allH4PlanetsBenefic = true;

		boolean allH1PlanetsMalefic = true;
		boolean allH7PlanetsMalefic = true;
		boolean allH10PlanetsMalefic = true;
		boolean allH4PlanetsMalefic = true;

		for (Planet h1Planet : h1Planets) {
			if (planetUtil.getPlanetDetails(h1Planet).getNature()
					.equals(PlanetNature.Benefic)
					&& !h1Planet.equals(Planet.SUN)) {
				allH1PlanetsMalefic = false;
			} else {
				allH1PlanetsBenefic = false;
			}
		}

		for (Planet h4Planet : h4Planets) {
			if (planetUtil.getPlanetDetails(h4Planet).getNature()
					.equals(PlanetNature.Benefic)
					&& !h4Planet.equals(Planet.SUN)) {
				allH4PlanetsMalefic = false;
			} else {
				allH4PlanetsBenefic = false;
			}
		}

		for (Planet h7Planet : h7Planets) {
			if (planetUtil.getPlanetDetails(h7Planet).getNature()
					.equals(PlanetNature.Benefic)
					&& !h7Planet.equals(Planet.SUN)) {
				allH7PlanetsMalefic = false;
			} else {
				allH7PlanetsBenefic = false;
			}
		}

		for (Planet h10Planet : h10Planets) {
			if (planetUtil.getPlanetDetails(h10Planet).getNature()
					.equals(PlanetNature.Benefic)
					&& !h10Planet.equals(Planet.SUN)) {
				allH10PlanetsMalefic = false;
			} else {
				allH10PlanetsBenefic = false;
			}
		}

		if (h1Planets.size() + h4Planets.size() + h7Planets.size()
				+ h10Planets.size() == 9) {
			yogasPresent.add(Yoga.Kamala);
		}

		if (h1Planets.size() + h4Planets.size() + h7Planets.size()
				+ h10Planets.size() <= 4) {
			yogasPresent.add(Yoga.Vaapi);
		}

		if (h1Planets.size() + h5Planets.size() + h9Planets.size() >= 5) {
			yogasPresent.add(Yoga.Dharma);
		}

		if (h1Planets.size() + h2Planets.size() + h3Planets.size() + h4Planets.size() >= 5) {
			yogasPresent.add(Yoga.Yoopa);
		}
		
		if (h4Planets.size() + h5Planets.size() + h6Planets.size() + h7Planets.size() >= 5) {
			yogasPresent.add(Yoga.Shara);
		}
		if (h7Planets.size() + h8Planets.size() + h9Planets.size() + h10Planets.size() >= 5) {
			yogasPresent.add(Yoga.Shakti);
		}
		if (h10Planets.size() + h11Planets.size() + h12Planets.size() + h1Planets.size() >= 5) {
			yogasPresent.add(Yoga.Danda);
		}
		if (h2Planets.size() + h6Planets.size() + h10Planets.size() >= 5) {
			yogasPresent.add(Yoga.Artha);
		}
		
		if (h3Planets.size() + h7Planets.size() + h11Planets.size() >= 5) {
			yogasPresent.add(Yoga.Kama);
		}
		
		if (h4Planets.size() + h8Planets.size() + h12Planets.size() >= 5) {
			yogasPresent.add(Yoga.Moksha);
		}
		if (allH1PlanetsBenefic && allH7PlanetsBenefic && allH4PlanetsMalefic
				& allH10PlanetsMalefic) {
			yogasPresent.add(Yoga.Vajra);
		}

		if (allH1PlanetsMalefic && allH7PlanetsMalefic && allH4PlanetsBenefic
				& allH10PlanetsBenefic) {
			yogasPresent.add(Yoga.Yava);
		}

		if (h1Planets.size() + h4Planets.size() >= 5) {
			yogasPresent.add(Yoga.Gada);
		}

		if (h4Planets.size() + h7Planets.size() >= 5) {
			yogasPresent.add(Yoga.Shankha);
		}

		if (h7Planets.size() + h10Planets.size() >= 5) {
			yogasPresent.add(Yoga.Vibhuka);
		}

		if (h1Planets.size() + h10Planets.size() >= 5) {
			yogasPresent.add(Yoga.Dhwaja);
		}

		if (h1Planets.size() + h7Planets.size() >= 5) {
			yogasPresent.add(Yoga.Shakata);
		}

		if (h4Planets.size() + h10Planets.size() >= 5) {
			yogasPresent.add(Yoga.Pakshi);
		}

		return yogasPresent;
	}

	public YogaDetails getYogaDetails(Yoga yoga) {
		return BaseYogasRefData.createNabhasYogasRefData().get(yoga);
	}


}
