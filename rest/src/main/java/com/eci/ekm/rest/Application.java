package com.eci.ekm.rest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eci.ekm.dataobject.User;
import com.eci.ekm.jpa.UserRepository;
import com.eci.ekm.service.UserService;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.eci.ekm.dataobject"})
@EnableJpaRepositories("com.eci.ekm.jpa")
@ComponentScan("com.eci.ekm")
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		String [] beanNames = ctx.getBeanDefinitionNames();
		//Arrays.stream(beanNames).forEach(System.out::println);
		
	}

	@Profile("dev")
	@Bean
	CommandLineRunner initDB(UserService userService){
		return (runner) -> {
			userService.createUser(new User("Raja","Sekar",User.Gender.Male));
			userService.createUser(new User("Raja1","Sekar1",User.Gender.Female));
		};
	}
	
	
	
	@Profile("prod")
	@Bean
	public String dummy() {
		return "something";
	}
}