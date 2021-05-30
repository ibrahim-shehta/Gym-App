package com.gym.modules.lookups.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.modules.lookups.model.Lookup;
import com.gym.modules.lookups.model.enums.LookupTypeCode;
import com.gym.modules.lookups.respository.LookupRepository;
import com.gym.modules.lookups.service.LookupService;

@Service
public class LookupServiceImpl implements LookupService {

	@Autowired
	private LookupRepository lookupRepository;
	
	@Override
	public String getLookupdefaultLookupValue(LookupTypeCode lookupTypeCode) {
		return lookupRepository.getLookupdefaultLookupValue(lookupTypeCode);
	}

	@Override
	public List<Lookup> getLookupsByLookupTypeCode(LookupTypeCode lookupTypeCode) {
		return lookupRepository.getLookupsByLookupTypeCode(lookupTypeCode);
	}

}
