package com.bataryat.modules.plan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bataryat.common.model.Auditable;

@Entity
@Table(name="plans")
public class Plan extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private Long value;
	
	@OneToMany(mappedBy="plan", orphanRemoval=true, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<PlanTranslate> planTranslate = new ArrayList<>();

	public Plan() {
		// TODO Auto-generated constructor stub
	}
	
	public Plan(Long id) {
		super(id);
	}

	
	public void addTranslate(PlanTranslate planTranslate) {
		this.planTranslate.add(planTranslate);
		planTranslate.setPlan(this);
    }
 
    public void removeTranslate(PlanTranslate planTranslate) {
        this.planTranslate.remove(planTranslate);
        planTranslate.setPlan(null);
    }
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public List<PlanTranslate> getPlanTranslate() {
		return planTranslate;
	}

	public void setPlanTranslate(List<PlanTranslate> planTranslate) {
		this.planTranslate = planTranslate;
	}
	
	
	
}
