package com.datacollection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.EducationBinding;
import com.datacollection.binding.IncomeBinding;
import com.datacollection.binding.PlanSelectionBinding;
import com.datacollection.service.DataCollectionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class IncomeController {

	private DataCollectionService collectionService;

	public IncomeController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@PostMapping("/income")
	public ResponseEntity<Long> saveIncome(@RequestBody IncomeBinding binding) {
		Long caseNum = collectionService.saveIncomeData(binding);
		return ResponseEntity.ok(caseNum);
	}
}
