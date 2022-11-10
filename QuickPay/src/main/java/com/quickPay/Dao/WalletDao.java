package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {

}
