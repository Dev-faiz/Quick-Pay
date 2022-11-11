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

import com.quickPay.Dao.WalletDao;
import com.quickPay.model.BankAccount;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.BillPayment;
import com.quickPay.model.Customer;
import com.quickPay.model.Transaction;
import com.quickPay.service.WalletService;


@RestController
public class WalletController {
	

	@Autowired
	public WalletService ws ; 

	@GetMapping("checkWallet")
	public String checkWallet() {
		
		return "Connected" ;
		
	}
	@PostMapping("createAccount")
	public ResponseEntity<Customer> createAc ( @RequestBody String name , @RequestBody String mobileNumber , @RequestBody BigDecimal amount ){
		
		return new ResponseEntity<Customer>(new Customer(14 , "Faiz" , "456" , "123" , null) , HttpStatus.ACCEPTED) ;
	}
	
	
	
	
	@GetMapping("customer/{id}")
	public ResponseEntity<BigDecimal> getBalancebyMobileNo( @PathVariable("id") String mobile ){
		
		
		Customer  c =  ws.showBalance(mobile);
		
		return new ResponseEntity<BigDecimal>(c.getWallet().getBalance() , HttpStatus.ACCEPTED);
		
	}
	
	
	
}
