package com.example.loginservice.exception;


import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMsg;

    private String developerMsg;

    private HttpStatus responseStatus;

    private int responseCode;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDeveloperMsg() {
		return developerMsg;
	}

	public void setDeveloperMsg(String developerMsg) {
		this.developerMsg = developerMsg;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
    
    
}



