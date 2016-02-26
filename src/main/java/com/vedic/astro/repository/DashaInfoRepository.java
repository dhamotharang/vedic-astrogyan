package com.vedic.astro.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.vedic.astro.domain.DashaCombination;
import com.vedic.astro.domain.DashaPeriodSnapshot;
import com.vedic.astro.enums.Dasha;
import com.vedic.astro.enums.NakDashaSystem;
import com.vedic.astro.exception.SystemException;

/**
 * The Repository which does all basic CRUD operations on the
 * <tt>Token</tt> object. Uses Spring's {@link MongoTemplate} to perform CRUD
 * operations.
 * 
 * @author Sumeer Saxena
 * @param <T>
 */
@Repository("dashaInfoRepository")
@Transactional
public class DashaInfoRepository {


	@Value("${mongo.collection.dasha_info}")
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
	public void add(Collection<DashaPeriodSnapshot> dashaPeriodSnapshotList) {

		
		try {
			
			mongoTemplate.insert(dashaPeriodSnapshotList, this.getRepositoryName());

		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
	}
	
	public DashaCombination findBy(String pid, NakDashaSystem dashaSystem, Date date ) {

		DashaCombination result = new DashaCombination();
		
		try {
        	List<BasicDBObject> conditionsList = new ArrayList<BasicDBObject>();
			conditionsList.add(new BasicDBObject("dashaPeriod.endDate", new BasicDBObject("$gte", date)));
			conditionsList.add(new BasicDBObject("dashaPeriod.startDate", new BasicDBObject("$lte", date)));
			conditionsList.add(new BasicDBObject("pid", pid));
			conditionsList.add(new BasicDBObject("dashaSystem", dashaSystem.name()));
			
			
			BasicDBObject db1 = new BasicDBObject();
			db1.put("$and", conditionsList);
			
			
			// Execute the query and find one matching entry
			DBCursor dbCursor  = mongoTemplate.getDb().getCollection(COLLECTION_NAME).find(db1);
			
			while(dbCursor.hasNext()){
				
				DBObject dbObject = dbCursor.next();
				DBObject dashaCombination = (DBObject) dbObject.get("dashaCombination");
				
				result.setLevel1(Dasha.valueOf((String)dashaCombination.get("level1")));
				result.setLevel2(Dasha.valueOf((String)dashaCombination.get("level2")));
				result.setLevel3(Dasha.valueOf((String)dashaCombination.get("level3")));
				result.setLevel4(Dasha.valueOf((String)dashaCombination.get("level4")));
				
			}
			
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return result;
	}

	public Long findSeqBy(String pid, NakDashaSystem dashaSystem, Date date ) {
		
		Long seq = null;     
		
		try {
			List<BasicDBObject> conditionsList = new ArrayList<BasicDBObject>();
			conditionsList.add(new BasicDBObject("dashaPeriod.endDate", new BasicDBObject("$gte", date)));
			conditionsList.add(new BasicDBObject("dashaPeriod.startDate", new BasicDBObject("$lte", date)));
			conditionsList.add(new BasicDBObject("pid", pid));
			conditionsList.add(new BasicDBObject("dashaSystem", dashaSystem.name()));
			
			
			BasicDBObject db1 = new BasicDBObject();
			db1.put("$and", conditionsList);
			
			// Execute the query and find one matching entry
			DBCursor dbCursor  = mongoTemplate.getDb().getCollection(COLLECTION_NAME).find(db1);
			
			while(dbCursor.hasNext()){
				
				DBObject dbObject = dbCursor.next();
				seq = (Long) dbObject.get("seq");
				
			}
			
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return seq;
	}

	protected String getRepositoryName(){
		return COLLECTION_NAME;
	}

	public List<DashaPeriodSnapshot> findBy(String pid, NakDashaSystem dashaSystem, Date fromDate, Date toDate) {

        List<DashaPeriodSnapshot> result = new ArrayList<DashaPeriodSnapshot>();
		
		try {
              Query query = new Query(Criteria.where("pid").is(pid)).addCriteria(
            		  Criteria.where("dashaSystem").is(dashaSystem.name()));
              
              Long fromSeq = findSeqBy(pid, dashaSystem, fromDate);
              Long toSeq = findSeqBy(pid, dashaSystem, toDate);
              
              query.addCriteria(Criteria.where("seq").gte(fromSeq).lte(toSeq));
              result = mongoTemplate.find(query, DashaPeriodSnapshot.class, getRepositoryName());
			
		} catch (Exception ex) {
			throw new SystemException(ex.getMessage(), ex);
		}
		
		return result;
	}

}
