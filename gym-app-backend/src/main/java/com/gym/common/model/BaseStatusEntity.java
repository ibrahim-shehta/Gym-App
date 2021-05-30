package com.gym.common.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseStatusEntity extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String statusReason;
	private Date statusDate;
	
	public BaseStatusEntity() {
		
	}
	
	public BaseStatusEntity(Long id) {
		super(id);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	
}
