package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;

public interface TransactionDao  extends JpaRepository<Transaction, Integer> {

}
