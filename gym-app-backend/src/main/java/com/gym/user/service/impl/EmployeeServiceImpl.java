package com.gym.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.user.model.Employee;
import com.gym.user.repository.EmployeeRepository;
import com.gym.user.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends UserServiceImpl<Employee, Long> implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeRepository getRepository() {
		return employeeRepository;
	}

}
