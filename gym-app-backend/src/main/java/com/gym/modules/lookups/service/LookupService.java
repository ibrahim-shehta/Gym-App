package com.gym.modules.lookups.service;

import java.util.List;

import com.gym.modules.lookups.model.Lookup;
import com.gym.modules.lookups.model.enums.LookupTypeCode;

public interface LookupService {

	String getLookupdefaultLookupValue(LookupTypeCode lookupTypeCode);
	
	List<Lookup> getLookupsByLookupTypeCode(LookupTypeCode lookupTypeCode);
}
