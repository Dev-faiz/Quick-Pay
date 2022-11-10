package com.quickPay.model;



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
public class Customer {
	
	@Id
	private Integer customerId ; 
	private String name ;
	private String mobileNumber ;
	private String password ;
	
	@OneToOne
	private Wallet wallet ; 
	
}
