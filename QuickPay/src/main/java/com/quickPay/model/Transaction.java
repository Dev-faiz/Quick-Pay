package com.quickPay.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class Transaction {
	
	@Id
	private Integer transactionId ;
	private String transactionType ; 
	private LocalDate localDate ;
	private Double amount ; 
	private String Description ; 
	
	
	@OneToOne
	private Wallet wallet ; 
	
	
}
