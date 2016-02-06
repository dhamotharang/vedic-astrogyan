package com.vedic.astro.repository;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.Member;
import com.vedic.astro.domain.PlanetTransitData;
import com.vedic.astro.enums.Planet;
import com.vedic.astro.exception.SystemException;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("transitInfoRepository")
@Transactional
public class TransitInfoRepository {


	@Value("${mongo.collection.transit_info}")
	public String COLLECTION_NAME;

	/**
	 * The mongoTemplate is injected.
	 */
	@Resource(name = "mongoTemplate")
	private MongoTemplate mongoTemplate;

	/**
	 * Creates a new token and adds to the collection.
	 * @param <T>
	 * 
	 * @param token Token of the User
	 * @return tokenId of the user
	 */
	public void add(List<PlanetTransitData> transitList) {
		try {
		
			mongoTemplate.insert(transitList, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}
	
	public PlanetTransitData findBy(Date date, Planet planet) {

		PlanetTransitData planetTransitData;		
		try {
			Query query = new Query(Criteria.where("planet").is(planet.name()));
			query.addCriteria(Criteria.where("startDate").lt(date).and("endDate").gte(date));

			// Execute the query and find one matching entry
			planetTransitData = mongoTemplate.findOne(query, PlanetTransitData.class,
					getRepositoryName());
			
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return planetTransitData;
	}

	protected String getRepositoryName(){
		return COLLECTION_NAME;
	}
}
