package com.quickPay.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.Dao.AddDto;
import com.quickPay.exception.BankAccountException;
import com.quickPay.exception.BankException;
import com.quickPay.exception.CustomerException;
import com.quickPay.exception.LoginException;

import com.quickPay.model.Customer;
import com.quickPay.model.CustomerDTO;
import com.quickPay.model.Transaction;

import com.quickPay.service.WalletService;

@RestController
public class WalletControl {

	@Autowired
	private WalletService wService ; 
	
	@PostMapping("fundTransfer")
	public ResponseEntity<Transaction> fundTransferHandle(@RequestParam String target , @RequestParam String source , Integer amount ) throws CustomerException{
		
		Transaction trans = 	wService.fundTransfer(source, target, amount);
		
		return new ResponseEntity<Transaction>( trans , HttpStatus.OK);
		
	}
	
	@GetMapping("getbalance")
	public ResponseEntity<Integer> showBalance(String key ) throws CustomerException, LoginException{
		
		Integer bal = wService.showBalance(key);
		
		return new ResponseEntity<>(bal , HttpStatus.ACCEPTED);

	}
	
	
	
	@GetMapping("getListOfCustomer")
	public ResponseEntity<List<Customer>> getList() throws CustomerException{
		
		List<Customer> customerList = wService.getList() ; 
		
		return new ResponseEntity<List<Customer>>( customerList , HttpStatus.OK);
	}
	
	@PostMapping("wallet")
	public ResponseEntity<Customer> createAcoountHandler(@RequestParam String mobile , @RequestParam String name) throws Exception{
		
		AddDto d = new AddDto();
		d.setMobile(mobile);
		d.setName(name);
		d.setAmount(0.0);
		Customer c =  wService.createAccount(d.getName(), d.getMobile(), d.getAmount());
		
		return new ResponseEntity<Customer>(c , HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("wallet/{mobile}")
//	public ResponseEntity<Integer> getBalance(@PathVariable("mobile") String mobile ) throws CustomerException , LoginException{
//		
//		Integer balance = wService.showBalance(mobile);
//		
//		return new ResponseEntity<Integer>( balance , HttpStatus.OK);
//		
//	}
	
	@PostMapping("depositmoney/{amount}")
	public ResponseEntity<Transaction> depositMoneyController(@RequestParam Integer walletId, @RequestParam(required = false) String key,@PathVariable Integer amount) throws Exception {
		
		Transaction message =  wService.addMoney(walletId, amount , key);
		
		return new ResponseEntity<Transaction>(message,HttpStatus.ACCEPTED);

	}
	
	@PutMapping("wallet")
	public ResponseEntity<Customer> updateCustomer( @RequestParam String name , @RequestParam  String mobile ,  @RequestParam String password , String key  ) throws CustomerException{
		
		CustomerDTO c = new CustomerDTO(mobile,password ,name   );
		
		Customer cus = wService.updateAccount(c,key);
		
		return new ResponseEntity<Customer>(cus , HttpStatus.ACCEPTED);
		
		
	}
	
	
}
