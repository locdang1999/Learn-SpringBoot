package com.danggialoc.learn.Springboot.tutorial.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${wellcome.message}")
	private String wellcomeMessage;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String hellWorld() {
		return wellcomeMessage;
	}
}
