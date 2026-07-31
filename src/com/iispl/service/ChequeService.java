package com.iispl.service;

import java.util.List;

import com.iispl.model.Cheque;

public interface ChequeService {
	
	void addCheque(Cheque cheque);
	
	List<Cheque> getAllCheques();
	
	List<Cheque> sortByChequeNumber();
	
	List<Cheque> sortByAmountAscending();

	List<Cheque> sortByAmountDescending();

	List<Cheque> sortByChequeDate();

	List<Cheque> sortByBankAndAmount();

	List<Cheque> sortByPriority();
	
	List<Cheque> sortByStatus();

	List<Cheque> getHighValueCheques();
	

}
