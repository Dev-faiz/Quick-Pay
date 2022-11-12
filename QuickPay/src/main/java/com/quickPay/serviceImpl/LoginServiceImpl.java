package com.quickPay.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.exception.LoginException;
import com.quickPay.model.Customer;
import com.quickPay.model.LoginDTO;
import com.quickPay.model.User;
import com.quickPay.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private UserDao sDao;
	
	
	
	@Override
	public String logIn(LoginDTO dto)throws LoginException{
		
		
		Customer existingCustomer = cDao.findByMobileNumber(dto.getMobileNo());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
			
		}
		
		
		
		
		Optional<User> validCustomerSessionOpt =  sDao.findById(existingCustomer.getCustomerId());
		
		
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			User user = new User(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sDao.save(user);

			return user.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}


	@Override
	public String logOut(String key)throws LoginException {
		
		User existCustomer = sDao.findByUuid(key);
		
		
		if(existCustomer == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(existCustomer);
		
		
		return "Logged Out !";
		
		
	}
	
}
