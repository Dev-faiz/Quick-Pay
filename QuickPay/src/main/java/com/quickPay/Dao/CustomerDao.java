package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.Customer;
import com.quickPay.model.Wallet;

public interface CustomerDao  extends JpaRepository<Customer, Integer> {

	public Customer	findByMobileNumber(String mobile);
	
	public Customer findByCustomerId(String id);
	
}




