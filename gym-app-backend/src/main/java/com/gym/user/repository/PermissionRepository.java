package com.gym.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.user.dto.PermissionDto;
import com.gym.user.model.Permission;

@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long>{

	//public Permission findByIdAndPermissionTranslateLangCode(Long id, String langCode);
	
//	@Query("from Permission p join fetch p.permissionTranslate pt "
//			+ "where p.id = :id and pt.langCode = :langCode ")
//	// @Query("from Permission p, PermissionTranslate pt where p.id = :id and pt.permission.id = :id and pt.langCode = :langCode")
//	public Permission getPermission(Long id, String langCode);

	@Query("select new com.gym.user.dto.PermissionDto(p.id, p.name, p.code, p.isModule, p.isScreen, p.path, p.icon, p.parent.id) from User u "
			+ "join u.roles r right join r.permissions p  where u.id = :userId or p.isModule = true or p.isScreen = true")
	public List<PermissionDto> getPermissionToUser(Long userId);
	
	@Query("select new com.gym.user.dto.PermissionDto(p.id, p.name, p.code, p.isModule, p.isScreen, p.path, p.icon, p.parent.id) from Permission p ")
	public List<PermissionDto> getAllPermissions();
}
