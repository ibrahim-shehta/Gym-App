package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.EmployeeDto;
import com.gym.user.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeDtoMapper extends BaseStatusMapper<Employee, EmployeeDto> {

}
