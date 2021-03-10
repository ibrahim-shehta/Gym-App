package com.gym.common.exception.exceptions;

public class SubscriptionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private String days;
	private boolean isWarning;
	
	public SubscriptionException(String msg) {
		super(msg);
	}
	
	public SubscriptionException(String msg, String days) {
		super(msg);
		this.setDays(days);
	}
	
	public SubscriptionException(String msg, boolean isWarning) {
		super(msg);
		this.isWarning = isWarning;
	}
	
	public SubscriptionException(String msg, String days, boolean isWarning) {
		super(msg);
		this.days = days;
		this.isWarning = isWarning;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public boolean isWarning() {
		return isWarning;
	}

	public void setWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}


}
