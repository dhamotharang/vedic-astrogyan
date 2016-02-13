package com.vedic.astro.dto;

import com.vedic.astro.enums.EntityType;

public class EntityAspectMappingDTO {

	private String aspectCode = null;
	private EntityType entityType = null;
	private String entityName = null;
	
	public EntityAspectMappingDTO() {
	}
	public EntityAspectMappingDTO(String aspectCode, EntityType entityType, String entityName) {
		this.aspectCode = aspectCode;
		this.entityType = entityType;
		this.entityName = entityName;
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
		return "EntityAspectMappingDTO [aspectCode=" + aspectCode + ", entityType=" + entityType + ", entityName="
				+ entityName + "]";
	}
}
