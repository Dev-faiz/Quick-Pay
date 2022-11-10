package com.quickPay.controller;


import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.model.BankAccount;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.BillPayment;
import com.quickPay.model.Customer;
import com.quickPay.model.Transaction;


@RestController
public class WalletController {
	
	

	@GetMapping("checkWallet")
	public String checkWallet() {
		
		return "Connected" ;
		
	}
	@PostMapping("createAccount")
	public  ResponseEntity<Customer> createAc ( @RequestBody String name , @RequestBody String mobileNumber , @RequestBody BigDecimal amount ){
		
		return new ResponseEntity<Customer>(new Customer(14 , "Faiz" , "456" , "123" , null) , HttpStatus.ACCEPTED) ;
	}
	@GetMapping("postBank")
	public ResponseEntity<BankAccount> postAccount( @RequestBody BankAccount  ba ) {
		
		return new  ResponseEntity<BankAccount> (ba , HttpStatus.OK);
	
		
	}
	@GetMapping("postBen")
	public ResponseEntity<Beneficiary> postBenficiary( @RequestBody Beneficiary  ba ) {
		
		return new  ResponseEntity<Beneficiary> (ba , HttpStatus.OK);
		
	}
	@GetMapping("postBill")
	public ResponseEntity<BillPayment> postAccount( @RequestBody BillPayment  ba ) {
		
		return new  ResponseEntity<BillPayment> (ba , HttpStatus.OK);
	
		
	}
	@GetMapping("postTrans")
	public ResponseEntity<Transaction> postAccount( @RequestBody Transaction  ba ) {
		
		return new  ResponseEntity<Transaction> (ba , HttpStatus.OK);
	
		
	}

	
	
	
	
	
	
	
	
}
