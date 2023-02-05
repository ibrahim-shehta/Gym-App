package com.gym.user.repository.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.user.model.User_;
import com.gym.common.constant.FilterKeys;
import com.gym.user.model.User;

public abstract class UserSpecification {

	public static<E extends User> Specification<E> filterUsers(Map<String, Object> filterDataMap) {
		return (Root<E> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			List<Predicate> orPredicates = new ArrayList<>();
			List<Predicate> andPredicates = new ArrayList<>();

			if (filterDataMap.isEmpty())
				return criteriaBuilder.and(orPredicates.toArray(new Predicate[orPredicates.size()]));

			if (filterDataMap.containsKey(FilterKeys.EMAIL)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.EMAIL),
						filterDataMap.get(FilterKeys.EMAIL) + "%");
				orPredicates.add(equalPredicate);
			}

			if (filterDataMap.containsKey(FilterKeys.USERNAME)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.USERNAME),
						filterDataMap.get(FilterKeys.USERNAME) + "%");
				orPredicates.add(equalPredicate);
			}

			if (filterDataMap.containsKey(FilterKeys.MOBILE)) {
				Predicate equalPredicate = criteriaBuilder.like(root.get(User_.MOBILE),
						filterDataMap.get(FilterKeys.MOBILE) + "%");
				orPredicates.add(equalPredicate);
			}
			
			if (filterDataMap.containsKey(FilterKeys.USER_TYPE)) {
				Predicate equalPredicate =criteriaBuilder.equal(root.get(User_.USER_TYPE),
						filterDataMap.get(FilterKeys.USER_TYPE));
				andPredicates.add(equalPredicate);
			}
			
			if (filterDataMap.containsKey(FilterKeys.STATUS)) {
				Predicate statusPredicate =criteriaBuilder.equal(root.get(User_.STATUS),
						filterDataMap.get(FilterKeys.STATUS));
				andPredicates.add(statusPredicate);
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
