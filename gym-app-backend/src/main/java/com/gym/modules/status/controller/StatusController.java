package com.gym.modules.status.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.response.ListResponse;
import com.gym.modules.status.model.Status;
import com.gym.modules.status.model.enums.StatusTypeCode;
import com.gym.modules.status.service.StatusService;

@Controller
@RequestMapping("/api/v1/status")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/{code}")
	public ResponseEntity<ListResponse<Status>> getByLookupCode(@PathVariable String code) {
		StatusTypeCode lookupTypeCode = StatusTypeCode.valueOf(code.toUpperCase());
		List<Status> lookups = statusService.getStatusByStatusTypeCode(lookupTypeCode);
		return ResponseEntity.ok(new ListResponse<Status>(lookups));
	}
}
