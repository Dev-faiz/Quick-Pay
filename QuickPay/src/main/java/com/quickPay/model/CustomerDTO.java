package com.quickPay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

	private String mobileNo ; 
	private String password ; 
	private String name ; 
	
}
