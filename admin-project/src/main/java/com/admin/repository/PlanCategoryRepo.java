package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.Entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer>{

	
}
