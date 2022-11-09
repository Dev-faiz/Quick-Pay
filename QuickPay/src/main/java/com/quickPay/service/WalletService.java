package com.quickPay.service;

public interface WalletService {

}
/*

	createAccount(String name , String mobileNumber , BigDecimal amount) return Customer and throws CustomerException
	
	showBalance(String mobile) return Customer and throws CustomerException 
	
	fundTransfer (String sourceMobileNo, String targetMobileNumber , BigDecimal amount ) return Transaction and throws TransactionObject 
	
	getList() returns List<Customer> and throws CustomerException
	
	updateAccount(Customer customer) return Customer and throws CustomerException
	
	addMoney(Wallet wallet , Double money ) return  Customer and throws CustomerException and WalletException 
	
	
	
  */
 