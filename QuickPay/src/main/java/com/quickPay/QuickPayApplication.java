package com.quickPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class QuickPayApplication {
	
//	Payment wallet Application
//	Problem Statement:
//	To create payment wallet application for XYZ bank. 
//	Customers will be able to park their money in the wallet.
//	Customer should be able to pay different bills using this wallet.
//	They should be able to connect bank account with this payment wallet and add money. 
//	Application should allow customers to check the balance, deposit money etc.
//	Modules:
//		Account Module
//		Customer Module
//		Bill Payment Module
//		Transaction Module
//		Beneficiary Module
//		Bank Account Module


	public static void main(String[] args) {
		SpringApplication.run(QuickPayApplication.class, args);
	}
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms ) {
		
		LocalValidatorFactoryBean lvfb = new LocalValidatorFactoryBean();
		
		lvfb.setValidationMessageSource(ms);
		
		return lvfb ; 
		
		
	}

}
