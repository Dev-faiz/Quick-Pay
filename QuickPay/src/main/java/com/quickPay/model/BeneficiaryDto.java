package com.quickPay.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDto {

	
	private String beneficiaryName;


//	@NotNull(message = "MobileNumber is mandatory")
	private String mobileNumber;
	
	private Integer walletId ; 
}
