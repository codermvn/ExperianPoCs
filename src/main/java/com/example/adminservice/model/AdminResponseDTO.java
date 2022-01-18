package com.example.adminservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
public class AdminResponseDTO  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String emailAddress;

    private Long id;

    private String password;

    private Character status;

    private Integer loginAttempt;
    
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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public List<String> getRoles() {
		if (CollectionUtils.isEmpty(roles)) {
			roles = new ArrayList<>();
		}
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
