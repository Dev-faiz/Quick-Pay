package com.quickPay.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.TransactionDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.TransactionException;
import com.quickPay.model.Transaction;
import com.quickPay.model.User;
import com.quickPay.model.Wallet;
import com.quickPay.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDao tDao;
	
	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private UserDao uDao;
	
	
	@Override
	public Transaction addTansaction(Transaction trans) throws TransactionException {
		Wallet wallet =  trans.getWallet();
		double wal_bal = wallet.getBalance();
		
		Integer trans_amount = (int) trans.getAmount();
		
		if(wal_bal > trans_amount) {
			
			wallet.setBalance(wal_bal - trans_amount);
			wDao.save(wallet);
			tDao.save(trans);
			
			return trans;
			
		}
		else {
			throw new TransactionException("Insufficient balance!Please add balance in wallet"); 
		}
		
		
		
		
		
		
		
	}

	@Override
	public List<Transaction> viewAllTransactionsbyType( String key, Integer walletId , String type  ) throws TransactionException {
		
		List<Transaction> tl = new ArrayList<>();
		
			User opts = uDao.findByUuid(key);
			
			
		
			if(opts== null ){
				throw new TransactionException("Unauthorized value");
			}
			
			
			
			Optional<Wallet> wallet= wDao.findById(walletId);
			
			
			
			if(!wallet.isPresent()){
				throw new TransactionException("Wallet not found");
			}else{
			
				
			List <Transaction>  transactions = wallet.get().getTransaction();
			
			for(int i = 0 ; i < transactions.size() ; i++ ) {
				
				if(transactions.get(i).getTransactionType().equals(type)) {
					tl.add(transactions.get(i));
				}
				
			}
			
			if(tl.size() >0){
				return tl;
			}else{
				throw new TransactionException("No Transaction Foundds");
			}
		}
	}

	@Override
	public List<Transaction> viewTransactionByDate(Integer walletId, String date) throws TransactionException {
		
		
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(date, dtf);
		
		
		Optional<Wallet> wallet= wDao.findById(walletId);
		
		
		if(!wallet.isPresent())
		{
			throw new TransactionException("No Wallet Regiesterd!!");
		}
		List <Transaction>  transactions = wallet.get().getTransaction();
//		transactions.get(0).getLocalDate()
		List <Transaction>  transationsDWIthDate = new ArrayList();
		
		for(Transaction tc : transactions )
		{
			if(tc.getLocalDate().equals(ld))
			{
				transationsDWIthDate.add(tc);
			}
		}
		
		
		if(transationsDWIthDate.size()>0)
		{
			return transationsDWIthDate;
		}
		else
		{
			throw new TransactionException("No Transaction found in given date");
		}
	}

	@Override
	public List<Transaction> viewAllTransactions() throws TransactionException {
		List<Transaction> transactions =  tDao.findAll();
		if(transactions.size() >0)
		{
			return transactions;
		}
		else
		{
			throw new TransactionException("Transaction not found");
		}
	}


	
	
}
