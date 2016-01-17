package com.vedic.astro.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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
public interface PersonalInfoRepository extends CrudRepository<PersonalInfo, String>{

}
