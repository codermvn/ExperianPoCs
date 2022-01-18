package com.example.loginservice.controller;

import static org.springframework.http.ResponseEntity.ok;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginservice.constants.WebResourceKeyConstants;
import com.example.loginservice.requestDTO.LoginRequestDTO;
import com.example.loginservice.service.LoginService;

@RestController
@RequestMapping(value = WebResourceKeyConstants.BASE_API)
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = WebResourceKeyConstants.LOGIN)
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO requestDTO, HttpServletRequest request) {
        return ok().body(loginService.login(requestDTO, request));
    }

    @GetMapping("/test")
    public String test() {
        return "test done";
    }
}
