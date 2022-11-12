package com.quickPay.service;

import com.quickPay.exception.BankAccountException;
import com.quickPay.model.BankAccount;

public interface BankAccountService {
	
	public String addAccount(BankAccount bankAccount,String key);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountException;

	public String removeAccount(Integer accountNumber,String key)throws BankAccountException;

}
