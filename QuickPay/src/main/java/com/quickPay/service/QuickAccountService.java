package com.quickPay.service;

import com.quickPay.exception.BankAccountNotFound;
import com.quickPay.model.BankAccount;

public interface QuickAccountService {

	public String addAccount(BankAccount bankAccount,Integer walletId);
	
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountNotFound;

	public String removeAccount(Integer accountNumber,String key)throws BankAccountNotFound;
}
