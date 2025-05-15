package com.datacollection.service;

import java.util.Map;

import com.datacollection.binding.CaseResponse;
import com.datacollection.binding.ChildrenRequest;
import com.datacollection.binding.EducationBinding;
import com.datacollection.binding.IncomeBinding;
import com.datacollection.binding.PlanSelectionBinding;
import com.datacollection.binding.SummaryBinding;

public interface DataCollectionService {
	
	public Map<Integer, String> getPlans();
	
	public SummaryBinding getSummary(Long caseNum);
	
	public CaseResponse getCaseEntity(Long caseNum);
	
	public Long loadCaseNum(Integer appId);
	
	public Long saveChildrenData(ChildrenRequest childrenBinding);
	
	public Long saveEducationData(EducationBinding educationBinding);
	
	public Long saveIncomeData(IncomeBinding incomeBinding);
	
	public Long savePlanSelection(PlanSelectionBinding selectionBinding);
	
}
