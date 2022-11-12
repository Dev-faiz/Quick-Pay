package com.quickPay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickPay.exception.BeneficiaryException;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.Customer;
import com.quickPay.service.BeneficiaryService;

@RestController
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService bService;
//DD
	@PostMapping("/beneficiaries")
	public ResponseEntity<Beneficiary> addBenificiaryHandler(@Valid @RequestBody Beneficiary bd)
			throws BeneficiaryException {

		Beneficiary beneficiary = bService.addBenificiary(bd);

		return new ResponseEntity<Beneficiary>(beneficiary, HttpStatus.CREATED);
	}

	@DeleteMapping("/beneficiaries")
	public ResponseEntity<Beneficiary> deleteBenificiaryHandler(@Valid @RequestBody Beneficiary bd)
			throws BeneficiaryException {

		Beneficiary deletebeneficiary = bService.deleteBenificiary(bd);

		return new ResponseEntity<Beneficiary>(deletebeneficiary, HttpStatus.OK);
	}

	@GetMapping("/beneficiaries/{mobilenumber}")
	public ResponseEntity<Beneficiary> viewBenificiaryHandler(@PathVariable("mobilenumber") String mobilenumber)
			throws BeneficiaryException {

		Beneficiary beneficiary = bService.viewBenificiary(mobilenumber);

//		 HttpHeaders hh =new HttpHeaders();
//		 hh.add("user", "beneficiary");
//		 hh.add("hello", bef.getName());

		return new ResponseEntity<Beneficiary>(beneficiary, HttpStatus.OK);
	}

	@PostMapping("/viewallbeneficiary")
	public ResponseEntity<List<Beneficiary>> viewAllBenificiaryHandler(@Valid @RequestBody Customer customer) {

		List<Beneficiary> list = bService.viewAllBenificiary(customer);

		return new ResponseEntity<List<Beneficiary>>(list, HttpStatus.OK);

	}
}
