package com.datacollection.binding;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class  ChildrenRequest {
	
	private Long caseNum;
	private List<ChildrenBinding> children;
}
