package com.quickPay.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class Wallet {
	
	
	@Id
	private Integer walletId ; 
	
	@NotNull
	@Min(value = 0 , message = "Insufficiend Balance")
	private BigDecimal balance ; 
	
	
	
	
}
