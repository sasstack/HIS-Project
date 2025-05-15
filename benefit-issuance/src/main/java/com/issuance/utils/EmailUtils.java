package com.issuance.utils;

import java.io.File;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	
	public boolean sendEmail(String subject, String body, String to, File file) {
		boolean isMailSent = false;
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.addAttachment("His-Eligbility-Notice.xlsx", file);
			mailSender.send(mimeMessage);
			isMailSent = true;
					
		} catch (Exception e) {
			logger.error("Exception Occured while sending Email", e);
		}
		
		return isMailSent;
		
	}

}