package com.datacollection.binding;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponse {

	
	private Long caseNum;
	
	Map<Integer, String> planNames;

}
