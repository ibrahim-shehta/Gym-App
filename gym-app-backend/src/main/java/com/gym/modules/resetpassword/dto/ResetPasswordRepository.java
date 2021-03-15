package com.gym.modules.resetpassword.dto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.modules.resetpassword.model.ResetPassword;

@Repository
public interface ResetPasswordRepository extends JpaRepository<ResetPassword, Long> {
	
	Optional<ResetPassword> findByIdAndCode(Long id, String code);
}
