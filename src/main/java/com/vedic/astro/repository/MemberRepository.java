package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.Member;
import com.vedic.astro.enums.MemberType;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("memberRepository")
public interface MemberRepository extends CrudRepository<Member, String>{
	
	@Query(value="{'createdById' : ?0}")
	public Optional<List<Member>> findByAdminId(String createdById);

	@Query(value="{'createdById' : ?0 , 'memberType' : ?1}")
	public Optional<List<Member>> findByAdminIdAndMemberType(String createdById, MemberType memberType);

	@Query(value="{'createdById' : ?0 , 'memberType' : {$ne : ?1}}")
	public Optional<List<Member>> findByAdminIdNotMemberType(String createdById, MemberType memberType);

}
