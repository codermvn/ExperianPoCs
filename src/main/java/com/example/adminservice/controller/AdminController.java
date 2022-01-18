package com.example.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adminservice.model.AdminRequestDTO;
import com.example.adminservice.service.AdminServiceImpl;

import static com.example.adminservice.constants.WebResourceKeyConstants.*;

@RestController
@RequestMapping(value = BASE_API)
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@GetMapping(value = FETCH_ADMIN_BY_USERNAME)
	public ResponseEntity<?> fetchAdminByUsername(@PathVariable("username") String username) {
		return ResponseEntity.ok(adminService.fetchAdminByUsername(username));
	}
	
	@PostMapping(value = SEARCH)
	public ResponseEntity<?> searchAdmin(@RequestBody AdminRequestDTO requestDTO) {
		return ResponseEntity.ok(adminService.searchAdmin(requestDTO));
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello world!!!";
	}
}
