package com.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.binding.ActivateAccount;
import com.admin.binding.CaseWorkerDto;
import com.admin.binding.RegistrationRequest;
import com.admin.service.CaseWorkerServiceImpl;


@RestController
public class CaseWorkerController {

	public CaseWorkerController(CaseWorkerServiceImpl impl) {
		super();
		this.impl = impl;
	}

	private CaseWorkerServiceImpl impl;

	@PostMapping("/register")
	public ResponseEntity<String> registerCaseWorker(@RequestBody RegistrationRequest registrationRequest) {
		boolean registerUser = impl.registerCaseWorker(registrationRequest);
		if (registerUser) {
			return ResponseEntity.ok("Registration Success");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration Failed");
		}
	}

	@PostMapping("/activate")
	public ResponseEntity<String> activateCaseWorker(@RequestBody ActivateAccount activateAccount) {
		String activateUser = impl.activateCaseWorker(activateAccount);
		switch (activateUser) {
		case "Account successfully activated":
			return ResponseEntity.ok(activateUser);
		case "New password and confirm password donot match":
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(activateUser);
		case "Wrong credentials":
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(activateUser);
		case "Email does not exist please register":
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(activateUser);
		default:
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
		}
	}

	@GetMapping("/caseWorker")
	public ResponseEntity<List<CaseWorkerDto>> getAllCaseWorkers() {
		List<CaseWorkerDto> allUsers = impl.getAllCaseWorkers();

		if (allUsers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(allUsers);
	}

	@GetMapping("/caseWorker/{userId}")
	public ResponseEntity<CaseWorkerDto> getCaseWorkerById(@PathVariable Integer userId) {
		CaseWorkerDto response = impl.getCaseWorkerById(userId);

		if (response != null) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // or a message object if you want
		}
	}

	@DeleteMapping("/caseWorker/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		boolean isDeleted = impl.deleteCaseWorkerById(userId);

		if (isDeleted) {
			return ResponseEntity.ok("User deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + userId);
	}

//	public boolean changeAccountStatus(Integer userId, String accStatus) {
//		
//		return false;
//	}
//
//	public String login(LoginRequest loginRequest) {
//		return "null";
//	}
//
//	public String forgotPassword(String email) {
//		
//				return "null";
//			
//	}

}
