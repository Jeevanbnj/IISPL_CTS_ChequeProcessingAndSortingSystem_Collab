package com.iispl.dao;

import java.util.List;

import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public interface ChequeDao {
	
	void addCheque(Cheque cheque);
	
	List<Cheque> getAllCheques();

	List<Cheque> getHighValueCheques();
	
	List<Cheque> getPendingCheques();
	
	void updateChequeStatus(String chequeNumber, ChequeStatus status);

}
