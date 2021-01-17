package com.bataryat.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.user.model.Permission;

public class PermissionDto extends BaseDto {

	private String code;
	private List<PermissionTranslateDto>  permissionTranslateDto = new ArrayList<>();
	
	
	public static PermissionDto mapEntityToDto(Permission entity) {
		if (entity == null) {
			return null;
		}
		PermissionDto dto = new PermissionDto();
		dto.setId(entity.getId());
		dto.code = entity.getCode();
		entity.getPermissionTranslate().forEach(item -> {
			dto.permissionTranslateDto.add(PermissionTranslateDto.mapEntityToDto(item));
		});
		return dto;
	}

	public static Permission mapDtoToEntity(PermissionDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<PermissionTranslateDto> getPermissionTranslateDto() {
		return permissionTranslateDto;
	}
	public void setPermissionTranslateDto(List<PermissionTranslateDto> permissionTranslateDto) {
		this.permissionTranslateDto = permissionTranslateDto;
	}

	
	
}
