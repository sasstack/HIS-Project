package com.datacollection.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datacollection.binding.CaseResponse;
import com.datacollection.binding.CreateCaseResponse;
import com.datacollection.entity.CaseEntity;
import com.datacollection.service.DataCollectionService;

@RestController
public class CreateCaseController {

	private DataCollectionService collectionService;

	public CreateCaseController(DataCollectionService collectionService) {
		super();
		this.collectionService = collectionService;
	}
	
	@GetMapping("/createCase/{appId}")
	public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer appId) {
		Long caseNum = collectionService.loadCaseNum(appId);
		Map<Integer, String> plans = collectionService.getPlans();
		CreateCaseResponse caseResponse = new CreateCaseResponse();
		
		caseResponse.setCaseNum(caseNum);
		caseResponse.setPlanNames(plans);
		
		return ResponseEntity.ok(caseResponse);
	}
	@GetMapping("/case/{caseNum}")
    public ResponseEntity<CaseResponse> getCase(@PathVariable Long caseNum) {
        CaseResponse caseResponse = collectionService.getCaseEntity(caseNum);
        if (caseResponse != null) {
            return ResponseEntity.ok(caseResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
