package com.vedic.astro.dto;

import com.vedic.astro.enums.EntityType;

public class EntityProfileAspectDTO extends ProfileAspectDTO {

	private EntityType entityType;
	private EntityType entityName;
	
	public EntityType getEntityType() {
		return entityType;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	public EntityType getEntityName() {
		return entityName;
	}
	public void setEntityName(EntityType entityName) {
		this.entityName = entityName;
	}

	@Override
	public String toString() {
		return "EntityProfileAspectDTO [entityType=" + entityType + ", entityName=" + entityName + "]";
	}
}
