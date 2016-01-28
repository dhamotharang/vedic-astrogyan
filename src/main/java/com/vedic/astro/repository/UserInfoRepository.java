package com.vedic.astro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vedic.astro.domain.UserInfo;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("userInfoRepository")
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{

	@Query(value="{'email' : ?0, 'password':?1}", fields="{_id : 0, firstName : 1, lastName : 2, role : 3}")
	public Optional<List<UserInfo>> getUserInfoByEmailAndPwd(String email, String password);
	
	@Query(value="{'email' : ?0}", fields="{_id : 0}")
	public Optional<List<UserInfo>> checkUserExists(String email);

}
