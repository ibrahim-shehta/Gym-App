package com.gym.common.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.gym.common.model.BaseEntity;

@NoRepositoryBean
public interface BaseRepositoryWithStatus<E extends BaseEntity, ID extends Serializable> extends BaseRepository<BaseEntity, ID>{

	@Modifying
	@Query("update #{#entityName} set isActive = :isActive where id = :id")
	void updateStatus(boolean isActive, ID id);
}
