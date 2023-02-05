package com.gym.user.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.gym.user.model.Employee;

@Repository
public interface EmployeeRepository extends UserRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{

	
}
