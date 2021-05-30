package com.gym.modules.lookups.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.lookups.model.LookupType;
import com.gym.modules.lookups.model.enums.LookupTypeCode;

@Repository
public interface LookupTypeRepository extends BaseRepository<LookupType, Long> {

	@Query("from LookupType lt join fetch lt.lookups where lt.code = :lookupTypeCode")
	LookupType findByLookupTypeCode(LookupTypeCode lookupTypeCode);
}
