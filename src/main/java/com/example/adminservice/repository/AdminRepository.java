package com.example.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adminservice.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	Admin findByUsername(String username);
}
