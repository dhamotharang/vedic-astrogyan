package com.vedic.astro.repository;

import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.VargaBirthChartData;
import com.vedic.astro.enums.BirthChartType;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("vargaChartRepository")
public interface VargaChartRepository extends CrudRepository<VargaBirthChartData, String>{

	@Query(value="{'pid' : ?0, 'birthChartType': ?1}")
	public Optional<VargaBirthChartData> findByPidAndChartType(String pid, BirthChartType birthChartType);

}
