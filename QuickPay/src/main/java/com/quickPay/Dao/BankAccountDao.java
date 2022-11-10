package com.quickPay.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickPay.model.BankAccount;


@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {

	

	public BankAccount findByBankNameAndWallet(String bankName, Integer Id);
	
	public Optional<BankAccount> findById(Integer accountNo);
	
	public Optional<BankAccount> findByAccountNo(Integer accountNo);
	
}
