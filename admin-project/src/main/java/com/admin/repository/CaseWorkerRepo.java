package com.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.Entity.CaseWorker;

public interface CaseWorkerRepo extends JpaRepository<CaseWorker, Integer>{

	Optional<CaseWorker> findByEmail(String email);

}
