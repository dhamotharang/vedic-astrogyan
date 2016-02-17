package com.vedic.astro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.repository.AnalysisComponentRepository;
import com.vedic.astro.repository.PredictionOutcomeRepository;
import com.vedic.astro.repository.PredictionTemplateRepository;

@Service("analysisComponentService")
@Transactional
public class AnalysisComponentService {

	@Autowired
	@Qualifier("analysisComponentRepository")
	private AnalysisComponentRepository analysisComponentRepository;

	@Autowired
	@Qualifier("predictionTemplateRepository")
	private PredictionTemplateRepository predictionTemplateRepository;
	
	@Autowired
	@Qualifier("predictionOutcomeRepository")
	private PredictionOutcomeRepository predictionOutcomeRepository;
	
}
