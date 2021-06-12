package com.gym.user.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseAuditRepository;
import com.gym.user.model.Role;

@Repository
public interface RoleRepository extends BaseAuditRepository<Role, Long> {

	@Query("select r from Role r left join fetch r.permissions p where r.id = :id")
	public Optional<Role> findById(Long id);
	
	public Page<Role> findByNameContains(String name, Pageable page);
}
