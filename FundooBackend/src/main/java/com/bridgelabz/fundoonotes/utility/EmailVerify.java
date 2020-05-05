package com.bridgelabz.fundoonotes.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailVerify {
	
//	private Logger log = LoggerFactory.getLogger(EmailVerify.class);

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendVerifyMail(String email, String token) throws MailException {
//		System.out.println("email" + email);
	//	log.info("verification mail");
		System.out.println("verification mail");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("chaithrabn96@gmail.com");
		mail.setTo(email);
		mail.setSubject("verify user");
		mail.setText("click here..." + token);

		mailsender.send(mail);
	}
	
	public void sendForgetPasswordMail(String email, String token) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("chaithrabn96@gmail.com");
		mail.setTo(email);
		mail.setSubject("Forget password link");
		mail.setText("click here..." + token);

		mailsender.send(mail);
	}
	
}
