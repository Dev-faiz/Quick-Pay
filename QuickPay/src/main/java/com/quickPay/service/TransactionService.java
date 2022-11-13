package com.quickPay.service;

import java.util.List;

import com.quickPay.exception.TransactionException;
import com.quickPay.model.Transaction;

public interface TransactionService {

	public Transaction addTansaction(Transaction trans) throws TransactionException;
	
	public List<Transaction> viewAllTransactionsbyType(String key,Integer walletId , String type) throws TransactionException;
	
	public List<Transaction> viewTransactionByDate(Integer walletId, String date)throws TransactionException;
	
	public List<Transaction> viewAllTransactions()throws TransactionException;
	
}

/*
 
 addTransaction return Transaction throws TransactionException
 
 viewAllTransaction return Transaction throws TransactionException 
 
 viewTransactionByDate(LocalDate from , LocalDate to ) return List<Transaction> and throws TransactionException
 
 viewAllTransaction(String type) return List<Transaction> and throws TransactionException  
 
 */
 