package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.BankAccount;
import com.quickPay.model.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {
	
	
    public Wallet findByWalletId(Integer walletId);
	
	public Wallet findBybankAccount(BankAccount bankAccount);
	
	
}
