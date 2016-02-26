package com.vedic.astro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.AnalysisGroup;

@Document(collection = "component_groups")
@TypeAlias("component_group")
public class ComponentGroup {

	@Id
	private String id = null;
	private AnalysisGroup parentCode = null; 
	private String code = null;
	private String name = null;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AnalysisGroup getParentCode() {
		return parentCode;
	}
	public void setParentCode(AnalysisGroup parentCode) {
		this.parentCode = parentCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ComponentGroup [id=" + id + ", parentCode=" + parentCode + ", code=" + code + ", name=" + name + "]";
	}
}
