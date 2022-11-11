package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickPay.model.Wallet;

@Repository
public interface WalletDao extends JpaRepository<Wallet, Integer> {

}
