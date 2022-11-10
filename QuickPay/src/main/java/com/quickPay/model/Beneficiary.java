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
public class Beneficiary {
	
	@Id
	private Integer  beneficiaryId ;
	private String beneficiaryName ;
	private String mobileNumber ; 
	
	@ManyToOne
	private Wallet wallet ; 
	
	
	
}

