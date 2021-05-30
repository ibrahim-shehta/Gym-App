package com.gym.modules.lookups.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.modules.lookups.model.LookupType;
import com.gym.modules.lookups.model.enums.LookupTypeCode;
import com.gym.modules.lookups.respository.LookupTypeRepository;
import com.gym.modules.lookups.service.LookupService;
import com.gym.modules.lookups.service.LookupTypeService;

@Service
public class LookupTypeServiceImpl implements LookupTypeService {

	@Autowired
	private LookupTypeRepository lookupTypeRepository;
	@Autowired
	private LookupService lookupService;
	
	@Override
	public LookupType getLookupTypeByCode(LookupTypeCode lookupTypeCode) {
		System.out.println("=============>>>" + lookupService.getLookupdefaultLookupValue(lookupTypeCode));
		return lookupTypeRepository.findByLookupTypeCode(lookupTypeCode);
	}

}
