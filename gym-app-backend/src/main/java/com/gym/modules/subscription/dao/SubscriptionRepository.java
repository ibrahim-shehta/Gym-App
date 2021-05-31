package com.gym.modules.subscription.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseStatusRepository;
import com.gym.modules.subscription.model.Subscription;

@Repository
public interface SubscriptionRepository extends BaseStatusRepository<Subscription, Long> {

//	@Query("select s from Subscription s join fetch s.user join fetch s.plan p join fetch p.planTranslate pt where pt.langCode = 'ar' and s.id = :id   ")

	@Query("select s from Subscription s join fetch s.user join fetch s.plan p where s.id = :id")
	public Optional<Subscription> findById(Long id);
	
	@Query("select s.id from Subscription s where s.user.id = :userId and s.status = :status")
	public List<Long> findSubscriptionByStatusAndUser(int status, Long userId);
	
	@Query("select s from Subscription s where s.user.id = :userId and s.status = :status")
	public List<Subscription> getSubscriptionEntityByStatusAndUserId(int status, Long userId);
	
	@Modifying(clearAutomatically = true)
	@Query("update Subscription s set s.status = :status where id = :id")
	public void updateSubscriptionStatusById(Long id, int status);
	
	@Modifying
	@Query("update Subscription s set s.attendanceDays = s.attendanceDays + 1 where s.user.id = :userId and s.status = :status")
	public void incrementDaysByUserIdAndStatus(Long userId, int status);
	
	@Modifying
	@Query("update Subscription s set s.attendanceDays = s.attendanceDays + 1 where s.id = :id")
	public void incrementDaysBySubscriptionId(Long id);
	
	@Modifying
	@Query("update Subscription s set s.paidAmount = (s.paidAmount + :paidAmount) where s.id = :id")
	public void payRemainAmount(Long id, double paidAmount);
	
}
