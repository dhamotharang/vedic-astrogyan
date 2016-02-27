package com.vedic.astro.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("transitInfoRepository")
public interface TransitInfoRepository extends CrudRepository<PlanetTransitData, String>{

	@Query("{'startDate' : {$lt : ?0},'endDate' : {$gte : ?0}, 'planet' : ?1}")
	public Optional<PlanetTransitData> findByDateAndPlanet(Date date, Planet planet);
	
	@Query("{'planet' : ?0,'sequence' : {$gte : ?1, $lte : ?2}}")
	public Optional<List<PlanetTransitData>> findByPlanetAndSequence(Planet planet, int fromSeq, int toSeq);

}
