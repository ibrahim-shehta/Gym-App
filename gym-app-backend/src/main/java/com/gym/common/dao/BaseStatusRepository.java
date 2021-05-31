package com.gym.common.dao;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.gym.common.model.BaseStatusEntity;

@NoRepositoryBean
public interface BaseStatusRepository<E extends BaseStatusEntity, ID extends Serializable> extends BaseAuditRepository<E, ID>{

	@Modifying
	@Query("update #{#entityName} set status = :status, statusReason = :reason, statusDate = :date where id = :id")
	void updateStatus(ID id, int status,String reason, Date date);
	
}
