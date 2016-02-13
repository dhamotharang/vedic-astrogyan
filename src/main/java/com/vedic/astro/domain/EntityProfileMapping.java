package com.vedic.astro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vedic.astro.enums.EntityType;
@Document(collection="entity_profile_mapping")
public class EntityProfileMapping {
	
	@Id
	private String id = null;
	private String aspectCode = null;
	private EntityType entityType = null;
	private String entityName = null;

	public EntityProfileMapping() {
	}
	
	public EntityProfileMapping(String aspectCode, EntityType entityType, String entityName) {
		this.aspectCode = aspectCode;
		this.entityType = entityType;
		this.entityName = entityName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAspectCode() {
		return aspectCode;
	}
	public void setAspectCode(String aspectCode) {
		this.aspectCode = aspectCode;
	}
	public EntityType getEntityType() {
		return entityType;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public String toString() {
		return "EntityAspectObservation [id=" + id + ", aspectCode=" + aspectCode + ", entityType=" + entityType
				+ ", entityName=" + entityName + "]";
	}
}