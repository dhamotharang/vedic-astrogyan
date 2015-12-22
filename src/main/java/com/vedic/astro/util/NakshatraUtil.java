package com.vedic.astro.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.domain.ZodiacDegreeRange;
import com.vedic.astro.enums.Dasha;
import com.vedic.astro.enums.House;
import com.vedic.astro.enums.Nakshatra;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.enums.Zodiac;

@Component("nakshatraUtil")
public class NakshatraUtil extends BaseEntityRefData {

	@Autowired
	@Qualifier("zodiacUtil")
	private ZodiacUtil zodiacUtil;

	public Nakshatra getNakshatra(Zodiac zodiac, Double degs) {

		Map<Zodiac, Map<ZodiacDegreeRange, Nakshatra>> zodiacNaksMap = createNakshatraRefData();
		Map<ZodiacDegreeRange, Nakshatra> zodiacNakMap = zodiacNaksMap
				.get(zodiac);

		Nakshatra nak = null;

		for (Map.Entry<ZodiacDegreeRange, Nakshatra> entry : zodiacNakMap
				.entrySet()) {

			if (entry.getKey().isBetween(degs)) {
				nak = entry.getValue();
				break;
			}
		}

		return nak;
	}

	public Planet getNakshatraLord(Nakshatra nakshatra) {
		return createNakshatraLordsRefData().getData().get(nakshatra.name());
	}

	public Planet getNakshatraSubLord(Zodiac zodiac, Double degs) {
		Map<Zodiac, Map<ZodiacDegreeRange, Zodiac>> zodiacNaksMap = createNakshatraSubLordsRefData();
		Map<ZodiacDegreeRange, Zodiac> zodiacNakSublordMap = zodiacNaksMap
				.get(zodiac);

		Zodiac zod = null;
		Planet subLord = null;
		for (Map.Entry<ZodiacDegreeRange, Zodiac> entry : zodiacNakSublordMap
				.entrySet()) {

			if (entry.getKey().isBetween(degs)) {
				zod = entry.getValue();
				break;
			}
		}

		if (zod != null) {
			subLord = zodiacUtil.getOwnerPlanet(zod);
		}

		return subLord;

	}

	public Nakshatra getNakshatraAtDistance(Integer count, Nakshatra nakshatra) {

		if (count == 0) {
			return nakshatra;
		}

		int index = nakshatra.ordinal() + count - 1;

		if (index >= 27) {
			index = index - 27;
		}
		return Nakshatra.values()[index];
	}

	public int distanceBetween(Nakshatra fromNakshatra, Nakshatra toNakshatra) {
		int distance = 1;
		if (toNakshatra.getValue() >= fromNakshatra.getValue()) {
			distance = toNakshatra.getValue() - fromNakshatra.getValue() + 1;
		} else {
			distance = (toNakshatra.getValue() + 27) - fromNakshatra.getValue()
					+ 1;
		}
		return distance;
	}

}
