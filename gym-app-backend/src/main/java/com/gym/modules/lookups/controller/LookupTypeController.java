package com.gym.modules.lookups.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.modules.lookups.model.LookupType;
import com.gym.modules.lookups.model.enums.LookupTypeCode;
import com.gym.modules.lookups.service.LookupTypeService;

@Controller
@RequestMapping("/api/v1/lookup-type")
public class LookupTypeController {
	
	@Autowired
	private LookupTypeService lookupTypeService;
	
	@GetMapping("/{code}")
	public ResponseEntity<BaseResponse<LookupType>> getByLookupCode(@PathVariable String code) {
		LookupTypeCode lookupTypeCode = LookupTypeCode.valueOf(code.toUpperCase());
		LookupType lookupType = lookupTypeService.getLookupTypeByCode(lookupTypeCode);
		return ResponseEntity.ok(new EntityResponse<LookupType>(lookupType));
	}
}
