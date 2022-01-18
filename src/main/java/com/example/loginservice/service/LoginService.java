package com.example.loginservice.service;

import com.example.loginservice.requestDTO.LoginRequestDTO;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

     String login(LoginRequestDTO requestDTO, HttpServletRequest request);

}
