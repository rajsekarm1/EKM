package com.eci.ekm.rest.controller;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public String debugMessage() {
		// TODO Auto-generated method stub
		return "Debug Message";
	}

}
