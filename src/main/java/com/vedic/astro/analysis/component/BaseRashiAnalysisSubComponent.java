package com.vedic.astro.analysis.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.domain.SubComponentOutcome;
import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.repository.ComponentRepository;
import com.vedic.astro.repository.SubComponentRepository;

public abstract class BaseRashiAnalysisSubComponent {

	protected String subComponentCode = null;
	protected List<String> outcomeCodes = new ArrayList<String>();

	@Autowired
	@Qualifier("componentRepository")
	private ComponentRepository componentRepository;

	@Autowired
	@Qualifier("subComponentRepository")
	private SubComponentRepository subComponentRepository;

	public BaseRashiAnalysisSubComponent(String componentCode, String subComponentCode) {
		super();
		this.subComponentCode = subComponentCode;
		Optional<AnalysisComponent> analysisComponentOpt = componentRepository.findByCode(componentCode);

		if (!analysisComponentOpt.isPresent()) {
			throw new SystemException("Component with this name is not configured", null);
		} else {
			AnalysisComponent analysisComponent = analysisComponentOpt.get();
			if (analysisComponent.getEnabled()) {
				Optional<List<AnalysisSubComponent>> subComponents = subComponentRepository
						.findByComponent(componentCode);

				List<String> subComponentCodes = new ArrayList<String>();
				for (AnalysisSubComponent subComponent : subComponents.get()) {
					subComponentCodes.add(subComponent.getCode());
				}

				if (!subComponentCodes.contains(subComponentCode)) {
					throw new SystemException("Subcomponent does not belong to component", null);
				}

				Optional<AnalysisSubComponent> subComponent = subComponentRepository.findByCode(subComponentCode);

				this.outcomeCodes = subComponent.get().getPredictionOutcomes();

			} else {
				throw new SystemException("Component with this name is not enabled", null);
			}
		}
	}

	public SubComponentOutcome evaluateOutcome(BirthChartData birthChartData) {
		SubComponentOutcome outcome = getOutcome(birthChartData);
		if (outcome != null) {
			if (!this.validOutcome(outcome)) {
				throw new SystemException("Outcome does not belong to subcomponent", null);
			}
		}
		return outcome;
	}

	protected abstract SubComponentOutcome getOutcome(BirthChartData birthChartData);

	private boolean validOutcome(SubComponentOutcome subComponentOutcome) {
		return outcomeCodes.contains(subComponentOutcome.getPredictionOutcomeCode());
	}

}
