package com.bitwise.manageme.rssson.web.http.exception;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoSuchRequestHandlingException extends Exception {

	private static final long serialVersionUID = 792535776398102463L;
	
	private String code;

	public NoSuchRequestHandlingException(String message, String code) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
