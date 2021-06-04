package com.gym.modules.status.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.status.model.Status;
import com.gym.modules.status.model.enums.StatusTypeCode;

@Repository
public interface StatusRepository extends BaseRepository<Status, Long> {
	
	@Query("select s.value from Status s join s.statusTypeStatus sts where sts.statusType.code = :statusTypeCode and sts.isDefault = true")
	int getDefaultStatusByStatusTypeCode(StatusTypeCode statusTypeCode);

	@Query("select new com.gym.modules.status.model.Status(s.id, s.name, s.value) from Status s join s.statusTypeStatus sts where sts.statusType.code = :statusTypeCode order by sts.sortRank")
	List<Status> getStatusByStatusTypeCode(StatusTypeCode statusTypeCode);

}
