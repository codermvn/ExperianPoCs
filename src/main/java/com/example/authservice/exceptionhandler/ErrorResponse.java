package com.example.authservice.exceptionhandler;


import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;
    private String errorMsg;
    private String developerMsg;
    
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
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
    
    
}



