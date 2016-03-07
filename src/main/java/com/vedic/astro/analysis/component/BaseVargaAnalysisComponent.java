package com.vedic.astro.analysis.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.MemberAnalysis;
import com.vedic.astro.domain.SubComponentOutcome;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.repository.ComponentRepository;
import com.vedic.astro.repository.MemberAnalysisRepository;
import com.vedic.astro.repository.SubComponentRepository;
import com.vedic.astro.util.RelationshipUtil;
import com.vedic.astro.vo.BirthChartCalcPrep;

public abstract class BaseVargaAnalysisComponent {

	protected String componentCode = null;
	protected boolean enabled = true;

	@Autowired
	@Qualifier("componentRepository")
	private ComponentRepository componentRepository;

	@Autowired
	@Qualifier("subComponentRepository")
	private SubComponentRepository subComponentRepository;

	@Autowired
	@Qualifier("memberAnalysisRepository")
	private MemberAnalysisRepository memberAnalysisRepository;
	
	@Autowired
	@Qualifier("relationshipUtil")
	private RelationshipUtil relationshipUtil;

	public BaseVargaAnalysisComponent(String componentCode) {
		super();
		this.componentCode = componentCode;
		Optional<AnalysisComponent> analysisComponentOpt = componentRepository.findByCode(componentCode);

		if (!analysisComponentOpt.isPresent()) {
			throw new SystemException("Component with this name is not configured", null);
		} else {
			AnalysisComponent analysisComponent = analysisComponentOpt.get();
			this.enabled = analysisComponent.getEnabled();
		}
	}

	@Async
	public VargaBirthChartData analyzeVargaChart(VargaBirthChartData vargaBirthChartData) {

		BirthChartCalcPrep chartPrep = relationshipUtil.prepareVargaChartForCalc(vargaBirthChartData.getChartHouses());
		
		MemberAnalysis memberAnalysis = evaluateCondition(chartPrep);
		if (memberAnalysis != null) {
			this.verifyAnalysis(memberAnalysis);
			memberAnalysisRepository.save(memberAnalysis);
		}
    	return vargaBirthChartData;
	}

	protected abstract MemberAnalysis evaluateCondition(BirthChartCalcPrep chartPrep);

	private void verifyAnalysis(MemberAnalysis memberAnalysis) {
		List<SubComponentOutcome> outcomes = memberAnalysis.getSubcomponentOutcomes();

		for (SubComponentOutcome outcome : outcomes) {
			Optional<List<AnalysisSubComponent>> subComponents = subComponentRepository.findByComponent(componentCode);

			List<String> subComponentCodes = new ArrayList<String>();
			for (AnalysisSubComponent subComponent : subComponents.get()) {
				subComponentCodes.add(subComponent.getCode());
			}

			if (!subComponentCodes.contains(outcome.getSubComponentCode())) {
				throw new SystemException("Subcomponent does not belong to component", null);
			}

			Optional<AnalysisSubComponent> subComponent = subComponentRepository
					.findByCode(outcome.getSubComponentCode());

			if (!subComponent.get().getPredictionOutcomes().contains(outcome.getPredictionOutcomeCode())) {
				throw new SystemException("Outcome does not belong to subcomponent" + outcome.getSubComponentCode(),
						null);
			}
		}
	}
}
