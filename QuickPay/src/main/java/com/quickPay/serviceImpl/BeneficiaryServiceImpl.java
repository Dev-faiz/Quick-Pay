package com.quickPay.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.BeneficiaryDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BeneficiaryException;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.Customer;
import com.quickPay.model.Wallet;
import com.quickPay.service.BeneficiaryService;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryDao bDao;

	@Autowired
	private WalletDao wDao;
	
	

	@Override
	public Beneficiary addBenificiary(Beneficiary bd) throws BeneficiaryException {

		
		if (bDao.findById(bd.getMobileNumber()).isEmpty()) {

			Wallet wt = bd.getWallet();

			wt.getBeneficiary().add(bd);

			return bDao.save(bd);
		} else {
			throw new BeneficiaryException("Beneficiary is already registered");
		}
	}

	@Override
	public Beneficiary deleteBenificiary(Beneficiary bd) throws BeneficiaryException {

		Optional<Beneficiary> opt = bDao.findById(bd.getMobileNumber());

		if (opt.isPresent()) {

			Beneficiary existbeneficiary = opt.get();

			Wallet wt = bd.getWallet();

			List<Beneficiary> list = wt.getBeneficiary();

			list.remove(bd);

			bDao.delete(existbeneficiary);

			return existbeneficiary;
		} else
			throw new BeneficiaryException("Beneficiary does not exist");
	}

	@Override
	public Beneficiary viewBenificiary(String mobno) throws BeneficiaryException {

		Optional<Beneficiary> opt = bDao.findById(mobno);
		if (opt.isPresent()) {
			return opt.get();
		} else
			throw new BeneficiaryException("No Beneficiary with the mobilenumber: " + mobno);
	}

	@Override
	public List<Beneficiary> viewAllBenificiary(Customer customer) {
		Integer id = customer.getWallet().getWalletId();

		Optional<Wallet> opt = wDao.findById(id);

		Wallet wt = opt.get();

		return wt.getBeneficiary();
	}

}
