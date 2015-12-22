package com.vedic.astro.repository;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vedic.astro.domain.BirthChartData;
import com.vedic.astro.enums.BirthChartType;
import com.vedic.astro.exception.SystemException;
import com.vedic.astro.vo.PersonalInfo;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("birthChartRepository")
@Transactional
public class BirthChartRepository {


	@Value("${mongo.collection.birth_charts}")
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
	public void add(BirthChartData birthChartData) {

		
		try {
             
			mongoTemplate.insert(birthChartData, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}
	
	public BirthChartData findBy(String pid, BirthChartType birthChartType) {

		BirthChartData birthChartData = null;
		try {
             
			Query query = new Query(Criteria.where("pid").is(pid));
			
			if(birthChartType!=null){
				query.addCriteria(Criteria.where("birthChartType").is(birthChartType.name()));
			}

			// Execute the query and find one matching entry
			birthChartData = mongoTemplate.findOne(query, BirthChartData.class,
					getRepositoryName());
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return birthChartData;
	}
	
	protected String getRepositoryName(){
		return COLLECTION_NAME;
	}
	
}
