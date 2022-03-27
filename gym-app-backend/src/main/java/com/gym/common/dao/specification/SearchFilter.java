package com.gym.common.dao.specification;

import com.gym.common.dao.specification.enums.Operator;

public class SearchFilter {
	private String property;
	private Operator operator;
	private Object value;
	private boolean isOr;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isOr() {
		return isOr;
	}

	public void setOr(boolean isOr) {
		this.isOr = isOr;
	}

}