package com.eci.ekm.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("welcomeService")
public class WelcomeServiceImpl implements WelcomeService{
	
	public String getWelcomeMessage(){
		return "welcome";
	}

}
