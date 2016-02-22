package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.AnalysisComponent;
import com.vedic.astro.enums.AnalysisGroup;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("analysisComponentRepository")
public interface AnalysisComponentRepository extends CrudRepository<AnalysisComponent, String>{

	@Query(value="{'predictionTemplateCode' : ?0}")
	public Optional<AnalysisComponent> findByTemplate(String predictionTemplateCode);

	@Query(value="{'code' : ?0}")
	public Optional<AnalysisComponent> findByCode(String code);

	@Query(value="{'analysisGroup' : ?0}")
	public Optional<List<AnalysisComponent>> findBySource(AnalysisGroup analysisGroup);

}
