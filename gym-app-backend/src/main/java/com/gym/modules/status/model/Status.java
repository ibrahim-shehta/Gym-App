package com.gym.modules.status.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gym.common.model.BaseEntity;

@Entity
public class Status extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int value;
	
	@JsonIgnore
	@OneToMany(mappedBy="status", fetch=FetchType.LAZY)
    private List<StatusTypeStatus> statusTypeStatus =new ArrayList<StatusTypeStatus>();
	
	public Status() {
		// TODO Auto-generated constructor stub
	}
	
	public Status(Long id) {
		super(id);
	}
	
	public Status(Long id, String name, int value) {
		this(id);
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public List<StatusTypeStatus> getStatusTypeStatus() {
		return statusTypeStatus;
	}

	public void setStatusTypeStatus(List<StatusTypeStatus> statusTypeStatus) {
		this.statusTypeStatus = statusTypeStatus;
	}
}
