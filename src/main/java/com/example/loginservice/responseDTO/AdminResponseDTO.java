package com.example.loginservice.responseDTO;

import java.io.Serializable;
import java.util.List;

public class AdminResponseDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String emailAddress;

    private Long id;

    private String password;

    private Integer loginAttempt;

    private Character status;
    
    private List<String> roles;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
