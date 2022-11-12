package com.quickPay.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.BankAccountDao;
import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.TransactionDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BankException;
import com.quickPay.exception.CustomerException;
import com.quickPay.exception.LoginException;
import com.quickPay.model.BankAccount;
import com.quickPay.model.Customer;
import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;

import com.quickPay.service.WalletService;

import net.bytebuddy.utility.RandomString;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletDao wDao ; 
	
	@Autowired
	private CustomerDao cDao ; 
	
	@Autowired 
	private UserDao udao ;
	
	@Autowired
	private BankAccountDao bankDao;
	
	@Autowired
	private TransactionDao tdao ;
	
	
	
	
	@Override
	public Integer showBalance( String key ) throws CustomerException , LoginException {
		
		Integer userId = udao.findByUuid(key).getUserId();
		
		if(userId != null ) {
			
			Optional<Customer> customer = cDao.findById(userId);
			
			Integer balance = customer.get().getWallet().getBalance().intValue();
			
			return balance ;
		}
		
		 throw new LoginException("Please key is not valid");
		
			
	}

	@Override
	public Transaction fundTransfer(String sourceMobileNo, String targetMobileNumber, Integer amount) throws CustomerException  {
		
	   Customer source =  cDao.findByMobileNumber(targetMobileNumber);
	   Customer target =  cDao.findByMobileNumber(sourceMobileNo);
	   
	   if(source == null ) throw new CustomerException("customer not found with "+ sourceMobileNo);
	   if(target == null ) throw new CustomerException("customer not found with "+ targetMobileNumber);
	   
	   
	   source.getWallet().setBalance(source.getWallet().getBalance() - amount);
	   target.getWallet().setBalance(target.getWallet().getBalance() + amount);
		
	   cDao.save(source);
	   cDao.save(target);
	   
	    Transaction transaction = new Transaction();
		transaction.setTransactionType("Money Transfer");
		transaction.setLocalDate(LocalDate.now());
		transaction.setAmount(amount);
		transaction.setDescription("Fund transfered from "+ source.getName() + " to wallet " + target.getName());
		
		tdao.save(transaction);
	   
		return transaction ; 
	}

	@Override
	public List<Customer> getList() throws CustomerException {
		
		 List<Customer> list =  cDao.findAll();
		 
		 if(list.isEmpty()) throw new CustomerException("No Customer is exist");
		 
		 return list ; 
		
	}

	@Override
	public Customer updateAccount(Customer customer) throws CustomerException {
		
		Integer cId = customer.getCustomerId();
		
		Optional<Customer> founded =  cDao.findById(cId);
		
		
		if(founded.isEmpty()) throw new CustomerException("Customer no founded with " + customer.getCustomerId());
			
		return cDao.save(founded.get());
		
			
	}

	@Override
	public Transaction addMoney( Integer walletId , Integer money , String key ) throws LoginException , BankException {
		
		
		Integer user = udao.findByUuid(key).getUserId();
		
		Optional<Customer> customer = cDao.findById(user);
		
		if(customer.isEmpty() ) throw new LoginException("Customer not found with this key ");
		
		Wallet wallet =  wDao.findByWalletId(walletId);
		
		
		
		
		BankAccount bankAc = wallet.getBankAccount() ; 
		
		
		if(bankAc == null ) throw new BankException("Bank not found Exception");
			
			
		if(bankAc.getBalanace() >= money ) {
			
			bankAc.setBalanace(bankAc.getBalanace() - money );
			wallet.setBalance(wallet.getBalance() + money );
			
			wDao.save(wallet);
			bankDao.save(bankAc);
			
			Transaction transaction = new Transaction();
					transaction.setTransactionType("Money Transfer");
					transaction.setLocalDate(LocalDate.now());
					transaction.setAmount(money);
					transaction.setDescription("Fund transfered from Bank to wallet");
					
					tdao.save(transaction);
					return transaction ;
				
		}else {
			
			throw new  BankException("Insufficient Balance" );
			
		}
		
		
		
	}

	@Override
	public Customer createAccount(String name, String mobileNumber, Double amount) throws BankException {
		
		
		Customer c = new Customer();
		c.setName(name);
		c.setMobileNumber(mobileNumber);
		c.setPassword(RandomString.make(6));
		
		Wallet w = new Wallet();
		c.setWallet(w);
		
		w.setBalance(amount);
		
		
		
//		BankAccount b = new BankAccount();
//		b.setBankName("QuickPay Bank");
//		b.setIFSCCode("QUCK456123");
//		b.setAccountNumber(55 );
//		b.setBalanace(amount+10000);
//		c.getWallet().setBankAccount(b);
//	
		
		
		wDao.save(w);
//		bankDao.save(b);
		return cDao.save(c);
		
		
		
		
	}

	

}
