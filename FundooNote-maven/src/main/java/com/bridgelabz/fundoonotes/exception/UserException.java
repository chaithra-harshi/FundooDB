package com.bridgelabz.fundoonotes.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * 
 * @author chaithra B N
 *
 */
/*
 * The class for the User Exceptions
 */
@Getter
public class UserException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	HttpStatus httpstatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserException(String message, HttpStatus httpstatus) {
		this.message = message;
		this.httpstatus = httpstatus;
	}
}
