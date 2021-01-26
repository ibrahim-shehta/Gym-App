package com.gym.modules.subscription.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.modules.plan.model.Plan_;
import com.gym.modules.subscription.model.Subscription_;
import com.gym.user.model.User_;
import com.gym.common.constant.FilterKeys;
import com.gym.common.helper.DaoHelper;
import com.gym.modules.subscription.model.Subscription;

public class SubscriptionSpecification {

	@SuppressWarnings("unchecked")
	public static Specification<Subscription> filterSubscriptions(Map<String, Object> filterDataMap) {
		return (Root<Subscription> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        		List<Predicate> predicates = new ArrayList<>();
        		Join<Object, Object> user = null;
        		Join<Object, Object> plan = null;
        		
        		if (DaoHelper.isCountQuery(query)) {
        			user = root.join(Subscription_.USER);
        			plan = root.join(Subscription_.PLAN);
        		} else {
        			user = (Join<Object, Object>) root.fetch(Subscription_.USER);
    				plan = (Join<Object, Object>) root.fetch(Subscription_.PLAN);
        		}
        		
                
                
                if (filterDataMap.isEmpty()) 
                	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
                    predicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.USERNAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.USERNAME), filterDataMap.get(FilterKeys.USERNAME) + "%");
                    predicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.EMAIL)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.EMAIL), filterDataMap.get(FilterKeys.EMAIL) + "%");
                    predicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.MOBILE)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.MOBILE), filterDataMap.get(FilterKeys.MOBILE) + "%");
                    predicates.add(equalPredicate);
            	}  
            	
            	if (filterDataMap.containsKey(FilterKeys.PALN_ID)) {
            		Predicate equalPredicate = criteriaBuilder.equal(plan.get(Plan_.ID), filterDataMap.get(FilterKeys.PALN_ID));
                    predicates.add(equalPredicate);
            	} 
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }; 
	}

}
