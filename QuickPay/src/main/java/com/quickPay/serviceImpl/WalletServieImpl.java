package com.quickPay.serviceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.model.Customer;
import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;
import com.quickPay.service.WalletService;

@Service
public class WalletServieImpl implements WalletService {

	@Autowired
	private WalletDao wd ; 
	
	@Autowired
	private CustomerDao cd ; 
	
	@Override
	public Customer createAccount(String name, String mobileNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showBalance(String mobile) {
		
		Customer customer =  cd.findCustomerBymobileNumber(mobile);
		
		BigDecimal bd =  customer.getWallet().getBalance();
		
		
		return customer ; 
	}

	
	
	@Override
	public Transaction fundTransfer(String sourceMobileNo, String targetMobileNumber, BigDecimal amount) {
	
		Customer source =  cd.findCustomerBymobileNumber(sourceMobileNo);
		
				 BigDecimal sourceBalance = source.getWallet().getBalance(); 
				 					
		Customer target =  cd.findCustomerBymobileNumber(targetMobileNumber);
		
		 		BigDecimal targetBalance = source.getWallet().getBalance(); 
		
		source.getWallet().setBalance(sourceBalance.subtract(amount));
		target.getWallet().setBalance(targetBalance.add(amount));
		
		cd.save(source);
		cd.save(target);
		
		
		
		
		
		return new Transaction();
	}

	@Override
	public List<Customer> getList() {
		
		List<Customer> listOfCustomer =  cd.findAll();
		
//		if(listOfCustomer.isEmpty()) throw Exception();
		
		return listOfCustomer;
	}

	@Override
	public Customer updateAccount(Customer customer) {
		
		Optional<Customer> foundedCustomer =  cd.findById(customer.getCustomerId());
		
		if( foundedCustomer.isEmpty() ) ;
		
		Customer updated =  cd.save(customer);
		
		return updated ; 
		
	}

	@Override
	public Customer addMoney(Wallet wallet, Double money) {
		
		
		
		
		return null;
	}

}
