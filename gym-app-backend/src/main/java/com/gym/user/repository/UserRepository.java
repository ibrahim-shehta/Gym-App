package com.gym.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	User findByUsername(String username);
	
	List<User> findByUsernameOrEmailOrMobile(String userName, String email, String mobile);

	@Modifying
	@Query("update User set imageName = :imageName where id = :id")
	void updateImageName(String imageName, Long id);
}
