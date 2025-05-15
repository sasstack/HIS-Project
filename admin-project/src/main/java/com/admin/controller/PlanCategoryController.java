package com.admin.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.binding.PlanCategoryResponse;
import com.admin.constants.AppConstants;
import com.admin.properties.AppProperties;
import com.admin.service.PlanCategoryService;

@RestController
public class PlanCategoryController {

	private PlanCategoryService planCategoryService;
	private  Map<String, String> messages;
	
	public PlanCategoryController(PlanCategoryService planCategoryService, Map<String, String> messages,
			AppProperties appProperties) {
		super();
		this.planCategoryService = planCategoryService;
		this.messages = appProperties.getMessages();
	}

	@PostMapping("/planCategories")
	public ResponseEntity<String> savePlanCategory(@RequestBody PlanCategoryResponse categoryResponse){
		
		boolean savePlanCategory = planCategoryService.savePlanCategory(categoryResponse);
		String str = AppConstants.EMPTY_STR;
		if (savePlanCategory) {
			str = messages.get(AppConstants.PLAN_CATEGORY_SAVE_SUCC);
		}else {
			str = messages.get(AppConstants.PLAN_CATEGORY_SAVE_FAIL);
		}
		return new ResponseEntity<>(str,HttpStatus.OK);
		
	}
}