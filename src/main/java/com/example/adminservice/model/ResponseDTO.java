package com.example.adminservice.model;

import java.io.Serializable;
import java.util.List;
public class ResponseDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<AdminResponseDTO> adminResponseDTOS;

    private String message;

	public List<AdminResponseDTO> getAdminResponseDTOS() {
		return adminResponseDTOS;
	}

	public void setAdminResponseDTOS(List<AdminResponseDTO> adminResponseDTOS) {
		this.adminResponseDTOS = adminResponseDTOS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
