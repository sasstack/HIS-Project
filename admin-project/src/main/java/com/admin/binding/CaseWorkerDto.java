package com.admin.binding;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CaseWorkerDto {

	private String fullName;

	private String email;

	private Long mobile;

	private String gender;

	private LocalDate dateOfBirth;

	private Long ssn;
}

