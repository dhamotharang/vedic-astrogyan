package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.AnalysisSubComponent;
import com.vedic.astro.enums.AnalysisGroup;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("subComponentRepository")
public interface SubComponentRepository extends CrudRepository<AnalysisSubComponent, String>{

	@Query(value="{'predictionTemplateCode' : ?0}")
	public Optional<AnalysisSubComponent> findByTemplate(String predictionTemplateCode);

	@Query(value="{'code' : ?0}")
	public Optional<AnalysisSubComponent> findByCode(String code);

	@Query(value="{'componentCode' : ?0}")
	public Optional<List<AnalysisSubComponent>> findByComponent(String componentCode);

}
