package com.example.adminservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.adminservice.model.Admin;
import com.example.adminservice.repository.AdminRepository;

@Component
public class ApplicationStartUp {
	
	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private StartupProperties startupProperties;
	
	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
			List<Admin> admins = repository.findAll();
			
			if (ObjectUtils.isEmpty(admins)) {
				
				Admin admin  = new Admin();
				admin.setUsername(startupProperties.getUsername());
				admin.setPassword(BCrypt.hashpw(startupProperties.getPassword(), BCrypt.gensalt()));
				admin.setRoles(Arrays.asList("ADMIN"));
				admin.setStatus(startupProperties.getStatus());
				
				this.repository.save(admin);
			}
				
		};
	}
}
