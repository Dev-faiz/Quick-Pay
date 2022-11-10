package com.quickPay.exception;

public class BankAccountNotFound extends Exception {
	
	public BankAccountNotFound() {
		
	}
	
	public BankAccountNotFound(String message) {
		super(message);
	}

}
