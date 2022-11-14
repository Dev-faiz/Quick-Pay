package com.quickPay.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.TransactionException;
import com.quickPay.model.Transaction;
import com.quickPay.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TransactionController {
	
	
	@Autowired
	private TransactionService transService;
	
	@PostMapping("/transaction")
	public Transaction saveTransactionHandler(@RequestBody Transaction trans) throws TransactionException{
		
		
		Transaction transaction =  transService.addTansaction(trans);
		return transaction;
	}
	//add
	
	@GetMapping("/transactions")
	ResponseEntity<List<Transaction>> viewAllTransactionsHandler() throws TransactionException{
		
		List<Transaction> Transactions =   transService.viewAllTransactions();
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
	
	
	

	
	@GetMapping("/transactions/{walletId}/{date}")
	ResponseEntity<List<Transaction>> viewTransactionByDateHandler(@PathVariable Integer walletId,
														@PathVariable String date
					) throws TransactionException{
		
		List<Transaction> Transactions = transService.viewTransactionByDate(walletId, date);
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/transactionsType/{walletId}/")
	ResponseEntity<List<Transaction>> viewTransactionByType(@RequestParam String key,
														@PathVariable Integer walletId  , 
														@RequestParam String type
					) throws TransactionException{
		
		List<Transaction> Transactions = transService.viewAllTransactionsbyType(key, walletId,  type );
		
		
		return new ResponseEntity<List<Transaction>>(Transactions,HttpStatus.OK);
	}
	
	
}
