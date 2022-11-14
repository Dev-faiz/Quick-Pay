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
import com.quickPay.model.CustomerDTO;
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
		
	  
	   
	    Transaction transaction = new Transaction();
		transaction.setTransactionType("Debit");
		transaction.setLocalDate(LocalDate.now());
		transaction.setAmount(amount);
		transaction.setDescription("Fund transfered from "+ source.getName() + " to wallet " + target.getName());
		transaction.setWallet(source.getWallet());
		
		cDao.save(source);
		cDao.save(target);
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
	public Customer updateAccount(CustomerDTO customer , String key ) throws CustomerException {
		
		Integer user = udao.findByUuid(key).getUserId();
		
		
		Optional<Customer> founded =  cDao.findById(user);
		
		
		if(founded.isEmpty()) throw new CustomerException("Customer no founded with " + user);
			
		founded.get().setMobileNumber(customer.getMobileNo());
		founded.get().setName(customer.getName());
		founded.get().setPassword(customer.getPassword());
		
		return cDao.save(founded.get());
		
			
	}

	@Override
	public Transaction addMoney( Integer walletId , Integer money , String key ) throws Exception {
		
		
		Integer user = udao.findByUuid(key).getUserId();
		
		Optional<Customer> customer = cDao.findById(user);
		
		if(customer.isEmpty() ) throw new LoginException("Customer not found with this key ");
		
		Optional<Wallet> wallet =  wDao.findByWalletId(walletId);
		
		
		
		
		
		BankAccount bankAc = wallet.get().getBankAccount() ; 
		
		
		if(bankAc == null ) throw new BankException("Bank not found Exception");
			
			
		if(bankAc.getBalanace() >= money ) {
			
			bankAc.setBalanace(bankAc.getBalanace() - money );
			wallet.get().setBalance(wallet.get().getBalance() + money );
			
			
			
			Transaction transaction = new Transaction();
					transaction.setTransactionType("Credit");
					transaction.setLocalDate(LocalDate.now());
					transaction.setAmount(money);
					transaction.setDescription("Fund transfered from Bank to wallet");

//					wallet.getTransaction().add(transaction);
					transaction.setWallet(wallet.get());
					
					try {
						wDao.save(wallet.get());
						bankDao.save(bankAc);
						tdao.save(transaction);
						return transaction ;
					}catch(Exception e) {
						throw new Exception("SQL");
					}
				
				
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
		
		wDao.save(w);
		return cDao.save(c);
		
		
		
		
	}

	

}
