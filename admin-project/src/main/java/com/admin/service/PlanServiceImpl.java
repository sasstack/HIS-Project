package com.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.admin.Entity.Plan;
import com.admin.Entity.PlanCategory;
import com.admin.binding.PlanResponse;
import com.admin.repository.PlanCategoryRepo;
import com.admin.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	private PlanRepository planRepository;
	private PlanCategoryRepo planCategoryRepo;

	public PlanServiceImpl(PlanRepository planRepository, PlanCategoryRepo planCategoryRepo) {
		super();
		this.planRepository = planRepository;
		this.planCategoryRepo = planCategoryRepo;
	}

//	public Plan createPlan(PlanResponse plan) {
//		Plan planEntity = new Plan();
//		BeanUtils.copyProperties(plan, planEntity);
//		planRepository.save(planEntity);
//		return planEntity;
//	}

	@Override
	public Map<Integer, String> getPlanCategories() {
		Map<Integer, String> collect = planCategoryRepo
				.findAll()
				.stream()
				.filter(PlanCategory::getActiveSw)
				.collect(Collectors.toMap(each->each.getPlanCategoryId(),each->each.getCategoryName()));
		return collect;
	}

	@Override
	public boolean savePlan(PlanResponse plan) {
		Plan planEntity = new Plan();
		BeanUtils.copyProperties(plan, planEntity);
		Plan saved = planRepository.save(planEntity);
		if(saved.getId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> allPlans = planRepository.findAll();
		return allPlans;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepository.findById(planId);
		
		return findById.orElse(null);
	}

	@Override
	public boolean updatePlan(PlanResponse plan) {
		Plan planEntity = new Plan();
		BeanUtils.copyProperties(plan, planEntity);
		Plan saved = planRepository.save(planEntity);
		return !(saved.getId()==null);
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		Optional<Plan> byId = planRepository.findById(planId);
		if(byId.isPresent()) {
			planRepository.delete(byId.get());
			return true;
		}
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, Boolean acctiveSw) {
		Optional<Plan> plan = planRepository.findById(planId);
		
		if(plan.isPresent()) {
			plan.get().setActiveSw(acctiveSw);
			planRepository.save(plan.get());
			return true;
		}
		return false;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
