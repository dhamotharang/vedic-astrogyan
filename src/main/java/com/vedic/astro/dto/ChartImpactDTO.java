package com.vedic.astro.dto;

public class ChartImpactDTO {
	
	private String entityType = null;
	private String name = null;
	private String source = null;
	private String impact = null;

	public ChartImpactDTO(String entityType, String name, String source, String impact) {
		super();
		this.entityType = entityType;
		this.name = name;
		this.source = source;
		this.impact = impact;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	@Override
	public String toString() {
		return "ChartProfileDTO [entityType=" + entityType + ", name=" + name + ", source=" + source + ", impact="
				+ impact + "]";
	}
}
