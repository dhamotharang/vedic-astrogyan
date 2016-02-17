package com.vedic.astro.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.AnalysisGroup;

@Document(collection = "member_analysis")
@TypeAlias("member_analysis")
public class MemberAnalysis {

	@Id
	private String id = null;
	private String pid = null;
	private AnalysisGroup analysisGroup = null; 
	private String componentCode = null;
	private String predictionTemplateCode = null;
	private String predictionOutcomeCode = null;
	private Date executedOn = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getPredictionTemplateCode() {
		return predictionTemplateCode;
	}
	public void setPredictionTemplateCode(String predictionTemplateCode) {
		this.predictionTemplateCode = predictionTemplateCode;
	}
	public String getPredictionOutcomeCode() {
		return predictionOutcomeCode;
	}
	public void setPredictionOutcomeCode(String predictionOutcomeCode) {
		this.predictionOutcomeCode = predictionOutcomeCode;
	}
	public Date getExecutedOn() {
		return executedOn;
	}
	public void setExecutedOn(Date executedOn) {
		this.executedOn = executedOn;
	}
	@Override
	public String toString() {
		return "MemberAnalysis [id=" + id + ", pid=" + pid + ", analysisGroup=" + analysisGroup + ", componentCode="
				+ componentCode + ", predictionTemplateCode=" + predictionTemplateCode + ", predictionOutcomeCode="
				+ predictionOutcomeCode + ", executedOn=" + executedOn + "]";
	}
}
