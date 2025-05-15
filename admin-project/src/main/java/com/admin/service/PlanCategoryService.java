package com.admin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.admin.Entity.PlanCategory;
import com.admin.binding.PlanCategoryResponse;
import com.admin.repository.PlanCategoryRepo;

@Service
public class PlanCategoryService {

	private PlanCategoryRepo categoryRepo;

	public PlanCategoryService(PlanCategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	public boolean savePlanCategory(PlanCategoryResponse categoryResponse) {
		PlanCategory planCategory = new PlanCategory();
		BeanUtils.copyProperties(categoryResponse, planCategory);
		categoryRepo.save(planCategory);
		if (planCategory.getPlanCategoryId()!=null) {
			return true;
		}
		return false;
	}
//	static List<PlanCategory> categories= new ArrayList<>();
//	static{
//		categories.add(new PlanCategory(1, "Food Plan", true, "sas", "sask", LocalDate.now(), LocalDate.now()));
//		categories.add(new PlanCategory(2, "Medical Plan", true, "sas", "sask", LocalDate.now(), LocalDate.now()));
//		categories.add(new PlanCategory(3, "Child Plan", true, "sas", "sask", LocalDate.now(), LocalDate.now()));
//		categories.add(new PlanCategory(4, "Unemployment Plan", true, "sas", "sask", LocalDate.now(), LocalDate.now()));
//	}

}
