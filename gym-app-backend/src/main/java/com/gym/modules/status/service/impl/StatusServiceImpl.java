package com.gym.modules.status.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.modules.status.model.Status;
import com.gym.modules.status.model.enums.StatusTypeCode;
import com.gym.modules.status.respository.StatusRepository;
import com.gym.modules.status.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public int getDefaultStatusByStatusTypeCode(StatusTypeCode statusTypeCode) {
		return statusRepository.getDefaultStatusByStatusTypeCode(statusTypeCode);
	}

	@Override
	public List<Status> getStatusByStatusTypeCode(StatusTypeCode statusTypeCode) {
		return statusRepository.getStatusByStatusTypeCode(statusTypeCode);
	}

}
