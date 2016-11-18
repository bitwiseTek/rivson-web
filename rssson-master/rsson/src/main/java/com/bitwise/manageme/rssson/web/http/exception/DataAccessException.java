package com.bitwise.manageme.rssson.web.http.exception;
/**
 *  
 * @author Sika Kay
 * @date 07/07/16
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class DataAccessException extends Exception {

	private static final long serialVersionUID = -2535531411250430229L;

	private String code;

	public DataAccessException(String message, String code) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}
