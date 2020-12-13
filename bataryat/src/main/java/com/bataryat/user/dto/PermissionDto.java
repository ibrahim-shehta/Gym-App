package com.bataryat.user.dto;

import java.util.ArrayList;
import java.util.List;

import com.bataryat.common.dto.BaseDto;
import com.bataryat.common.dto.MapperDto;
import com.bataryat.user.model.Permission;

public class PermissionDto extends BaseDto implements MapperDto<Permission, PermissionDto, Long>{

	private String code;
	private List<PermissionTranslateDto>  permissionTranslateDto = new ArrayList<>();
	
	
	@Override
	public PermissionDto mapEntityToDto(Permission entity) {
		if (entity == null) {
			return null;
		}
		this.setId(entity.getId());
		this.code = entity.getCode();
		entity.getPermissionTranslate().forEach(item -> {
			this.permissionTranslateDto.add(new PermissionTranslateDto().mapEntityToDto(item));
		});
		return this;
	}

	@Override
	public Permission mapDtoToEntity(PermissionDto dto) {
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
