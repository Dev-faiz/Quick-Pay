package com.quickPay.service;

import java.math.BigDecimal;

import com.quickPay.model.Customer;

public interface WalletService {
	
	
	
	public Customer createAccount( String name , String mobileNumber , BigDecimal amount ) ; 
	
	public Customer showBalance(String mobile )  ;

}
/*

	createAccount(String name , String mobileNumber , BigDecimal amount) return Customer and throws CustomerException
	
	showBalance(String mobile) return Customer and throws CustomerException 
	
	fundTransfer (String sourceMobileNo, String targetMobileNumber , BigDecimal amount ) return Transaction and throws TransactionObject 
	
	getList() returns List<Customer> and throws CustomerException
	
	updateAccount(Customer customer) return Customer and throws CustomerException
	
	addMoney(Wallet wallet , Double money ) return  Customer and throws CustomerException and WalletException 
	
	
	
  */
 