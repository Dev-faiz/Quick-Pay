package com.quickPay.serviceDao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.exception.BeneficiaryException;
import com.quickPay.model.Beneficiary;
import com.quickPay.repo.BeneficiaryRepo;
import com.quickPay.service.BeneficiaryService;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryRepo bRepo;

	@Override
	public Beneficiary addBenificiary(Beneficiary bd) throws BeneficiaryException {

		Beneficiary beneficiary = bRepo.save(bd);

		return beneficiary;
	}

	@Override
	public Beneficiary deleteBenificiary(Beneficiary bd) throws BeneficiaryException {

		Optional<Beneficiary> opt = bRepo.findById(bd.getBeneficiaryId());

		if (opt.isPresent()) {

			Beneficiary existbeneficiary = opt.get();
			bRepo.delete(existbeneficiary);

			return existbeneficiary;
		} else
			throw new BeneficiaryException("Beneficiary does not exist");
	}

	@Override
	public Beneficiary viewBenificiary(String mobno) throws BeneficiaryException {

		Beneficiary beneficiary = bRepo.findByMobileNumber(mobno);

		if (beneficiary!=null) {

			Beneficiary benef= beneficiary;
			

			return benef;
		} else
			throw new BeneficiaryException("No Beneficiary with mobilenumber: " + mobno);
	}

}
