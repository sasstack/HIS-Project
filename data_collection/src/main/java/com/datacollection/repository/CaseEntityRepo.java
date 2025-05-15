package com.datacollection.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacollection.entity.CaseEntity;

public interface CaseEntityRepo extends JpaRepository<CaseEntity, Long>{

	public Optional<CaseEntity> findByAppId(Integer appId);
}
