package com.iispl.vallidation;

import com.iispl.enums.ChequeStatus;
import com.iispl.exception.InvalidAccountNumberException;
import com.iispl.model.Cheque;

public class AccountNumberValidationRule implements ChequeValidationRule {

	@Override
	public ChequeStatus validate(Cheque cheque) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		if(cheque.getAccountNumber() == null || cheque.getAccountNumber().isBlank()) {
			throw new InvalidAccountNumberException();
		}
		return ChequeStatus.PENDING;
	}

}
