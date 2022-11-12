package com.quickPay.service;

import com.quickPay.exception.CustomerException;
import com.quickPay.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer c ) throws CustomerException;
	
	public Customer updateCustomer(Customer c , String key  ) throws CustomerException;
	
	
}
