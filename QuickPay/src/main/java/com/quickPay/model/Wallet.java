package com.quickPay.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Cascade;

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
public class Wallet {
	
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Integer walletId ; 
	
	@Min(0)
	private Double balance ; 
	

	
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "wallet")
	private Customer customer ; 
	
	
	
	@OneToMany(cascade = CascadeType.ALL )
	private List<BankAccount> bankAccount ; 
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "wallet")
	@JsonIgnore
	private List<Transaction> transaction = new ArrayList<>() ; 
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "wallet")
	@JsonIgnore
	private List<BillPayment> billPayment = new ArrayList<>() ; 
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "wallet")
	@JsonIgnore
	private List<Beneficiary> beneficiary = new ArrayList<>() ; 
	
	
	
	
}
