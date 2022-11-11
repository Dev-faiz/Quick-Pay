package com.quickPay.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BillPayment {
	
	@Id
	private Integer billId ; 
	
	
	private String billType ; 
	private Integer amount ;
	private LocalDate paymentDate ; 
	
	@ManyToOne
	private Wallet wallet ; 
}
