package com.quickPay.service;


import java.util.List;

import com.quickPay.exception.BeneficiaryException;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.Customer;

public interface BeneficiaryService {

	public Beneficiary addBenificiary(Beneficiary bd )  throws BeneficiaryException;

	public Beneficiary deleteBenificiary(Beneficiary bd )throws BeneficiaryException;

	public Beneficiary viewBenificiary(String mobno)throws BeneficiaryException;

	public List<Beneficiary> viewAllBenificiary(Customer customer);


}