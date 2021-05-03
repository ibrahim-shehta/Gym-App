package com.gym.modules.exercises.excercises.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.common.constant.FilterKeys;
import com.gym.common.helper.DaoHelper;
import com.gym.modules.exercises.excercises.model.Exercise;
import com.gym.modules.exercises.excercises.model.Exercise_;

public abstract class ExerciseSpecification {

	public static Specification<Exercise> filterExercises(Map<String, Object> filterDataMap) {
		return (Root<Exercise> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        		List<Predicate> predicates = new ArrayList<>();

        		Join<Object, Object> category = null;
        		Join<Object, Object> equipment = null;
        		
        		if (DaoHelper.isCountQuery(query)) {
        			category = root.join(Exercise_.CATEGORY);
        			equipment = root.join(Exercise_.EQUIPMENT);
        		} else {
        			category = (Join<Object, Object>) root.fetch(Exercise_.CATEGORY);
        			equipment = (Join<Object, Object>) root.fetch(Exercise_.EQUIPMENT);
        		}
        		
                if (filterDataMap.isEmpty()) 
                	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate namePredicate = criteriaBuilder.like(root.get(Exercise_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
                    predicates.add(namePredicate);
            	}
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }; 
	}

}
