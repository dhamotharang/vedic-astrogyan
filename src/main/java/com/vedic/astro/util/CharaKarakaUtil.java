package com.vedic.astro.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.vedic.astro.enums.CharaKaraka;
import com.vedic.astro.enums.House;

@Component("charaKarakaUtil")
public class CharaKarakaUtil {

	private static Map<CharaKaraka,List<House>> charaKarakaHouseMapping = 
			BaseEntityRefData.getCharaKarakaHouseMapping();
	
	private CharaKarakaUtil() {
	}
	

	public List<House> getImpactedHouses(CharaKaraka charaKaraka) {
		List<House> impactedHouses = charaKarakaHouseMapping.get(charaKaraka);
		return impactedHouses;
	}

	public CharaKaraka getCharaKarakaForHouse(House house) {
		CharaKaraka charaKaraka = null;

		Set<Map.Entry<CharaKaraka, List<House>>> mapEntries = charaKarakaHouseMapping
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
