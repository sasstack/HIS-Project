package com.admin.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.admin.Entity.CaseWorker;
import com.admin.binding.ActivateAccount;
import com.admin.binding.CaseWorkerDto;
import com.admin.binding.LoginRequest;
import com.admin.binding.RegistrationRequest;
import com.admin.repository.CaseWorkerRepo;
import com.admin.utils.EmailUtils;

import jakarta.transaction.Transactional;

@Service
public class CaseWorkerServiceImpl implements CaseWorkerService {

	private CaseWorkerRepo repo;
	private EmailUtils emailUtils;
	Logger logger = LoggerFactory.getLogger(CaseWorkerServiceImpl.class);
	

	public CaseWorkerServiceImpl(CaseWorkerRepo repo, EmailUtils emailUtils) {
		super();
		this.repo = repo;
		this.emailUtils = emailUtils;
	}

	@Override
	@Transactional
	public Boolean registerCaseWorker(RegistrationRequest registrationRequest) {
		CaseWorker worker = new CaseWorker();
		BeanUtils.copyProperties(registrationRequest, worker);
		worker.setAccStatus("In-Active");
		worker.setPassword(generateRandomPwd());
		 CaseWorker caseWorker = repo.save(worker);
		Boolean sendEmail=false;
		if (caseWorker.getUserId()!=null) {
			String subject = "Registration successful!";
			String fileName = "email-template.html";
			String body = readEmailBody(worker.getFullName(),worker.getPassword(),fileName);
			sendEmail = emailUtils.sendEmail(worker.getEmail(), subject, body);
		}
		return sendEmail;
	}

	

	@Override
	public String activateCaseWorker(ActivateAccount activateAccount) {
		Optional<CaseWorker> byEmail = repo.findByEmail(activateAccount.getEmail());
		
		if (byEmail.isPresent()) {
			CaseWorker worker = byEmail.get();
			if (activateAccount.getTempPassword().equals(worker.getPassword())) {
				if (activateAccount.getNewPassword().equals(activateAccount.getConfirmPassword())) {
					worker.setAccStatus("Active");
					worker.setPassword(activateAccount.getNewPassword());
					repo.save(worker);
					return "Account successfully activated";
				}else {
					return "New password and confirm password donot match";
				}
			}else {
				return "Wrong credentials";
			}
		}else {
			return "Email does not exist please register";
		}
	}

	@Override
	public List<CaseWorkerDto> getAllCaseWorkers() {
		List<CaseWorkerDto> workers = new ArrayList<>();
		List<CaseWorker> allWorkers = repo.findAll();
		for (CaseWorker worker : allWorkers) {
			CaseWorkerDto response = new CaseWorkerDto();
			BeanUtils.copyProperties(worker, response);
			workers.add(response);
		}
		return workers;
	}

	@Override
	public CaseWorkerDto getCaseWorkerById(Integer userId) {
		Optional<CaseWorker> byId = repo.findById(userId);
		
		if (byId.isPresent()) {
			CaseWorkerDto response = new CaseWorkerDto();
			CaseWorker worker = byId.get();
			BeanUtils.copyProperties(worker, response);
			return response;
		}
		return null;
	}

	@Override
	public CaseWorkerDto getCaseWorkerByEmail(String email) {
		Optional<CaseWorker> byEmail = repo.findByEmail(email);
		if (byEmail.isPresent()) {
			CaseWorkerDto response = new CaseWorkerDto();
			CaseWorker user = byEmail.get();
			BeanUtils.copyProperties(user, response);
			return response;
		}
		return null;
	}

	@Override
	public boolean deleteCaseWorkerById(Integer userId) {
		try {
			if (repo.existsById(userId)) {
				repo.deleteById(userId);
				return true;
			}
			 return false;
		} catch (Exception e) {
			logger.error("Exception Occured",e);
			return false;
		}		
	}

	@Override
	public boolean changeAccountStatus(Integer userId, String accStatus) {
		Optional<CaseWorker> byId = repo.findById(userId);
		if (byId.isPresent()) {
			CaseWorker worker = byId.get();
			worker.setAccStatus(accStatus);
			repo.save(worker);
			return true;
		}
		return false;
	}

	@Override
	public String login(LoginRequest loginRequest) {
		Optional<CaseWorker> byEmail = repo.findByEmail(loginRequest.getEmail());
				
				if (byEmail.isEmpty()) {
					return "Account does not exist please register";
				}
				CaseWorker worker = byEmail.get();
				if (worker.getAccStatus().equals("In-Active")) {
					return "Account is not activated please activate and tr logging in";
				}
				if(!worker.getPassword().equals(loginRequest.getPassword())) {
					return "Wrong credentials";
				}
					return "Successfully logged in";
	}

	@Override
	public String forgotPassword(String email) {
		Optional<CaseWorker> byEmail = repo.findByEmail(email);
		
		if (byEmail.isEmpty()) {
			return "Account does not exist please register";
		}
		CaseWorker worker = byEmail.get();
		String fileName = "recover-pwd-body.txt";
		String body = readEmailBody(worker.getFullName(), worker.getPassword(), fileName);
		String subject= "Password recovery";
		boolean sendEmail = emailUtils.sendEmail(worker.getEmail(), subject, body);
//		if (user.getAccStatus().equals("In-Active")) {
//			return "Account is not activated please activate and try logging in";
//		}
		
			if(sendEmail) {
				return "Password sent to your registered mail";
			}
			return null;
	}
	
	private String readEmailBody(String fullName, String password, String fileName) {
		String url="http://localhost:8080/activate";
		String mailBody="";
		
		try (
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				){
			StringBuilder bodyBuilder = new StringBuilder();
			String line = bufferedReader.readLine();
			
			while (line != null) {
				bodyBuilder.append(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			mailBody = bodyBuilder.toString();
			mailBody = mailBody.replace("${name}", fullName);
			mailBody = mailBody.replace("${tempPassword}", password);
			mailBody = mailBody.replace("${activationLink}", url);
//			activationLink
			System.out.println(mailBody);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return mailBody;
	}
	
	private String generateRandomPwd() {
		final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	    final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
	    final String DIGITS = "0123456789";
	    final String SPECIAL_CHARS = "!@#$%^&*()_-+=<>?";
	    final String ALL_CHARS = CHAR_LOWERCASE + CHAR_UPPERCASE + DIGITS + SPECIAL_CHARS;
	    
	    int length=8;
		StringBuilder password = new StringBuilder();
		Random random = new Random();
		
		password.append(CHAR_LOWERCASE.charAt(random.nextInt(CHAR_LOWERCASE.length())));
		password.append(CHAR_UPPERCASE.charAt(random.nextInt(CHAR_UPPERCASE.length())));
		password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
		password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
		
		for(int i=4; i<length; i++) {
//			ALL_CHARS[0];
			System.out.println(password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length()))));
		}
		char[] passwordArray = password.toString().toCharArray();
		
		for (int i = 0; i < passwordArray.length; i++) {
			int index = random.nextInt(passwordArray.length);
			
			char temp = passwordArray[i];
			passwordArray[i]= passwordArray[index];
			passwordArray[index] = temp;
		}
		
		return password.toString();
		}

}
