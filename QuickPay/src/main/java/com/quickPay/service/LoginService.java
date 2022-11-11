package com.quickPay.service;

import com.quickPay.exception.LoginException;
import com.quickPay.model.LoginDTO;

public interface LoginService {
	
	public String logIn(LoginDTO dto)throws LoginException;

	public String logOut(String key)throws LoginException;
	
	
}
