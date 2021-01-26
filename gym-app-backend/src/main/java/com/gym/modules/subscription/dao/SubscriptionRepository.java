package com.gym.modules.subscription.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.modules.subscription.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>, JpaSpecificationExecutor<Subscription> {

//	@Query("select s from Subscription s join fetch s.user join fetch s.plan p join fetch p.planTranslate pt where pt.langCode = 'ar' and s.id = :id   ")

	@Query("select s from Subscription s join fetch s.user join fetch s.plan p where s.id = :id   ")
	public Optional<Subscription> findById(Long id);
}
