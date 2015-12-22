package com.vedic.astro.domain;

import java.util.Map;

import com.vedic.astro.enums.EntityType;

public class EntityRefData<T> {

	private EntityType entityType = null;

	private Map<String, T> data = null;
	
	public Map<String, T> getData() {
		return data;
	}

	public void setData(Map<String, T> data) {
		this.data = data;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	@Override
	public String toString() {
		return "EntityRefData [entityType=" + entityType + ", data=" + data
				+ "]";
	}
}
