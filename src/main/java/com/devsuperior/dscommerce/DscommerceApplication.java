package com.devsuperior.dscommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.devsuperior.dscommerce.entities.User;

@SpringBootApplication
public class DscommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DscommerceApplication.class, args);
		User user = new User();
		System.out.println("User: " + user);
	}

}
