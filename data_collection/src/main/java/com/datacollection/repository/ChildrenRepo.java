package com.datacollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacollection.entity.Children;

public interface ChildrenRepo extends JpaRepository<Children, Integer>{

	List<Children> findByCaseNum(Long caseNum);

}
