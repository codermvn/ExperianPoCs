package com.example.adminservice.service;
import java.util.List;

import com.example.adminservice.model.Admin;
import com.example.adminservice.model.AdminRequestDTO;
import com.example.adminservice.model.AdminResponseDTO;
import com.example.adminservice.model.ResponseDTO;

public interface AdminService {

    void saveAdmin(AdminRequestDTO requestDTO);

    AdminResponseDTO searchAdmin(AdminRequestDTO requestDTO);

    Admin updateAdmin(AdminRequestDTO requestDTO);

    AdminResponseDTO fetchAdminByUsername(String username);

    ResponseDTO adminsToSendEmails();

    List<Admin> fetchAllAdmins();
}
