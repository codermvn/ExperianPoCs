package com.example.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.adminservice.model.Admin;
import com.example.adminservice.model.AdminRequestDTO;
import com.example.adminservice.model.AdminResponseDTO;
import com.example.adminservice.model.ResponseDTO;
import com.example.adminservice.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repository;
	
	@Override
	public void saveAdmin(AdminRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminResponseDTO searchAdmin(AdminRequestDTO requestDTO) {
		Admin admin = repository.findByUsername(requestDTO.getUsername());
		
		AdminResponseDTO responseDTO = new AdminResponseDTO();
		responseDTO.setEmailAddress(admin.getEmailAddress());
		responseDTO.setId(admin.getId());
		responseDTO.setLoginAttempt(admin.getLoginAttempt());
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();  
		boolean isPasswordMatches = bcrypt.matches(
				requestDTO.getPassword(),
		        admin.getPassword()
		);
		
		if (isPasswordMatches) {
			responseDTO.setPassword(requestDTO.getPassword());
		}
		
		responseDTO.setStatus(admin.getStatus());
		responseDTO.getRoles().add(admin.getRoles().get(0));
		return responseDTO;
	}

	@Override
	public Admin updateAdmin(AdminRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminResponseDTO fetchAdminByUsername(String username) {
		Admin admin = repository.findByUsername(username);
		
		AdminResponseDTO responseDTO = new AdminResponseDTO();
		responseDTO.setEmailAddress(admin.getEmailAddress());
		responseDTO.setId(admin.getId());
		responseDTO.setLoginAttempt(admin.getLoginAttempt());
		responseDTO.getRoles().add(admin.getRoles().get(0));
		responseDTO.setStatus(admin.getStatus());
		responseDTO.setPassword(admin.getPassword());
		return responseDTO;
	}

	@Override
	public ResponseDTO adminsToSendEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> fetchAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
