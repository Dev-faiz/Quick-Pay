package com.quickPay.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.BeneficiaryDao;
import com.quickPay.Dao.CustomerDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BeneficiaryException;
import com.quickPay.exception.CustomerException;
import com.quickPay.model.Beneficiary;
import com.quickPay.model.BeneficiaryDto;
import com.quickPay.model.Customer;
import com.quickPay.model.Wallet;
import com.quickPay.service.BeneficiaryService;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private BeneficiaryDao bDao;

	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private UserDao uDao ;
	
	@Autowired 
	private CustomerDao cDao ; 

	@Override
	public Beneficiary addBenificiary(BeneficiaryDto bdt , String key ) throws BeneficiaryException {

		Integer userId = uDao.findByUuid(key).getUserId();
		Customer c = cDao.getById(userId);
		
		Wallet wt =  c.getWallet();
		
		Beneficiary  b = new Beneficiary();
//		
			
			b.setBeneficiaryName(bdt.getBeneficiaryName());
			b.setMobileNumber(bdt.getMobileNumber());
			b.setWallet(wt);
		
		
			wt.getBeneficiary().add(b );
			
			wDao.save(wt);
		return 	bDao.save(b);
		
		 

		
//		Integer userId = uDao.findByUuid(key).getUserId();
//		Customer c = cDao.getById(userId);
//		if( c != null) {	
//			
//			Wallet wt = c.getWallet();
//			
//			Beneficiary  b = new Beneficiary();
//			
//				b.setWallet(wt);
//				b.setBeneficiaryName(bdt.getBeneficiaryName());
//				b.setMobileNumber(bdt.getMobileNumber());
//				
//			
//			
//			wt.getBeneficiary().add(b);
//
//			return bDao.save(b);
//
//		} else {
//			throw new BeneficiaryException("Beneficiary is already registered");
//		}
	}

	@Override
	public String deleteBenificiary(String mobile , String key ) throws BeneficiaryException, CustomerException {
		
		Integer userId = uDao.findByUuid(key).getUserId();
		
		Optional<Customer> customer =  cDao.findById(userId);
		
		if(customer.isEmpty()) throw new CustomerException();
		else {
			
			Wallet w = customer.get().getWallet() ;
			
			List<Beneficiary> listOfbeneficiary = w.getBeneficiary();
			 System.out.println(listOfbeneficiary.size());
			for(int i = 0 ; i < listOfbeneficiary.size() ; i++ ) {
				
				if(listOfbeneficiary.get(i).getMobileNumber().equals(mobile)) {
						
					 bDao.deleteById(listOfbeneficiary.get(i).getMobileNumber());
					 bDao.save((listOfbeneficiary.get(i)));
					
					 listOfbeneficiary.remove(i);
					 
				}
				
					
			}
			wDao.save(w);
			return "Successfully beneficiary deleted " ; 
			
		}
		
		
		

//		Optional<Beneficiary> opt = bDao.findById(bd.getMobileNumber());
//
//		if (opt.isPresent()) {
//
//			Beneficiary existbeneficiary = opt.get();
//
//			Wallet wt = bd.getWallet();
//
//			List<Beneficiary> list = wt.getBeneficiary();
//
//			list.remove(bd);
//
//			bDao.delete(existbeneficiary);
//
//			return existbeneficiary;
//		} else
//			throw new BeneficiaryException("Beneficiary does not exist");
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
