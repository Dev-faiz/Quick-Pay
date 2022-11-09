package com.quickPay.model;

import java.time.LocalDate;

public class BillPayment {
	
	private Integer billId ; 
	private String billType ; 
	private Integer amount ;
	private LocalDate paymentDate ; 
	
	private Wallet wallet ; 
}
