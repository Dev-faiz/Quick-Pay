package com.quickPay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.quickPay.exception.BankAccountNotFound;
import com.quickPay.model.BankAccount;
import com.quickPay.model.Wallet;
import com.quickPay.service.QuickAccountService;

public class QuickAccountServiceImpl implements QuickAccountService {

	@Autowired
	private Wallet wallet;
	
	
	
	
	
	
	@Override
	public String addAccount(BankAccount bankAccount, Integer walletId) {
	
		return null;
	}
	
	
	

	@Override
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountNotFound {

		return null;
	}
	
	
	

	@Override
	public String removeAccount(Integer accountNumber, String key) throws BankAccountNotFound {
	
		
		
		return null;
	}

	
	
}
