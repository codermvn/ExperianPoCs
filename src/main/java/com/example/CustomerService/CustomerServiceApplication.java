package com.example.CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
@EntityScan("com.example.model")
//@ComponentScan(basePackages = {"com.example.demo.base.model", "com.example.CustomerService.Model"})
//@EnableJpaRepositories(basePackages = "com.example.CustomerService.Repository")
//@EnableTransactionManagement
//@ComponentScan(basePackages = "com.example.model")
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}