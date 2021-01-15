package com.bataryat.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bataryat.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	User findByUsername(String username);
	
	List<User> findByUsernameOrEmailOrMobile(String userName, String email, String mobile);
}
