package com.gym.modules.resetpassword.dto;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.resetpassword.model.ResetPassword;

@Repository
public interface ResetPasswordRepository extends BaseRepository<ResetPassword, Long> {
	
	Optional<ResetPassword> findByIdAndCode(Long id, String code);
}
