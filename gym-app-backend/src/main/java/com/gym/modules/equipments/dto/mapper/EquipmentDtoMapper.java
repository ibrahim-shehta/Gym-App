package com.gym.modules.equipments.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.modules.equipments.dto.EquipmentDto;
import com.gym.modules.equipments.model.Equipment;

@Mapper(componentModel = "spring")
public interface EquipmentDtoMapper extends BaseStatusMapper<Equipment, EquipmentDto> {

}
