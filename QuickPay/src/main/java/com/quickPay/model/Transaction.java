package com.quickPay.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId ;
	private String transactionType ;
	
	@CreatedDate
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate localDate ;
	private Integer amount ; 
	private String Description ; 
	
	
	@ManyToOne(cascade = CascadeType.ALL )
	private Wallet wallet ; 
	
	
}
