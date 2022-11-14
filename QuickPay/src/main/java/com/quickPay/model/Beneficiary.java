package com.quickPay.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Beneficiary {


	@Size(min = 2, max = 10, message = "Name length min=2 and max=10")
//	@NotNull(message = "Name is mandatory")
	private String beneficiaryName;

	@Id
//	@NotNull(message = "MobileNumber is mandatory")
	private String mobileNumber;
	

	@ManyToOne(cascade = CascadeType.ALL )
	@JsonIgnore
	private Wallet wallet;

	public Beneficiary() {
		// TODO Auto-generated constructor stub
	}

	public Beneficiary(
			@Size(min = 2, max = 10, message = "Name length min=2 and max=10") @NotNull(message = "Name is mandatory") String beneficiaryName,
			@NotNull(message = "MobileNumber is mandatory") String mobileNumber, Wallet wallet) {
		super();
		this.beneficiaryName = beneficiaryName;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



}
