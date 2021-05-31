package com.gym.modules.plan.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.modules.plan.model.Plan;

@Repository
public interface PlanRepository extends BaseAuditRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {

}
