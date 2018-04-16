package com.eci.ekm.jpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.eci.ekm.dataobject.User;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	UserRepositoryImpl userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
		
	}
	

	@Bean
	public CommandLineRunner demo(UserRepositoryImpl repository) {
		return (args) -> {
			// save a couple of customers
//			repository.create(new User("Jack", "Bauer",User.Gender.Male));
//			repository.create(new User("ChloaSDadASDadaDe", "O'Brian",User.Gender.Male));
//			repository.create(new User("Kim", "Bauer",User.Gender.Male));
//			repository.create(new User("David", "Palmer",User.Gender.Male));
//			repository.create(new User("Michelle", "Dessler",User.Gender.Female));
//				
//			repository.getAllEntity().stream().forEach(data -> {
//				log.debug("the user value:",data);
//			});
		};
	}

}
