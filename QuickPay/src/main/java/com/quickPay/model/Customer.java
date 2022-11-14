package com.quickPay.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId ; 
//	
	@Size( min = 3 , max = 15 , message = "name length must be between 3 and 15")
	private String name ;
	
	@Column(unique = true)
	private String mobileNumber ;
	
	private String password ;
	
	@OneToOne(cascade = CascadeType.ALL )
	private Wallet wallet ; 
	
}
