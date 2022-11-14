package com.quickPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.LoginException;
import com.quickPay.model.LoginDTO;
import com.quickPay.service.LoginService;

@RestController
public class LoginController {
	

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestParam String mobile , @RequestParam String password) throws LoginException {
		
		LoginDTO dto = new LoginDTO(mobile , password);
		
		String result = customerLogin.logIn(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
		
		return customerLogin.logOut(key);
		
	}
	
	
	
	
	
}
