package com.quickPay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickPay.model.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet,Integer>  {
	
	                                       
}
