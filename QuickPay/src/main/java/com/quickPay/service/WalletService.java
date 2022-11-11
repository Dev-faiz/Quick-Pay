package com.quickPay.service;

import java.math.BigDecimal;
import java.util.List;

import com.quickPay.model.Customer;
import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;

public interface WalletService {
	
	
	
	public Customer createAccount( String name , String mobileNumber , BigDecimal amount ) ; 
	
	public Customer showBalance(String mobile )  ;
	
	public Transaction  fundTransfer (String sourceMobileNo, String targetMobileNumber , BigDecimal amount ) ;
	
	public  List<Customer> getList() ; 
	
	public  Customer updateAccount(Customer customer)  ; 
	
	public Customer addMoney(Wallet wallet , Double money )   ; 
    
}
/*

	createAccount(String name , String mobileNumber , BigDecimal amount) return Customer and throws CustomerException
	
	showBalance(String mobile) return Customer and throws CustomerException 
	
	fundTransfer (String sourceMobileNo, String targetMobileNumber , BigDecimal amount ) return Transaction and throws TransactionObject 
	
	getList() returns List<Customer> and throws CustomerException
	
	updateAccount(Customer customer) return Customer and throws CustomerException
	
	addMoney(Wallet wallet , Double money ) return  Customer and throws CustomerException and WalletException 
	
	
	
  */
 