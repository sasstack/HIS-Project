package com.datacollection.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.ChildrenBinding;
import com.datacollection.binding.ChildrenRequest;
import com.datacollection.binding.EducationBinding;
import com.datacollection.binding.IncomeBinding;
import com.datacollection.binding.PlanSelectionBinding;
import com.datacollection.binding.SummaryBinding;
import com.datacollection.service.DataCollectionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChildrenController {

	private DataCollectionService collectionService;

	public ChildrenController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@PostMapping("/children")
	public ResponseEntity<SummaryBinding> saveChildren(@RequestBody ChildrenRequest bindings) {
		Long caseNum = collectionService.saveChildrenData(bindings);
		SummaryBinding summary = collectionService.getSummary(caseNum);
		return ResponseEntity.ok(summary);
	}
}
