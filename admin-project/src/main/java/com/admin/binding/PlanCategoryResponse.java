package com.admin.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlanCategoryResponse {
	
	
	private String categoryName;
	private Boolean activeSw;
}
