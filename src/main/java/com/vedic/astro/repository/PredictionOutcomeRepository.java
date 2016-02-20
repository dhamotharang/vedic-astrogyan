package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.PredictionOutcome;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("predictionOutcomeRepository")
public interface PredictionOutcomeRepository extends CrudRepository<PredictionOutcome, String>{

	@Query(value="{'templateCode' : ?0}")
	public Optional<List<PredictionOutcome>> getOutcomesForTemplate(String templateCode);

	@Query(value="{'code' : ?0}")
	public Optional<PredictionOutcome> findByCode(String code);

}
