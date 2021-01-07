package com.bataryat.modules.plan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bataryat.modules.plan.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

}
