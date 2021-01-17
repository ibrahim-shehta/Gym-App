package com.gym.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.gym.user.model.User;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class}) 
public abstract class Auditable extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4648826521531988784L;

 	@CreatedDate
 	@Column(updatable=false)
    protected Date createdAt;
 
 	@ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
 	@JoinColumn(updatable=false)
    protected User createdBy;
    
    @LastModifiedDate
    protected Date lastModifiedAt;          
 
    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    protected User lastModifiedBy;
	    
	public Auditable() {

	}

	public Auditable(Long id) {
		super(id);
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	

}
