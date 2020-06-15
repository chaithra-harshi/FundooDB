package com.bridgelabz.fundoonotes.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * The Class for the Note Exception
 * 
 * @author chaithra B N
 *
 */
@Getter
public class NoteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	HttpStatus httpstatus;

	public NoteException(String message, HttpStatus httpstatus) {
		this.message = message;
		this.httpstatus = httpstatus;
	}

}
