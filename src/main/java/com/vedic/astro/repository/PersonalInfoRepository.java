package com.vedic.astro.repository;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
@Repository("personalInfoRepository")
@Transactional
public class PersonalInfoRepository {


	@Value("${mongo.collection.personal_info}")
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
	public String add(PersonalInfo personalInfo) {

		String pid = null;
		try {
             
			pid = UUID.randomUUID().toString();
			personalInfo.setPid(pid);
			// Insert to db
			mongoTemplate.insert(personalInfo, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return pid;
	}
	
	public PersonalInfo findBy(String pid) {

		PersonalInfo personalInfo = null;
		try {
             
			Query query = new Query(Criteria.where("pid").is(pid));

			// Execute the query and find one matching entry
			 personalInfo = mongoTemplate.findOne(query, PersonalInfo.class,
					getRepositoryName());
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return personalInfo;
	}
	
	protected String getRepositoryName(){
		return COLLECTION_NAME;
	}
	
}
