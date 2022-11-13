package com.quickPay.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickPay.Dao.BankAccountDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BankAccountException;
import com.quickPay.model.BankAccDTO;
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
	public String addAccount(BankAccDTO bankAccount,Integer walletId, String key) {
		
	 User currentUser =  userDao.findByUuid(key);
	 
	 if(currentUser != null) {

		  
			
			
		  Optional<Wallet> wallet = walletdao.findById(walletId);
		   
		  if(wallet.isPresent()) {
			  
			  BankAccount bank = new BankAccount();
			  bank.setAccountNumber(bankAccount.getAccountNumber());
			  bank.setIFSCCode(bankAccount.getIFSCCode());
			  bank.setBankName(bankAccount.getBankName());
			  bank.setBalanace(bankAccount.getBalanace());
			  wallet.get().setBankAccount(bank);
 
		
		
		
		walletdao.save(wallet.get());
			  
			  
		  }else {
			  return "wallet not found";
		  }
		  
		  
		return bankAccount.getBankName()+" is successfully added..";
  }
  
	return "user not found "+walletId;
	
	
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
			
			  Wallet wallet =  bankAccount.get().getWallet();
			
			  wallet.setBankAccount(null);

			if(bankAccount.isPresent()) {
				
				bankAccDao.delete(bankAccount.get());
				
				return bankAccount.get().getBankName()+" succesfully removed";
			}
			else
				throw new BankAccountException("Account  is Not Exist with number "+bankAccount.get());
			  
			  
		}
		
		
		 throw new BankAccountException("Key Invalid");
	}

	

}
