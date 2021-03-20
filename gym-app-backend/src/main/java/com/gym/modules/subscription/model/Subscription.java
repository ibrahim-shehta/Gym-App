package com.gym.modules.subscription.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.gym.common.model.Auditable;
import com.gym.modules.plan.model.Plan;
import com.gym.modules.subscription.model.enums.SubscriptionStatus;
import com.gym.user.model.User;

@Entity
public class Subscription extends Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double price;
	private int numberOfDays;
	private int numberOfReservedDays;
	private int numberOfInvitations;
	private int discount;
	private boolean isSpecial;

	@Type(type = "date")
	private Date startDate;
	@Type(type = "date")
	private Date endDate;
	private double paidAmount;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Plan plan;

	private int attendanceDays;
	private int takenInvitations;
	private String subscriptionNumber;
	private String statusReason;
	@Enumerated(EnumType.STRING)
	private SubscriptionStatus status;
	private double requiredAmount;

	public Subscription() {

	}

	public Subscription(Long id) {
		super(id);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public int getNumberOfReservedDays() {
		return numberOfReservedDays;
	}

	public void setNumberOfReservedDays(int numberOfReservedDays) {
		this.numberOfReservedDays = numberOfReservedDays;
	}

	public int getNumberOfInvitations() {
		return numberOfInvitations;
	}

	public void setNumberOfInvitations(int numberOfInvitations) {
		this.numberOfInvitations = numberOfInvitations;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public int getAttendanceDays() {
		return attendanceDays;
	}

	public void setAttendanceDays(int attendanceDays) {
		this.attendanceDays = attendanceDays;
	}

	public int getTakenInvitations() {
		return takenInvitations;
	}

	public void setTakenInvitations(int takenInvitations) {
		this.takenInvitations = takenInvitations;
	}

	public String getSubscriptionNumber() {
		return subscriptionNumber;
	}

	public void setSubscriptionNumber(String subscriptionNumber) {
		this.subscriptionNumber = subscriptionNumber;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public SubscriptionStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}

	public double getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(double requiredAmount) {
		this.requiredAmount = requiredAmount;
	}
}
