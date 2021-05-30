package com.gym.modules.lookups.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.lookups.model.Lookup;
import com.gym.modules.lookups.model.enums.LookupTypeCode;

@Repository
public interface LookupRepository extends BaseRepository<Lookup, Long> {
	
	@Query("select l.value from Lookup l join l.lookupType lt where lt.code = :lookupTypeCode and l.sortRank = 0")
	String getLookupdefaultLookupValue(LookupTypeCode lookupTypeCode);

	@Query("select l from Lookup l join l.lookupType lt where lt.code = :lookupTypeCode order by l.sortRank")
	List<Lookup> getLookupsByLookupTypeCode(LookupTypeCode lookupTypeCode);

}
