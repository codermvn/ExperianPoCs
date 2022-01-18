package com.example.loginservice.requestDTO;

import java.io.Serializable;

public class LoginRequestDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userCredential;
	
	private String username;

    private String password;

    private Long subDepartmentId;

	public String getUserCredential() {
		return userCredential;
	}

	public void setUserCredential(String userCredential) {
		this.userCredential = userCredential;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSubDepartmentId() {
		return subDepartmentId;
	}

	public void setSubDepartmentId(Long subDepartmentId) {
		this.subDepartmentId = subDepartmentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
