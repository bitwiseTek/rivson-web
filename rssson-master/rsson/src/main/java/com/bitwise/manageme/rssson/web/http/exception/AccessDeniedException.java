package com.bitwise.manageme.rssson.web.http.exception;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
public class AccessDeniedException extends Exception {

	private static final long serialVersionUID = -6437777506553150499L;
	
	private String code;

	public AccessDeniedException(String message, String code) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
