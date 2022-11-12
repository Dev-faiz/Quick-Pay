package com.quickPay.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.exception.CustomerException;
import com.quickPay.model.Customer;
import com.quickPay.model.User;
import com.quickPay.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao ; 
	
	@Autowired
	private UserDao uDao ;
	
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {
		
		Customer existingCustomer= cDao.findByMobileNumber(customer.getMobileNumber());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer Already Registered with Mobile number");
			
		
		
		
			return cDao.save(customer);
			
			
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
			User loggedInUser= uDao.findByUuid(key);
			
			if(loggedInUser == null) {
				throw new CustomerException("Please provide a valid key to update a customer");
			}
			
			
		
			
			if(customer.getCustomerId() == loggedInUser.getUserId()) {
				//If LoggedInUser id is same as the id of supplied Customer which we want to update
				return cDao.save(customer);
			}
			else
				throw new CustomerException("Invalid Customer Details, please login first");
		
		}
	

}


