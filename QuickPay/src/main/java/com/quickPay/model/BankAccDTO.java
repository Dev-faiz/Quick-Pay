package com.quickPay.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccDTO {
	
	@Id
	private Integer accountNumber ;
	
	@NotNull
	private String IFSCCode  ;
	
	@NotNull
	private String bankName ;
	
	@NotNull
	private Double balanace ; 

}
