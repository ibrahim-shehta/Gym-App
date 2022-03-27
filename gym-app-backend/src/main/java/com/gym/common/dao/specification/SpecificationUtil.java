package com.gym.common.dao.specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.gym.common.helper.DaoHelper;

public class SpecificationUtil {
	public static <T> Specification<T> bySearchQuery(SearchQuery searchQuery) {

		if (searchQuery == null)
			return null;

		return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criterailBuilder) -> {

			List<Predicate> andPredicates = new ArrayList<>();
			List<Predicate> orPredicates = new ArrayList<>();

			List<JoinColumnProps> joinColumnProps = searchQuery.getJoinColumnProps();
			if (joinColumnProps != null && !joinColumnProps.isEmpty()) 
				for (JoinColumnProps joinColumnProp : joinColumnProps) 
					addJoinColumnProps(andPredicates, orPredicates, joinColumnProp, criterailBuilder, root, query); 
				

			List<SearchFilter> searchFilters = searchQuery.getSearchFitlers();
			if (searchFilters != null && !searchFilters.isEmpty()) 
					addPredicates(andPredicates, orPredicates, criterailBuilder, searchFilters, null, root);

					

			if (andPredicates.isEmpty() && orPredicates.isEmpty()) 
				return criterailBuilder.conjunction();
			

			if (orPredicates.isEmpty() && !andPredicates.isEmpty()) 
				query.where(criterailBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()])));
			else if (!orPredicates.isEmpty() && andPredicates.isEmpty())
				query.where(criterailBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])));
			else 
				query.where(
						criterailBuilder.or(orPredicates.toArray(new Predicate[orPredicates.size()])),
						criterailBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()]))
				);
			

			return query.getRestriction();


		};
	}
	

	private static <T> void addJoinColumnProps(List<Predicate> andPredicates, List<Predicate> orPredicates,
			JoinColumnProps joinColumnProp, CriteriaBuilder criterailBuilder, Root<T> root, CriteriaQuery<?> query) {

		List<SearchFilter> searchFilters = joinColumnProp.getSearchFilter();

		final Join<Object, Object> joinParent;
		if (DaoHelper.isCountQuery(query)) {
			joinParent = root.join(joinColumnProp.getJoinColumnName(),
					joinColumnProp.getJoinType() != null ? joinColumnProp.getJoinType() : JoinType.INNER);
		} else {
			joinParent = (Join<Object, Object>) root.fetch(joinColumnProp.getJoinColumnName(),
					joinColumnProp.getJoinType() != null ? joinColumnProp.getJoinType() : JoinType.INNER);
		}

		if (searchFilters != null && !searchFilters.isEmpty())
			addPredicates(andPredicates, orPredicates, criterailBuilder, searchFilters, joinParent, null);

	}


	private static <T>void addPredicates(List<Predicate> andPredicates, List<Predicate> orPredicates,
			CriteriaBuilder criterailBuilder, List<SearchFilter> searchFilters, final Join<Object, Object> joinParent, Root<T> root) {
			searchFilters.forEach(searchFilter -> 
				addPredicate(andPredicates, orPredicates, searchFilter, criterailBuilder,
						joinParent != null ? joinParent.get(searchFilter.getProperty()) : root.get(searchFilter.getProperty()))
		);
	}

//	private static <T> void addPredicates(List<Predicate> andPredicates, List<Predicate> orPredicates,
//			SearchFilter searchFilter, CriteriaBuilder criterailBuilder, Root<T> root) {
//		String property = searchFilter.getProperty();
//		Path expression = root.get(property);
//
//		addPredicate(andPredicates, orPredicates, searchFilter, criterailBuilder, expression);
//
//	}

	private static void addPredicate(List<Predicate> andPredicates, List<Predicate> orPredicates,
			SearchFilter searchFilter, CriteriaBuilder criterailBuilder, Path expression) {

		if (searchFilter.isOr()) {
			addPredicatesToList(orPredicates, searchFilter, criterailBuilder, expression);
		} else {
			addPredicatesToList(andPredicates, searchFilter, criterailBuilder, expression);
		}

	}

	private static void addPredicatesToList(List<Predicate> predicates, SearchFilter searchFilter,
			CriteriaBuilder criterailBuilder, Path expression) {
		switch (searchFilter.getOperator()) {
		case EQUAL:
			predicates.add(criterailBuilder.equal(expression, searchFilter.getValue()));
			break;
		case NOT_EQUAL:
			predicates.add(criterailBuilder.notEqual(expression, searchFilter.getValue()));
			break;
		case LIKE:
			predicates.add(criterailBuilder.like(expression, "%" + ((String)searchFilter.getValue()).toUpperCase() + "%"));
			break;
		case NOT_LIKE:
			predicates.add(criterailBuilder.notLike(expression, "%" + searchFilter.getValue() + "%"));
			break;
		case IN:
			//String[] objs = (Long[])searchFilter.getValue();
			//List<Long> list = Arrays.asList(searchFilter.getValue()).stream().map(i -> Long.parseLong(i))
			//.collect(Collectors.toList());
//			String[] arr = ((String) searchFilter.getValue()).split(",");
//			List<String> l1 = null;
//			List<Long> l2 = null;
//			try {
//				l2 = new ArrayList<>();
//				for(String s : arr) {
//					l2.add(Long.parseLong(s));
//				}
//			} catch(Exception e) {
//				l1 = Arrays.asList(arr);
//			}
			predicates.add(criterailBuilder.in(expression).value(getInList(searchFilter)));
			break;
		case NOT_IN:
			predicates.add(criterailBuilder.in(expression).value(searchFilter.getValue()).not());
			break;
		case GREATER_THAN:
			predicates.add(criterailBuilder.greaterThan(expression, (Comparable) searchFilter.getValue()));
			break;
		case LESS_THAN:
			predicates.add(criterailBuilder.lessThan(expression, (Comparable) searchFilter.getValue()));
			break;
		case GREATER_THAN_OR_EQUAL:
			predicates.add(criterailBuilder.greaterThanOrEqualTo(expression, (Comparable) searchFilter.getValue()));
			break;
		case LESS_THAN_OR_EQUAL:
			predicates.add(criterailBuilder.lessThanOrEqualTo(expression, (Comparable) searchFilter.getValue()));
			break;
		case IS_NULL:
			predicates.add(criterailBuilder.isNull(expression));
			break;
		case NOT_NULL:
			predicates.add(criterailBuilder.isNotNull(expression));
			break;

		default:
			System.out.println("Predicate is not matched");
			throw new IllegalArgumentException(searchFilter.getOperator() + " is not a valid predicate");
		}
	}
	
	
	private static List<Object> getInList(SearchFilter searchFilter) {
		String[] arr = ((String) searchFilter.getValue()).split(",");
		List<Object> list = new ArrayList<>();
		try {
			for(String s : arr) {
				list.add(Long.parseLong(s));
			}
		} catch(Exception e) {
			list = Arrays.asList(arr);
		}
		
		return list;
	}

}