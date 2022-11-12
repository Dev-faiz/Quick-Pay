package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quickPay.model.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {


}
