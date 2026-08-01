package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidPresentingBankException;
import com.iispl.model.Cheque;

public class PresentingBankValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidPresentingBankException{
	
		if(cheque.getPresentingBank()==null || cheque.getPresentingBank().trim().isEmpty()) {
			
			throw new InvalidPresentingBankException();
			
		}
		return ChequeStatus.PENDING;
	}

}
	
