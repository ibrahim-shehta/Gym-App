package com.gym.modules.lookups.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.gym.common.model.BaseEntity;
import com.gym.modules.lookups.model.enums.LookupTypeCode;

@Entity
public class LookupType extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	@Enumerated(EnumType.STRING)
	private LookupTypeCode code;
	
	@OneToMany(mappedBy="lookupType", fetch=FetchType.EAGER)
	private List<Lookup> lookups = new ArrayList<Lookup>();
	public LookupType() {
		// TODO Auto-generated constructor stub
	}
	
	public LookupType(Long id) {
		super(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LookupTypeCode getCode() {
		return code;
	}
	public void setCode(LookupTypeCode code) {
		this.code = code;
	}

	public List<Lookup> getLookups() {
		return lookups;
	}

	public void setLookups(List<Lookup> lookups) {
		this.lookups = lookups;
	}
	
}
