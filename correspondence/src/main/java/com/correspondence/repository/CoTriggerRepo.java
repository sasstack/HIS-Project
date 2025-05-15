package com.correspondence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.correspondence.entity.CoTrigger;

public interface CoTriggerRepo extends JpaRepository<CoTrigger, Integer>{

	public Optional<CoTrigger>  findByCaseNum(Long caseNum);
	public List<CoTrigger>  findByTrgStatus(String trgStatus);
}
