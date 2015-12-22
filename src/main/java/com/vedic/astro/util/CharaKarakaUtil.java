package com.vedic.astro.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;

@Component("charaKarakaUtil")
public class CharaKarakaUtil {

	private CharaKarakaUtil() {
	}

	public List<House> getImpactedHouses(CharaKaraka charaKaraka) {
		List<House> impactedHouses = BaseEntityRefData
				.getCharaKarakaHouseMapping().get(charaKaraka);
		return impactedHouses;
	}

	public CharaKaraka getCharaKarakaForHouse(House house) {
		CharaKaraka charaKaraka = null;

		Map<CharaKaraka, List<House>> charaKarakaMap = BaseEntityRefData
				.getCharaKarakaHouseMapping();
		Set<Map.Entry<CharaKaraka, List<House>>> mapEntries = charaKarakaMap
				.entrySet();

		for (Map.Entry<CharaKaraka, List<House>> mapEntry : mapEntries) {
			List<House> karakaHouses = mapEntry.getValue();
			if (karakaHouses.contains(house)) {
				charaKaraka = mapEntry.getKey();
			}
		}
		return charaKaraka;
	}
}
