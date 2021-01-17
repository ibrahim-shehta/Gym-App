package com.bataryat.config.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bataryat.user.model.User;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {

	 @Bean
	 public AuditorAware<User> auditorAware() {
	        return new AuditorAwareImpl();
	 }
}