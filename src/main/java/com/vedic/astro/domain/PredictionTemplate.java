package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="prediction_templates")
@TypeAlias("prediction_template")
public class PredictionTemplate {

	@Id
	private String id = null;
	private String name = null;
	private String code = null;
	private List<String> aspectCodes = new ArrayList<String>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getAspectCodes() {
		return aspectCodes;
	}
	public void setAspectCodes(List<String> aspectCodes) {
		this.aspectCodes = aspectCodes;
	}
	@Override
	public String toString() {
		return "PredictionTemplate [id=" + id + ", name=" + name + ", code=" + code + ", aspectCodes=" + aspectCodes
				+ "]";
	}
}
