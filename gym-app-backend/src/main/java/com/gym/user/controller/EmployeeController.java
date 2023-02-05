package com.gym.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.user.dto.EmployeeDto;
import com.gym.user.dto.EmployeeListDto;
import com.gym.user.dto.mapper.EmployeeDtoMapper;
import com.gym.user.dto.mapper.EmployeeListDtoMapper;
import com.gym.user.model.Employee;
import com.gym.user.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController extends UserController<Employee, Long, EmployeeDto, EmployeeListDto> {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeDtoMapper employeeDtoMapper;
	
	@Autowired
	private EmployeeListDtoMapper employeeListDtoMapper;
	

	@Override
	protected EmployeeService getService() {
		return employeeService;
	}

	@Override
	protected EmployeeDtoMapper getEntityDtoMapper() {
		return employeeDtoMapper;
	}

	@Override
	protected EmployeeListDtoMapper getListDtoMapper() {
		return employeeListDtoMapper;
	}
	
	
}
