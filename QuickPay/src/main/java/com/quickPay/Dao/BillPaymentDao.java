package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickPay.model.BillPayment;
import com.quickPay.model.Wallet;

public interface BillPaymentDao  extends JpaRepository<BillPayment, Integer>{

}


