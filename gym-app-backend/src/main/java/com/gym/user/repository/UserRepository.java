package com.gym.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseStatusRepository;
import com.gym.user.model.User;

@Repository
public interface UserRepository extends BaseStatusRepository<User, Long>, JpaSpecificationExecutor<User>{

	User findByUsername(String username);
	
	
	User findByEmail(String email);
	
	List<User> findByUsernameOrEmailOrMobile(String userName, String email, String mobile);

	@Modifying
	@Query("update User set imageName = :imageName where id = :id")
	void updateImageName(String imageName, Long id);
	
	@Modifying
	@Query("update User set password = :password where id = :id")
	void updateUserPassword(String password, Long id);
}
