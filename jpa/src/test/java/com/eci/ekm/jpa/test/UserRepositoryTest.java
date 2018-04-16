package com.eci.ekm.jpa.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eci.ekm.dataobject.User.Gender;
import com.eci.ekm.dataobject.User;
import com.eci.ekm.jpa.UserRepositoryImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.eci.ekm.jpa.Application.class)
public class UserRepositoryTest{

	@Autowired
	 private UserRepositoryImpl userRepository;
	 
	 @Test
	 public void testInsertUser(){
		 User user = new User("testfirst", "testSecond",User.Gender.Female);
		 user = userRepository.create(user);
		 user.setFirstName("updatedFirstName");
		 userRepository.update(user, "lastName", "updateLastName");
		 System.out.println("Running the stest method");
	 }
	 
	 

}
