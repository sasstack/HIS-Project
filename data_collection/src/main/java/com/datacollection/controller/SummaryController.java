package com.datacollection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.SummaryBinding;
import com.datacollection.service.DataCollectionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SummaryController {

	private DataCollectionService collectionService;

	public SummaryController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	@GetMapping("/summary/{caseNum}")
	public ResponseEntity<SummaryBinding> getSummary(@PathVariable Long caseNum) {
		SummaryBinding summary = collectionService.getSummary(caseNum);
		return ResponseEntity.ok(summary);
	}
}
