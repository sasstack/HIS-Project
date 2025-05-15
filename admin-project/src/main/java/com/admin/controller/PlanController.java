package com.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.Entity.Plan;
import com.admin.binding.PlanResponse;
import com.admin.constants.AppConstants;
import com.admin.properties.AppProperties;
import com.admin.service.PlanService;

@RestController
public class PlanController {

	private PlanService planService;
	private  Map<String, String> messages;
	
	
	public PlanController(PlanService planService, AppProperties appProperties) {
		super();
		this.planService = planService;
		this.messages = appProperties.getMessages();
		
		
	}


	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories,HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody PlanResponse plan) {
		boolean savePlan = planService.savePlan(plan);
		String str = AppConstants.EMPTY_STR;
		if (savePlan) {
			str = messages.get(AppConstants.PLAN_SAVE_SUCC);
		}else {
			str = messages.get(AppConstants.PLAN_SAVE_FAIL);
		}
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@GetMapping("plans")
	public ResponseEntity<List<Plan>> getPlans() {
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(planById, HttpStatus.OK);
		
	}
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean isDeleted = planService.deletePlanById(planId);
		String str = AppConstants.EMPTY_STR;
		if (isDeleted) {
			str = messages.get(AppConstants.PLAN_DELETE_SUCC);
		}else {
			str = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody PlanResponse plan){
		boolean isUpdated = planService.updatePlan(plan);
		String str = AppConstants.EMPTY_STR;
		if (isUpdated) {
			str = messages.get(AppConstants.PLAN_UPDATE_SUCC);
		}else {
			str = messages.get(AppConstants.PLAN_UPDATE_FAIL);
		}
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable Boolean status){
		boolean ischanged = planService.planStatusChange(planId, status);
		String str = AppConstants.EMPTY_STR;
		if (ischanged) {
			str = messages.get(AppConstants.PLAN_STATUS_CHANGE);
		} else {
			str = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
		}
		return new ResponseEntity<>(str, HttpStatus.OK);
	}	
}
