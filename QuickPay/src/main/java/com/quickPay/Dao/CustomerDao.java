package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.Customer;


public interface CustomerDao  extends JpaRepository<Customer, Integer> {
	
	public Customer findCustomerBymobileNumber(String mobile ) ; 
	
}
