package com.iispl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.iispl.dao.ChequeDao;
import com.iispl.dao.ChequeDaoImpl;
import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class ChequeServiceImpl implements ChequeService {
	
	ChequeDao chequeDao = new ChequeDaoImpl();
	ChequeValidator validator = new ChequeValidator();

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
		List<Cheque> cheques = getAllCheques();
		Collections.sort(cheques);
		return cheques;
	}

	@Override
	public List<Cheque> sortByAmountAscending() {
		List<Cheque> chequeList=getAllCheques();
		chequeList.sort((c1,c2) -> c1.getChequeAmount().compareTo(c2.getChequeAmount()));
		return chequeList;
	}

	@Override
	public List<Cheque> sortByAmountDescending() {
		// TODO Auto-generated method stub
		List<Cheque> chequeList=getAllCheques();
		chequeList.sort((c1,c2) -> c2.getChequeAmount().compareTo(c1.getChequeAmount()));
		return chequeList;
	}

	@Override
	public List<Cheque> sortByChequeDate() {
		// TODO Auto-generated method stub
		List<Cheque> chequeList=getAllCheques();
		chequeList.sort((c1,c2) -> c1.getChequeDate().compareTo(c2.getChequeDate()));
		return chequeList;
	}

	@Override
	public List<Cheque> sortByBankAndAmount() {
		List<Cheque> cheques = getAllCheques();
		cheques.sort((c1, c2) -> {
			if (!c1.getPresentingBank().equals(c2.getPresentingBank())) {
				return c1.getPresentingBank().compareTo(c2.getPresentingBank());
			}
			else {
				return c1.getChequeAmount().compareTo(c2.getChequeAmount());
			}
		});
		return cheques;
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
		
		Collections.sort(cheques ,(c1,c2) -> c1.getStatus().compareTo(c2.getStatus()));
		
		return cheques;
	}

	@Override
	public List<Cheque> getHighValueCheques() {
		List<Cheque> highValueCheques = chequeDao.getHighValueCheques();
		Collections.sort(highValueCheques,(c1,c2) -> c2.getChequeAmount().compareTo(c1.getChequeAmount()));
		return highValueCheques;
	}

	@Override
	public List<Cheque> getPendingCheques() {
		return chequeDao.getPendingCheques();
	}

	@Override
	public void updateChequeStatus(String chequeNumber, ChequeStatus status) {
		chequeDao.updateChequeStatus(chequeNumber, status);
	}

	@Override
	public void validateCheque(Cheque cheque) {
		ChequeStatus status = validator.validate(cheque);
		updateChequeStatus(cheque.getChequeNumber(), status);
	}

	@Override
	public List<Cheque> sortByClearingZoneAndAmount() {
		List<Cheque> cheques =  getAllCheques();

		Collections.sort(cheques, (c1, c2) -> {
			if (!c1.getClearingZone().equals(c2.getClearingZone())) {
				return c1.getClearingZone().compareTo(c2.getClearingZone());
			}
			return c2.getChequeAmount().compareTo(c1.getChequeAmount());
		});
		
	}
	

}
