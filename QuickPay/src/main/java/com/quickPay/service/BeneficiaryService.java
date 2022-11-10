package com.quickPay.service;


import com.quickPay.exception.BeneficiaryException;
import com.quickPay.model.Beneficiary;

public interface BeneficiaryService {

	public Beneficiary addBenificiary(Beneficiary bd )  throws BeneficiaryException;

	public Beneficiary deleteBenificiary(Beneficiary bd )throws BeneficiaryException;

	public Beneficiary viewBenificiary(String mobno)throws BeneficiaryException;

	//public List<BeneficiaryDetails> viewAllBenificiary(Customer customer) throws BankAccountException;


}
/*
 
  addBenficiary(Beneficiary benificaryObj) returns Beneficiary object and throws BeneficiaryException 
  
  removeBenficiary(Beneficiary benificaryObj) returns Beneficiary object and throws BeneficiaryException 
  
  viewBenficiary(String mobNumber) returns Beneficiary object and throws BeneficiaryException 
  
  viewAllBenficiary(Customer customer) returns List<Beneficiary> object and throws BeneficiaryException && CustomerException
 
    
 */  
  
 