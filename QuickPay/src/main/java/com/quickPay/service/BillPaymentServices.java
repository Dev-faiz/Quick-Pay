package com.quickPay.service;

import java.util.List;

import com.quickPay.exception.BillPaymentNotFoundException;
import com.quickPay.model.BillPayment;

public interface BillPaymentServices {

	public String addBillPayment(BillPayment payment, Integer wallId);
	
	public List<BillPayment> viewBillPayment() throws BillPaymentNotFoundException;
}

