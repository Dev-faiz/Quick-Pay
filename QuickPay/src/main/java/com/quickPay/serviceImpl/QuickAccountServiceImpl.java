package com.quickPay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BankAccountNotFound;
import com.quickPay.model.BankAccount;
import com.quickPay.service.QuickAccountService;

public class QuickAccountServiceImpl implements QuickAccountService {

	@Autowired
	private WalletDao wallet;
	
	@Autowired
	private CustomerDao cd ; 
	
	
	
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
