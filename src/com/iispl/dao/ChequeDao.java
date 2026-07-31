package com.iispl.dao;

import java.util.List;

import com.iispl.model.Cheque;

public interface ChequeDao {
	
	void addCheque(Cheque cheque);
	
	List<Cheque> getAllCheques();

	List<Cheque> getHighValueCheques();

}
