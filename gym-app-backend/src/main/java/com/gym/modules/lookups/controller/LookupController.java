package com.gym.modules.lookups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.response.ListResponse;
import com.gym.modules.lookups.model.Lookup;
import com.gym.modules.lookups.model.enums.LookupTypeCode;
import com.gym.modules.lookups.service.LookupService;

@Controller
@RequestMapping("/api/v1/lookup")
public class LookupController {
	
	@Autowired
	private LookupService lookupService;
	
	@GetMapping("/{code}")
	public ResponseEntity<ListResponse<Lookup>> getByLookupCode(@PathVariable String code) {
		LookupTypeCode lookupTypeCode = LookupTypeCode.valueOf(code.toUpperCase());
		List<Lookup> lookups = lookupService.getLookupsByLookupTypeCode(lookupTypeCode);
		return ResponseEntity.ok(new ListResponse<Lookup>(lookups));
	}
}
