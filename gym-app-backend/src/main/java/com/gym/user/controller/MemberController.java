package com.gym.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.user.dto.MemberDto;
import com.gym.user.dto.MemberListDto;
import com.gym.user.dto.mapper.MemberDtoMapper;
import com.gym.user.dto.mapper.MemberListDtoMapper;
import com.gym.user.model.Member;
import com.gym.user.service.MemberService;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController extends UserController<Member, Long, MemberDto, MemberListDto> {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDtoMapper memberDtoMapper;
	
	@Autowired
	private MemberListDtoMapper memberListDtoMapper;
	

	@Override
	protected MemberService getService() {
		return memberService;
	}

	@Override
	protected MemberDtoMapper getEntityDtoMapper() {
		return memberDtoMapper;
	}

	@Override
	protected MemberListDtoMapper getListDtoMapper() {
		return memberListDtoMapper;
	}
	
	
}
