package com.gym.common.dto;

import java.util.Date;

public class AuditDto {

	private String createdByName;
	private Date createdAt;
	
	private String lastModifiedName;
	private Date lastModifiedAt;
	
	
	public AuditDto() {}

	

	public AuditDto(String createdByName, Date createdAt, String lastModifiedName, Date lastModifiedAt) {
		super();
		this.createdByName = createdByName;
		this.createdAt = createdAt;
		this.lastModifiedName = lastModifiedName;
		this.lastModifiedAt = lastModifiedAt;
	}



	public String getCreatedByName() {
		return createdByName;
	}


	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getLastModifiedName() {
		return lastModifiedName;
	}


	public void setLastModifiedName(String lastModifiedName) {
		this.lastModifiedName = lastModifiedName;
	}


	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}


	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	
}
