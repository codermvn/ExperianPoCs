package com.example.loginservice.responseDTO;

import java.io.Serializable;

public class NetworkResponseDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ipAddress;

    private String macAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
