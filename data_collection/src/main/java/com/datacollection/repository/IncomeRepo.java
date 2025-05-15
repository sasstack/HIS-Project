package com.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacollection.entity.Income;

public interface IncomeRepo extends JpaRepository<Income, Integer> {

	public Income findByCaseNum(Long caseNum);

}
