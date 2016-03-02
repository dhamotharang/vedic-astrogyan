package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.MemberAnalysis;
import com.vedic.astro.enums.AnalysisGroup;
import com.vedic.astro.enums.PredictionSystem;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("memberAnalysisRepository")
public interface MemberAnalysisRepository extends CrudRepository<MemberAnalysis, String>{

	@Query(value="{'predictionSystem' : ?0 , 'analysisGroup' : ?1, 'memberId' : ?2}")
	public Optional<List<MemberAnalysis>> findByAnalysisGroupAndPredictionSystem(
			PredictionSystem predictionSystem,	AnalysisGroup analysisGroup, String memberId);

	@Query(value="{'subcomponentOutcomes.predictionOutcomeCode' : {$in : ?0}}")
	public Optional<List<MemberAnalysis>> findByPredictionOutcomes(
			List<String> predictionOutcomeCodes);
}
