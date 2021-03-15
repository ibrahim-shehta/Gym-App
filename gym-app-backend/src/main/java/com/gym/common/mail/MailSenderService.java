package com.gym.common.mail;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;



@Component
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;

	void sendSimpleEmail(String title, String message, String[] to) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(title);
		msg.setText(message);
		javaMailSender.send(msg);
	}

	@Async
	public void resetPassword(String to, String link, String name) throws MessagingException {
		Context context = new Context();
		context.setVariable("link", link);
		context.setVariable("name", name);
		String process = templateEngine.process("emails/resetpassword", context);
		javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Welcome Mr.Gym Password");
		helper.setText(process, true);
		helper.setTo(to);
        javaMailSender.send(mimeMessage);
        System.out.println("Reset Mail To --> " + to + " --" + new Date());
	}
	
}
