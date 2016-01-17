package com.vedic.astro.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.LocationInfo;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("locationInfoRepository")
public interface LocationInfoRepository extends CrudRepository<LocationInfo, String>{

	@Query(value="{'countryCode' : ?0, 'cityCode':?1}", fields="{_id : 0, locationId : 1}")
	public List<LocationInfo> getLocationByCountryAndCity(String countryCode, String cityCode);
}
