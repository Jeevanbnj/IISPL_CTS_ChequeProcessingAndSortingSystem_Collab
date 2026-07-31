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
		
		return null;
	}

	@Override
	public List<Cheque> sortByChequeNumber() {
		List<Cheque> cheques = getAllCheques();
		Collections.sort(cheques);
		return cheques;
	}

	@Override
	public List<Cheque> sortByAmountAscending() {
		List<Cheque> cheques = getAllCheques();
		Collections.sort(cheques, (c1, c2) -> c1.getChequeAmount().compareTo(c2.getChequeAmount()));
		return cheques;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Cheque> sortByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> getHighValueCheques() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cheque> sortByAmountDescending() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
