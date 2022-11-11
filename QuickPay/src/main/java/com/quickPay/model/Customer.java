package com.quickPay.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	private Integer customerId ;
	
	// @JsonIgnore 
	
	@NotNull
	@Size(min =  3 , max = 3 , message = "name is not valid"  )
	private String name ;
	
	@Size(min = 10 )
	@NotNull
	private String mobileNumber ;
	
	@NotNull
	private String password ;
	
	@OneToOne
	private Wallet wallet ; 
	
	
}
