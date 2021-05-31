package com.gym.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.gym.common.model.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity, ID> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {

}
