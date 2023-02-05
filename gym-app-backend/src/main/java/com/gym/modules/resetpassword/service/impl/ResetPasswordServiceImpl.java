package com.gym.modules.resetpassword.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gym.common.constant.MessagesKeys;
import com.gym.common.exception.exceptions.BusinessException;
import com.gym.common.mail.MailSenderService;
import com.gym.modules.resetpassword.dto.ResetPasswordRepository;
import com.gym.modules.resetpassword.model.ResetPassword;
import com.gym.modules.resetpassword.service.ResetPasswordService;
import com.gym.user.model.User;
import com.gym.user.service.UserService;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Value("${app.reset.password.expiration}")
	private int expirationMinutes;
	
	@Value("${app.reset.password.link}")
	private String resetLink;

	@Autowired
	private ResetPasswordRepository resetPasswordRepository;

	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService<User, Long> userService;

	@Override
	public void generateResetPassword(User user) {
		ResetPassword resetPassword = new ResetPassword();
		resetPassword.setCode(UUID.randomUUID().toString());
		resetPassword.setCreationDate(new Date());
		resetPassword.setUser(user);
		resetPassword.setExpireDate(addMinutesToCurrentDate());
		resetPassword = resetPasswordRepository.save(resetPassword);
		// send email to user
		try {
			mailSenderService.resetPassword(user.getEmail(),
					resetLink + resetPassword.getCode() + "-" + resetPassword.getId(), user.getName());
			// mailSenderService.sendMail(user);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void verifyResetPasswordCode(String code, String password) {
		Long id = Long.parseLong(code.substring(code.lastIndexOf("-") + 1));
		String uuidCode = code.substring(0, code.lastIndexOf("-"));
		Optional<ResetPassword> resetPass = resetPasswordRepository.findByIdAndCode(id, uuidCode);
		ResetPassword resetPassword = new ResetPassword();
		if (resetPass.isPresent()) {
			resetPassword = resetPass.get();
			if (resetPassword.isExpired()) {
				throw new BusinessException(MessagesKeys.RESET_PASSWORD_CODE_EXPIRED);
			} else if (resetPassword.getExpireDate().before(new Date())) {
				throw new BusinessException(MessagesKeys.RESET_PASSWORD_DATE_EXPIRED);
			}
			
			resetPassword.setExpired(true);
			resetPasswordRepository.save(resetPassword);
			userService.updateUserPassword(passwordEncoder.encode(password), resetPassword.getUser().getId());
			
		} else {
			throw new BusinessException(MessagesKeys.RESET_PASSWORD_CODE_NOT_FOUND);
		}
	}

	private Date addMinutesToCurrentDate() {
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.MINUTE, expirationMinutes);
		Date newDate = currentDate.getTime();
		return newDate;
	}
}
