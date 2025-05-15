package com.admin.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PlanResponse {

	
	private String name;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	
	private Integer categoryId;
	private Boolean activeSw;
}

//@Id
//@GeneratedValue
//@Column(name = "PLAN_ID")
//private Integer id;
//
//@Column(name = "PLAN_NAME")
//private String name;
//
//@Column(name = "PLAN_START_DATE")
//private LocalDate planStartDate;
//
//@Column(name = "PLAN_END_DATE")
//private LocalDate planEndDate;
//
//@Column(name = "ACTIVE_SW")
//private Boolean activeSw;
//
//@Column(name = "PLAN_CATEGORY_ID")
//private Integer planCategoryId;
//
//@Column(name = "CREATED_BY")
//private String createdBy;
//
//@Column(name = "UPDATED_BY")
//private String updatedBy;
//
//@Column(name = "CREATED_DATE", updatable = false)
//@CreationTimestamp
//private LocalDate createdDate;
//
//@Column(name = "UPDATED_DATE", insertable = false)
//@UpdateTimestamp
//private LocalDate updatedDate;
