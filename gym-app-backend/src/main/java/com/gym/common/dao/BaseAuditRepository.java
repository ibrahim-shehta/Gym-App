package com.gym.common.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.gym.common.dto.AuditDto;
import com.gym.common.model.Auditable;

@NoRepositoryBean
public interface BaseAuditRepository<E extends Auditable, ID extends Serializable> extends BaseRepository<E, ID>{

	@Query("select new com.gym.common.dto.AuditDto(c.name, e.createdAt, m.name, e.lastModifiedAt) "
			+ "from #{#entityName} e join  e.createdBy c join e.lastModifiedBy m where e.id = :id")
	AuditDto findAuditByEntityId(ID id);
}
