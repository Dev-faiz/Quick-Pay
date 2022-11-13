package com.quickPay.service;


import java.util.List;

import com.quickPay.exception.BeneficiaryException;
import com.quickPay.exception.CustomerException;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.BeneficiaryDto;
import com.quickPay.model.Customer;

public interface BeneficiaryService {

	public Beneficiary addBenificiary(BeneficiaryDto bd , String key )  throws BeneficiaryException;

	public String deleteBenificiary(String mobile , String key  )throws BeneficiaryException , CustomerException;

	public Beneficiary viewBenificiary(String mobno)throws BeneficiaryException;

	public List<Beneficiary> viewAllBenificiary() throws BeneficiaryException;


}