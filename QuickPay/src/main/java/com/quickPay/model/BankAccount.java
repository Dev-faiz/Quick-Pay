package com.quickPay.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
public class BankAccount {
	
	@Id
	private Integer accountNumber ;
	
	@NotNull
	private String IFSCCode  ;
	
	@NotNull
	private String bankName ;
	
	@NotNull
	private Double balanace ; 
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "bankAccount")
	private Wallet wallet ; 
	
}
