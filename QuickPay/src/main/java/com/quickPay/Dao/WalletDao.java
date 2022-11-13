package com.quickPay.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.BankAccount;
import com.quickPay.model.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {
	
	
    public Optional<Wallet> findByWalletId(Integer walletId);
	
	public Wallet findBybankAccount(BankAccount bankAccount);
	
	
	
}



