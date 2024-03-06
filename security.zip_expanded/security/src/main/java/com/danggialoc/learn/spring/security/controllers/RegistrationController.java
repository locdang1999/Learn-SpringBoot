package com.danggialoc.learn.spring.security.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danggialoc.learn.spring.security.entity.User;
import com.danggialoc.learn.spring.security.entity.VerificationToken;
import com.danggialoc.learn.spring.security.event.RegistrationCompleteEvent;
import com.danggialoc.learn.spring.security.model.PassworldModel;
import com.danggialoc.learn.spring.security.model.UserModel;
import com.danggialoc.learn.spring.security.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class RegistrationController {

	@Autowired
	private UserService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel data, final HttpServletRequest request) {

		User user = service.registerUser(data);
		publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));

		return "Success";
	}

	@GetMapping("/verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token) {
		String result = service.validateVerificationToken(token);
		if (result.equalsIgnoreCase("valid")) {
			return "User Verifies Successfully!!";
		}
		return "Bad User";
	}

	@GetMapping("/resendVerifyToken")
	public String resendverificationToken(@RequestParam("token") String oldToken, HttpServletRequest request) {
		VerificationToken verificationToken = service.generateNewVerificationToken(oldToken);
		User user = verificationToken.getUser();
		resendVerificationTokenMail(user, applicationUrl(request), verificationToken);
		return "Verification Link Sent";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody PassworldModel passworldModel, HttpServletRequest request) {
		User user = service.findUserByEmail(passworldModel.getEmail());
		String url = "";
		if (user != null) {
			String token = UUID.randomUUID().toString();
			service.createPasswordReserTokenForUser(user,token);
			url = passwordResetTokenMail(user,applicationUrl(request),token);
		}
		return url;
	}
	
	@PostMapping("/savePassword")
	public String savePassword(@RequestParam("token") String token, @RequestBody PassworldModel passwordModel) {
		String result = service.validatePasswordResetToken(token);
		if(!result.equalsIgnoreCase("valid")) {
			return "Invalid Token";
		}
		Optional<User> user = service.getUserByPasswordResetToken(token);
		if(user.isPresent()) {
			service.changePassword(user.get(), passwordModel.getNewPassword());
			return "Password Reset Successfully!!";
		}else {
			return "ds";
		}
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody PassworldModel passworldModel) {
		User user = service.findUserByEmail(passworldModel.getEmail());
		if(!service.checkIfvalidOldPassword(user,passworldModel.getOldPassword())) {
			return "Invalid Old Password";
		}
		//Save New Password
		service.changePassword(user, passworldModel.getNewPassword());
		return "Password Chanfed Successfully";
	}

	private String passwordResetTokenMail(User user, String applicationUrl, String token) {
		// TODO Auto-generated method stub
		String url = applicationUrl + "/user/savePassword?token=" + token;
		log.info("Click the link to Reset your Password: {}", url);
		return url;
	}

	private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
		// TODO Auto-generated method stub
		String url = applicationUrl + "/user/verifyRegistration?token=" + verificationToken.getToken();
		log.info("Click the link to verify your account: {}", url);
	}

	private String applicationUrl(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
}
