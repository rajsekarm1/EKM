package com.eci.ekm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eci.ekm.dataobject.User;
import com.eci.ekm.jpa.UserRepository;

@Service("userService")
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> getAllUsers(){
		Iterable<User> userIterable = repository.findAll();
		List<User> userList = new ArrayList<User>();
		userIterable.forEach(userList::add);
		return userList;
	}
	
	public User createUser(User user){
		User dbUser = repository.save(user);
		return dbUser;
	}
	
	
}
