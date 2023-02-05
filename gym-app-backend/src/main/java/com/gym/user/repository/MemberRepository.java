package com.gym.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.user.model.Member;

@Repository
public interface MemberRepository extends UserRepository<Member, Long>, JpaSpecificationExecutor<Member>{

	
}
