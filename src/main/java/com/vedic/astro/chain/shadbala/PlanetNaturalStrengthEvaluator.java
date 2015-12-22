package com.vedic.astro.chain.shadbala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vedic.astro.enums.Planet;
import com.vedic.astro.util.PlanetUtil;

@Component("planetNaturalStrengthEvaluator")
public class PlanetNaturalStrengthEvaluator implements Command {

	@Autowired
	@Qualifier("planetUtil")
	private PlanetUtil planetUtil;

	@Override
	public boolean execute(Context context) throws Exception {

		Map<Planet, Double> planetStrengths = new HashMap<Planet, Double>(7);

		for(Planet planet : planetUtil.getPlanetsForConsideration(false)){
		planetStrengths.put(planet, 
				planetUtil.getPlanetDetails(planet).getLuminosity());
		}
		System.out.println("natural strength = " + planetStrengths);

		return false;
	}
}

