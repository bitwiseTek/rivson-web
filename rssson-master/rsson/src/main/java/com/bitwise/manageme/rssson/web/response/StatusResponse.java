package com.bitwise.manageme.rssson.web.response;
/**
 *  
 * @author Sika Kay
 * @date 10/09/16
 *
 */
import java.util.ArrayList;
import java.util.List;

public class StatusResponse {

	private Boolean success;
	
	private List<String> messages;
	
	public StatusResponse() {
		this.messages = new ArrayList<String>();
	}
	
	public StatusResponse(Boolean success) {
		super();
		this.success = success;
		this.messages = new ArrayList<String>();
	}
	
	public StatusResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.messages = new ArrayList<String>();
		this.messages.add(message);
	}
	
	public StatusResponse(Boolean success, List<String> messages) {
		super();
		this.success = success;
		this.messages = messages;
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String msg : messages) {
			sb.append(msg + ", ");
		}
		
		return "StatusResponse [success=" + success + ",  messages="  + sb.toString() + "]";
	}
} 
