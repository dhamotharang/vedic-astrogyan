package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;

@Document(collection = "member_analysis")
@TypeAlias("member_analysis")
public class MemberAnalysis {

	@Id
	private String id = null;
	private String memberId = null;
	private AnalysisGroup analysisGroup = null;
	private PredictionSystem predictionSystem = null;
	private String componentCode = null;
	private List<SubComponentOutcome> subcomponentOutcomes = new ArrayList<SubComponentOutcome>();
	private Date executedOn = new Date();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public AnalysisGroup getAnalysisGroup() {
		return analysisGroup;
	}
	public void setAnalysisGroup(AnalysisGroup analysisGroup) {
		this.analysisGroup = analysisGroup;
	}
	public String getComponentCode() {
		return componentCode;
	}
	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}
	public Date getExecutedOn() {
		return executedOn;
	}
	public void setExecutedOn(Date executedOn) {
		this.executedOn = executedOn;
	}
	public PredictionSystem getPredictionSystem() {
		return predictionSystem;
	}
	public void setPredictionSystem(PredictionSystem predictionSystem) {
		this.predictionSystem = predictionSystem;
	}
	public List<SubComponentOutcome> getSubcomponentOutcomes() {
		return subcomponentOutcomes;
	}
	public void setSubcomponentOutcomes(List<SubComponentOutcome> subcomponentOutcomes) {
		this.subcomponentOutcomes = subcomponentOutcomes;
	}
	@Override
	public String toString() {
		return "MemberAnalysis [id=" + id + ", memberId=" + memberId + ", analysisGroup=" + analysisGroup
				+ ", predictionSystem=" + predictionSystem + ", componentCode=" + componentCode
				+ ", subcomponentOutcomes=" + subcomponentOutcomes + ", executedOn=" + executedOn + "]";
	}
}
