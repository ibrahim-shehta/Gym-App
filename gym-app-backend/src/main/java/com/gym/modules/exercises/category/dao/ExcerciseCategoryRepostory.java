package com.gym.modules.exercises.category.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.modules.exercises.category.model.ExcerciseCategory;

@Repository
public interface ExcerciseCategoryRepostory extends BaseAuditRepository<ExcerciseCategory, Long>, JpaSpecificationExecutor<ExcerciseCategory> {
	
	public Page<ExcerciseCategory> findByNameContains(String name, Pageable page);
}
