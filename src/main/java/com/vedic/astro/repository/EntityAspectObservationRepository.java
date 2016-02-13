package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.EntityProfileMapping;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("entityAspectObservationRepository")
public interface EntityAspectObservationRepository extends CrudRepository<EntityProfileMapping, String>{

	@Query(value="{'aspectCode' : ?0, 'entityType':?1, 'entityName':?2}")
	public Optional<EntityProfileMapping> getAllMappedEntities(String aspectCode, String entityType, String entityName);

	@Query(value="{'aspectCode' : ?0}")
	public Optional<List<EntityProfileMapping>> getAllMappedEntities(String aspectCode);

}
