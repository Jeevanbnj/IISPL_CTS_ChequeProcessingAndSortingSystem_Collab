package com.iispl.service;

import java.util.Collections;
import java.util.List;

import com.iispl.dao.ChequeDao;
import com.iispl.dao.ChequeDaoImpl;
import com.iispl.model.Cheque;

public class ChequeServiceImpl implements ChequeService {
	
	ChequeDao chequeDao = new ChequeDaoImpl();

	@Override
	public void addCheque(Cheque cheque) {
		//Create object of ChequeVaalidator
		
	}

	@Override
	public List<Cheque> getAllCheques() {
		
		return chequeDao.getAllCheques();
		
	}

	@Override
	public List<Cheque> sortByChequeNumber() {
		
		return null;
	}

	@Override
	public List<Cheque> sortByAmountAscending() {
		
		return null;
	}

	@Override
	public List<Cheque> sortByAmountDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> sortByChequeDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> sortByBankAndAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> sortByPriority() {
		
		List<Cheque> cheques =  getAllCheques();
		
		Collections.sort(cheques ,(c1,c2) -> c1.getPriority().compareTo(c2.getPriority()));
		
		return cheques;
	}
	
	@Override
	public List<Cheque> sortByStatus() {
		
		List<Cheque> cheques =  getAllCheques();
		
		Collections.sort(cheques ,(c1,c2) -> c1.getPriority().compareTo(c2.getPriority()));
		
		return cheques;
	}

	@Override
	public List<Cheque> getHighValueCheques() {
		
		return null;
	}

	

}
