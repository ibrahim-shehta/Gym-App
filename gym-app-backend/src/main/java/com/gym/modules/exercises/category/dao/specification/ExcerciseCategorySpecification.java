package com.gym.modules.exercises.category.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.modules.plan.model.Plan_;
import com.gym.common.constant.FilterKeys;
import com.gym.modules.plan.model.Plan;

public abstract class ExcerciseCategorySpecification {

	public static Specification<Plan> filterPlans(Map<String, Object> filterDataMap) {
		return (Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        		List<Predicate> predicates = new ArrayList<>();

                if (filterDataMap.isEmpty()) 
                	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(root.get(Plan_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
                    predicates.add(equalPredicate);
            	}
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }; 
	}

}
