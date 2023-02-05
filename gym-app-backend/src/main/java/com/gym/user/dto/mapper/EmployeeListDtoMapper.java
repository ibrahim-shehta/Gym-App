package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.EmployeeListDto;
import com.gym.user.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeListDtoMapper extends BaseStatusMapper<Employee, EmployeeListDto> {

}
