package com.bataryat.user.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.bataryat.common.constant.FilterKeys;
import com.bataryat.modules.plan.model.PlanTranslate_;
import com.bataryat.user.model.User;
import com.bataryat.user.model.User_;

public abstract class UserSpecification {

	public static Specification<User> filterUsers(Map<String, Object> filterDataMap) {
		return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filterDataMap.isEmpty())
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

			if (filterDataMap.containsKey(FilterKeys.NAME)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(PlanTranslate_.NAME),
						filterDataMap.get(FilterKeys.NAME) + "%");
				predicates.add(equalPredicate);
			}

			if (filterDataMap.containsKey(FilterKeys.EMAIL)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.EMAIL),
						filterDataMap.get(FilterKeys.EMAIL) + "%");
				predicates.add(equalPredicate);
			}

			if (filterDataMap.containsKey(FilterKeys.USERNAME)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.USERNAME),
						filterDataMap.get(FilterKeys.USERNAME) + "%");
				predicates.add(equalPredicate);
			}

			if (filterDataMap.containsKey(FilterKeys.MOBILE)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.MOBILE),
						filterDataMap.get(FilterKeys.MOBILE) + "%");
				predicates.add(equalPredicate);
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}

}
