package com.eci.ekm.jpa;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.eci.ekm.jpa.UserRepository;
import com.eci.ekm.dataobject.User;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.eci.ekm.dataobject"})
@EnableJpaRepositories("com.eci.ekm.jpa")
@ComponentScan("com.eci.ekm.dataobject")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
		
	}
	
	@Transactional
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Jack", "Bauer",User.Gender.Male));
			repository.save(new User("ChloaSDadASDadaDe", "O'Brian",User.Gender.Male));
			repository.save(new User("Kim", "Bauer",User.Gender.Male));
			repository.save(new User("David", "Palmer",User.Gender.Male));
			repository.save(new User("Michelle", "Dessler",User.Gender.Female));

			// fetch all customers
			log.info("User found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			User customer = repository.findOne(1L);
			log.info("User found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("User found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (User bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
			
		};
	}

}
