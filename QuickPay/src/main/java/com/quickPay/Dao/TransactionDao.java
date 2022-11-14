package com.quickPay.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickPay.model.Transaction;
import com.quickPay.model.TransactionType;
import com.quickPay.model.Wallet;
@Repository
public interface TransactionDao  extends JpaRepository<Transaction, Integer> {
	public List<Transaction> findByTransactionType(TransactionType transactionType);
}




