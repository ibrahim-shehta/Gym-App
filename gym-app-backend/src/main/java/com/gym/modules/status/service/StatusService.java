package com.gym.modules.status.service;

import java.util.List;

import com.gym.modules.status.model.Status;
import com.gym.modules.status.model.enums.StatusTypeCode;

public interface StatusService {

	int getDefaultStatusByStatusTypeCode(StatusTypeCode statusTypeCode);
	
	List<Status> getStatusByStatusTypeCode(StatusTypeCode statusTypeCode);
}
