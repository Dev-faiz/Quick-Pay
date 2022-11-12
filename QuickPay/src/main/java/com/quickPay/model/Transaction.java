package com.quickPay.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
<<<<<<< HEAD
=======

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> parent of 2d3eb31 (transaction layer uploaded)

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
