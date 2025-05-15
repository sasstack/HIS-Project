package com.admin.service;

import java.util.List;
import java.util.Map;

import com.admin.Entity.Plan;
import com.admin.binding.PlanResponse;

//@Service
public interface PlanService {
	
	public Map<Integer, String> getPlanCategories();
	
	public boolean savePlan(PlanResponse plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(PlanResponse plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId,Boolean acctiveSw);
	
	public Map<Integer, String> getPlanNames();

}
