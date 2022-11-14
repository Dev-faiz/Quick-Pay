package com.quickPay.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickPay.Dao.BillPaymentDao;
import com.quickPay.Dao.UserDao;
import com.quickPay.Dao.WalletDao;
import com.quickPay.exception.BillPaymentNotFoundException;
import com.quickPay.model.BillPayment;
import com.quickPay.model.Transaction;
import com.quickPay.model.Wallet;
import com.quickPay.service.BillPaymentServices;

@Service
public class BillPaymentServiceImpl implements BillPaymentServices   {

	@Autowired
	private WalletDao wDao;
	
	@Autowired
	private BillPaymentDao billDao;
	
	@Autowired
	private TransactionServiceImpl trService;
	
	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public String addBillPayment(BillPayment payment, Integer wallId) {
		
		Wallet wallet =payment.getWallet();


		Transaction tr = new Transaction();

		tr.setAmount(payment.getAmount());
		tr.setDescription(payment.getBillType());
		tr.setLocalDate(LocalDate.now());


		billDao.save(payment);

		return "Payment Done Successfully..."+"\n";

	}

	@Override
	public List<BillPayment> viewBillPayment() throws BillPaymentNotFoundException {
		
		List<BillPayment> billList = billDao.findAll();
		if(billList.size()==0) {
			throw new BillPaymentNotFoundException("No BillPaymets in the List ");
		}
		
				
		return billList;
	}

}
