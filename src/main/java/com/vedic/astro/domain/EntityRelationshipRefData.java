package com.vedic.astro.domain;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.vedic.astro.enums.EntityRelationshipType;
import com.vedic.astro.enums.EntityType;

public class EntityRelationshipRefData {

	private EntityRelationshipType entityRelationshipType = null;

	private Map<String, Map<String, EntityRelationshipValue>> data = null;

	public EntityRelationshipType getEntityRelationshipType() {
		return entityRelationshipType;
	}

	public void setEntityRelationshipType(
			EntityRelationshipType entityRelationshipType) {
		this.entityRelationshipType = entityRelationshipType;
	}

	public Map<String, Map<String, EntityRelationshipValue>> getData() {
		return data;
	}

	public void setData(Map<String, Map<String, EntityRelationshipValue>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "EntityRelationshipRefData [entityRelationshipType="
				+ entityRelationshipType + ", data=" + data + "]";
	}
}
