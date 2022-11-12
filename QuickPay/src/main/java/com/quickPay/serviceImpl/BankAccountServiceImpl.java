package com.quickPay.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickPay.Dao.BankAccountDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BankAccountException;
import com.quickPay.model.BankAccount;
import com.quickPay.model.User;
import com.quickPay.model.Wallet;
import com.quickPay.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountDao bankAccDao;
	
	@Autowired
	WalletDao walletdao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String addAccount(BankAccount bankAccount, String key) {
		
	 User currentUser =  userDao.findByUuid(key);
		
		if(currentUser == null) {
			
			return "You are not Valid User";
			
		}
		else {
			
			BankAccount bank= bankAccDao.save(bankAccount);
			
			return "BankAccount Has Been Created";
			
			
		}
	
	}
	

	
	@Override
	public BankAccount getAccountByAccountNumber(Integer accountNumber) throws BankAccountException {
	
		Optional<BankAccount> bankAccount = bankAccDao.findById(accountNumber);
		
		if(bankAccount.isPresent()) {
			BankAccount existAccount = bankAccount.get();
			
			return existAccount;
		}else {
			 throw new BankAccountException("No Account Registerd with Account Number "+accountNumber)  ;
		}
		
		
	}

	@Override
	public String removeAccount(Integer accountNumber, String key) throws BankAccountException {
		User currentUser =  userDao.findByUuid(key);
		
		if(currentUser != null) {
			
			Optional<BankAccount> bankAccount = bankAccDao.findById(accountNumber);
			
//			  Wallet wallet =  bankAccount.get().getWallet();
//			
//			  wallet.setBankAccount(null);
			if(bankAccount.isPresent()) {
				
				bankAccDao.delete(bankAccount.get());
				
				return bankAccount.get().getBankName()+" succesfully removed";
			}
			else
				throw new BankAccountException("Account  is Not Exist with number "+bankAccount.get().getAccountNumber());
			  
		}
		
		
		 throw new BankAccountException("Key Invalid");
	}
	

	

}
