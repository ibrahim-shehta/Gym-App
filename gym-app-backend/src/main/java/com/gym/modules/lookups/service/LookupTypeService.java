package com.gym.modules.lookups.service;

import com.gym.modules.lookups.model.LookupType;
import com.gym.modules.lookups.model.enums.LookupTypeCode;

public interface LookupTypeService {

	public LookupType getLookupTypeByCode(LookupTypeCode lookupTypeCode);
}
