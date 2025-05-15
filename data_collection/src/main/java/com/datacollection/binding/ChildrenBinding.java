package com.datacollection.binding;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class ChildrenBinding {

	private String childName;
	private Long caseNum;
	private Integer childAge;
	private Long childSsn;
}
