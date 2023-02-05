package com.gym.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.user.model.Member;
import com.gym.user.repository.MemberRepository;
import com.gym.user.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl extends UserServiceImpl<Member, Long>  implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public MemberRepository getRepository() {
		return memberRepository;
	}

}
