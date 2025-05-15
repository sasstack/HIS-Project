package com.datacollection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.EducationBinding;
import com.datacollection.binding.IncomeBinding;
import com.datacollection.binding.PlanSelectionBinding;
import com.datacollection.service.DataCollectionService;

@RestController
public class EducationController {

	private DataCollectionService collectionService;

	public EducationController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@PostMapping("/education")
	public ResponseEntity<Long> saveEducation(@RequestBody EducationBinding binding) {
		Long caseNum = collectionService.saveEducationData(binding);
		return ResponseEntity.ok(caseNum);
	}
}
