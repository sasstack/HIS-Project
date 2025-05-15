package com.datacollection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.PlanSelectionBinding;
import com.datacollection.service.DataCollectionService;

@RestController
public class PlanSelectionController {

	private DataCollectionService collectionService;

	public PlanSelectionController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@PostMapping("/planSelection")
	public ResponseEntity<Long> planSelection(@RequestBody PlanSelectionBinding binding) {
		Long caseNum = collectionService.savePlanSelection(binding);
		return ResponseEntity.ok(caseNum);
	}
}
