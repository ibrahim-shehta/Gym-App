package com.bataryat.modules.plan.dao.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.domain.Specification;

import com.bataryat.common.constant.FilterKeys;
import com.bataryat.common.helper.DaoHelper;
import com.bataryat.modules.plan.model.Plan;
import com.bataryat.modules.plan.model.PlanTranslate_;
import com.bataryat.modules.plan.model.Plan_;

public abstract class PlanSpecification {

	@SuppressWarnings("unchecked")
	public static Specification<Plan> filterPlans(Map<String, Object> filterDataMap) {
		return (Root<Plan> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
        		List<Predicate> predicates = new ArrayList<>();
        		Join<Object, Object> planTranslate;
        		
        		if (DaoHelper.isCountQuery(query)) 
                	planTranslate = root.join(Plan_.PLAN_TRANSLATE);
        		 else 
                	planTranslate = (Join<Object, Object>) root.fetch(Plan_.PLAN_TRANSLATE);
        		
                
            	Predicate equalPredicate1 = criteriaBuilder.equal(planTranslate.get(PlanTranslate_.LANG_CODE), LocaleContextHolder.getLocale().getLanguage());
                predicates.add(equalPredicate1);
                
                if (filterDataMap.isEmpty()) 
                	return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                
                
            	if (filterDataMap.containsKey(FilterKeys.NAME)) {
            		Predicate equalPredicate = criteriaBuilder.like(planTranslate.get(PlanTranslate_.NAME), filterDataMap.get(FilterKeys.NAME) + "%");
                    predicates.add(equalPredicate);
            	}
            	
//            	if (filterDataMap.containsKey(FilterKeys.CODE)) {
//            		Predicate equalPredicate = criteriaBuilder.like(root.get(Plan_.CODE), filterDataMap.get(FilterKeys.CODE) + "%");
//                    predicates.add(equalPredicate);
//            	}
                
            	if (filterDataMap.containsKey(FilterKeys.DESCRIPTION)) {
            		Predicate equalPredicate = criteriaBuilder.like(planTranslate.get(PlanTranslate_.DESCRIPTION), filterDataMap.get(FilterKeys.DESCRIPTION) + "%");
                    predicates.add(equalPredicate);
            	}
                
                
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }; 
	}

}
