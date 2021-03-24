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
import com.gym.modules.subscription.model.enums.SubscriptionStatus;
import com.gym.user.model.User_;
import com.gym.common.constant.AppUtils;
import com.gym.common.constant.FilterKeys;
import com.gym.common.helper.DaoHelper;
import com.gym.modules.subscription.model.Subscription;

public class SubscriptionSpecification {

	@SuppressWarnings("unchecked")
	public static Specification<Subscription> filterSubscriptions(Map<String, Object> filterDataMap) {
		return (Root<Subscription> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
				List<Predicate> orPredicates = new ArrayList<>();
				List<Predicate> andPredicates = new ArrayList<>();
				
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
                	return null;
                
                if (filterDataMap.containsKey(FilterKeys.USER_ID)) {
            		Predicate equalPredicate = criteriaBuilder.equal(user.get(User_.ID), filterDataMap.get(FilterKeys.USER_ID));
            		andPredicates.add(equalPredicate);
            	}
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
            		orPredicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.USERNAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.USERNAME), filterDataMap.get(FilterKeys.USERNAME) + "%");
            		orPredicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.EMAIL)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.EMAIL), filterDataMap.get(FilterKeys.EMAIL) + "%");
            		orPredicates.add(equalPredicate);
            	}
            	
            	if (filterDataMap.containsKey(FilterKeys.MOBILE)) {
            		Predicate equalPredicate = criteriaBuilder.like(user.get(User_.MOBILE), filterDataMap.get(FilterKeys.MOBILE) + "%");
            		orPredicates.add(equalPredicate);
            	}  
            	
            	if (filterDataMap.containsKey(FilterKeys.PALN_ID)) {
            		Predicate equalPredicate = criteriaBuilder.equal(plan.get(Plan_.ID), filterDataMap.get(FilterKeys.PALN_ID));
            		orPredicates.add(equalPredicate);
            	} 
            	
            	if (filterDataMap.containsKey(FilterKeys.SUBSCRIPTION_NUMBER)) {
            		Predicate equalPredicate = criteriaBuilder.like(root.get(Subscription_.SUBSCRIPTION_NUMBER), filterDataMap.get(FilterKeys.SUBSCRIPTION_NUMBER) + "%");
            		orPredicates.add(equalPredicate);
            	}
            	if (filterDataMap.containsKey(FilterKeys.STATUS)) {
            		String statusStr = filterDataMap.get(FilterKeys.STATUS) + "";
            		SubscriptionStatus status;
            		if (AppUtils.isInteger(statusStr)) {
            			int index = Integer.parseInt(statusStr);
            			status = SubscriptionStatus.values()[index];
            		} else {
            			status = SubscriptionStatus.valueOf(statusStr);
            		}            		
            		Predicate equalPredicate = criteriaBuilder.equal(root.get(Subscription_.STATUS), status);
            		andPredicates.add(equalPredicate);
            	}
                
            	if (orPredicates.isEmpty() && !andPredicates.isEmpty()) {
    				query.where(criteriaBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
    			} else if (!orPredicates.isEmpty() && andPredicates.isEmpty()) {
    				query.where(criteriaBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])));
    			} else {
    				query.where(criteriaBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])),
    						criteriaBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()]))
    						);
    			}
						
                return query.getRestriction();
            }; 
	}

}
