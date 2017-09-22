package com.eci.ekm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eci.ekm.service.WelcomeService;

@RestController
@RequestMapping("/")
public class WelcomeController {
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Value("${welcomecontroller.msg}")
	private String propertyFileMsg;
	
	@RequestMapping("/welcome")
	public String dynamicConfiguration() {
		return welcomeService.getWelcomeMessage();
	}

}
