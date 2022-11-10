package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.Beneficiary;
import com.quickPay.model.Wallet;

public interface BeneficiaryDao  extends JpaRepository<Beneficiary, Integer>{

}
