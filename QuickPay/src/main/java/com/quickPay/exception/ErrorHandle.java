package com.quickPay.exception;

import java.time.LocalDateTime;

public class ErrorHandle {
	
	private LocalDateTime ldt ; 
	private String message ; 
	private String description ;
	
	
	public LocalDateTime getLdt() {
		return ldt;
	}
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ErrorHandle() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorHandle(LocalDateTime ldt, String message, String description) {
		super();
		this.ldt = ldt;
		this.message = message;
		this.description = description;
	}
	
	
	
}
