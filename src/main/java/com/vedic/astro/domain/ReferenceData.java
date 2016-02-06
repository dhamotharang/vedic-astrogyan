package com.vedic.astro.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.dto.ReferenceDataDTO;

@Document(collection="general")
@TypeAlias("reference_data")
public class ReferenceData {
	
	@Id
	private String id = null;
	
	/**
	 * Name of the data.
	 */
	private String name = null;
	
	/**
	 * List of reference data.
	 */
	private List<ReferenceDataDTO> data = new ArrayList<ReferenceDataDTO>();

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

	public List<ReferenceDataDTO> getData() {
		return data;
	}

	public void setData(List<ReferenceDataDTO> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ReferenceData [id=" + id + ", name=" + name + ", data=" + data + "]";
	}
}
