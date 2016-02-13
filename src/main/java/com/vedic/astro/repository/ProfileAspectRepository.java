package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.ProfileAspect;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("profileAspectRepository")
public interface ProfileAspectRepository extends CrudRepository<ProfileAspect, String>{

	@Query(value="{'parentCode' : {$exists:false}}")
	public Optional<List<ProfileAspect>> getAllParents();

	@Query(value="{'parentCode' : ?0}")
	public Optional<List<ProfileAspect>> getImmediateChildren(String parentCode);

}
