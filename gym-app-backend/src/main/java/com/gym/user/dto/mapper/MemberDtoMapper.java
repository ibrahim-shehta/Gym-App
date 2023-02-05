package com.gym.user.dto.mapper;

import org.mapstruct.Mapper;

import com.gym.common.dto.mapper.BaseStatusMapper;
import com.gym.user.dto.MemberDto;
import com.gym.user.model.Member;

@Mapper(componentModel = "spring")
public interface MemberDtoMapper extends BaseStatusMapper<Member, MemberDto> {

}
