package com.vedic.astro.util;

import org.springframework.stereotype.Component;

import com.vedic.astro.enums.LifeEvent;
import com.vedic.astro.vo.LifeEventConfig;

@Component("lifeEventUtil")
public class LifeEventUtil {

	private LifeEventUtil() {
	}

	public static LifeEventConfig getLifeEventConfig(LifeEvent lifeEvent) {
		return LifeEventRefData.createLifeEventRefData().get(lifeEvent);
	}
}
