package com.quickPay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.BillPaymentNotFoundException;
import com.quickPay.model.BillPayment;
import com.quickPay.service.BillPaymentServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BillPaymentController {

	

	@Autowired
	private BillPaymentServices billPayService;
	

	

	@PostMapping("/bills/{walletId}")
	public String addBill(@RequestBody BillPayment pay,@PathVariable("walletId") Integer wallId) {
		return billPayService.addBillPayment(pay,wallId);
	}
	
	
	
	
	
	@GetMapping("/bills")
	ResponseEntity<List<BillPayment>> getBillDetails() throws BillPaymentNotFoundException{
		List<BillPayment> bills = billPayService.viewBillPayment();
		return new ResponseEntity<>(bills, HttpStatus.OK);
		
	}
	
	
	
	
}
