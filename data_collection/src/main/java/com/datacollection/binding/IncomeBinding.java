package com.datacollection.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class IncomeBinding {

	private Long caseNum;
	private Double empIncome;
	private Double propertyIncome;
}
