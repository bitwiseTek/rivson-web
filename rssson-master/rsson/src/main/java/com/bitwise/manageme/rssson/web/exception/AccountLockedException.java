package com.bitwise.manageme.rssson.web.exception;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class AccountLockedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public AccountLockedException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
