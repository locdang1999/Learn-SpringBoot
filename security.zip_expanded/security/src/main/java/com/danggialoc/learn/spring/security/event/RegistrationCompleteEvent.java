package com.danggialoc.learn.spring.security.event;

import org.springframework.context.ApplicationEvent;

import com.danggialoc.learn.spring.security.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private String applicationUrl;

	public RegistrationCompleteEvent(User user, String applicationUrl) {
		super(user);
		// TODO Auto-generated constructor stub
		this.user = user;
		this.applicationUrl = applicationUrl;
	}

}
