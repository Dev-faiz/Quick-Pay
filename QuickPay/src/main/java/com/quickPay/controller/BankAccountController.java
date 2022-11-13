package com.quickPay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.BankAccountException;
import com.quickPay.model.BankAccDTO;
import com.quickPay.model.BankAccount;
import com.quickPay.service.BankAccountService;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BankAccountController {
	
	@Autowired
    private BankAccountService bankService;
	
	//add

	
	@PostMapping("/addBank")
	ResponseEntity<String> addAccounthandler(@Valid @RequestBody BankAccDTO bankAccount,@RequestParam Integer walletId, @RequestParam String key){
		
	return new ResponseEntity<String>(bankService.addAccount(bankAccount,walletId, key),HttpStatus.CREATED);
	
	}
	
	@GetMapping("/bank/{accountNumber}")
	ResponseEntity<BankAccount> searchBankAccountByAccountNo(@PathVariable Integer accountNumber) throws BankAccountException{
		
	BankAccount bankacc =	bankService.getAccountByAccountNumber(accountNumber);
		
	return new ResponseEntity<>(bankacc,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/bank/{accountNumber}")
	ResponseEntity<String> deleteBankAccount(@PathVariable Integer accountNumber, @RequestParam String key) throws BankAccountException{
		
		
	 String bankacc = 	bankService.removeAccount(accountNumber,key);
		
	 return new ResponseEntity<String>(bankacc,HttpStatus.OK); 
	 
	}
}
