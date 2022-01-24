package com.example.CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EntityScan("com.example.CustomerService.model")
//@ComponentScan(basePackages = {"com.example.demo.base.model", "com.example.CustomerService.Model"})
//@EnableJpaRepositories(basePackages = "com.example.CustomerService.Repository")
//@EnableTransactionManagement
@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}