package com.admin.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PLAN_MASTER")
public class Plan {

	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer id;

	@Column(name = "PLAN_NAME")
	private String name;

	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;

	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;

	@Column(name = "ACTIVE_SW")
	private Boolean activeSw;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;

 

}
