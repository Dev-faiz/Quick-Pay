package com.quickPay.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quickPay.model.Beneficiary;

@Repository
public interface BeneficiaryDao extends JpaRepository<Beneficiary, String> {


}
