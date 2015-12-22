package com.vedic.astro.util;

import java.util.HashMap;
import java.util.Map;

import com.vedic.astro.enums.House;
import com.vedic.astro.enums.LifeEvent;
import com.vedic.astro.vo.LifeEventConfig;

public class LifeEventRefData {
	
	public static Map<LifeEvent, LifeEventConfig> createLifeEventRefData(){
	
		Map<LifeEvent, LifeEventConfig> lifeEventMap = new HashMap<LifeEvent, LifeEventConfig>();
		
		LifeEventConfig childbirthEventConfig = new LifeEventConfig();
		childbirthEventConfig.addHouseChanged(House.H2);
		childbirthEventConfig.addHouseChanged(House.H5);
		
		lifeEventMap.put(LifeEvent.CHILD_BIRTH, childbirthEventConfig);
		
		return lifeEventMap;
	}
}
