package com.quickPay.service;

import java.math.BigDecimal;
import java.util.List;

import com.quickPay.exception.BankException;
import com.quickPay.exception.CustomerException;
import com.quickPay.exception.LoginException;
import com.quickPay.model.Customer;
import com.quickPay.model.CustomerDTO;
import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;

public interface WalletService {
	
	
//	public Wallet save(Wallet w);
	
	public Customer createAccount( String name , String mobileNumber , Double amount ) throws BankException , Exception; 
	
	public Integer showBalance( String key ) throws CustomerException , LoginException ;
	
	public Transaction fundTransfer (String sourceMobileNo, String targetMobileNumber , Integer amount ) throws CustomerException ;
	
	public  List<Customer> getList() throws CustomerException ; 
	
	public  Customer updateAccount(CustomerDTO customer , String key) throws CustomerException  ; 
	
	public Transaction addMoney(Integer wallet , Integer money , String key  ) throws LoginException , BankException, Exception  ; 
	
	

}
