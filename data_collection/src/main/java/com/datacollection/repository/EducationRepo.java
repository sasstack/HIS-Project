package com.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacollection.entity.Education;

public interface EducationRepo extends JpaRepository<Education, Integer> {

	public Education findByCaseNum(Long caseNum);

}
