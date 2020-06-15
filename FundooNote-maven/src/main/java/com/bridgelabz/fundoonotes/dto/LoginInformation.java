package com.bridgelabz.fundoonotes.dto;

import lombok.Data;

/**
 * 
 * @author chaithra B N
 *
 */
@Data
public class LoginInformation {
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;

}
