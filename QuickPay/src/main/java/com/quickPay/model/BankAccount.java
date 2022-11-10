package com.quickPay.model;



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
public class BankAccount {
	
	@Id
	private Integer accountNumber ;
	private String IFSCCode  ;
	private String bankName ;
	private Double balanace ; 
	
	@ManyToOne
	private Wallet wallet ; 
	
}
