package com.vedic.astro.repository;

import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.ReferenceData;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("referenceDataRepository")
public interface ReferenceDataRepository extends CrudRepository<ReferenceData, String>{

	@Query(value="{'name' : ?0}")
	public Optional<ReferenceData> getReferenceData(String name);
	
}
