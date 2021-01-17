package com.bataryat.modules.plan.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bataryat.modules.plan.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {

	@Query("from Plan p join fetch p.planTranslate pt where p.id = :id and pt.langCode = :langCode")
	public Optional<Plan> findByIdAndLang(Long id, String langCode);
	
	@Query("from Plan p join fetch p.planTranslate pt where pt.langCode = :langCode")
	public List<Plan> findAllByLang(String langCode);
}
