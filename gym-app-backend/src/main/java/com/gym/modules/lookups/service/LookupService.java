package com.gym.modules.lookups.service;

import com.gym.modules.lookups.model.enums.LookupTypeCode;

public interface LookupService {

	String getLookupdefaultLookupValue(LookupTypeCode lookupTypeCode);
}
