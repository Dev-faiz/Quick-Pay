package com.quickPay.model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
public class Beneficiary {
	
	@Id
	@NotNull(message = "ID is mandatory")
	private Integer  beneficiaryId ;
	
	@Size(min=2, max=10,message = "Name length min=2 and max=10")
	@NotNull(message = "Name is mandatory")
	private String beneficiaryName ;
	
	@NotNull(message = "MobileNumber is mandatory")
	private String mobileNumber ; 
	
	@ManyToOne
	private Wallet wallet ; 
	
	
	
}

