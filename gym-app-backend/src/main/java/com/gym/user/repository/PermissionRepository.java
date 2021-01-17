package com.gym.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.user.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

	public Permission findByIdAndPermissionTranslateLangCode(Long id, String langCode);
	
	@Query("from Permission p join fetch p.permissionTranslate pt "
			+ "where p.id = :id and pt.langCode = :langCode ")
	// @Query("from Permission p, PermissionTranslate pt where p.id = :id and pt.permission.id = :id and pt.langCode = :langCode")
	public Permission getPermission(Long id, String langCode);

}
