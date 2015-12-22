package com.vedic.astro.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.vedic.astro.domain.ZodiacDetails;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;
import com.vedic.astro.enums.ZodiacType;
import com.vedic.astro.vo.ZodiacDegRange;
import com.vedic.astro.vo.ZodiacPosition;

@Component("zodiacUtil")
public class ZodiacUtil {

	private ZodiacUtil() {
	}

	public ZodiacDetails getZodiacDetails(Zodiac zodiac) {
		return BaseEntityRefData.createZodiacRefData().getData()
				.get(zodiac.name());

	}

	public Planet getOwnerPlanet(Zodiac zodiac) {
		return getZodiacDetails(zodiac).getRulingPlanet();
	}

	public Zodiac getZodiacAtDistance(Integer count, Zodiac zodiac) {

		int index = -1;
		if (count > 0) {
			index = zodiac.ordinal() + count - 1;
		} else if (count < 0) {
			index = 13 + zodiac.ordinal() + count;
		} else {
			index = zodiac.ordinal();
		}
		if (index >= 12) {
			index = index - 12;
		}
		return Zodiac.values()[index];
	}

	public int getAbsoluteDegrees(Zodiac zodiac, int degrees) {
		int index = zodiac.ordinal() - 1;

		return Zodiac.values()[index].getMaxDegrees() + degrees;
	}

	public int getDifferenceBetween(Zodiac zodiac1, int degrees1,
			Zodiac zodiac2, int degrees2) {

		return Math.abs(getAbsoluteDegrees(zodiac1, degrees1)
				- getAbsoluteDegrees(zodiac2, degrees2));
	}

	public ZodiacPosition calcZodiacPosition(Double absoluteDegrees,
			Map<ZodiacDegRange, Zodiac> zodiacMap) {
		ZodiacPosition zodiacPosition = null;

		Set<Map.Entry<ZodiacDegRange, Zodiac>> mapEntries = zodiacMap
				.entrySet();

		for (Map.Entry<ZodiacDegRange, Zodiac> mapEntry : mapEntries) {
			if ((absoluteDegrees > mapEntry.getKey().getMinDegrees())
					&& (absoluteDegrees <= mapEntry.getKey().getMaxDegrees())) {
				Double diffDeg = absoluteDegrees
						- mapEntry.getKey().getMinDegrees();
				zodiacPosition = new ZodiacPosition(MathUtil.round(diffDeg, 2),
						mapEntry.getValue());
				break;
			}
		}
		return zodiacPosition;
	}

	public Map<ZodiacDegRange, Zodiac> getZodiacDegreesMap() {

		Map<ZodiacDegRange, Zodiac> zodiacMap = new HashMap<ZodiacDegRange, Zodiac>(
				12);
		for (Zodiac zodiac : Zodiac.values()) {

			Double minDeg = (zodiac.getNumber() - 1) * 30.0;
			Double maxDeg = zodiac.getNumber() * 30.0;

			zodiacMap.put(new ZodiacDegRange(minDeg, maxDeg), zodiac);
		}

		return zodiacMap;
	}

	public List<Zodiac> getZodiacsOfType(ZodiacType zodiacType) {
		List<Zodiac> zodiacList = new ArrayList<Zodiac>();
		for (Zodiac zodiac : Zodiac.values()) {
			if (zodiac.getZodiacType().equals(zodiacType)) {
				zodiacList.add(zodiac);
			}
		}
		return zodiacList;
	}

	public List<Zodiac> getAspectingZodiacs(Zodiac zodiac) {

		List<Zodiac> aspectingZodiacs = new ArrayList<Zodiac>();

		if (zodiac.getZodiacType().equals(ZodiacType.Fixed)) {

			aspectingZodiacs.addAll(getZodiacsOfType(ZodiacType.Movable));
			aspectingZodiacs.remove(getZodiacAtDistance(-2, zodiac));

		} else if (zodiac.getZodiacType().equals(ZodiacType.Movable)) {

			aspectingZodiacs.addAll(getZodiacsOfType(ZodiacType.Fixed));
			aspectingZodiacs.remove(getZodiacAtDistance(2, zodiac));

		} else if (zodiac.getZodiacType().equals(ZodiacType.Dual)) {

			aspectingZodiacs.addAll(getZodiacsOfType(ZodiacType.Dual));
			aspectingZodiacs.remove(zodiac);

		}
		return aspectingZodiacs;
	}


	public List<Zodiac> getOwnedZodiacs(Planet planet) {
		Map<Planet, List<Zodiac>> planetToZodiacOwnerMap = new HashMap<Planet, List<Zodiac>>();

		for (Zodiac zodiac : Zodiac.values()) {

			Planet rulingPlanet = getZodiacDetails(zodiac).getRulingPlanet();
			List<Zodiac> zodiacs = planetToZodiacOwnerMap.get(rulingPlanet);
			if (zodiacs == null) {
				zodiacs = new ArrayList<Zodiac>(2);
			}
			zodiacs.add(zodiac);
			planetToZodiacOwnerMap.put(rulingPlanet, zodiacs);
		}

		return planetToZodiacOwnerMap.get(planet);
	}
	
	public Map<Zodiac, Double> calcZodiacStrengthsBasedOnType(){
		Map<Zodiac, Double> zodiacStrengthMap = new HashMap<Zodiac, Double>();
		
		for(Zodiac zodiac : Zodiac.values()){
			zodiacStrengthMap.put(zodiac, zodiac.getZodiacType().getScore());
		}
		return zodiacStrengthMap;
	}
	
	public int distanceBetween(Zodiac fromZodiac, Zodiac toZodiac){
		int distance = 1;
		if(toZodiac.getNumber()>=fromZodiac.getNumber()){
			distance = toZodiac.getNumber() - fromZodiac.getNumber() + 1;
		}
		else {
			distance = (toZodiac.getNumber()+12) - fromZodiac.getNumber() + 1;
		}
		return distance;
	}
	
	public Planet getSecondaryLord(Zodiac zodiac){
		return BaseEntityRelationshipRefData.getSecondaryLords().get(zodiac);
	}
}
