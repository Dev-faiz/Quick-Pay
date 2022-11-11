package com.quickPay.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.CustomerException;
import com.quickPay.exception.LoginException;
import com.quickPay.model.Wallet;
import com.quickPay.service.WalletService;

@RestController
public class WalletControl {

	@Autowired
	private WalletService wService ; 
	

	
	@GetMapping("wallet/{mobile}")
	public ResponseEntity<Integer> getBalance(@PathVariable("mobile") String mobile ) throws CustomerException , LoginException{
		
		Integer balance = wService.showBalance(mobile);
		
		return new ResponseEntity<Integer>( balance , HttpStatus.OK);
		
	}
	
	
}
