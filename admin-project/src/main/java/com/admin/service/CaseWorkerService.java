package com.admin.service;

import java.util.List;

import com.admin.binding.ActivateAccount;
import com.admin.binding.CaseWorkerDto;
import com.admin.binding.LoginRequest;
import com.admin.binding.RegistrationRequest;

public interface CaseWorkerService {
	
	
	public Boolean registerCaseWorker(RegistrationRequest registrationRequest);
	
	public String activateCaseWorker(ActivateAccount activateAccount);
	
	public List<CaseWorkerDto> getAllCaseWorkers();
	
	public CaseWorkerDto getCaseWorkerById(Integer userId);
	
	public CaseWorkerDto getCaseWorkerByEmail(String email);
	
	public boolean deleteCaseWorkerById(Integer userId);
	
	public boolean changeAccountStatus(Integer userId, String accStatus);
	
	public String login(LoginRequest loginRequest);
	
	public String forgotPassword(String email);
	

}
