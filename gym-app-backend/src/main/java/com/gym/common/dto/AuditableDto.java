package com.gym.common.dto;

import java.util.Date;

import com.gym.common.model.Auditable;

public class AuditableDto {

	private String createdBy;
	private String lastModifiedBy;
	private Date createdAt;
	private Date lastModifiedAt;
	
	public static AuditableDto mapEntityToDto(Auditable entity) {
		AuditableDto dto = new AuditableDto();
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setLastModifiedAt(entity.getLastModifiedAt());
		dto.setCreatedBy(entity.getCreatedBy().getUsername());
		dto.setLastModifiedBy(entity.getLastModifiedBy().getUsername());
		return dto;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	
	
}
