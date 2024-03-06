package com.danggialoc.learn.spring.security.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.danggialoc.learn.spring.security.entity.User;
import com.danggialoc.learn.spring.security.event.RegistrationCompleteEvent;
import com.danggialoc.learn.spring.security.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	private UserService service;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// Create the Verification Token for the User with Link
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		service.saveVerificationTokenUser(token,user);
		//Send Mail to user
		String url = event.getApplicationUrl() + "/user/verifyRegistration?token=" + token;
		//sendVerificationEmail()
		log.info("Click the link to verify your account: {}",url);
	}

}
