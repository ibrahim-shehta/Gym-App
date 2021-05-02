package com.gym.modules.equipments.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.common.constant.FilterKeys;
import com.gym.modules.equipments.model.Equipment;
import com.gym.modules.equipments.model.Equipment_;

public abstract class EquipmentSpecification {

	public static Specification<Equipment> filterEquipments(Map<String, Object> filterDataMap) {
		return (Root<Equipment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        		List<Predicate> predicates = new ArrayList<>();

                if (filterDataMap.isEmpty()) 
                	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate namePredicate = criteriaBuilder.like(root.get(Equipment_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
                    predicates.add(namePredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.IS_ACTIVE)) {
            		Predicate isActivePredicate = criteriaBuilder.equal(root.get(Equipment_.IS_ACTIVE), filterDataMap.get(FilterKeys.IS_ACTIVE));
                    predicates.add(isActivePredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.CODE)) {
            		Predicate codePredicate = criteriaBuilder.equal(root.get(Equipment_.CODE), filterDataMap.get(FilterKeys.CODE));
                    predicates.add(codePredicate);
            	}
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }; 
	}

}
